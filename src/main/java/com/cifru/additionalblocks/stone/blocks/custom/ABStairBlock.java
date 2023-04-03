package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABStairBlock extends BaseBlock implements IWaterLoggable {

    public ABStairBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(ABBlockProperties.STAIR_HALF, Half.BOTTOM).setValue(ABBlockProperties.STAIR_SHAPE, StairsShape.STRAIGHT).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
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
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState otherState, IWorld level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return neighborSide.getAxis().isHorizontal() ? state.setValue(ABBlockProperties.STAIR_SHAPE, getStairsShape(state, level, pos)) : state;
    }

    @Override
    public BlockState rotate(BlockState state, IWorld level, BlockPos pos, Rotation rotation){
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
    public VoxelShape getShape(BlockState state, IBlockReader level, BlockPos pos, ISelectionContext context){
        Direction facing = state.getValue(ABBlockProperties.HORIZONTAL_FACING);
        Half half = state.getValue(ABBlockProperties.STAIR_HALF);
        StairsShape shape = state.getValue(ABBlockProperties.STAIR_SHAPE);
        return (half == Half.BOTTOM ? StairsBlock.BOTTOM_SHAPES : StairsBlock.TOP_SHAPES)[StairsBlock.SHAPE_BY_STATE[shape.ordinal() * 4 + facing.get2DDataValue()]];
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
    public boolean isPathfindable(BlockState state, IBlockReader level, BlockPos pos, PathType pathType){
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.HORIZONTAL_FACING, ABBlockProperties.STAIR_HALF, ABBlockProperties.STAIR_SHAPE, ABBlockProperties.WATERLOGGED);
    }

    private static StairsShape getStairsShape(BlockState state, IBlockReader level, BlockPos pos){
        // Check the block behind
        Direction facing = state.getValue(ABBlockProperties.HORIZONTAL_FACING);
        BlockState stateBehind = level.getBlockState(pos.relative(facing));
        if(StairsBlock.isStairs(stateBehind) && state.getValue(ABBlockProperties.STAIR_HALF) == stateBehind.getValue(ABBlockProperties.STAIR_HALF)){
            Direction facingBehind = stateBehind.getValue(ABBlockProperties.HORIZONTAL_FACING);
            if(facingBehind.getAxis() != facing.getAxis() && areStairsAligned(state, level, pos, facingBehind.getOpposite()))
                return facingBehind == facing.getCounterClockWise() ? StairsShape.OUTER_LEFT : StairsShape.OUTER_RIGHT;
        }

        // Check the block in front
        BlockState stateInFront = level.getBlockState(pos.relative(facing.getOpposite()));
        if(StairsBlock.isStairs(stateInFront) && state.getValue(ABBlockProperties.STAIR_HALF) == stateInFront.getValue(ABBlockProperties.STAIR_HALF)){
            Direction facingInFront = stateInFront.getValue(ABBlockProperties.HORIZONTAL_FACING);
            if(facingInFront.getAxis() != facing.getAxis() && areStairsAligned(state, level, pos, facingInFront))
                return facingInFront == facing.getCounterClockWise() ? StairsShape.INNER_LEFT : StairsShape.INNER_RIGHT;
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean areStairsAligned(BlockState state, IBlockReader level, BlockPos pos, Direction side){
        BlockState sideState = level.getBlockState(pos.relative(side));
        return !StairsBlock.isStairs(sideState) || sideState.getValue(ABBlockProperties.HORIZONTAL_FACING) != state.getValue(ABBlockProperties.HORIZONTAL_FACING) || sideState.getValue(ABBlockProperties.STAIR_HALF) != state.getValue(ABBlockProperties.STAIR_HALF);
    }
}
