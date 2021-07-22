package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class BasicBlock extends Block implements IConfigObject, IItemGroupIndex {

    private final Supplier<Boolean> enable;

    public BasicBlock(String registryName, Supplier<Boolean> configValue, AbstractBlock.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }
    public BasicBlock(String registryName, AbstractBlock.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = ()->true;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
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
