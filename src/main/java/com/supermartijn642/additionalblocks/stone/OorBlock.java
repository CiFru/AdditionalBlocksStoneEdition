package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
import java.util.function.Supplier;

public class OorBlock extends DropExperienceBlock implements IConfigObject, IItemGroupIndex, IHarvestableBlock, RegistryNameHolder {
    private final Supplier<Boolean> enable;
    private final IHarvestableBlock.ToolType toolType;
    private final IHarvestableBlock.ToolTier toolTier;
    private final String registryName;

    public OorBlock(String registryName, Supplier<Boolean> configValue, BlockBehaviour.Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.registryName = registryName;
        this.enable = configValue;
        this.toolType = toolType;
        this.toolTier = toolTier;
    }

    public OorBlock(String registryName, BlockBehaviour.Properties properties, ToolType toolType, ToolTier toolTier) {
        super(properties);
        this.registryName = registryName;
        this.enable = () -> true;
        this.toolType = toolType;
        this.toolTier = toolTier;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource rand, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
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

    @Override
    public String getRegistryName() {
        return this.registryName;
    }
}

