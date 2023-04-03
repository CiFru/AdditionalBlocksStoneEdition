package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
public class ABHorizontalRotationBlock extends BaseBlock {

    public ABHorizontalRotationBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        Direction facing = context.getHorizontalDirection();
        return this.defaultBlockState().setValue(ABBlockProperties.HORIZONTAL_FACING, facing.getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.HORIZONTAL_FACING);
    }
}
