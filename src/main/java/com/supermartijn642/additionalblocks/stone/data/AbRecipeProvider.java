package com.supermartijn642.additionalblocks.stone.data;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import com.supermartijn642.additionalblocks.stone.SlabBlock;
import com.supermartijn642.additionalblocks.stone.StairBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

import java.util.function.Consumer;

public class AbRecipeProvider extends RecipeProvider {
    public AbRecipeProvider(DataGenerator dataGenerator) {

        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        this.addStoneStairsRecipes(recipeConsumer);
        this.addStoneSlabsRecipes(recipeConsumer);
        this.addStoneWallsRecipes(recipeConsumer);
        AbSCRProvider.stoneCuttingRecipes(recipeConsumer, RecipeProvider::has);
    }

    private void addStairsRecipe(Consumer<IFinishedRecipe> recipeConsumer, StairBlock stairBlock, Block block) {
        ShapedRecipeBuilder.shaped(stairBlock, 4)
            .pattern("  A")
            .pattern(" AA")
            .pattern("AAA")
            .define('A', block)
            .unlockedBy("has_item", has(block))
            .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(stairBlock, 4)
            .pattern("A  ")
            .pattern("AA ")
            .pattern("AAA")
            .define('A', block)
            .unlockedBy("has_item", has(block))
            .save(recipeConsumer, "abstoneedition:" + stairBlock.getRegistryName().getPath() + "_2");
    }

    private void addSlabRecipe(Consumer<IFinishedRecipe> recipeConsumer, SlabBlock slabBlock, Block block) {
        ShapedRecipeBuilder.shaped(slabBlock, 6)
            .pattern("AAA")
            .define('A', block)
            .unlockedBy("has_item", has(block))
            .save(recipeConsumer);
    }

    private void addWallsRecipe(Consumer<IFinishedRecipe> recipeConsumer, WallBlock wallBlock, Block block) {
        ShapedRecipeBuilder.shaped(wallBlock, 6)
            .pattern("AAA")
            .pattern("AAA")
            .define('A', block)
            .unlockedBy("has_item", has(block))
            .save(recipeConsumer);
    }

    private void addStoneStairsRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.brown_stone_path_straight_stairs, AdditionalBlocks.brown_stone_path_straight);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.brown_stone_path_curved_stairs, AdditionalBlocks.brown_stone_path_curved);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.brown_stone_pattern_stairs, AdditionalBlocks.brown_stone_pattern);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.brown_stone_tiles_stairs, AdditionalBlocks.brown_stone_tiles);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.old_stone_path_straight_stairs, AdditionalBlocks.old_stone_path_straight);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.old_stone_path_curved_stairs, AdditionalBlocks.old_stone_path_curved);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.old_stone_pattern_stairs, AdditionalBlocks.old_stone_pattern);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.old_stone_tiles_stairs, AdditionalBlocks.old_stone_tiles);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.stone_path_straight_stairs, AdditionalBlocks.stone_path_straight);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.stone_path_curved_stairs, AdditionalBlocks.stone_path_curved);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.stone_pattern_stairs, AdditionalBlocks.stone_pattern);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.stone_tiles_stairs, AdditionalBlocks.stone_tiles);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.glowstone_stairs, Blocks.GLOWSTONE);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.limestone_bricks_stairs, AdditionalBlocks.limestone_bricks);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.smooth_limestone_stairs, AdditionalBlocks.smooth_limestone);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.smooth_stone_stairs, Blocks.SMOOTH_STONE);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.smooth_smooth_stone_stairs, AdditionalBlocks.smooth_smooth_stone);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.obsidian_stairs, Blocks.OBSIDIAN);
        this.addStairsRecipe(recipeConsumer, AdditionalBlocks.obsidian_bricks_stairs, AdditionalBlocks.obsidian_bricks);
    }

    private void addStoneSlabsRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.brown_stone_path_straight_slab, AdditionalBlocks.brown_stone_path_straight);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.brown_stone_path_curved_slab, AdditionalBlocks.brown_stone_path_curved);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.brown_stone_pattern_slab, AdditionalBlocks.brown_stone_pattern);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.brown_stone_tiles_slab, AdditionalBlocks.brown_stone_tiles);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.old_stone_path_straight_slab, AdditionalBlocks.old_stone_path_straight);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.old_stone_path_curved_slab, AdditionalBlocks.old_stone_path_curved);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.old_stone_pattern_slab, AdditionalBlocks.old_stone_pattern);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.old_stone_tiles_slab, AdditionalBlocks.old_stone_tiles);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.stone_path_straight_slab, AdditionalBlocks.stone_path_straight);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.stone_path_curved_slab, AdditionalBlocks.stone_path_curved);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.stone_pattern_slab, AdditionalBlocks.stone_pattern);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.stone_tiles_slab, AdditionalBlocks.stone_tiles);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.glowstone_slab, Blocks.GLOWSTONE);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.limestone_bricks_slab, AdditionalBlocks.limestone_bricks);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.smooth_limestone_slab, AdditionalBlocks.smooth_limestone);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.smooth_smooth_stone_slab, AdditionalBlocks.smooth_smooth_stone);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.obsidian_slab, Blocks.OBSIDIAN);
        this.addSlabRecipe(recipeConsumer, AdditionalBlocks.obsidian_bricks_slab, AdditionalBlocks.obsidian_bricks);
    }

    private void addStoneWallsRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.polished_andesite_wall, Blocks.POLISHED_ANDESITE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.polished_diorite_wall, Blocks.POLISHED_DIORITE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.polished_granite_wall, Blocks.POLISHED_GRANITE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.andesite_bricks_wall, AdditionalBlocks.andesite_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.diorite_bricks_wall, AdditionalBlocks.diorite_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.granite_bricks_wall, AdditionalBlocks.granite_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.black_marble_wall, AdditionalBlocks.black_marble);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.black_marble_bricks_wall, AdditionalBlocks.black_marble_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.bloodstone_wall, AdditionalBlocks.bloodstone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.bloodstone_bricks_wall, AdditionalBlocks.bloodstone_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.glowstone_wall, Blocks.GLOWSTONE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.glowstone_bricks_wall, AdditionalBlocks.glowstone_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.gray_bricks_wall, AdditionalBlocks.gray_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.limestone_bricks_wall, AdditionalBlocks.limestone_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.marble_wall, AdditionalBlocks.marble);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.marble_bricks_wall, AdditionalBlocks.marble_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_black_marble_wall, AdditionalBlocks.smooth_black_marble);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_bloodstone_wall, AdditionalBlocks.smooth_bloodstone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_glowstone_wall, AdditionalBlocks.smooth_glowstone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_limestone_wall, AdditionalBlocks.smooth_limestone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_marble_wall, AdditionalBlocks.smooth_marble);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_stone_wall, Blocks.SMOOTH_STONE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_stone_bricks_wall, AdditionalBlocks.smooth_stone_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.stone_brick_block_wall, AdditionalBlocks.stone_brick_block);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.volcanic_stone_wall, AdditionalBlocks.volcanic_stone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.volcanic_stone_bricks_wall, AdditionalBlocks.volcanic_stone_bricks);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.stone_wall, Blocks.STONE);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.smooth_smooth_stone_wall, AdditionalBlocks.smooth_smooth_stone);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.obsidian_wall, Blocks.OBSIDIAN);
        this.addWallsRecipe(recipeConsumer, AdditionalBlocks.obsidian_bricks_wall, AdditionalBlocks.obsidian_bricks);
    }
}
