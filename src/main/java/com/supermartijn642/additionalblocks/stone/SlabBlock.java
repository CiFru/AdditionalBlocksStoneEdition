package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class SlabBlock extends net.minecraft.world.level.block.SlabBlock implements IConfigObject, IItemGroupIndex {

    private final BasicBlock block;

    public SlabBlock(BasicBlock block, Properties properties) {
        super(properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_slab");
        this.block = block;
    }

    public SlabBlock(BasicBlock block, String registryName, Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.block = block;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.block.isEnabled();
    }

    @Override
    public int getItemGroupIndex() {
        return 2;
    }
}
