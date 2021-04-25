package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;

import java.util.Random;
import java.util.function.Supplier;

public class OorBlock extends OreBlock implements IConfigObject {
    private final Supplier<Boolean> enable;

    public OorBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public OorBlock(String registryName, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = () -> true;
    }

    protected int getExperience(Random rand) {
        if (this == AdditionalBlocks.copper_ore) {
            return MathHelper.nextInt(rand, 0, 2);
        } else {
            return this == AdditionalBlocks.silver_ore ? MathHelper.nextInt(rand, 0, 3) : 0;
        }
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }
}

