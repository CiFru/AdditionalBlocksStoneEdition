package com.cifru.additionalblocks.stone.blocks;

import com.cifru.additionalblocks.stone.AdditionalBlocks;
import com.cifru.additionalblocks.stone.generators.ABBlockStateGenerator;
import com.cifru.additionalblocks.stone.generators.ABLootTableGenerator;
import com.cifru.additionalblocks.stone.generators.ABModelGenerator;
import com.cifru.additionalblocks.stone.generators.ABRecipeGenerator;
import com.cifru.additionalblocks.stone.items.custom.ABBlockItem;
import com.cifru.additionalblocks.stone.tools.ToolTier;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.item.BaseBlockItem;
import com.supermartijn642.core.item.ItemProperties;
import com.supermartijn642.core.registry.RegistrationHandler;
import com.supermartijn642.core.util.Holder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class BlockBuilder {

    private static BlockBuilder create(String modid, String identifier){
        return new BlockBuilder(new ResourceLocation(modid, identifier));
    }

    public static BlockBuilder create(String identifier){
        return create("abstoneedition", identifier);
    }

    private final ResourceLocation identifier;
    private final Set<ResourceLocation> blockTags = new HashSet<>();
    private Supplier<Boolean> configOption = () -> true;
    private Material material;
    private DyeColor mapColor;
    private boolean requireCorrectTool = false;
    private SoundType soundType;
    private Float destroyTime;
    private Float explosionResistance;
    private ToolType harvestTool;
    private ToolTier harvestTier;
    private Integer lightLevel;

    private ABBlockStateGenerator.BlockPreset blockStatePreset = ABBlockStateGenerator.SIMPLE;
    private ABLootTableGenerator.BlockPreset lootTablePreset = ABLootTableGenerator.DROP_SELF;
    private ABModelGenerator.BlockPreset modelPreset = ABModelGenerator.CUBE;
    private ABRecipeGenerator.BlockPreset recipePreset = null;
    private final Set<Supplier<IItemProvider>> stoneCuttingInputs = new HashSet<>();
    private String englishTranslation;

    private boolean hasBeenBuild = false;

    private BlockBuilder(ResourceLocation identifier){
        this.identifier = identifier;
    }

    public BlockBuilder configOption(Supplier<Boolean> enabled){
        this.configOption = enabled;
        return this;
    }

    public BlockBuilder material(Material material){
        this.material = material;
        return this;
    }

    public BlockBuilder mapColor(DyeColor color){
        this.mapColor = color;
        return this;
    }

    public BlockBuilder requireCorrectToolForDrops(){
        this.requireCorrectTool = true;
        return this;
    }

    public BlockBuilder sound(SoundType soundType){
        this.soundType = soundType;
        return this;
    }

    public BlockBuilder destroyTime(float time){
        this.destroyTime = time;
        return this;
    }

    public BlockBuilder explosionResistance(float resistance){
        this.explosionResistance = resistance;
        return this;
    }

    public BlockBuilder harvestTool(ToolType tool, ToolTier tier){
        this.harvestTool = tool;
        this.harvestTier = tier;
        return this;
    }

    public BlockBuilder harvestTool(ToolType tool){
        return this.harvestTool(tool, null);
    }

    public BlockBuilder blockTag(String namespace, String location){
        this.blockTags.add(new ResourceLocation(namespace, location));
        return this;
    }

    public BlockBuilder lightLevel(int light){
        this.lightLevel = light;
        return this;
    }

    public BlockBuilder blockStatePreset(ABBlockStateGenerator.BlockPreset preset){
        this.blockStatePreset = preset;
        return this;
    }

    public BlockBuilder lootTablePreset(ABLootTableGenerator.BlockPreset preset){
        this.lootTablePreset = preset;
        return this;
    }

    public BlockBuilder modelPreset(ABModelGenerator.BlockPreset preset){
        this.modelPreset = preset;
        return this;
    }

    public BlockBuilder recipePreset(ABRecipeGenerator.BlockPreset preset){
        this.recipePreset = preset;
        return this;
    }

    public BlockBuilder stoneCutting(Supplier<IItemProvider> input){
        this.stoneCuttingInputs.add(input);
        return this;
    }

    public BlockBuilder translation(String translation){
        this.englishTranslation = translation;
        return this;
    }

    public BlockBuilder configure(Configurator configurator){
        configurator.configure(this);
        return this;
    }

    public <T extends BaseBlock> BlockType<T> buildCustom(Function<BlockProperties,T> blockSupplier, Consumer<BlockType<?>> output){
        if(this.hasBeenBuild)
            throw new IllegalStateException("Block has already been build!");
        this.hasBeenBuild = true;

        // Validate mandatory properties
        if(this.material == null)
            throw new IllegalStateException("Block builder for '" + this.identifier + "' is missing a material!");

        // Add harvest tags
        if(this.harvestTool != null && this.harvestTool.getMineableTag() != null)
            this.blockTags.add(this.harvestTool.getMineableTag());
        if(this.harvestTier != null && this.harvestTier.getMaterialTag() != null)
            this.blockTags.add(this.harvestTier.getMaterialTag());

        // Create the block properties
        BlockProperties properties = this.mapColor == null ? BlockProperties.create(this.material) : BlockProperties.create(this.material, this.mapColor);
        if(this.requireCorrectTool)
            properties.requiresCorrectTool();
        if(this.soundType != null)
            properties.sound(this.soundType);
        if(this.destroyTime != null)
            properties.destroyTime(this.destroyTime);
        if(this.explosionResistance != null)
            properties.explosionResistance(this.explosionResistance);
        if(this.lightLevel != null)
            properties.lightLevel(this.lightLevel);

        // Create lazy suppliers for the block and item
        Supplier<T> block = new Holder<T>() {
            @Override
            public T get(){
                T value = super.get();
                if(value == null){
                    value = blockSupplier.apply(properties);
                    this.set(value);
                }
                return value;
            }
        }::get;
        Supplier<BaseBlockItem> item = new Holder<BaseBlockItem>() {
            @Override
            public BaseBlockItem get(){
                BaseBlockItem value = super.get();
                if(value == null){
                    value = new ABBlockItem(block.get(), ItemProperties.create().group(AdditionalBlocks.ITEM_GROUP), BlockBuilder.this.configOption);
                    this.set(value);
                }
                return value;
            }
        }::get;

        // Register the block and item
        RegistrationHandler handler = RegistrationHandler.get(this.identifier.getNamespace());
        handler.registerBlock(this.identifier.getPath(), block::get);
        handler.registerItem(this.identifier.getPath(), item::get);

        // Create the block type
        BlockType<T> blockType = new BlockType<>(this.identifier, this.configOption, block, item, this.blockTags, this.blockStatePreset, this.lootTablePreset, this.modelPreset, this.recipePreset, stoneCuttingInputs, this.englishTranslation);
        output.accept(blockType);
        return blockType;
    }

    public BlockType<BaseBlock> buildRegular(Consumer<BlockType<?>> output){
        return this.buildCustom(properties -> new BaseBlock(false, properties), output);
    }

    public interface Configurator {

        void configure(BlockBuilder builder);
    }
}
