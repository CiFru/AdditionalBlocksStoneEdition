package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class StairBlock extends net.minecraft.world.level.block.StairBlock implements IConfigObject, IItemGroupIndex {

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
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
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
