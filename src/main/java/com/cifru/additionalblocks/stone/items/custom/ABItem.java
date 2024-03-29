package com.cifru.additionalblocks.stone.items.custom;

import com.supermartijn642.core.item.BaseItem;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.world.item.CreativeModeTab;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABItem extends BaseItem {

    private final Supplier<Boolean> enabled;

    public ABItem(ItemProperties properties, Supplier<Boolean> enabled){
        super(properties);
        this.enabled = enabled;
    }

    @Override
    public Collection<CreativeModeTab> getCreativeTabs(){
        return this.enabled.get() ? super.getCreativeTabs() : Collections.emptyList();
    }
}
