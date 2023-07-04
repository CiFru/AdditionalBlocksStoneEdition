package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.cifru.additionalblocks.stone.condition.BlockEnabledResourceCondition;
import com.cifru.additionalblocks.stone.condition.ItemEnabledResourceCondition;
import com.cifru.additionalblocks.stone.items.ItemType;
import com.supermartijn642.core.generator.RecipeGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

/**
 * Created 24/03/2023 by SuperMartijn642
 */
public class ABStoneCuttingRecipeGenerator extends RecipeGenerator {

    public ABStoneCuttingRecipeGenerator(ResourceCache cache){
        super("abstoneedition", cache);
    }

    @Override
    public String getName(){
        return this.modName + " Stone Cutting Generator";
    }
    @Override
    public void generate(){
        // Marble
        this.create(AdditionalBlocksBlocks.MARBLE_STAIRS, 1, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_SLAB, 2, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_WALL, 1, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_MARBLE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_MARBLE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_MARBLE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_BRICKS, 1, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.MARBLE_BRICKS, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.MARBLE_BRICKS, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_BRICKS_WALL, 1, AdditionalBlocksBlocks.MARBLE_BRICKS, AdditionalBlocksBlocks.MARBLE);
        this.create(AdditionalBlocksBlocks.MARBLE_PILLAR, 1, AdditionalBlocksBlocks.MARBLE);
        // Stone brick block
        this.create(AdditionalBlocksBlocks.STONE_BRICK_BLOCK, 1, Blocks.STONE);
        this.create(AdditionalBlocksBlocks.STONE_BRICK_BLOCK_STAIRS, 1, AdditionalBlocksBlocks.STONE_BRICK_BLOCK, Blocks.STONE);
        this.create(AdditionalBlocksBlocks.STONE_BRICK_BLOCK_SLAB, 2, AdditionalBlocksBlocks.STONE_BRICK_BLOCK, Blocks.STONE);
        this.create(AdditionalBlocksBlocks.STONE_BRICK_BLOCK_WALL, 1, AdditionalBlocksBlocks.STONE_BRICK_BLOCK, Blocks.STONE);
        // Diorite bricks
        this.create(AdditionalBlocksBlocks.DIORITE_BRICKS, 1, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        this.create(AdditionalBlocksBlocks.DIORITE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        this.create(AdditionalBlocksBlocks.DIORITE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        this.create(AdditionalBlocksBlocks.DIORITE_BRICKS_WALL, 1, AdditionalBlocksBlocks.DIORITE_BRICKS, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        // Polished diorite
        this.create(AdditionalBlocksBlocks.POLISHED_DIORITE_WALL, 2, Blocks.DIORITE, Blocks.POLISHED_DIORITE);
        // Andesite bricks
        this.create(AdditionalBlocksBlocks.ANDESITE_BRICKS, 1, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        this.create(AdditionalBlocksBlocks.ANDESITE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        this.create(AdditionalBlocksBlocks.ANDESITE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        this.create(AdditionalBlocksBlocks.ANDESITE_BRICKS_WALL, 1, AdditionalBlocksBlocks.ANDESITE_BRICKS, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        // Polished andesite
        this.create(AdditionalBlocksBlocks.POLISHED_ANDESITE_WALL, 2, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
        // Granite bricks
        this.create(AdditionalBlocksBlocks.GRANITE_BRICKS, 1, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        this.create(AdditionalBlocksBlocks.GRANITE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        this.create(AdditionalBlocksBlocks.GRANITE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        this.create(AdditionalBlocksBlocks.GRANITE_BRICKS_WALL, 1, AdditionalBlocksBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        // Polished granite
        this.create(AdditionalBlocksBlocks.POLISHED_GRANITE_WALL, 2, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        // Bloodstone
        this.create(AdditionalBlocksBlocks.BLOODSTONE_STAIRS, 1, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_SLAB, 2, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_WALL, 1, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLOODSTONE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_BLOODSTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLOODSTONE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_BLOODSTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLOODSTONE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_BRICKS, 1, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.BLOODSTONE_BRICKS, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.BLOODSTONE_BRICKS, AdditionalBlocksBlocks.BLOODSTONE);
        this.create(AdditionalBlocksBlocks.BLOODSTONE_BRICKS_WALL, 1, AdditionalBlocksBlocks.BLOODSTONE_BRICKS, AdditionalBlocksBlocks.BLOODSTONE);
        // Black marble
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_STAIRS, 1, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_SLAB, 2, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_WALL, 1, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS, 1, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS, AdditionalBlocksBlocks.BLACK_MARBLE);
        this.create(AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS_WALL, 1, AdditionalBlocksBlocks.BLACK_MARBLE_BRICKS, AdditionalBlocksBlocks.BLACK_MARBLE);
        // Brown bricks
        this.create(AdditionalBlocksBlocks.BROWN_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.BROWN_BRICKS);
        this.create(AdditionalBlocksBlocks.BROWN_BRICKS_SLAB, 2, AdditionalBlocksBlocks.BROWN_BRICKS);
        // Volcanic stone
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_STAIRS, 1, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_SLAB, 2, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_WALL, 1, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS, 1, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS, AdditionalBlocksBlocks.VOLCANIC_STONE);
        this.create(AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS_WALL, 1, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS, AdditionalBlocksBlocks.VOLCANIC_STONE);
        // Stone path + pattern + tiles
        this.create(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT_STAIRS, 1, AdditionalBlocksBlocks.STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.STONE_PATH_STRAIGHT_SLAB, 2, AdditionalBlocksBlocks.STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.STONE_PATH_CURVED_STAIRS, 1, AdditionalBlocksBlocks.STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.STONE_PATH_CURVED_SLAB, 2, AdditionalBlocksBlocks.STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.STONE_PATTERN_STAIRS, 1, AdditionalBlocksBlocks.STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.STONE_PATTERN_SLAB, 2, AdditionalBlocksBlocks.STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.STONE_TILES_STAIRS, 1, AdditionalBlocksBlocks.STONE_TILES);
        this.create(AdditionalBlocksBlocks.STONE_TILES_SLAB, 2, AdditionalBlocksBlocks.STONE_TILES);
        // Brown stone path + pattern + tiles
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT_STAIRS, 1, AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT_SLAB, 2, AdditionalBlocksBlocks.BROWN_STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED_STAIRS, 1, AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED_SLAB, 2, AdditionalBlocksBlocks.BROWN_STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATTERN_STAIRS, 1, AdditionalBlocksBlocks.BROWN_STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_PATTERN_SLAB, 2, AdditionalBlocksBlocks.BROWN_STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_TILES_STAIRS, 1, AdditionalBlocksBlocks.BROWN_STONE_TILES);
        this.create(AdditionalBlocksBlocks.BROWN_STONE_TILES_SLAB, 2, AdditionalBlocksBlocks.BROWN_STONE_TILES);
        // Old stone path + pattern + tiles
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT_STAIRS, 1, AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT_SLAB, 2, AdditionalBlocksBlocks.OLD_STONE_PATH_STRAIGHT);
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED_STAIRS, 1, AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED_SLAB, 2, AdditionalBlocksBlocks.OLD_STONE_PATH_CURVED);
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATTERN_STAIRS, 1, AdditionalBlocksBlocks.OLD_STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.OLD_STONE_PATTERN_SLAB, 2, AdditionalBlocksBlocks.OLD_STONE_PATTERN);
        this.create(AdditionalBlocksBlocks.OLD_STONE_TILES_STAIRS, 1, AdditionalBlocksBlocks.OLD_STONE_TILES);
        this.create(AdditionalBlocksBlocks.OLD_STONE_TILES_SLAB, 2, AdditionalBlocksBlocks.OLD_STONE_TILES);
        // Limestone
        this.create(AdditionalBlocksBlocks.LIMESTONE_STAIRS, 1, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_SLAB, 2, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_WALL, 1, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_LIMESTONE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_LIMESTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_LIMESTONE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_LIMESTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_LIMESTONE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_BRICKS, 1, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.LIMESTONE_BRICKS, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.LIMESTONE_BRICKS, AdditionalBlocksBlocks.LIMESTONE);
        this.create(AdditionalBlocksBlocks.LIMESTONE_BRICKS_WALL, 1, AdditionalBlocksBlocks.LIMESTONE_BRICKS, AdditionalBlocksBlocks.LIMESTONE);
        // Asphalt
        this.create(AdditionalBlocksBlocks.ASPHALT_STAIRS, 1, AdditionalBlocksBlocks.ASPHALT);
        this.create(AdditionalBlocksBlocks.ASPHALT_SLAB, 2, AdditionalBlocksBlocks.ASPHALT);
        // Charred blocks
        this.create(AdditionalBlocksBlocks.CHARRED_STAIRS, 1, AdditionalBlocksBlocks.CHARRED_PLANKS);
        this.create(AdditionalBlocksBlocks.CHARRED_SLAB, 2, AdditionalBlocksBlocks.CHARRED_PLANKS);
        // Gray bricks
        this.create(AdditionalBlocksBlocks.GRAY_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.GRAY_BRICKS);
        this.create(AdditionalBlocksBlocks.GRAY_BRICKS_SLAB, 2, AdditionalBlocksBlocks.GRAY_BRICKS);
        this.create(AdditionalBlocksBlocks.GRAY_BRICKS_WALL, 1, AdditionalBlocksBlocks.GRAY_BRICKS);
        // Smooth glowstone
        this.create(AdditionalBlocksBlocks.SMOOTH_GLOWSTONE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_GLOWSTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_GLOWSTONE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_GLOWSTONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_GLOWSTONE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_GLOWSTONE);
        // Glowstone
        this.create(AdditionalBlocksBlocks.GLOWSTONE_STAIRS, 1, Blocks.GLOWSTONE);
        this.create(AdditionalBlocksBlocks.GLOWSTONE_SLAB, 2, Blocks.GLOWSTONE);
        this.create(AdditionalBlocksBlocks.GLOWSTONE_WALL, 1, Blocks.GLOWSTONE);
        // Glowstone bricks
        this.create(AdditionalBlocksBlocks.GLOWSTONE_BRICKS, 1, Blocks.GLOWSTONE);
        this.create(AdditionalBlocksBlocks.GLOWSTONE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.GLOWSTONE_BRICKS, Blocks.GLOWSTONE);
        this.create(AdditionalBlocksBlocks.GLOWSTONE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.GLOWSTONE_BRICKS, Blocks.GLOWSTONE);
        this.create(AdditionalBlocksBlocks.GLOWSTONE_BRICKS_WALL, 1, AdditionalBlocksBlocks.GLOWSTONE_BRICKS, Blocks.GLOWSTONE);
        // Smooth stone bricks
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, 1, Blocks.SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, Blocks.SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, Blocks.SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS_WALL, 1, AdditionalBlocksBlocks.SMOOTH_STONE_BRICKS, Blocks.SMOOTH_STONE);
        // Smooth stone
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_STAIRS, 1, Blocks.SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_STONE_WALL, 1, Blocks.SMOOTH_STONE);
        // Stone
        this.create(AdditionalBlocksBlocks.STONE_WALL, 1, Blocks.STONE);
        // Smooth smooth stone
        this.create(AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE_STAIRS, 1, AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE_SLAB, 2, AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE);
        this.create(AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE_WALL, 1, AdditionalBlocksBlocks.SMOOTH_SMOOTH_STONE);
        // Obsidian
        this.create(AdditionalBlocksBlocks.OBSIDIAN_STAIRS, 1, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_SLAB, 2, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_WALL, 1, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_BRICKS, 1, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_BRICKS_STAIRS, 1, AdditionalBlocksBlocks.OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_BRICKS_SLAB, 2, AdditionalBlocksBlocks.OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        this.create(AdditionalBlocksBlocks.OBSIDIAN_BRICKS_WALL, 1, AdditionalBlocksBlocks.OBSIDIAN_BRICKS, Blocks.OBSIDIAN);
        // 1.19
        this.create(AdditionalBlocksBlocks.REINFORCED_DEEPSLATE_STAIRS, 1, Blocks.REINFORCED_DEEPSLATE);
        this.create(AdditionalBlocksBlocks.REINFORCED_DEEPSLATE_SLAB, 2, Blocks.REINFORCED_DEEPSLATE);
        this.create(AdditionalBlocksBlocks.REINFORCED_DEEPSLATE_WALL, 1, Blocks.REINFORCED_DEEPSLATE);
        // Concrete and Terracotta
        this.create(AdditionalBlocksBlocks.WHITE_CONCRETE_SLAB, 2, Blocks.WHITE_CONCRETE);
        this.create(AdditionalBlocksBlocks.WHITE_CONCRETE_STAIRS, 1, Blocks.WHITE_CONCRETE);
        this.create(AdditionalBlocksBlocks.WHITE_CONCRETE_WALL, 1, Blocks.WHITE_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLACK_CONCRETE_SLAB, 2, Blocks.BLACK_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLACK_CONCRETE_STAIRS, 1, Blocks.BLACK_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLACK_CONCRETE_WALL, 1, Blocks.BLACK_CONCRETE);
        this.create(AdditionalBlocksBlocks.GRAY_CONCRETE_SLAB, 2, Blocks.GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.GRAY_CONCRETE_STAIRS, 1, Blocks.GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.GRAY_CONCRETE_WALL, 1, Blocks.GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_CONCRETE_SLAB, 2, Blocks.LIGHT_GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_CONCRETE_STAIRS, 1, Blocks.LIGHT_GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_CONCRETE_WALL, 1, Blocks.LIGHT_GRAY_CONCRETE);
        this.create(AdditionalBlocksBlocks.BROWN_CONCRETE_SLAB, 2, Blocks.BROWN_CONCRETE);
        this.create(AdditionalBlocksBlocks.BROWN_CONCRETE_STAIRS, 1, Blocks.BROWN_CONCRETE);
        this.create(AdditionalBlocksBlocks.BROWN_CONCRETE_WALL, 1, Blocks.BROWN_CONCRETE);
        this.create(AdditionalBlocksBlocks.PINK_CONCRETE_SLAB, 2, Blocks.PINK_CONCRETE);
        this.create(AdditionalBlocksBlocks.PINK_CONCRETE_STAIRS, 1, Blocks.PINK_CONCRETE);
        this.create(AdditionalBlocksBlocks.PINK_CONCRETE_WALL, 1, Blocks.PINK_CONCRETE);
        this.create(AdditionalBlocksBlocks.RED_CONCRETE_SLAB, 2, Blocks.RED_CONCRETE);
        this.create(AdditionalBlocksBlocks.RED_CONCRETE_STAIRS, 1, Blocks.RED_CONCRETE);
        this.create(AdditionalBlocksBlocks.RED_CONCRETE_WALL, 1, Blocks.RED_CONCRETE);
        this.create(AdditionalBlocksBlocks.ORANGE_CONCRETE_SLAB, 2, Blocks.ORANGE_CONCRETE);
        this.create(AdditionalBlocksBlocks.ORANGE_CONCRETE_STAIRS, 1, Blocks.ORANGE_CONCRETE);
        this.create(AdditionalBlocksBlocks.ORANGE_CONCRETE_WALL, 1, Blocks.ORANGE_CONCRETE);
        this.create(AdditionalBlocksBlocks.YELLOW_CONCRETE_SLAB, 2, Blocks.YELLOW_CONCRETE);
        this.create(AdditionalBlocksBlocks.YELLOW_CONCRETE_STAIRS, 1, Blocks.YELLOW_CONCRETE);
        this.create(AdditionalBlocksBlocks.YELLOW_CONCRETE_WALL, 1, Blocks.YELLOW_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIME_CONCRETE_SLAB, 2, Blocks.LIME_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIME_CONCRETE_STAIRS, 1, Blocks.LIME_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIME_CONCRETE_WALL, 1, Blocks.LIME_CONCRETE);
        this.create(AdditionalBlocksBlocks.GREEN_CONCRETE_SLAB, 2, Blocks.GREEN_CONCRETE);
        this.create(AdditionalBlocksBlocks.GREEN_CONCRETE_STAIRS, 1, Blocks.GREEN_CONCRETE);
        this.create(AdditionalBlocksBlocks.GREEN_CONCRETE_WALL, 1, Blocks.GREEN_CONCRETE);
        this.create(AdditionalBlocksBlocks.CYAN_CONCRETE_SLAB, 2, Blocks.CYAN_CONCRETE);
        this.create(AdditionalBlocksBlocks.CYAN_CONCRETE_STAIRS, 1, Blocks.CYAN_CONCRETE);
        this.create(AdditionalBlocksBlocks.CYAN_CONCRETE_WALL, 1, Blocks.CYAN_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_CONCRETE_SLAB, 2, Blocks.LIGHT_BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_CONCRETE_STAIRS, 1, Blocks.LIGHT_BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_CONCRETE_WALL, 1, Blocks.LIGHT_BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLUE_CONCRETE_SLAB, 2, Blocks.BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLUE_CONCRETE_STAIRS, 1, Blocks.BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.BLUE_CONCRETE_WALL, 1, Blocks.BLUE_CONCRETE);
        this.create(AdditionalBlocksBlocks.PURPLE_CONCRETE_SLAB, 2, Blocks.PURPLE_CONCRETE);
        this.create(AdditionalBlocksBlocks.PURPLE_CONCRETE_STAIRS, 1, Blocks.PURPLE_CONCRETE);
        this.create(AdditionalBlocksBlocks.PURPLE_CONCRETE_WALL, 1, Blocks.PURPLE_CONCRETE);
        this.create(AdditionalBlocksBlocks.MAGENTA_CONCRETE_SLAB, 2, Blocks.MAGENTA_CONCRETE);
        this.create(AdditionalBlocksBlocks.MAGENTA_CONCRETE_STAIRS, 1, Blocks.MAGENTA_CONCRETE);
        this.create(AdditionalBlocksBlocks.MAGENTA_CONCRETE_WALL, 1, Blocks.MAGENTA_CONCRETE);

        this.create(AdditionalBlocksBlocks.WHITE_TERRACOTTA_SLAB, 2, Blocks.WHITE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.WHITE_TERRACOTTA_STAIRS, 1, Blocks.WHITE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.WHITE_TERRACOTTA_WALL, 1, Blocks.WHITE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLACK_TERRACOTTA_SLAB, 2, Blocks.BLACK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLACK_TERRACOTTA_STAIRS, 1, Blocks.BLACK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLACK_TERRACOTTA_WALL, 1, Blocks.BLACK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GRAY_TERRACOTTA_SLAB, 2, Blocks.GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GRAY_TERRACOTTA_STAIRS, 1, Blocks.GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GRAY_TERRACOTTA_WALL, 1, Blocks.GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_TERRACOTTA_SLAB, 2, Blocks.LIGHT_GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, 1, Blocks.LIGHT_GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_GRAY_TERRACOTTA_WALL, 1, Blocks.LIGHT_GRAY_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BROWN_TERRACOTTA_SLAB, 2, Blocks.BROWN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BROWN_TERRACOTTA_STAIRS, 1, Blocks.BROWN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BROWN_TERRACOTTA_WALL, 1, Blocks.BROWN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PINK_TERRACOTTA_SLAB, 2, Blocks.PINK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PINK_TERRACOTTA_STAIRS, 1, Blocks.PINK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PINK_TERRACOTTA_WALL, 1, Blocks.PINK_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.RED_TERRACOTTA_SLAB, 2, Blocks.RED_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.RED_TERRACOTTA_STAIRS, 1, Blocks.RED_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.RED_TERRACOTTA_WALL, 1, Blocks.RED_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.ORANGE_TERRACOTTA_SLAB, 2, Blocks.ORANGE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.ORANGE_TERRACOTTA_STAIRS, 1, Blocks.ORANGE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.ORANGE_TERRACOTTA_WALL, 1, Blocks.ORANGE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.YELLOW_TERRACOTTA_SLAB, 2, Blocks.YELLOW_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.YELLOW_TERRACOTTA_STAIRS, 1, Blocks.YELLOW_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.YELLOW_TERRACOTTA_WALL, 1, Blocks.YELLOW_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIME_TERRACOTTA_SLAB, 2, Blocks.LIME_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIME_TERRACOTTA_STAIRS, 1, Blocks.LIME_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIME_TERRACOTTA_WALL, 1, Blocks.LIME_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GREEN_TERRACOTTA_SLAB, 2, Blocks.GREEN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GREEN_TERRACOTTA_STAIRS, 1, Blocks.GREEN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.GREEN_TERRACOTTA_WALL, 1, Blocks.GREEN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.CYAN_TERRACOTTA_SLAB, 2, Blocks.CYAN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.CYAN_TERRACOTTA_STAIRS, 1, Blocks.CYAN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.CYAN_TERRACOTTA_WALL, 1, Blocks.CYAN_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_TERRACOTTA_SLAB, 2, Blocks.LIGHT_BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, 1, Blocks.LIGHT_BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.LIGHT_BLUE_TERRACOTTA_WALL, 1, Blocks.LIGHT_BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLUE_TERRACOTTA_SLAB, 2, Blocks.BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLUE_TERRACOTTA_STAIRS, 1, Blocks.BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.BLUE_TERRACOTTA_WALL, 1, Blocks.BLUE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PURPLE_TERRACOTTA_SLAB, 2, Blocks.PURPLE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PURPLE_TERRACOTTA_STAIRS, 1, Blocks.PURPLE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.PURPLE_TERRACOTTA_WALL, 1, Blocks.PURPLE_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.MAGENTA_TERRACOTTA_SLAB, 2, Blocks.MAGENTA_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.MAGENTA_TERRACOTTA_STAIRS, 1, Blocks.MAGENTA_TERRACOTTA);
        this.create(AdditionalBlocksBlocks.MAGENTA_TERRACOTTA_WALL, 1, Blocks.MAGENTA_TERRACOTTA);
    }

    private void create(BlockType<?> output, int count, ItemLike... inputs){
        StoneCuttingRecipeBuilder builder = this.stoneCutting(
            output.getIdentifier().getNamespace(),
            output.getIdentifier().getPath() + "_stonecutting",
            output,
            count);
        builder.condition(new BlockEnabledResourceCondition(output));

        for(ItemLike input : inputs){
            builder.input(input);
            if(input instanceof BlockType<?>)
                builder.condition(new BlockEnabledResourceCondition(((BlockType<?>)input)));
            else if(input instanceof ItemType<?>)
                builder.condition(new ItemEnabledResourceCondition(((ItemType<?>)input)));
        }
    }
}
