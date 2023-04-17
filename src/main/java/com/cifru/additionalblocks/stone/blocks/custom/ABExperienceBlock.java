package com.cifru.additionalblocks.stone.blocks.custom;

import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
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
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean bl){
        super.spawnAfterBreak(state, level, pos, stack, bl);
        if(bl && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0){
            int xp = RANDOM.nextInt(this.maxExperience);
            if(xp > 0)
                this.popExperience(level, pos, xp);
        }
    }
}
