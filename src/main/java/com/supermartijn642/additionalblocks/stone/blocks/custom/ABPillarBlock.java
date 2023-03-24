package com.supermartijn642.additionalblocks.stone.blocks.custom;

import com.supermartijn642.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
public class ABPillarBlock extends BaseBlock {

    public ABPillarBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.AXIS, Direction.Axis.Y));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Direction facing = context.getClickedFace();
        return this.defaultBlockState().setValue(ABBlockProperties.AXIS, facing.getAxis());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.AXIS);
    }
}
