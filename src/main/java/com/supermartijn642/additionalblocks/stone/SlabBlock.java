package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class SlabBlock extends net.minecraft.world.level.block.SlabBlock implements IConfigObject, IItemGroupIndex, IHarvestableBlock  {

    private final Block block;
    private final Supplier<Boolean> enabled;
    private final IHarvestableBlock.ToolType toolType;
    private final IHarvestableBlock.ToolTier toolTier;

    public SlabBlock(BasicBlock block, Properties properties, ToolType toolType, ToolTier toolTier) {
        this(block, block.getRegistryName().getPath() + "_slab", properties, toolType, toolTier);
    }

    public SlabBlock(Block block, Supplier<Boolean> enabled, Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_slab");
        this.block = block;
        this.enabled = enabled;
        this.toolType = toolType;
        this.toolTier = toolTier;
    }

    public SlabBlock(BasicBlock block, String registryName, Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.setRegistryName(registryName);
        this.block = block;
        this.enabled = block::isEnabled;
        this.toolType = toolType;
        this.toolTier = toolTier;
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
        return 2;
    }

    @Override
    public ToolType getHarvestToolType() {
        return this.toolType;
    }

    @Override
    public ToolTier getHarvestToolTier() {
        return this.toolTier;
    }
}
