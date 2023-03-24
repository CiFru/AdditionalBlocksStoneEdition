package com.supermartijn642.additionalblocks.stone.items.custom;

import com.supermartijn642.additionalblocks.stone.tools.ABToolMaterial;
import com.supermartijn642.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABAxeItem extends ABToolItem {

    public ABAxeItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.AXE);
    }
}
