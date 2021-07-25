package com.supermartijn642.additionalblocks.stone;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class StairBlock extends StairsBlock implements IConfigObject, IItemGroupIndex {

    private final Block block;
    private final Supplier<Boolean> enabled;

    public StairBlock(BasicBlock block, Properties properties) {
        this(block, block.getRegistryName().getPath() + "_stairs", properties);
    }

    public StairBlock(Block block, Supplier<Boolean> enabled, Properties properties) {
        super(block::defaultBlockState, properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_stairs");
        this.block = block;
        this.enabled = enabled;
    }

    public StairBlock(BasicBlock block, String registryName, Properties properties) {
        super(block::defaultBlockState, properties);
        this.setRegistryName(registryName);
        this.block = block;
        this.enabled = block::isEnabled;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.enabled.get();
    }

    @Override
    public int getItemGroupIndex() {
        return 1;
    }
}
