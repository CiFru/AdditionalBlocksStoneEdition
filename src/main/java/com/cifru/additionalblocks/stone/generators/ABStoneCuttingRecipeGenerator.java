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
