package com.supermartijn642.additionalblocks.stone.blocks;

import com.supermartijn642.additionalblocks.stone.generators.ABBlockStateGenerator;
import com.supermartijn642.additionalblocks.stone.generators.ABLootTableGenerator;
import com.supermartijn642.additionalblocks.stone.generators.ABModelGenerator;
import com.supermartijn642.additionalblocks.stone.generators.ABRecipeGenerator;
import com.supermartijn642.core.block.BaseBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class BlockType<T extends BaseBlock> implements ItemLike {

    private final ResourceLocation identifier;
    private final Supplier<Boolean> configOption;
    private final Supplier<T> block;
    private final Supplier<? extends BlockItem> item;
    private final Set<ResourceLocation> blockTags;

    private final ABBlockStateGenerator.BlockPreset blockStatePreset;
    private final ABLootTableGenerator.BlockPreset lootTablePreset;
    private final ABModelGenerator.BlockPreset modelPreset;
    private final ABRecipeGenerator.BlockPreset recipePreset;
    private final Set<Supplier<ItemLike>> stoneCuttingInputs;
    private final String englishTranslation;

    public BlockType(ResourceLocation identifier, Supplier<Boolean> configOption, Supplier<T> block, Supplier<? extends BlockItem> item, Set<ResourceLocation> blockTags, ABBlockStateGenerator.BlockPreset blockStatePreset, ABLootTableGenerator.BlockPreset lootTablePreset, ABModelGenerator.BlockPreset modelPreset, ABRecipeGenerator.BlockPreset recipePreset, Set<Supplier<ItemLike>> stoneCuttingInputs, String englishTranslation){
        this.identifier = identifier;
        this.configOption = configOption;
        this.block = block;
        this.item = item;
        this.blockTags = blockTags;
        this.blockStatePreset = blockStatePreset;
        this.lootTablePreset = lootTablePreset;
        this.modelPreset = modelPreset;
        this.recipePreset = recipePreset;
        this.stoneCuttingInputs = Collections.unmodifiableSet(stoneCuttingInputs);
        this.englishTranslation = englishTranslation;
    }

    public ResourceLocation getIdentifier(){
        return this.identifier;
    }

    public boolean isEnabled(){
        return this.configOption.get();
    }

    public T getBlock(){
        return this.block.get();
    }

    public BlockItem getItem(){
        return this.item.get();
    }

    public Set<ResourceLocation> getBlockTags(){
        return this.blockTags;
    }

    public ABBlockStateGenerator.BlockPreset getBlockStatePreset(){
        return this.blockStatePreset;
    }

    public ABLootTableGenerator.BlockPreset getLootTablePreset(){
        return this.lootTablePreset;
    }

    public ABModelGenerator.BlockPreset getModelPreset(){
        return this.modelPreset;
    }

    public ABRecipeGenerator.BlockPreset getRecipePreset(){
        return this.recipePreset;
    }

    public Set<Supplier<ItemLike>> getStoneCuttingInputs(){
        return this.stoneCuttingInputs;
    }

    public String getLanguagePreset(){
        return this.englishTranslation;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        BlockType<?> blockType = (BlockType<?>)o;

        return this.identifier.equals(blockType.identifier);
    }

    @Override
    public int hashCode(){
        return this.identifier.hashCode();
    }

    @Override
    public Item asItem(){
        return this.getItem();
    }
}
