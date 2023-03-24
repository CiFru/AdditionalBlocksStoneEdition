package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
public class ABExperienceBlock extends BaseBlock {

    private final int maxExperience;

    public ABExperienceBlock(BlockProperties properties, int maxExperience){
        super(false, properties);
        this.maxExperience = maxExperience;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource random, BlockPos pos, int fortuneLevel, int silkTouchLevel){
        return Mth.nextInt(random, 0, this.maxExperience);
    }
}
