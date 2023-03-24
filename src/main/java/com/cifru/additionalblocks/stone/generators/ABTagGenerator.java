package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.cifru.additionalblocks.stone.items.ItemType;
import com.supermartijn642.core.generator.ResourceCache;
import com.supermartijn642.core.generator.TagGenerator;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABTagGenerator extends TagGenerator {

    public ABTagGenerator(ResourceCache cache){
        super("abstoneedition", cache);
    }

    @Override
    public void generate(){
        // Generate tags for all blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            blockType.getBlockTags().stream().map(this::blockTag).forEach(tag -> tag.add(blockType.getBlock()));
            blockType.getBlockTags().stream().map(this::itemTag).forEach(tag -> tag.add(blockType.getItem()));
        }
        // Generate tags for all items
        for(ItemType<?> itemType : AdditionalBlocksItems.ALL_ITEMS)
            itemType.getTags().stream().map(this::itemTag).forEach(tag -> tag.add(itemType.getItem()));
    }
}
