package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.cifru.additionalblocks.stone.items.ItemType;
import com.supermartijn642.core.generator.ModelGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created 11/03/2023 by SuperMartijn642
 */
public class ABModelGenerator extends ModelGenerator {

    public static final SingleTextureBlockPreset CUBE = new SingleTextureBlockPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, BlockType<?> blockType, ResourceLocation texture){
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            generator.cubeAll(namespace, "block/" + identifier, texture);
            generator.model(namespace, "item/" + identifier).parent(namespace, "block/" + identifier);
        }
    };
    public static final SingleTextureBlockPreset SLAB = new SingleTextureBlockPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, BlockType<?> blockType, ResourceLocation texture){
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            generator.slabTop(namespace, "block/" + identifier + "_top", texture, texture, texture);
            generator.slabBottom(namespace, "block/" + identifier + "_bottom", texture, texture, texture);
            generator.cubeAll(namespace, "block/" + identifier, texture);
            generator.model(namespace, "item/" + identifier).parent(namespace, "block/" + identifier + "_bottom");
        }
    };
    public static final SingleTextureBlockPreset STAIRS = new SingleTextureBlockPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, BlockType<?> blockType, ResourceLocation texture){
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            generator.model(namespace, "block/" + identifier)
                .parent("minecraft", "block/stairs")
                .texture("bottom", texture)
                .texture("side", texture)
                .texture("top", texture);
            generator.model(namespace, "block/" + identifier + "_inner")
                .parent("minecraft", "block/inner_stairs")
                .texture("bottom", texture)
                .texture("side", texture)
                .texture("top", texture);
            generator.model(namespace, "block/" + identifier + "_outer")
                .parent("minecraft", "block/outer_stairs")
                .texture("bottom", texture)
                .texture("side", texture)
                .texture("top", texture);
            generator.model(namespace, "item/" + identifier).parent(namespace, "block/" + identifier);
        }
    };
    public static final SingleTextureBlockPreset WALL = new SingleTextureBlockPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, BlockType<?> blockType, ResourceLocation texture){
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            generator.model(namespace, "block/" + identifier + "_post")
                .parent("minecraft", "block/template_wall_post")
                .texture("wall", texture);
            generator.model(namespace, "block/" + identifier + "_side")
                .parent("minecraft", "block/template_wall_side")
                .texture("wall", texture);
            generator.model(namespace, "block/" + identifier + "_side_tall")
                .parent("minecraft", "block/template_wall_side_tall")
                .texture("wall", texture);
            generator.model(namespace, "item/" + identifier)
                .parent("minecraft", "block/wall_inventory")
                .texture("wall", texture);
        }
    };
    public static final PillarBlockPreset PILLAR = new PillarBlockPreset();
    public static final SingleTextureItemPreset GENERATED = new SingleTextureItemPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, ItemType<?> itemType, ResourceLocation texture){
            generator.itemGenerated(itemType.getItem(), texture);
        }
    };
    public static final SingleTextureItemPreset HANDHELD = new SingleTextureItemPreset() {
        @Override
        protected void createModels(ABModelGenerator generator, ItemType<?> itemType, ResourceLocation texture){
            generator.itemHandheld(itemType.getItem(), texture);
        }
    };

    private final Map<BlockType<?>,Consumer<BlockType<?>>> blockBuilders = new HashMap<>();
    private final Map<ItemType<?>,Consumer<ItemType<?>>> itemBuilders = new HashMap<>();

    public ABModelGenerator(ResourceCache cache){
        super("abstoneedition", cache);
        this.populateBuilders();
    }

    private void populateBuilders(){
        // Create block and item models manually
        this.blockBuilders.put(AdditionalBlocksBlocks.BISMUTH_CLUSTER, blockType -> {
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            this.model(namespace, "item/" + identifier)
                .parent(namespace, "block/" + identifier);
        });
    }

    @Override
    public void generate(){
        // Generate models for all blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            BlockPreset preset = blockType.getModelPreset();
            Consumer<BlockType<?>> builder = this.blockBuilders.get(blockType);
            if(preset != null && builder != null)
                throw new IllegalStateException("Block type '" + blockType.getIdentifier() + "' has both a model preset and a manual builder!");
            if(preset == null && builder == null)
                throw new IllegalStateException("Missing model generator for block type '" + blockType.getIdentifier() + "'!");

            if(preset != null)
                preset.createModels(this, blockType);
            if(builder != null)
                builder.accept(blockType);
        }
        // Generate models for all items
        for(ItemType<?> itemType : AdditionalBlocksItems.ALL_ITEMS){
            ItemPreset preset = itemType.getModelPreset();
            Consumer<ItemType<?>> builder = this.itemBuilders.get(itemType);
            if(preset != null && builder != null)
                throw new IllegalStateException("Item type '" + itemType.getIdentifier() + "' has both a model preset and a manual builder!");
            if(preset == null && builder == null)
                throw new IllegalStateException("Missing model generator for item type '" + itemType.getIdentifier() + "'!");

            if(preset != null)
                preset.createModels(this, itemType);
            if(builder != null)
                builder.accept(itemType);
        }
    }

    public interface BlockPreset {

        void createModels(ABModelGenerator generator, BlockType<?> blockType);
    }

    public static abstract class SingleTextureBlockPreset implements BlockPreset {

        protected SingleTextureBlockPreset(){
        }

        @Override
        public void createModels(ABModelGenerator generator, BlockType<?> blockType){
            this.createModels(generator, blockType, BlockType::getIdentifier);
        }

        private void createModels(ABModelGenerator generator, BlockType<?> blockType, Function<BlockType<?>,ResourceLocation> texture){
            this.createModels(generator, blockType, texture.apply(blockType));
        }

        protected abstract void createModels(ABModelGenerator generator, BlockType<?> blockType, ResourceLocation texture);

        public BlockPreset withTexture(String namespace, String path){
            ResourceLocation location = new ResourceLocation(namespace, path);
            return this.copy(blockType -> location);
        }

        public BlockPreset withTexture(String path){
            return this.copy(blockType -> new ResourceLocation(blockType.getIdentifier().getNamespace(), path));
        }

        public BlockPreset withTexture(Function<BlockType<?>,ResourceLocation> texture){
            return this.copy(texture);
        }

        private BlockPreset copy(Function<BlockType<?>,ResourceLocation> texture){
            return (generator, blockType) -> SingleTextureBlockPreset.this.createModels(generator, blockType, texture);
        }
    }

    public static class PillarBlockPreset implements BlockPreset {

        private final Function<BlockType<?>,ResourceLocation> sideTexture, endTexture;

        protected PillarBlockPreset(Function<BlockType<?>,ResourceLocation> sideTexture, Function<BlockType<?>,ResourceLocation> endTexture){
            this.sideTexture = sideTexture;
            this.endTexture = endTexture;
        }

        protected PillarBlockPreset(){
            this(BlockType::getIdentifier, blockType -> new ResourceLocation(blockType.getIdentifier().getNamespace(), blockType.getIdentifier().getPath() + "_top"));
        }

        @Override
        public void createModels(ABModelGenerator generator, BlockType<?> blockType){
            String namespace = blockType.getIdentifier().getNamespace();
            String identifier = blockType.getIdentifier().getPath();
            ResourceLocation side = this.sideTexture.apply(blockType);
            ResourceLocation end = this.sideTexture.apply(blockType);
            generator.cube(namespace, "block/" + identifier, end, end, side, side, side, side);
            generator.model(namespace, "item/" + identifier).parent(namespace, "block/" + identifier);
        }

        public PillarBlockPreset withSide(String namespace, String path){
            ResourceLocation location = new ResourceLocation(namespace, path);
            return new PillarBlockPreset(blockType -> location, this.endTexture);
        }

        public PillarBlockPreset withSide(String path){
            return new PillarBlockPreset(blockType -> new ResourceLocation(blockType.getIdentifier().getNamespace(), path), this.endTexture);
        }

        public PillarBlockPreset withSide(Function<BlockType<?>,ResourceLocation> texture){
            return new PillarBlockPreset(texture, this.endTexture);
        }

        public PillarBlockPreset withEnd(String namespace, String path){
            ResourceLocation location = new ResourceLocation(namespace, path);
            return new PillarBlockPreset(this.sideTexture, blockType -> location);
        }

        public PillarBlockPreset withEnd(String path){
            return new PillarBlockPreset(this.sideTexture, blockType -> new ResourceLocation(blockType.getIdentifier().getNamespace(), path));
        }

        public PillarBlockPreset withEnd(Function<BlockType<?>,ResourceLocation> texture){
            return new PillarBlockPreset(this.sideTexture, texture);
        }
    }

    public interface ItemPreset {

        void createModels(ABModelGenerator generator, ItemType<?> itemType);
    }

    public static abstract class SingleTextureItemPreset implements ItemPreset {

        protected SingleTextureItemPreset(){
        }

        @Override
        public void createModels(ABModelGenerator generator, ItemType<?> itemType){
            this.createModels(generator, itemType, ItemType::getIdentifier);
        }

        private void createModels(ABModelGenerator generator, ItemType<?> itemType, Function<ItemType<?>,ResourceLocation> texture){
            this.createModels(generator, itemType, texture.apply(itemType));
        }

        protected abstract void createModels(ABModelGenerator generator, ItemType<?> itemType, ResourceLocation texture);

        public ItemPreset withTexture(String namespace, String path){
            ResourceLocation location = new ResourceLocation(namespace, path);
            return this.copy(itemType -> location);
        }

        public ItemPreset withTexture(String path){
            return this.copy(itemType -> new ResourceLocation(itemType.getIdentifier().getNamespace(), path));
        }

        public ItemPreset withTexture(Function<ItemType<?>,ResourceLocation> texture){
            return this.copy(texture);
        }

        private ItemPreset copy(Function<ItemType<?>,ResourceLocation> texture){
            return (generator, itemType) -> this.createModels(generator, itemType, texture);
        }
    }
}
