package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class BasicBlock extends Block implements IConfigObject, IItemGroupIndex {

    private final Supplier<Boolean> enable;

    public BasicBlock(String registryName, Supplier<Boolean> configValue, BlockBehaviour.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }
    public BasicBlock(String registryName, BlockBehaviour.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = ()->true;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }

    @Override
    public int getItemGroupIndex() {
        return 0;
    }
}
