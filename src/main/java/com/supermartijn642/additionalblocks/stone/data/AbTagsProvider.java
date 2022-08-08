package com.supermartijn642.additionalblocks.stone.data;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import com.supermartijn642.additionalblocks.stone.IHarvestableBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

/**
 * Created 7/25/2021 by SuperMartijn642
 */
public class AbTagsProvider extends BlockTagsProvider {

    public AbTagsProvider(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (Block block : AdditionalBlocks.blocks) {
            if (block instanceof WallBlock)
                this.tag(BlockTags.WALLS).add(block);
            if (block instanceof IHarvestableBlock) {
                if (((IHarvestableBlock) block).getHarvestToolType() != null)
                    this.tag(((IHarvestableBlock) block).getHarvestToolType().tag).add(block);
                if (((IHarvestableBlock) block).getHarvestToolTier() != null)
                    this.tag(((IHarvestableBlock) block).getHarvestToolTier().tag).add(block);
            } else
                System.err.println("Block '" + ForgeRegistries.BLOCKS.getKey(block) + "' of class '" + block.getClass() + "' doesn't implement IHarvestableBlock, you idiot!");
        }
    }
}
