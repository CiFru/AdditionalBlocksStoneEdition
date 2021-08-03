package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Random;
import java.util.function.Supplier;

public class OorBlock extends OreBlock implements IConfigObject, IItemGroupIndex, IHarvestableBlock{
    private final Supplier<Boolean> enable;
    private final IHarvestableBlock.ToolType toolType;
    private final IHarvestableBlock.ToolTier toolTier;

    public OorBlock(String registryName, Supplier<Boolean> configValue, BlockBehaviour.Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
        this.toolType = toolType;
        this.toolTier = toolTier;
    }

    public OorBlock(String registryName, BlockBehaviour.Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = () -> true;
        this.toolType = toolType;
        this.toolTier = toolTier;
    }

    protected int xpOnDrop(Random rand) {
            return this == AdditionalBlocks.silver_ore ? Mth.nextInt(rand, 0, 3) : 0;
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

    @Override
    public ToolType getHarvestToolType() {
        return this.toolType;
    }

    @Override
    public ToolTier getHarvestToolTier() {
        return this.toolTier;
    }
}

