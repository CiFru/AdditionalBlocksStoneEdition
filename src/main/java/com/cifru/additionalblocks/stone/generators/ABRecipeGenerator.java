package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.cifru.additionalblocks.stone.condition.BlockEnabledResourceCondition;
import com.cifru.additionalblocks.stone.condition.ItemEnabledResourceCondition;
import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.supermartijn642.core.generator.RecipeGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABRecipeGenerator extends RecipeGenerator {

    public static final SingleIngredientBlockPreset STAIRS = new SingleIngredientBlockPreset() {
        @Override
        protected void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient){
            generator.shaped(blockType.getBlock(), 4)
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
            generator.shaped(blockType.getIdentifier().getNamespace(), blockType.getIdentifier().getPath() + "_mirrored", blockType.getBlock(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
        }
    };
    public static final SingleIngredientBlockPreset SLAB = new SingleIngredientBlockPreset() {
        @Override
        protected void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient){
            generator.shaped(blockType.getBlock(), 6)
                .pattern("AAA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
        }
    };
    public static final SingleIngredientBlockPreset WALL = new SingleIngredientBlockPreset() {
        @Override
        protected void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient){
            generator.shaped(blockType.getBlock(), 6)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
        }
    };
    public static final SingleIngredientBlockPreset TWO_BY_TWO = new SingleIngredientBlockPreset() {
        @Override
        protected void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient){
            generator.shaped(blockType.getBlock(), 6)
                .pattern("AA")
                .pattern("AA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
        }
    };
    public static final SingleIngredientBlockPreset THREE_BY_THREE = new SingleIngredientBlockPreset() {
        @Override
        protected void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient){
            generator.shaped(blockType.getBlock(), 6)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ingredient)
                .unlockedBy(ingredient.getItems()[0].getItem())
                .condition(new BlockEnabledResourceCondition(blockType));
        }
    };

    public ABRecipeGenerator(ResourceCache cache){
        super("abstoneedition", cache);
    }

    public void manualRecipes(){
        // Andesite bricks
        this.shaped(AdditionalBlocksBlocks.ANDESITE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.POLISHED_ANDESITE)
            .unlockedBy(Items.ANDESITE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.ANDESITE_BRICKS));
        // Asphalt
        this.smelting(AdditionalBlocksBlocks.ASPHALT)
            .input(Items.BLACK_DYE)
            .includeSmelting()
            .durationSeconds(25)
            .experience(2)
            .unlockedBy(Items.BLACK_DYE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.ASPHALT));
        // Aztec Pattern
        this.shaped(AdditionalBlocksBlocks.AZTEC_PATTERN, 6)
            .pattern("ACA")
            .pattern("ASA")
            .pattern("AAA")
            .input('A', Items.STONE)
            .input('C', Items.GRAY_DYE)
            .input('S', Items.VINE)
            .unlockedBy(Items.STONE, Items.GRAY_DYE, Items.VINE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.AZTEC_PATTERN));
        // Aztec Patterned Wall
        this.shaped(AdditionalBlocksBlocks.AZTEC_PATTERNED_WALL, 4)
            .pattern("CA")
            .pattern("AC")
            .input('A', Items.SMOOTH_STONE)
            .input('C', Items.STONE)
            .unlockedBy(Items.STONE, Items.SMOOTH_STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.AZTEC_PATTERNED_WALL));
        // Aztec Pillar
        this.shaped(AdditionalBlocksBlocks.AZTEC_PILLAR, 2)
            .pattern("#")
            .pattern("#")
            .input('#', AdditionalBlocksBlocks.AZTEC_TILES)
            .unlockedBy(AdditionalBlocksBlocks.AZTEC_TILES)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.AZTEC_PILLAR))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.AZTEC_TILES));
        // Aztec Tiles
        this.shaped(AdditionalBlocksBlocks.AZTEC_TILES, 4)
            .pattern("CA")
            .pattern("AC")
            .input('A', Items.COBBLESTONE)
            .input('C', Items.STONE)
            .unlockedBy(Items.STONE, Items.COBBLESTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.AZTEC_TILES));
        // Bismuth Block
        this.shaped(AdditionalBlocksBlocks.BISMUTH_BLOCK)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.BISMUTH_INGOT)
            .unlockedBy(AdditionalBlocksItems.BISMUTH_INGOT)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BISMUTH_BLOCK));
        // Bismuth Cluster
        this.shaped(AdditionalBlocksBlocks.BISMUTH_CLUSTER)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.RAW_BISMUTH)
            .unlockedBy(AdditionalBlocksItems.RAW_BISMUTH)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BISMUTH_CLUSTER));
        // Black Marble
        this.shaped(AdditionalBlocksBlocks.BLACK_MARBLE, 4)
            .pattern("CA")
            .pattern("AC")
            .input('A', Items.COAL_BLOCK)
            .input('C', AdditionalBlocksBlocks.MARBLE)
            .unlockedBy(Items.COAL_BLOCK, AdditionalBlocksBlocks.MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLACK_MARBLE));
        // Black Marble Bricks
        this.shaped(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksBlocks.BLACK_MARBLE)
            .unlockedBy(AdditionalBlocksBlocks.BLACK_MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLACK_MARBLE));
        // Bloodstone
        this.shaped(AdditionalBlocksBlocks.BLOODSTONE, 9)
            .pattern("ABA")
            .pattern("BAB")
            .pattern("ABA")
            .input('A', Items.COAL)
            .input('B', Items.REDSTONE)
            .unlockedBy(Items.COAL, Items.REDSTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLOODSTONE));
        // Bloodstone Bricks
        this.shaped(AdditionalBlocksBlocks.BLOODSTONE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksBlocks.BLOODSTONE)
            .unlockedBy(AdditionalBlocksBlocks.BLOODSTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLOODSTONE_BRICKS))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLOODSTONE));
        // Brown Bricks
        this.smelting(AdditionalBlocksBlocks.BROWN_BRICKS)
            .input(Items.BRICKS)
            .includeSmelting()
            .durationSeconds(10)
            .experience(2)
            .unlockedBy(Items.BRICKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BROWN_BRICKS));
        // Brown Stone Path Curved
        this.smelting(AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED)
            .input(AdditionalBlocksBlocks.STONE_PATH_CURVED)
            .includeSmelting()
            .durationSeconds(10)
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.STONE_PATH_CURVED)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATH_CURVED));
        // Brown Stone Path Straight
        this.smelting(AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT)
            .input(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT)
            .includeSmelting()
            .durationSeconds(10)
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT));
        // Brown Stone Pattern
        this.smelting(AdditionalBlocksBlocks.BROWN_STONE_PATTERN)
            .input(AdditionalBlocksBlocks.STONE_PATTERN)
            .includeSmelting()
            .durationSeconds(10)
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.STONE_PATTERN)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BROWN_STONE_PATTERN))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATTERN));
        // Brown Stone Tiles
        this.smelting(AdditionalBlocksBlocks.BROWN_STONE_TILES)
            .input(AdditionalBlocksBlocks.STONE_TILES)
            .includeSmelting()
            .durationSeconds(10)
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.STONE_TILES)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BROWN_STONE_TILES))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_TILES));
        // Charred Log
        this.shaped(AdditionalBlocksBlocks.CHARRED_LOG, 2)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.CHARCOAL)
            .unlockedBy(Items.CHARCOAL)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.CHARRED_LOG));
        // Charred Planks
        this.shapeless(AdditionalBlocksBlocks.CHARRED_PLANKS, 4)
            .input(AdditionalBlocksBlocks.CHARRED_LOG)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.CHARRED_LOG))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.CHARRED_PLANKS));
        // Charred Wood
        this.shaped(AdditionalBlocksBlocks.CHARRED_WOOD, 3)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksBlocks.CHARRED_LOG)
            .unlockedBy(Items.OAK_PLANKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.CHARRED_WOOD))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.CHARRED_LOG));
        // Diorite Bricks
        this.shaped(AdditionalBlocksBlocks.DIORITE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.POLISHED_DIORITE)
            .unlockedBy(Items.DIORITE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.DIORITE_BRICKS));
        // Glowstone Bricks
        this.shaped(AdditionalBlocksBlocks.GLOWSTONE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.GLOWSTONE)
            .unlockedBy(Items.GLOWSTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.GLOWSTONE_BRICKS));
        // Granite Bricks
        this.shaped(AdditionalBlocksBlocks.GRANITE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.POLISHED_GRANITE)
            .unlockedBy(Items.GRANITE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.GRANITE_BRICKS));
        // Gray Bricks
        this.shaped(AdditionalBlocksBlocks.GRAY_BRICKS, 2)
            .pattern("CA")
            .pattern("AC")
            .input('A', Items.GRAY_DYE)
            .input('C', Items.BRICKS)
            .unlockedBy(Items.BRICKS, Items.GRAY_DYE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.GRAY_BRICKS));
        // Limestone
        this.shaped(AdditionalBlocksBlocks.LIMESTONE, 9)
            .pattern("ABA")
            .pattern("BAB")
            .pattern("ABA")
            .input('A', Items.SANDSTONE)
            .input('B', Items.QUARTZ_BLOCK)
            .unlockedBy(Items.SANDSTONE, Items.QUARTZ_BLOCK)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.LIMESTONE));
        // Limestone Bricks
        this.shaped(AdditionalBlocksBlocks.LIMESTONE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksBlocks.SMOOTH_LIMESTONE)
            .unlockedBy(AdditionalBlocksBlocks.LIMESTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.LIMESTONE_BRICKS))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_LIMESTONE));
        // Marble
        this.shaped(AdditionalBlocksBlocks.MARBLE, 6)
            .pattern("ABA")
            .pattern("BAB")
            .pattern("ABA")
            .input('A', Items.DIORITE)
            .input('B', Items.QUARTZ_BLOCK)
            .unlockedBy(Items.DIORITE, Items.QUARTZ_BLOCK)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE));
        // Marble Bricks
        this.shaped(AdditionalBlocksBlocks.MARBLE_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksBlocks.MARBLE)
            .unlockedBy(AdditionalBlocksBlocks.MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE_BRICKS));
        // Marble Pillar
        this.shaped(AdditionalBlocksBlocks.MARBLE_PILLAR, 2)
            .pattern("#")
            .pattern("#")
            .input('#', AdditionalBlocksBlocks.MARBLE)
            .unlockedBy(AdditionalBlocksBlocks.MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE_PILLAR));
        // Obsidian Bricks
        this.shaped(AdditionalBlocksBlocks.OBSIDIAN_BRICKS, 4)
            .pattern("AA")
            .pattern("AA")
            .input('A', Items.OBSIDIAN)
            .unlockedBy(Items.OBSIDIAN)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.OBSIDIAN_BRICKS));
        // Old Stone Path Curved
        this.shaped(AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED, 6)
            .pattern("XXX")
            .pattern("X##")
            .pattern("X#X")
            .input('X', Items.STONE_BRICKS)
            .input('#', Items.STONE)
            .unlockedBy(Items.STONE_BRICKS, Items.STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED));
        // Old Stone Path Straight
        this.shaped(AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT, 6)
            .pattern("XXX")
            .pattern("###")
            .pattern("XXX")
            .input('X', Items.STONE_BRICKS)
            .input('#', Items.STONE)
            .unlockedBy(Items.STONE_BRICKS, Items.STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT));
        // Old Stone Pattern
        this.shaped(AdditionalBlocksBlocks.OLD_STONE_PATTERN, 9)
            .pattern("X#X")
            .pattern("#X#")
            .pattern("X#X")
            .input('X', Items.STONE_BRICKS)
            .input('#', Items.STONE)
            .unlockedBy(Items.STONE_BRICKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.OLD_STONE_PATTERN));
        // Old Stone Tiles
        this.shaped(AdditionalBlocksBlocks.OLD_STONE_TILES, 4)
            .pattern("##")
            .pattern("##")
            .input('#', Items.STONE_BRICKS)
            .unlockedBy(Items.STONE_BRICKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.OLD_STONE_TILES));
        // Pebbles
        this.shaped(AdditionalBlocksBlocks.PEBBLES, 4)
            .pattern("##")
            .pattern("##")
            .input('#', Items.COBBLESTONE)
            .unlockedBy(Items.COBBLESTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.PEBBLES));
        // Raw Silver Block
        this.shaped(AdditionalBlocksBlocks.RAW_SILVER_BLOCK)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.RAW_SILVER)
            .unlockedBy(AdditionalBlocksItems.RAW_SILVER)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.RAW_SILVER_BLOCK));
        // Silver Block
        this.shaped(AdditionalBlocksBlocks.SILVER_BLOCK)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.SILVER_INGOT)
            .unlockedBy(AdditionalBlocksItems.SILVER_INGOT)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SILVER_BLOCK));
        // Smooth Black Marble
        this.smelting(AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE)
            .input(AdditionalBlocksBlocks.BLACK_MARBLE)
            .includeSmelting()
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.BLACK_MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLACK_MARBLE));
        // Smooth Bloodstone
        this.smelting(AdditionalBlocksBlocks.SMOOTH_BLOODSTONE)
            .input(AdditionalBlocksBlocks.BLOODSTONE)
            .includeSmelting()
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.BLOODSTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_BLOODSTONE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BLOODSTONE));
        // Smooth glowstone
        this.smelting(AdditionalBlocksBlocks.SMOOTH_GLOWSTONE)
            .input(Items.GLOWSTONE)
            .includeSmelting()
            .experience(5)
            .unlockedBy(Items.GLOWSTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_GLOWSTONE));
        // Smooth limestone
        this.shaped(AdditionalBlocksBlocks.SMOOTH_LIMESTONE, 4)
            .pattern("##")
            .pattern("##")
            .input('#', AdditionalBlocksBlocks.LIMESTONE)
            .unlockedBy(AdditionalBlocksBlocks.LIMESTONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_LIMESTONE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.LIMESTONE));
        // Smooth marble bricks
        this.smelting(AdditionalBlocksBlocks.SMOOTH_MARBLE)
            .input(AdditionalBlocksBlocks.MARBLE)
            .includeSmelting()
            .experience(2)
            .unlockedBy(AdditionalBlocksBlocks.MARBLE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_MARBLE))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.MARBLE));
        // Smooth stone bricks
        this.shaped(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, 4)
            .pattern("##")
            .pattern("##")
            .input('#', Items.SMOOTH_STONE)
            .unlockedBy(Items.SMOOTH_STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS));
        // Stone brick block
        this.shaped(AdditionalBlocksBlocks.STONE_BRICK_BLOCK, 6)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', Items.STONE)
            .unlockedBy(Items.STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_BRICK_BLOCK));
        // Stone path curved
        this.shaped(AdditionalBlocksBlocks.STONE_PATH_CURVED, 6)
            .pattern("XXX")
            .pattern("X##")
            .pattern("X#X")
            .input('X', AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .input('#', Items.SMOOTH_STONE)
            .unlockedBy(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, Items.SMOOTH_STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATH_CURVED))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS));
        // Stone path straight
        this.shaped(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT, 6)
            .pattern("XXX")
            .pattern("###")
            .pattern("XXX")
            .input('X', AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .input('#', Items.SMOOTH_STONE)
            .unlockedBy(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, Items.SMOOTH_STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS));
        // Stone pattern
        this.shaped(AdditionalBlocksBlocks.STONE_PATTERN, 9)
            .pattern("X#X")
            .pattern("#X#")
            .pattern("X#X")
            .input('X', AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .input('#', Items.SMOOTH_STONE)
            .unlockedBy(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_PATTERN))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS));
        // Stone tiles
        this.shaped(AdditionalBlocksBlocks.STONE_TILES, 4)
            .pattern("##")
            .pattern("##")
            .input('#', AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .unlockedBy(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.STONE_TILES))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS));
        // Sunstone
        Tags.IOptionalNamedTag<Item> copperIngots = ItemTags.createOptional(new ResourceLocation("forge", "ingots/copper"));
        this.shaped(AdditionalBlocksBlocks.SUNSTONE)
            .pattern("ACA")
            .pattern("SCS")
            .pattern("ACA")
            .input('A', Items.STONE)
            .input('C', copperIngots)
            .input('S', Tags.Items.INGOTS_GOLD)
            .unlockedBy(copperIngots)
            .unlockedBy(Tags.Items.INGOTS_GOLD)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SUNSTONE));
        // Volcanic stone
        this.shaped(AdditionalBlocksBlocks.VOLCANIC_STONE, 4)
            .pattern("SC")
            .pattern("CS")
            .input('S', Items.BASALT)
            .input('C', Items.STONE)
            .unlockedBy(Items.BASALT)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.VOLCANIC_STONE));
        // Volcanic stone bricks
        this.shaped(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS, 4)
            .pattern("##")
            .pattern("##")
            .input('#', AdditionalBlocksBlocks.VOLCANIC_STONE)
            .unlockedBy(AdditionalBlocksBlocks.VOLCANIC_STONE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.VOLCANIC_STONE));
        // Water stone
        this.shaped(AdditionalBlocksBlocks.WATER_STONE, 4)
            .pattern("X#X")
            .pattern("#X#")
            .pattern("X#X")
            .input('X', Tags.Items.COBBLESTONE)
            .input('#', Items.BLUE_ICE)
            .unlockedBy(Items.BLUE_ICE)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.WATER_STONE));
        // Watery pebbles
        this.shaped(AdditionalBlocksBlocks.WATERY_PEBBLES, 4)
            .pattern("SC")
            .pattern("CS")
            .input('S', AdditionalBlocksBlocks.PEBBLES)
            .input('C', Items.ICE)
            .unlockedBy(AdditionalBlocksBlocks.PEBBLES)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.WATERY_PEBBLES))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.PEBBLES));

        // Copper ingots
        this.smelting("copper_ingot_from_ore", AdditionalBlocksItems.COPPER_INGOT)
            .input(AdditionalBlocksBlocks.COPPER_ORE)
            .includeBlasting()
            .unlockedBy(AdditionalBlocksBlocks.COPPER_ORE)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.COPPER_ORE));
        this.shapeless(AdditionalBlocksItems.COPPER_INGOT, 9)
            .input(AdditionalBlocksBlocks.COPPER_BLOCK)
            .unlockedBy(AdditionalBlocksItems.COPPER_INGOT, AdditionalBlocksBlocks.COPPER_BLOCK)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.COPPER_BLOCK));
        // Copper nuggets
        this.shapeless(AdditionalBlocksItems.COPPER_NUGGET, 9)
            .input(copperIngots)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_NUGGET));
        this.shaped("copper_ingot_from_nuggets", AdditionalBlocksItems.COPPER_INGOT)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.COPPER_NUGGET)
            .unlockedBy(AdditionalBlocksItems.COPPER_INGOT, AdditionalBlocksItems.COPPER_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_INGOT));
        this.smelting("copper_nugget_from_smelting", AdditionalBlocksItems.COPPER_NUGGET)
            .input(AdditionalBlocksItems.COPPER_AXE, AdditionalBlocksItems.COPPER_PICKAXE, AdditionalBlocksItems.COPPER_SHOVEL, AdditionalBlocksItems.COPPER_HOE, AdditionalBlocksItems.COPPER_SWORD)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksItems.COPPER_AXE, AdditionalBlocksItems.COPPER_PICKAXE, AdditionalBlocksItems.COPPER_SHOVEL, AdditionalBlocksItems.COPPER_HOE, AdditionalBlocksItems.COPPER_SWORD)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_AXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_PICKAXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_SHOVEL))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_HOE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_SWORD));
        // Copper axe
        this.shaped(AdditionalBlocksItems.COPPER_AXE)
            .pattern("AA")
            .pattern("AB")
            .pattern(" B")
            .input('A', copperIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_AXE));
        // Copper pickaxe
        this.shaped(AdditionalBlocksItems.COPPER_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" B ")
            .input('A', copperIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_PICKAXE));
        // Copper shovel
        this.shaped(AdditionalBlocksItems.COPPER_SHOVEL)
            .pattern("A")
            .pattern("B")
            .pattern("B")
            .input('A', copperIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_SHOVEL));
        // Copper hoe
        this.shaped(AdditionalBlocksItems.COPPER_HOE)
            .pattern("AA")
            .pattern(" B")
            .pattern(" B")
            .input('A', copperIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_HOE));
        // Copper sword
        this.shaped(AdditionalBlocksItems.COPPER_SWORD)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .input('A', copperIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(copperIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.COPPER_SWORD));

        // Silver ingots
        Tags.IOptionalNamedTag<Item> silverIngots = ItemTags.createOptional(new ResourceLocation("forge", "ingots/silver"));
        this.smelting("silver_ingot_from_raw", AdditionalBlocksItems.SILVER_INGOT)
            .input(AdditionalBlocksItems.RAW_SILVER)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksItems.RAW_SILVER)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_INGOT))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.RAW_SILVER));
        this.smelting("silver_ingot_from_ore", AdditionalBlocksItems.SILVER_INGOT)
            .input(AdditionalBlocksBlocks.SILVER_ORE)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksBlocks.SILVER_ORE)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SILVER_ORE));
        this.shapeless(AdditionalBlocksItems.SILVER_INGOT, 9)
            .input(AdditionalBlocksBlocks.SILVER_BLOCK)
            .unlockedBy(AdditionalBlocksItems.SILVER_INGOT, AdditionalBlocksBlocks.SILVER_BLOCK)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.SILVER_BLOCK));
        // Silver nuggets
        this.shapeless(AdditionalBlocksItems.SILVER_NUGGET, 9)
            .input(AdditionalBlocksItems.SILVER_INGOT)
            .unlockedBy(AdditionalBlocksItems.SILVER_INGOT, AdditionalBlocksItems.SILVER_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_INGOT));
        this.shaped("silver_ingot_from_nuggets", AdditionalBlocksItems.SILVER_INGOT)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.SILVER_NUGGET)
            .unlockedBy(AdditionalBlocksItems.SILVER_INGOT, AdditionalBlocksItems.SILVER_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_INGOT));
        this.smelting("silver_nugget_from_smelting", AdditionalBlocksItems.SILVER_NUGGET)
            .input(AdditionalBlocksItems.SILVER_AXE, AdditionalBlocksItems.SILVER_PICKAXE, AdditionalBlocksItems.SILVER_SHOVEL, AdditionalBlocksItems.SILVER_HOE, AdditionalBlocksItems.SILVER_SWORD)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(10)
            .experience(1)
            .unlockedBy(AdditionalBlocksItems.SILVER_AXE, AdditionalBlocksItems.SILVER_PICKAXE, AdditionalBlocksItems.SILVER_SHOVEL, AdditionalBlocksItems.SILVER_HOE, AdditionalBlocksItems.SILVER_SWORD)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_AXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_PICKAXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_SHOVEL))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_HOE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_SWORD));
        // Raw silver
        this.shapeless(AdditionalBlocksItems.RAW_SILVER, 9)
            .input(AdditionalBlocksBlocks.RAW_SILVER_BLOCK)
            .unlockedBy(AdditionalBlocksItems.RAW_SILVER, AdditionalBlocksBlocks.RAW_SILVER_BLOCK)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.RAW_SILVER))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.RAW_SILVER_BLOCK));
        // Silver axe
        this.shaped(AdditionalBlocksItems.SILVER_AXE)
            .pattern("AA")
            .pattern("AB")
            .pattern(" B")
            .input('A', silverIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(silverIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_AXE));
        // Silver pickaxe
        this.shaped(AdditionalBlocksItems.SILVER_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" B ")
            .input('A', silverIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(silverIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_PICKAXE));
        // Silver shovel
        this.shaped(AdditionalBlocksItems.SILVER_SHOVEL)
            .pattern("A")
            .pattern("B")
            .pattern("B")
            .input('A', silverIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(silverIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_SHOVEL));
        // Silver hoe
        this.shaped(AdditionalBlocksItems.SILVER_HOE)
            .pattern("AA")
            .pattern(" B")
            .pattern(" B")
            .input('A', silverIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(silverIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_HOE));
        // Silver sword
        this.shaped(AdditionalBlocksItems.SILVER_SWORD)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .input('A', silverIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(silverIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.SILVER_SWORD));

        // Bismuth ingots
        Tags.IOptionalNamedTag<Item> bismuthIngots = ItemTags.createOptional(new ResourceLocation("forge", "ingots/bismuth"));
        this.smelting("bismuth_ingot_from_raw", AdditionalBlocksItems.BISMUTH_INGOT)
            .input(AdditionalBlocksItems.RAW_BISMUTH)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksItems.RAW_BISMUTH)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_INGOT))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.RAW_BISMUTH));
        this.smelting("bismuth_ingot_from_ore", AdditionalBlocksItems.BISMUTH_INGOT)
            .input(AdditionalBlocksBlocks.BISMUTH_ORE)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksBlocks.BISMUTH_ORE)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BISMUTH_ORE));
        this.shapeless(AdditionalBlocksItems.BISMUTH_INGOT, 9)
            .input(AdditionalBlocksBlocks.BISMUTH_BLOCK)
            .unlockedBy(AdditionalBlocksItems.BISMUTH_INGOT, AdditionalBlocksBlocks.BISMUTH_BLOCK)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_INGOT))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BISMUTH_BLOCK));
        // Bismuth nuggets
        this.shapeless(AdditionalBlocksItems.BISMUTH_NUGGET, 9)
            .input(AdditionalBlocksItems.BISMUTH_INGOT)
            .unlockedBy(AdditionalBlocksItems.BISMUTH_INGOT, AdditionalBlocksItems.BISMUTH_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_INGOT));
        this.shaped("bismuth_ingot_from_nuggets", AdditionalBlocksItems.BISMUTH_INGOT)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.BISMUTH_NUGGET)
            .unlockedBy(AdditionalBlocksItems.BISMUTH_INGOT, AdditionalBlocksItems.BISMUTH_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_INGOT));
        this.smelting("bismuth_nugget_from_smelting", AdditionalBlocksItems.BISMUTH_NUGGET)
            .input(AdditionalBlocksItems.BISMUTH_AXE, AdditionalBlocksItems.BISMUTH_PICKAXE, AdditionalBlocksItems.BISMUTH_SHOVEL, AdditionalBlocksItems.BISMUTH_HOE, AdditionalBlocksItems.BISMUTH_SWORD)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(10)
            .experience(1)
            .unlockedBy(AdditionalBlocksItems.BISMUTH_AXE, AdditionalBlocksItems.BISMUTH_PICKAXE, AdditionalBlocksItems.BISMUTH_SHOVEL, AdditionalBlocksItems.BISMUTH_HOE, AdditionalBlocksItems.BISMUTH_SWORD)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_AXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_PICKAXE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_SHOVEL))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_HOE))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_SWORD));
        // Raw bismuth
        this.shapeless(AdditionalBlocksItems.RAW_BISMUTH, 9)
            .input(AdditionalBlocksBlocks.BISMUTH_CLUSTER)
            .unlockedBy(AdditionalBlocksItems.RAW_BISMUTH, AdditionalBlocksBlocks.BISMUTH_CLUSTER)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.RAW_BISMUTH))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.BISMUTH_CLUSTER));
        // Bismuth axe
        this.shaped(AdditionalBlocksItems.BISMUTH_AXE)
            .pattern("AA")
            .pattern("AB")
            .pattern(" B")
            .input('A', bismuthIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(bismuthIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_AXE));
        // Bismuth pickaxe
        this.shaped(AdditionalBlocksItems.BISMUTH_PICKAXE)
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" B ")
            .input('A', bismuthIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(bismuthIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_PICKAXE));
        // Bismuth shovel
        this.shaped(AdditionalBlocksItems.BISMUTH_SHOVEL)
            .pattern("A")
            .pattern("B")
            .pattern("B")
            .input('A', bismuthIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(bismuthIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_SHOVEL));
        // Bismuth hoe
        this.shaped(AdditionalBlocksItems.BISMUTH_HOE)
            .pattern("AA")
            .pattern(" B")
            .pattern(" B")
            .input('A', bismuthIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(bismuthIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_HOE));
        // Bismuth sword
        this.shaped(AdditionalBlocksItems.BISMUTH_SWORD)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .input('A', bismuthIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(bismuthIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.BISMUTH_SWORD));

        // Uranium block
        this.shaped(AdditionalBlocksBlocks.URANIUM_BLOCK)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .input('A', AdditionalBlocksItems.REFINED_URANIUM)
            .unlockedBy(AdditionalBlocksItems.REFINED_URANIUM)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.URANIUM_BLOCK));
        // Refined Uranium Shard (nugget)
        this.shapeless(AdditionalBlocksItems.URANIUM_NUGGET, 4)
            .input(AdditionalBlocksItems.REFINED_URANIUM)
            .unlockedBy(AdditionalBlocksItems.REFINED_URANIUM, AdditionalBlocksItems.URANIUM_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.REFINED_URANIUM));
        this.shaped("refined_uranium_from_nuggets", AdditionalBlocksItems.REFINED_URANIUM)
            .pattern("AA")
            .pattern("AA")
            .input('A', AdditionalBlocksItems.URANIUM_NUGGET)
            .unlockedBy(AdditionalBlocksItems.REFINED_URANIUM, AdditionalBlocksItems.URANIUM_NUGGET)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_NUGGET))
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.REFINED_URANIUM));
        this.smelting("uranium_nugget_from_ore", AdditionalBlocksItems.URANIUM_NUGGET)
            .input(AdditionalBlocksBlocks.URANIUM_ORE)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_NUGGET));
        this.smelting("uranium_nugget_from_smelting", AdditionalBlocksItems.URANIUM_NUGGET)
            .input(AdditionalBlocksItems.URANIUM_SWORD)
            .includeBlasting()
            .includeSmelting()
            .durationSeconds(10)
            .experience(1)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_NUGGET));
        this.smelting("uranium_nugget_from_raw", AdditionalBlocksItems.URANIUM_NUGGET)
            .input(AdditionalBlocksItems.RAW_URANIUM)
            .includeSmelting()
            .includeBlasting()
            .durationSeconds(30)
            .experience(4)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_NUGGET));
        // Refined Uranium (ingot)
        Tags.IOptionalNamedTag<Item> uraniumIngots = ItemTags.createOptional(new ResourceLocation("forge", "ingots/uranium"));
        this.shapeless(AdditionalBlocksItems.REFINED_URANIUM, 9)
            .input(AdditionalBlocksBlocks.URANIUM_BLOCK)
            .unlockedBy(AdditionalBlocksItems.REFINED_URANIUM, AdditionalBlocksBlocks.URANIUM_BLOCK)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.REFINED_URANIUM))
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.URANIUM_BLOCK));
        // Uranium Glass
        this.shaped(AdditionalBlocksBlocks.URANIUM_GLASS, 8)
            .pattern("XXX")
            .pattern("X#X")
            .pattern("XXX")
            .input('X', Items.GLASS)
            .input('#', AdditionalBlocksItems.REFINED_URANIUM)
            .unlockedBy(Items.GLASS)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.URANIUM_GLASS));
        // Uranium Glass Pane
        this.shaped(AdditionalBlocksBlocks.URANIUM_GLASS_PANE, 16)
            .pattern("XXX")
            .pattern("XXX")
            .input('X', AdditionalBlocksBlocks.URANIUM_GLASS)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.URANIUM_GLASS_PANE));
        // Nuclear TNT
        this.shaped(AdditionalBlocksBlocks.NUCLEAR_TNT, 1)
            .pattern("CBC")
            .pattern("BAB")
            .pattern("CBC")
            .input('A', Items.TNT)
            .input('B', AdditionalBlocksItems.REFINED_URANIUM)
            .input('C', Items.GUNPOWDER)
            .unlockedBy(Items.TNT)
            .unlockedBy(Items.GUNPOWDER)
            .unlockedBy(AdditionalBlocksItems.RAW_URANIUM)
            .condition(new BlockEnabledResourceCondition(AdditionalBlocksBlocks.NUCLEAR_TNT));
        // Uranium Sword
        this.shaped(AdditionalBlocksItems.URANIUM_SWORD)
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .input('A', uraniumIngots)
            .input('B', Tags.Items.RODS_WOODEN)
            .unlockedBy(uraniumIngots)
            .condition(new ItemEnabledResourceCondition(AdditionalBlocksItems.URANIUM_SWORD));
    }

    @Override
    public void generate(){
        // Generate recipes for blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            BlockPreset preset = blockType.getRecipePreset();
            if(preset != null)
                preset.createRecipes(this, blockType);
            Set<Supplier<IItemProvider>> stoneCuttingInputs = blockType.getStoneCuttingInputs();
            if(!stoneCuttingInputs.isEmpty()){
                StoneCuttingRecipeBuilder builder = this.stoneCutting(blockType.getBlock());
                stoneCuttingInputs.forEach(i -> builder.input(i.get()));
                stoneCuttingInputs.forEach(i -> builder.unlockedBy(i.get()));
                builder.condition(new BlockEnabledResourceCondition(blockType));
            }
        }

        this.manualRecipes();
    }

    public interface BlockPreset {

        void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType);
    }

    public static abstract class SingleIngredientBlockPreset {

        protected SingleIngredientBlockPreset(){
        }

        private void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Function<BlockType<?>,Ingredient> ingredient){
            this.createRecipes(generator, blockType, ingredient.apply(blockType));
        }

        protected abstract void createRecipes(ABRecipeGenerator generator, BlockType<?> blockType, Ingredient ingredient);

        public BlockPreset from(Supplier<IItemProvider> item){
            return this.copy(blockType -> Ingredient.of(item.get()));
        }

        public BlockPreset from(Ingredient ingredient){
            return this.copy(blockType -> ingredient);
        }

        private BlockPreset copy(Function<BlockType<?>,Ingredient> ingredient){
            return (generator, blockType) -> this.createRecipes(generator, blockType, ingredient);
        }
    }
}
