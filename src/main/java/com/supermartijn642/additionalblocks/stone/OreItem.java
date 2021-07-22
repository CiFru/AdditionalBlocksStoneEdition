package com.supermartijn642.additionalblocks.stone;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

public class OreItem extends Item implements IConfigObject, IItemGroupIndex {

    private final Supplier<Boolean> enable;

    public OreItem(String registryName, Supplier<Boolean> enable, Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public int getItemGroupIndex() {
        return 3;
    }
}
