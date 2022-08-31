package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class ClusterBlock extends BasicBlock {
    private static final VoxelShape SHAPE = VoxelShapes.or(
        Block.makeCuboidShape(5, 2, 4, 12, 4, 11),
        Block.makeCuboidShape(6, 0, 5, 11, 2, 10),
        Block.makeCuboidShape(12, 4, 4, 13, 6, 12),
        Block.makeCuboidShape(4, 4, 4, 7, 6, 8),
        Block.makeCuboidShape(8, 4, 9, 12, 6, 12),
        Block.makeCuboidShape(4, 4, 3, 12, 6, 4),
        Block.makeCuboidShape(4, 4, 11, 8, 6, 12),
        Block.makeCuboidShape(8, 4, 4, 12, 6, 8),
        Block.makeCuboidShape(4, 4, 8, 5, 6, 11),
        Block.makeCuboidShape(3, 6, 7, 4, 8, 12),
        Block.makeCuboidShape(9, 6, 3, 10, 8, 6),
        Block.makeCuboidShape(13, 6, 6, 14, 8, 10),
        Block.makeCuboidShape(3, 6, 2, 6, 8, 7),
        Block.makeCuboidShape(10, 6, 2, 12, 8, 5),
        Block.makeCuboidShape(13, 6, 13, 14, 8, 14),
        Block.makeCuboidShape(2, 6, 2, 3, 8, 3),
        Block.makeCuboidShape(12, 6, 4, 14, 8, 6),
        Block.makeCuboidShape(9, 6, 10, 14, 8, 13),
        Block.makeCuboidShape(3, 6, 12, 9, 8, 13),
        Block.makeCuboidShape(9, 6, 6, 13, 8, 7),
        Block.makeCuboidShape(6, 6, 2, 10, 8, 3),
        Block.makeCuboidShape(1, 8, 1, 5, 10, 4),
        Block.makeCuboidShape(12, 8, 11, 15, 10, 15),
        Block.makeCuboidShape(2, 8, 4, 5, 10, 6),
        Block.makeCuboidShape(10, 8, 11, 12, 10, 14),
        Block.makeCuboidShape(5, 8, 1, 12, 10, 2),
        Block.makeCuboidShape(14, 8, 4, 15, 10, 11),
        Block.makeCuboidShape(11, 8, 5, 14, 10, 6),
        Block.makeCuboidShape(11, 8, 4, 14, 10, 5),
        Block.makeCuboidShape(11, 8, 2, 12, 10, 4),
        Block.makeCuboidShape(2, 8, 6, 3, 10, 14),
        Block.makeCuboidShape(10, 8, 2, 11, 10, 6),
        Block.makeCuboidShape(3, 8, 13, 10, 10, 14),
        Block.makeCuboidShape(1, 10, 4, 2, 12, 14),
        Block.makeCuboidShape(2, 10, 4, 4, 12, 5),
        Block.makeCuboidShape(3, 10, 2, 4, 12, 4),
        Block.makeCuboidShape(2, 10, 2, 3, 12, 3),
        Block.makeCuboidShape(0, 10, 0, 1, 12, 5),
        Block.makeCuboidShape(1, 10, 0, 11, 12, 1),
        Block.makeCuboidShape(11, 10, 0, 12, 12, 4),
        Block.makeCuboidShape(11, 10, 4, 16, 12, 5),
        Block.makeCuboidShape(15, 10, 5, 16, 12, 15),
        Block.makeCuboidShape(11, 10, 15, 16, 12, 16),
        Block.makeCuboidShape(1, 10, 14, 12, 12, 15),
        Block.makeCuboidShape(11, 10, 12, 12, 12, 14),
        Block.makeCuboidShape(12, 10, 12, 14, 12, 13),
        Block.makeCuboidShape(13, 10, 13, 14, 12, 14)
    ).simplify();

    public ClusterBlock(String registryName, Supplier<Boolean> configValue, Properties properties) {
        super(registryName, configValue, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader level, BlockPos position, ISelectionContext context) {
        return SHAPE;
    }
}
