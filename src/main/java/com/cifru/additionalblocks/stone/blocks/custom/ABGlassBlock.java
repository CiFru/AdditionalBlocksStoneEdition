package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Created 13/04/2023 by SuperMartijn642
 */
public class ABGlassBlock extends BaseBlock implements BeaconBeamBlock {

    public ABGlassBlock(BlockProperties properties){
        super(false, properties.noOcclusion().isRedstoneConductor(false).isSuffocating(false));
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        return Shapes.empty();
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState neighborState, Direction neighborSide){
        return neighborState.is(this) || super.skipRendering(state, neighborState, neighborSide);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos){
        return true;
    }

    @Override
    public DyeColor getColor(){
        return DyeColor.GREEN;
    }
}
