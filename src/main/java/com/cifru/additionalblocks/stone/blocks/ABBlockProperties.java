package com.cifru.additionalblocks.stone.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.*;

/**
 * Created 1/16/2021 by SuperMartijn642
 */
public class ABBlockProperties {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final EnumProperty<SlabType> SLAB_TYPE = BlockStateProperties.SLAB_TYPE;
    public static final EnumProperty<Half> STAIR_HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> STAIR_SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty WALL_POST = BlockStateProperties.UP;
    public static final EnumProperty<WallSide> WALL_NORTH = BlockStateProperties.NORTH_WALL;
    public static final EnumProperty<WallSide> WALL_EAST = BlockStateProperties.EAST_WALL;
    public static final EnumProperty<WallSide> WALL_SOUTH = BlockStateProperties.SOUTH_WALL;
    public static final EnumProperty<WallSide> WALL_WEST = BlockStateProperties.WEST_WALL;
    public static final BooleanProperty CONNECTION_NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty CONNECTION_EAST = BlockStateProperties.EAST;
    public static final BooleanProperty CONNECTION_SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty CONNECTION_WEST = BlockStateProperties.WEST;
}
