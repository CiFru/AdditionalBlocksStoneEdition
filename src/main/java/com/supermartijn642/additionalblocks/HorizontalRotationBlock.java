package com.supermartijn642.additionalblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

/**
 * Created 1/15/2021 by SuperMartijn642
 */
public class HorizontalRotationBlock extends BasicBlock {

    public HorizontalRotationBlock(String registryName, Properties properties){
        super(registryName, properties);
        this.setDefaultState(this.getDefaultState().with(BlockProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.HORIZONTAL_FACING);
    }
}
