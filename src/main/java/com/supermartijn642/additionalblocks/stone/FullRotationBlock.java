package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

import java.util.function.Supplier;

/**
 * Created 1/16/2021 by SuperMartijn642
 */
public class FullRotationBlock extends BasicBlock {

    private final boolean reversePlacement;

    public FullRotationBlock(String registryName, boolean reversePlacement, Properties properties, Supplier<Boolean> configValue){
        super(registryName, configValue, properties);
        this.reversePlacement = reversePlacement;
        this.registerDefaultState(this.defaultBlockState().setValue(BlockProperties.FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        Direction facing = context.getNearestLookingDirection();
        return this.defaultBlockState().setValue(BlockProperties.FACING, this.reversePlacement ? facing.getOpposite() : facing);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.FACING);
    }
}
