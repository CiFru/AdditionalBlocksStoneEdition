package com.cifru.additionalblocks.stone.tools;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public enum ToolTier {

    WOOD(BlockTags.MINEABLE_WITH_PICKAXE, Tiers.WOOD), STONE(BlockTags.NEEDS_STONE_TOOL, Tiers.STONE), GOLD(BlockTags.MINEABLE_WITH_PICKAXE, Tiers.GOLD), IRON(BlockTags.NEEDS_IRON_TOOL, Tiers.IRON), DIAMOND(BlockTags.NEEDS_DIAMOND_TOOL, Tiers.DIAMOND), NETHERITE(BlockTags.NEEDS_DIAMOND_TOOL, Tiers.NETHERITE);

    private final Tag.Named<Block> materialTag;
    private final Tier vanillaTier;

    ToolTier(Tag.Named<Block> materialTag, Tier vanillaTier){
        this.materialTag = materialTag;
        this.vanillaTier = vanillaTier;
    }

    public Tag.Named<Block> getMaterialTag(){
        return this.materialTag;
    }

    public Tier getVanillaTier(){
        return this.vanillaTier;
    }
}
