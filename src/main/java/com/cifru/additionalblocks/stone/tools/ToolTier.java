package com.cifru.additionalblocks.stone.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public enum ToolTier {

    WOOD(null, ItemTier.WOOD), STONE(new ResourceLocation("minecraft", "needs_stone_tool"), ItemTier.STONE), GOLD(null, ItemTier.GOLD), IRON(new ResourceLocation("minecraft", "needs_iron_tool"), ItemTier.IRON), DIAMOND(new ResourceLocation("minecraft", "needs_diamond_tool"), ItemTier.DIAMOND), NETHERITE(new ResourceLocation("minecraft", "needs_diamond_tool"), ItemTier.NETHERITE);

    private final ResourceLocation materialTag;
    private final IItemTier vanillaTier;

    ToolTier(ResourceLocation materialTag, IItemTier vanillaTier){
        this.materialTag = materialTag;
        this.vanillaTier = vanillaTier;
    }

    public ResourceLocation getMaterialTag(){
        return this.materialTag;
    }

    public IItemTier getVanillaTier(){
        return this.vanillaTier;
    }
}
