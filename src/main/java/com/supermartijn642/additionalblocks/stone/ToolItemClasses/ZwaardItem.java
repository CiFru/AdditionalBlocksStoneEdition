package com.supermartijn642.additionalblocks.stone.ToolItemClasses;

import com.supermartijn642.additionalblocks.stone.IConfigObject;
import com.supermartijn642.additionalblocks.stone.IItemGroupIndex;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

public class ZwaardItem extends SwordItem implements IConfigObject, IItemGroupIndex {

    private final Supplier<Boolean> enable;

    public ZwaardItem(String registryName, Supplier<Boolean> enable, Properties properties, int attackDamage, float attackSpeed) {
        super(ItemTier.IRON, attackDamage, attackSpeed, properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public int getItemGroupIndex() {
        return 4;
    }
}
