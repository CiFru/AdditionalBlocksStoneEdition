package com.supermartijn642.additionalblocks.stone.ToolItemClasses;

import com.supermartijn642.additionalblocks.stone.IConfigObject;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

import java.util.function.Supplier;

public class BijlItem extends AxeItem implements IConfigObject {

    private final Supplier<Boolean> enable;

    public BijlItem(String registryName, Supplier<Boolean> enable, Properties properties, float attackDamage, float attackSpeed) {
        super(ItemTier.IRON, attackDamage, attackSpeed, properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }
}
