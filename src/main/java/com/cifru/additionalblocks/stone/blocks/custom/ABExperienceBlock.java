package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
public class ABExperienceBlock extends BaseBlock {

    private static final Random RANDOM = new Random();

    private final int maxExperience;

    public ABExperienceBlock(BlockProperties properties, int maxExperience){
        super(false, properties);
        this.maxExperience = maxExperience;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, BlockPos pos, int fortuneLevel, int silkTouchLevel){
        return silkTouchLevel == 0 ? RANDOM.nextInt(this.maxExperience) : 0;
    }
}
