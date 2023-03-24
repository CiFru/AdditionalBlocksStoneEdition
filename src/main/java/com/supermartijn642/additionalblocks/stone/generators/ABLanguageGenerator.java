package com.supermartijn642.additionalblocks.stone.generators;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import com.supermartijn642.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.supermartijn642.additionalblocks.stone.blocks.BlockType;
import com.supermartijn642.additionalblocks.stone.items.AdditionalBlocksItems;
import com.supermartijn642.additionalblocks.stone.items.ItemType;
import com.supermartijn642.core.generator.LanguageGenerator;
import com.supermartijn642.core.generator.ResourceCache;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
public class ABLanguageGenerator extends LanguageGenerator {

    public ABLanguageGenerator(ResourceCache cache){
        super("abstoneedition", cache, "en_us");
    }

    @Override
    public void generate(){
        this.itemGroup(AdditionalBlocks.ITEM_GROUP, "Additional Blocks - Stone Edition");

        // Generate translations for all blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            String translation = blockType.getLanguagePreset();
            if(translation == null)
                throw new IllegalStateException("Missing translation for block type '" + blockType.getIdentifier() + "'!");
            this.block(blockType.getBlock(), translation);
        }
        // Generate translations for all items
        for(ItemType<?> itemType : AdditionalBlocksItems.ALL_ITEMS){
            String translation = itemType.getLanguagePreset();
            if(translation == null)
                throw new IllegalStateException("Missing translation for item type '" + itemType.getIdentifier() + "'!");
            this.item(itemType.getItem(), translation);
        }
    }
}
