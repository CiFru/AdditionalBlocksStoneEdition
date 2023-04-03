package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.block.BlockShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABSlabBlock extends BaseBlock implements SimpleWaterloggedBlock {

    private static final BlockShape BOTTOM_SHAPE = BlockShape.createBlockShape(0, 0, 0, 16, 8, 16);
    private static final BlockShape TOP_SHAPE = BlockShape.createBlockShape(0, 8, 0, 16, 16, 16);

    public ABSlabBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.SLAB_TYPE, SlabType.BOTTOM).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        if(context.getLevel().getBlockState(context.getClickedPos()).is(this))
            return this.defaultBlockState().setValue(ABBlockProperties.SLAB_TYPE, SlabType.DOUBLE);

        SlabType half = context.getClickedFace() == Direction.UP || context.getClickLocation().y - context.getClickedPos().getY() <= 0.5 ? SlabType.BOTTOM : SlabType.TOP;
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(ABBlockProperties.SLAB_TYPE, half).setValue(ABBlockProperties.WATERLOGGED, waterlogged);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState otherState, LevelAccessor level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, neighborSide, otherState, level, pos, neighborPos);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context){
        SlabType slabType = state.getValue(ABBlockProperties.SLAB_TYPE);
        if(slabType != SlabType.DOUBLE && context.getItemInHand().is(this.asItem())){
            if(!context.replacingClickedOnBlock())
                return true;
            Direction face = context.getClickedFace();
            return slabType == SlabType.BOTTOM ?
                face == Direction.UP || (face.getAxis().isHorizontal() && context.getClickLocation().y - context.getClickedPos().getY() > 0.5) :
                face == Direction.DOWN || (face.getAxis().isHorizontal() && context.getClickLocation().y - context.getClickedPos().getY() <= 0.5);
        }
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        SlabType slabType = state.getValue(ABBlockProperties.SLAB_TYPE);
        return (slabType == SlabType.BOTTOM ? BOTTOM_SHAPE :
            slabType == SlabType.TOP ? TOP_SHAPE : BlockShape.fullCube()).getUnderlying();
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state){
        return state.getValue(ABBlockProperties.SLAB_TYPE) != SlabType.DOUBLE;
    }

    @Override
    public FluidState getFluidState(BlockState state){
        return state.getValue(ABBlockProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluid){
        return state.getValue(ABBlockProperties.SLAB_TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluid);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter level, BlockPos pos, BlockState state, Fluid fluid){
        return state.getValue(ABBlockProperties.SLAB_TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(level, pos, state, fluid);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathType){
        return pathType == PathComputationType.WATER && state.getValue(ABBlockProperties.WATERLOGGED);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.SLAB_TYPE, ABBlockProperties.WATERLOGGED);
    }
}
