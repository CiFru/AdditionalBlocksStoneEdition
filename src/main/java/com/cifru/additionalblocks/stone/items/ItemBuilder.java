package com.cifru.additionalblocks.stone.items;

import com.cifru.additionalblocks.stone.AdditionalBlocks;
import com.cifru.additionalblocks.stone.generators.ABModelGenerator;
import com.cifru.additionalblocks.stone.items.custom.ABItem;
import com.supermartijn642.core.item.BaseItem;
import com.supermartijn642.core.item.ItemProperties;
import com.supermartijn642.core.registry.RegistrationHandler;
import com.supermartijn642.core.util.Holder;
import net.minecraft.util.ResourceLocation;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ItemBuilder {

    private static ItemBuilder create(String modid, String identifier){
        return new ItemBuilder(new ResourceLocation(modid, identifier));
    }

    public static ItemBuilder create(String identifier){
        return create("abstoneedition", identifier);
    }

    private final ResourceLocation identifier;
    private final Set<ResourceLocation> tags = new HashSet<>();
    private Supplier<Boolean> configOption = () -> true;
    private Integer stackSize;
    private Integer durability;
    private boolean fireResistant = false;

    private ABModelGenerator.ItemPreset modelPreset = ABModelGenerator.GENERATED;
    private String englishTranslation;

    private boolean hasBeenBuild = false;

    private ItemBuilder(ResourceLocation identifier){
        this.identifier = identifier;
    }

    public ItemBuilder configOption(Supplier<Boolean> enabled){
        this.configOption = enabled;
        return this;
    }

    public ItemBuilder tag(String namespace, String location){
        this.tags.add(new ResourceLocation(namespace, location));
        return this;
    }

    public ItemBuilder stackSize(int max){
        this.stackSize = max;
        return this;
    }

    public ItemBuilder durability(int durability){
        this.durability = durability;
        return this;
    }

    public ItemBuilder fireResistant(){
        this.fireResistant = true;
        return this;
    }

    public ItemBuilder modelPreset(ABModelGenerator.ItemPreset preset){
        this.modelPreset = preset;
        return this;
    }

    public ItemBuilder translation(String translation){
        this.englishTranslation = translation;
        return this;
    }

    public ItemBuilder configure(Configurator configurator){
        configurator.configure(this);
        return this;
    }

    public <T extends BaseItem> ItemType<T> buildCustom(BiFunction<ItemProperties,Supplier<Boolean>,T> itemSupplier, Consumer<ItemType<?>> output){
        if(this.hasBeenBuild)
            throw new IllegalStateException("Block has already been build!");
        this.hasBeenBuild = true;

        // Create the item properties
        ItemProperties properties = ItemProperties.create();
        properties.group(AdditionalBlocks.ITEM_GROUP);
        if(this.stackSize != null)
            properties.maxStackSize(this.stackSize);
        if(this.durability != null)
            properties.durability(this.durability);
        if(this.fireResistant)
            properties.fireResistant();

        // Create a lazy supplier for the item
        Supplier<T> item = new Holder<T>() {
            @Override
            public T get(){
                T value = super.get();
                if(value == null){
                    value = itemSupplier.apply(properties, configOption);
                    this.set(value);
                }
                return value;
            }
        }::get;

        // Register the item
        RegistrationHandler handler = RegistrationHandler.get(this.identifier.getNamespace());
        handler.registerItem(this.identifier.getPath(), item::get);

        // Create the item type
        ItemType<T> itemType = new ItemType<>(this.identifier, this.configOption, item, this.tags, this.modelPreset, this.englishTranslation);
        output.accept(itemType);
        return itemType;
    }

    public ItemType<BaseItem> buildRegular(Consumer<ItemType<?>> output){
        return this.buildCustom(ABItem::new, output);
    }

    public interface Configurator {

        void configure(ItemBuilder builder);
    }
}
