package com.supermartijn642.additionalblocks.stone;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface IHarvestableBlock {

    ToolType getHarvestToolType();

    ToolTier getHarvestToolTier();

    enum ToolType {
        PICKAXE(BlockTags.MINEABLE_WITH_PICKAXE), SHOVEL(BlockTags.MINEABLE_WITH_SHOVEL), AXE(BlockTags.MINEABLE_WITH_AXE), HOE(BlockTags.MINEABLE_WITH_HOE);

        public final TagKey<Block> tag;

        ToolType(TagKey<Block> tag) {
            this.tag = tag;
        }
    }

    enum ToolTier {
        WOOD(BlockTags.MINEABLE_WITH_PICKAXE), STONE(BlockTags.NEEDS_STONE_TOOL), GOLD(BlockTags.MINEABLE_WITH_PICKAXE), IRON(BlockTags.NEEDS_IRON_TOOL), DIAMOND(BlockTags.NEEDS_DIAMOND_TOOL), NETHERITE(BlockTags.NEEDS_DIAMOND_TOOL); // TODO

        public final TagKey<Block> tag;

        ToolTier(TagKey<Block> tag) {
            this.tag = tag;
        }
    }
}
