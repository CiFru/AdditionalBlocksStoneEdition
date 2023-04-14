package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

/**
 * Created 13/04/2023 by SuperMartijn642
 */
public class ABGlassBlock extends BaseBlock implements IBeaconBeamColorProvider {

    public ABGlassBlock(BlockProperties properties){
        super(false, properties.noOcclusion().isRedstoneConductor(false).isSuffocating(false));
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, IBlockReader level, BlockPos pos, ISelectionContext context){
        return VoxelShapes.empty();
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState neighborState, Direction neighborSide){
        return neighborState.is(this) || super.skipRendering(state, neighborState, neighborSide);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader level, BlockPos pos){
        return true;
    }

    @Override
    public DyeColor getColor(){
        return DyeColor.GREEN;
    }

    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader level, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, EntityType<?> entityType){
        return false;
    }
}
