package com.supermartijn642.additionalblocks.stone.items;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocksConfig;
import com.supermartijn642.additionalblocks.stone.items.custom.*;
import com.supermartijn642.additionalblocks.stone.tools.ABToolMaterial;
import com.supermartijn642.core.item.BaseItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class AdditionalBlocksItems {

    public static final List<ItemType<?>> ALL_ITEMS;
    private static final Consumer<ItemType<?>> COLLECTOR;

    static{
        List<ItemType<?>> blocks = new ArrayList<>();
        ALL_ITEMS = Collections.unmodifiableList(blocks);
        COLLECTOR = blocks::add;
    }

    // ---- Items ----
    // Copper
    public static final ItemType<BaseItem> COPPER_NUGGET = ItemBuilder.create("copper_nugget").translation("Copper Nugget").configOption(AdditionalBlocksConfig.enableCopper).tag("forge", "nuggets").tag("forge", "nuggets/copper").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> COPPER_AXE = ItemBuilder.create("copper_axe").translation("Copper Axe").configOption(AdditionalBlocksConfig.enableCopper).buildCustom((properties, enabled) -> new ABAxeItem(properties, enabled, ABToolMaterial.COPPER), COLLECTOR);
    public static final ItemType<BaseItem> COPPER_PICKAXE = ItemBuilder.create("copper_pickaxe").translation("Copper Pickaxe").configOption(AdditionalBlocksConfig.enableCopper).buildCustom((properties, enabled) -> new ABPickaxeItem(properties, enabled, ABToolMaterial.COPPER), COLLECTOR);
    public static final ItemType<BaseItem> COPPER_SHOVEL = ItemBuilder.create("copper_shovel").translation("Copper Shovel").configOption(AdditionalBlocksConfig.enableCopper).buildCustom((properties, enabled) -> new ABShovelItem(properties, enabled, ABToolMaterial.COPPER), COLLECTOR);
    public static final ItemType<BaseItem> COPPER_HOE = ItemBuilder.create("copper_hoe").translation("Copper Hoe").configOption(AdditionalBlocksConfig.enableCopper).buildCustom((properties, enabled) -> new ABHoeItem(properties, enabled, ABToolMaterial.COPPER), COLLECTOR);
    public static final ItemType<BaseItem> COPPER_SWORD = ItemBuilder.create("copper_sword").translation("Copper Sword").configOption(AdditionalBlocksConfig.enableCopper).buildCustom((properties, enabled) -> new ABSwordItem(properties, enabled, ABToolMaterial.COPPER), COLLECTOR);
    // Silver
    public static final ItemType<BaseItem> SILVER_INGOT = ItemBuilder.create("silver_ingot").translation("Silver Ingot").configOption(AdditionalBlocksConfig.enableSilver).tag("forge", "ingots").tag("forge", "ingots/silver").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> SILVER_NUGGET = ItemBuilder.create("silver_nugget").translation("Silver Nugget").configOption(AdditionalBlocksConfig.enableSilver).tag("forge", "nuggets").tag("forge", "nuggets/silver").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> RAW_SILVER = ItemBuilder.create("raw_silver").translation("Raw Silver").configOption(AdditionalBlocksConfig.enableSilver).tag("forge", "raw_materials").tag("forge", "raw_materials/silver").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> SILVER_AXE = ItemBuilder.create("silver_axe").translation("Silver Axe").configOption(AdditionalBlocksConfig.enableSilver).buildCustom((properties, enabled) -> new ABAxeItem(properties, enabled, ABToolMaterial.SILVER), COLLECTOR);
    public static final ItemType<BaseItem> SILVER_PICKAXE = ItemBuilder.create("silver_pickaxe").translation("Silver Pickaxe").configOption(AdditionalBlocksConfig.enableSilver).buildCustom((properties, enabled) -> new ABPickaxeItem(properties, enabled, ABToolMaterial.SILVER), COLLECTOR);
    public static final ItemType<BaseItem> SILVER_SHOVEL = ItemBuilder.create("silver_shovel").translation("Silver Shovel").configOption(AdditionalBlocksConfig.enableSilver).buildCustom((properties, enabled) -> new ABShovelItem(properties, enabled, ABToolMaterial.SILVER), COLLECTOR);
    public static final ItemType<BaseItem> SILVER_HOE = ItemBuilder.create("silver_hoe").translation("Silver Hoe").configOption(AdditionalBlocksConfig.enableSilver).buildCustom((properties, enabled) -> new ABHoeItem(properties, enabled, ABToolMaterial.SILVER), COLLECTOR);
    public static final ItemType<BaseItem> SILVER_SWORD = ItemBuilder.create("silver_sword").translation("Silver Sword").configOption(AdditionalBlocksConfig.enableSilver).buildCustom((properties, enabled) -> new ABSwordItem(properties, enabled, ABToolMaterial.SILVER), COLLECTOR);
    // Bismuth
    public static final ItemType<BaseItem> BISMUTH_INGOT = ItemBuilder.create("bismuth_ingot").translation("Bismuth Ingot").configOption(AdditionalBlocksConfig.enableBismuth).tag("forge", "ingots").tag("forge", "ingots/bismuth").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> RAW_BISMUTH = ItemBuilder.create("raw_bismuth_chunk").translation("Bismuth Nugget").configOption(AdditionalBlocksConfig.enableBismuth).tag("forge", "raw_materials").tag("forge", "raw_materials/bismuth").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_NUGGET = ItemBuilder.create("bismuth_nugget").translation("Bismuth Crystal").configOption(AdditionalBlocksConfig.enableBismuth).tag("forge", "nuggets").tag("forge", "nuggets/bismuth").buildRegular(COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_AXE = ItemBuilder.create("bismuth_axe").translation("Bismuth Axe").configOption(AdditionalBlocksConfig.enableBismuth).buildCustom((properties, enabled) -> new ABAxeItem(properties, enabled, ABToolMaterial.BISMUTH), COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_PICKAXE = ItemBuilder.create("bismuth_pickaxe").translation("Bismuth Pickaxe").configOption(AdditionalBlocksConfig.enableBismuth).buildCustom((properties, enabled) -> new ABPickaxeItem(properties, enabled, ABToolMaterial.BISMUTH), COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_SHOVEL = ItemBuilder.create("bismuth_shovel").translation("Bismuth Shovel").configOption(AdditionalBlocksConfig.enableBismuth).buildCustom((properties, enabled) -> new ABShovelItem(properties, enabled, ABToolMaterial.BISMUTH), COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_HOE = ItemBuilder.create("bismuth_hoe").translation("Bismuth Hoe").configOption(AdditionalBlocksConfig.enableBismuth).buildCustom((properties, enabled) -> new ABHoeItem(properties, enabled, ABToolMaterial.BISMUTH), COLLECTOR);
    public static final ItemType<BaseItem> BISMUTH_SWORD = ItemBuilder.create("bismuth_sword").translation("Bismuth Sword").configOption(AdditionalBlocksConfig.enableBismuth).buildCustom((properties, enabled) -> new ABSwordItem(properties, enabled, ABToolMaterial.BISMUTH), COLLECTOR);

    public static void init(){
        // Cause the class to be loaded
    }
}
