package com.supermartijn642.additionalblocks.stone.ToolItemClasses;

import com.supermartijn642.additionalblocks.stone.IConfigObject;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;

import java.util.function.Supplier;

public class SchoffelItem extends HoeItem implements IConfigObject {

    private final Supplier<Boolean> enable;

    public SchoffelItem(String registryName, Supplier<Boolean> enable, Properties properties, int attackDamage, float attackSpeed) {
        super(ItemTier.IRON, attackDamage, attackSpeed, properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }
}

