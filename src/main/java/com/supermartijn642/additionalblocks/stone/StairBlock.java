package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class StairBlock extends StairBlock implements IConfigObject, IItemGroupIndex {

    private final BasicBlock block;

    public StairBlock(BasicBlock block, Properties properties) {
        super(block::defaultBlockState, properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_stairs");
        this.block = block;
    }

    public StairBlock(BasicBlock block, String registryName, Properties properties) {
        super(block::defaultBlockState, properties);
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
        return 1;
    }
}
