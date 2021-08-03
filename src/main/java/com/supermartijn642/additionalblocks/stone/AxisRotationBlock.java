package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import java.util.function.Supplier;

/**
 * Created 1/15/2021 by SuperMartijn642
 */
public class AxisRotationBlock extends BasicBlock {

    public AxisRotationBlock(String registryName,Supplier<Boolean> configValue, Properties properties, ToolType toolType, ToolTier toolTier){
        super(registryName, configValue, properties, toolType, toolTier);
        this.registerDefaultState(this.defaultBlockState().setValue(BlockProperties.AXIS, Direction.Axis.Y));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Direction facing = context.getClickedFace();
        return this.defaultBlockState().setValue(BlockProperties.AXIS, facing.getAxis());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.AXIS);
    }
}
