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
public class HorizontalRotationBlock extends BasicBlock {

    private final boolean reversePlacement;

    public HorizontalRotationBlock(String registryName, Supplier<Boolean> configValue, boolean reversePlacement, Properties properties){
        super(registryName, configValue, properties);
        this.reversePlacement = reversePlacement;
        this.registerDefaultState(this.defaultBlockState().setValue(BlockProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Direction facing = context.getHorizontalDirection();
        return this.defaultBlockState().setValue(BlockProperties.HORIZONTAL_FACING, this.reversePlacement ? facing.getOpposite() : facing);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.HORIZONTAL_FACING);
    }
}
