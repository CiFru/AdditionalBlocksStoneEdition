package com.cifru.additionalblocks.stone.items;

import com.cifru.additionalblocks.stone.generators.ABModelGenerator;
import com.supermartijn642.core.item.BaseItem;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.Set;
import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ItemType<T extends BaseItem> implements IItemProvider {

    private final ResourceLocation identifier;
    private final Supplier<Boolean> configOption;
    private final Supplier<T> item;
    private final Set<ResourceLocation> tags;

    private final ABModelGenerator.ItemPreset modelPreset;
    private final String englishTranslation;

    public ItemType(ResourceLocation identifier, Supplier<Boolean> configOption, Supplier<T> item, Set<ResourceLocation> tags, ABModelGenerator.ItemPreset modelPreset, String englishTranslation){
        this.identifier = identifier;
        this.configOption = configOption;
        this.item = item;
        this.tags = tags;
        this.modelPreset = modelPreset;
        this.englishTranslation = englishTranslation;
    }

    public ResourceLocation getIdentifier(){
        return this.identifier;
    }

    public boolean isEnabled(){
        return this.configOption.get();
    }

    public T getItem(){
        return this.item.get();
    }

    public Set<ResourceLocation> getTags(){
        return this.tags;
    }

    public ABModelGenerator.ItemPreset getModelPreset(){
        return this.modelPreset;
    }

    public String getLanguagePreset(){
        return this.englishTranslation;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        ItemType<?> itemType = (ItemType<?>)o;

        return this.identifier.equals(itemType.identifier);
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
