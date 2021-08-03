package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import java.util.function.Supplier;

/**
 * Created 1/16/2021 by SuperMartijn642
 */
public class FullRotationBlock extends BasicBlock {

    private final boolean reversePlacement;

    public FullRotationBlock(String registryName, boolean reversePlacement, Properties properties, Supplier<Boolean> configValue, ToolType toolType, ToolTier toolTier){
        super(registryName, configValue, properties, toolType, toolTier);
        this.reversePlacement = reversePlacement;
        this.registerDefaultState(this.defaultBlockState().setValue(BlockProperties.FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Direction facing = context.getNearestLookingDirection();
        return this.defaultBlockState().setValue(BlockProperties.FACING, this.reversePlacement ? facing.getOpposite() : facing);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.FACING);
    }
}
