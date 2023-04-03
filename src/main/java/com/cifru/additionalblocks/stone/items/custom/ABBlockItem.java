package com.cifru.additionalblocks.stone.items.custom;

import com.supermartijn642.core.item.BaseBlockItem;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

/**
 * Created 16/03/2023 by SuperMartijn642
 */
public class ABBlockItem extends BaseBlockItem {

    private final Supplier<Boolean> enabled;

    public ABBlockItem(Block block, ItemProperties properties, Supplier<Boolean> enabled){
        super(block, properties);
        this.enabled = enabled;
    }

    @Override
    public Collection<ItemGroup> getCreativeTabs(){
        return this.enabled.get() ? super.getCreativeTabs() : Collections.emptyList();
    }
}
