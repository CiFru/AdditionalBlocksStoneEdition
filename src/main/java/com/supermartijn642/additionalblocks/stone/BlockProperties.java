package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * Created 1/16/2021 by SuperMartijn642
 */
public class BlockProperties {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

}
