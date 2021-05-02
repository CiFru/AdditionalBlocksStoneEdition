package com.supermartijn642.additionalblocks.stone.ToolItemClasses;

import com.supermartijn642.additionalblocks.stone.IConfigObject;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

import java.util.function.Supplier;

public class ZwaardItem extends SwordItem implements IConfigObject {

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
}
