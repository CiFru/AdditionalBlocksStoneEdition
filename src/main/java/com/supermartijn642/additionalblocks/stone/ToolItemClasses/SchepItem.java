package com.supermartijn642.additionalblocks.stone.ToolItemClasses;

import com.supermartijn642.additionalblocks.stone.IConfigObject;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;

import java.util.function.Supplier;

public class SchepItem extends ShovelItem implements IConfigObject {

    private final Supplier<Boolean> enable;

    public SchepItem(String registryName, Supplier<Boolean> enable, Properties properties, float attackDamage, float attackSpeed) {
        super(ItemTier.IRON, attackDamage, attackSpeed, properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }
}