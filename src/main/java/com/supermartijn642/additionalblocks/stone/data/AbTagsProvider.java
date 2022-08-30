package com.supermartijn642.additionalblocks.stone.data;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import javax.annotation.Nullable;

/**
 * Created 7/25/2021 by SuperMartijn642
 */
public class AbTagsProvider extends BlockTagsProvider {

    public AbTagsProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void registerTags() {
        for (Block block : AdditionalBlocks.blocks) {
            if (block instanceof WallBlock)
                this.getOrCreateBuilder(BlockTags.WALLS).add(block);
        }
    }
}
