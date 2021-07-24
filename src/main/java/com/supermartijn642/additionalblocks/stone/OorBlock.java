package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Random;
import java.util.function.Supplier;

public class OorBlock extends OreBlock implements IConfigObject, IItemGroupIndex{
    private final Supplier<Boolean> enable;

    public OorBlock(String registryName, Supplier<Boolean> configValue, BlockBehaviour.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public OorBlock(String registryName, BlockBehaviour.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = () -> true;
    }

    protected int xpOnDrop(Random rand) {
//        if (this == AdditionalBlocks.copper_ore) {
//            return Mth.nextInt(rand, 0, 2);
//        } else {
            return this == AdditionalBlocks.silver_ore ? Mth.nextInt(rand, 0, 3) : 0;
//        }
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }

    @Override
    public int getItemGroupIndex() {
        return 0;
    }
}

