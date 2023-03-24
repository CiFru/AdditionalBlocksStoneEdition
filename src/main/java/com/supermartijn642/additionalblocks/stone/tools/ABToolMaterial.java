package com.supermartijn642.additionalblocks.stone.tools;

import com.supermartijn642.additionalblocks.stone.items.AdditionalBlocksItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public enum ABToolMaterial {

    COPPER(ToolTier.IRON, 6, 2, 250, 14, () -> Items.COPPER_INGOT),
    SILVER(ToolTier.IRON, 6, 2, 250, 14, AdditionalBlocksItems.SILVER_INGOT::getItem),
    BISMUTH(ToolTier.DIAMOND, 8, 3, 1561, 10, AdditionalBlocksItems.BISMUTH_INGOT::getItem);

    private final ToolTier miningTier;
    private final int miningSpeed;
    private final int attackDamage;
    private final int durability;
    private final int enchantmentValue;
    private final Supplier<Item> repairItem;

    ABToolMaterial(ToolTier miningTier, int miningSpeed, int attackDamage, int durability, int enchantmentValue, Supplier<Item> repairItem){
        this.miningTier = miningTier;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.durability = durability;
        this.enchantmentValue = enchantmentValue;
        this.repairItem = repairItem;
    }

    public ToolTier getMiningTier(){
        return this.miningTier;
    }

    public int getMiningSpeed(){
        return this.miningSpeed;
    }

    public int getAttackDamage(){
        return this.attackDamage;
    }

    public int getDurability(){
        return this.durability;
    }

    public int getEnchantmentValue(){
        return this.enchantmentValue;
    }

    public Supplier<Item> getRepairItem(){
        return this.repairItem;
    }
}
