package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABStairBlock extends BaseBlock implements SimpleWaterloggedBlock {

    public ABStairBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(ABBlockProperties.STAIR_HALF, Half.BOTTOM).setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.STRAIGHT).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Direction facing = context.getHorizontalDirection();
        Half half = context.getClickedFace() == Direction.DOWN || context.getClickLocation().y - context.getClickedPos().getY() <= 0.5 ? Half.BOTTOM : Half.TOP;
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        BlockState partialState = this.defaultBlockState()
            .setValue(ABBlockProperties.HORIZONTAL_FACING, facing)
            .setValue(ABBlockProperties.STAIR_HALF, half)
            .setValue(ABBlockProperties.WATERLOGGED, waterlogged);
        return partialState.setValue(ABBlockProperties.STAIR_SHAPE, getStairsShape(partialState, context.getLevel(), context.getClickedPos()));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState otherState, LevelAccessor level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return neighborSide.getAxis().isHorizontal() ? state.setValue(ABBlockProperties.STAIR_SHAPE, getStairsShape(state, level, pos)) : state;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation rotation){
        return state.setValue(ABBlockProperties.HORIZONTAL_FACING, rotation.rotate(state.getValue(ABBlockProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror){
        Direction facing = state.getValue(ABBlockProperties.HORIZONTAL_FACING);
        StairsShape shape = state.getValue(ABBlockProperties.STAIR_SHAPE);
        if(mirror == Mirror.LEFT_RIGHT && facing.getAxis() == Direction.Axis.Z){
            state = state.rotate(Rotation.CLOCKWISE_180);
            switch(shape){
                case INNER_LEFT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.INNER_RIGHT);
                case INNER_RIGHT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.INNER_LEFT);
                case OUTER_LEFT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.OUTER_RIGHT);
                case OUTER_RIGHT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.OUTER_LEFT);
            }
        }else if(mirror == Mirror.FRONT_BACK && facing.getAxis() == Direction.Axis.X){
            state = state.rotate(Rotation.CLOCKWISE_180);
            switch(shape){
                case OUTER_LEFT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.OUTER_RIGHT);
                case OUTER_RIGHT:
                    state = state.setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.OUTER_LEFT);
            }
        }
        return state;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        Direction facing = state.getValue(ABBlockProperties.HORIZONTAL_FACING);
        Half half = state.getValue(ABBlockProperties.STAIR_HALF);
        StairsShape shape = state.getValue(ABBlockProperties.STAIR_SHAPE);
        return (half == Half.BOTTOM ? StairBlock.BOTTOM_SHAPES : StairBlock.TOP_SHAPES)[StairBlock.SHAPE_BY_STATE[shape.ordinal() * 4 + facing.get2DDataValue()]];
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state){
        return true;
    }

    @Override
    public FluidState getFluidState(BlockState state){
        return state.getValue(ABBlockProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathType){
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.HORIZONTAL_FACING, ABBlockProperties.STAIR_HALF, ABBlockProperties.STAIR_SHAPE, ABBlockProperties.WATERLOGGED);
    }

    private static StairsShape getStairsShape(BlockState state, BlockGetter level, BlockPos pos){
        // Check the block behind
        Direction facing = state.getValue(ABBlockProperties.HORIZONTAL_FACING);
        BlockState stateBehind = level.getBlockState(pos.relative(facing));
        if(StairBlock.isStairs(stateBehind) && state.getValue(ABBlockProperties.STAIR_HALF) == stateBehind.getValue(ABBlockProperties.STAIR_HALF)){
            Direction facingBehind = stateBehind.getValue(ABBlockProperties.HORIZONTAL_FACING);
            if(facingBehind.getAxis() != facing.getAxis() && areStairsAligned(state, level, pos, facingBehind.getOpposite()))
                return facingBehind == facing.getCounterClockWise() ? StairsShape.OUTER_LEFT : StairsShape.OUTER_RIGHT;
        }

        // Check the block in front
        BlockState stateInFront = level.getBlockState(pos.relative(facing.getOpposite()));
        if(StairBlock.isStairs(stateInFront) && state.getValue(ABBlockProperties.STAIR_HALF) == stateInFront.getValue(ABBlockProperties.STAIR_HALF)){
            Direction facingInFront = stateInFront.getValue(ABBlockProperties.HORIZONTAL_FACING);
            if(facingInFront.getAxis() != facing.getAxis() && areStairsAligned(state, level, pos, facingInFront))
                return facingInFront == facing.getCounterClockWise() ? StairsShape.INNER_LEFT : StairsShape.INNER_RIGHT;
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean areStairsAligned(BlockState state, BlockGetter level, BlockPos pos, Direction side){
        BlockState sideState = level.getBlockState(pos.relative(side));
        return !StairBlock.isStairs(sideState) || sideState.getValue(ABBlockProperties.HORIZONTAL_FACING) != state.getValue(ABBlockProperties.HORIZONTAL_FACING) || sideState.getValue(ABBlockProperties.STAIR_HALF) != state.getValue(ABBlockProperties.STAIR_HALF);
    }
}
