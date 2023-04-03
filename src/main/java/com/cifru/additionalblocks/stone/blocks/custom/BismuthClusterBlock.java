package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.block.BlockShape;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

/**
 * Created 22/03/2023 by SuperMartijn642
 */
public class BismuthClusterBlock extends BaseBlock {

    private static final BlockShape SHAPE = BlockShape.create(
        BlockShape.or(
            BlockShape.createBlockShape(5, 2, 4, 12, 4, 11),
            BlockShape.createBlockShape(6, 0, 5, 11, 2, 10),
            BlockShape.createBlockShape(12, 4, 4, 13, 6, 12),
            BlockShape.createBlockShape(4, 4, 4, 7, 6, 8),
            BlockShape.createBlockShape(8, 4, 9, 12, 6, 12),
            BlockShape.createBlockShape(4, 4, 3, 12, 6, 4),
            BlockShape.createBlockShape(4, 4, 11, 8, 6, 12),
            BlockShape.createBlockShape(8, 4, 4, 12, 6, 8),
            BlockShape.createBlockShape(4, 4, 8, 5, 6, 11),
            BlockShape.createBlockShape(3, 6, 7, 4, 8, 12),
            BlockShape.createBlockShape(9, 6, 3, 10, 8, 6),
            BlockShape.createBlockShape(13, 6, 6, 14, 8, 10),
            BlockShape.createBlockShape(3, 6, 2, 6, 8, 7),
            BlockShape.createBlockShape(10, 6, 2, 12, 8, 5),
            BlockShape.createBlockShape(13, 6, 13, 14, 8, 14),
            BlockShape.createBlockShape(2, 6, 2, 3, 8, 3),
            BlockShape.createBlockShape(12, 6, 4, 14, 8, 6),
            BlockShape.createBlockShape(9, 6, 10, 14, 8, 13),
            BlockShape.createBlockShape(3, 6, 12, 9, 8, 13),
            BlockShape.createBlockShape(9, 6, 6, 13, 8, 7),
            BlockShape.createBlockShape(6, 6, 2, 10, 8, 3),
            BlockShape.createBlockShape(1, 8, 1, 5, 10, 4),
            BlockShape.createBlockShape(12, 8, 11, 15, 10, 15),
            BlockShape.createBlockShape(2, 8, 4, 5, 10, 6),
            BlockShape.createBlockShape(10, 8, 11, 12, 10, 14),
            BlockShape.createBlockShape(5, 8, 1, 12, 10, 2),
            BlockShape.createBlockShape(14, 8, 4, 15, 10, 11),
            BlockShape.createBlockShape(11, 8, 5, 14, 10, 6),
            BlockShape.createBlockShape(11, 8, 4, 14, 10, 5),
            BlockShape.createBlockShape(11, 8, 2, 12, 10, 4),
            BlockShape.createBlockShape(2, 8, 6, 3, 10, 14),
            BlockShape.createBlockShape(10, 8, 2, 11, 10, 6),
            BlockShape.createBlockShape(3, 8, 13, 10, 10, 14),
            BlockShape.createBlockShape(1, 10, 4, 2, 12, 14),
            BlockShape.createBlockShape(2, 10, 4, 4, 12, 5),
            BlockShape.createBlockShape(3, 10, 2, 4, 12, 4),
            BlockShape.createBlockShape(2, 10, 2, 3, 12, 3),
            BlockShape.createBlockShape(0, 10, 0, 1, 12, 5),
            BlockShape.createBlockShape(1, 10, 0, 11, 12, 1),
            BlockShape.createBlockShape(11, 10, 0, 12, 12, 4),
            BlockShape.createBlockShape(11, 10, 4, 16, 12, 5),
            BlockShape.createBlockShape(15, 10, 5, 16, 12, 15),
            BlockShape.createBlockShape(11, 10, 15, 16, 12, 16),
            BlockShape.createBlockShape(1, 10, 14, 12, 12, 15),
            BlockShape.createBlockShape(11, 10, 12, 12, 12, 14),
            BlockShape.createBlockShape(12, 10, 12, 14, 12, 13),
            BlockShape.createBlockShape(13, 10, 13, 14, 12, 14)
        ).getUnderlying().optimize()
    );

    public BismuthClusterBlock(BlockProperties properties){
        super(false, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader level, BlockPos position, ISelectionContext context){
        return SHAPE.getUnderlying();
    }
}
