package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABHoeItem extends ABToolItem {

    public ABHoeItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.HOE);
    }
}
