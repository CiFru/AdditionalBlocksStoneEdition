package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class BasicBlock extends Block implements IConfigObject {

    public BasicBlock(String registryName, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
//    System.out.println("configvalue: "+(AdditionalBlocksConfig.enableMarble.get()));
//    if (AdditionalBlocksConfig.enableMarble.get())
            super.fillItemGroup(group, items);
    }

    @Override
    public boolean isEnabled() {
        System.out.println("TEST5!"+AdditionalBlocksConfig.enableMarble.get());
        return AdditionalBlocksConfig.enableMarble.get();
    }
}
