package com.supermartijn642.additionalblocks.stone;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class AbBlockStateProvider extends BlockStateProvider {
    public AbBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.addStoneStairsModels();
        this.addStoneSlabModels();
        this.addStoneWallModels();
    }

    private void addStoneStairsModels() {
        this.stairsBlock(AdditionalBlocks.brown_stone_path_straight_stairs, "brown_stone_path_straight", new ResourceLocation("abstoneedition", "brown_stone_path_straight"));
        this.stairsBlock(AdditionalBlocks.brown_stone_path_curved_stairs, "brown_stone_path_curved", new ResourceLocation("abstoneedition", "brown_stone_path_curved"));
        this.stairsBlock(AdditionalBlocks.brown_stone_pattern_stairs, "brown_stone_pattern", new ResourceLocation("abstoneedition", "brown_stone_pattern"));
        this.stairsBlock(AdditionalBlocks.brown_stone_tiles_stairs, "brown_stone_tiles", new ResourceLocation("abstoneedition", "brown_stone_tiles"));
        this.stairsBlock(AdditionalBlocks.old_stone_path_straight_stairs, "old_stone_path_straight", new ResourceLocation("abstoneedition", "old_stone_path_straight"));
        this.stairsBlock(AdditionalBlocks.old_stone_path_curved_stairs, "old_stone_path_curved", new ResourceLocation("abstoneedition", "old_stone_path_curved"));
        this.stairsBlock(AdditionalBlocks.old_stone_pattern_stairs, "old_stone_pattern", new ResourceLocation("abstoneedition", "old_stone_pattern"));
        this.stairsBlock(AdditionalBlocks.old_stone_tiles_stairs, "old_stone_tiles", new ResourceLocation("abstoneedition", "old_stone_tiles"));
        this.stairsBlock(AdditionalBlocks.stone_path_straight_stairs, "stone_path_straight", new ResourceLocation("abstoneedition", "stone_path_straight"));
        this.stairsBlock(AdditionalBlocks.stone_path_curved_stairs, "stone_path_curved", new ResourceLocation("abstoneedition", "stone_path_curved"));
        this.stairsBlock(AdditionalBlocks.stone_pattern_stairs, "stone_pattern", new ResourceLocation("abstoneedition", "stone_pattern"));
        this.stairsBlock(AdditionalBlocks.stone_tiles_stairs, "stone_tiles", new ResourceLocation("abstoneedition", "stone_tiles"));
        this.stairsBlock(AdditionalBlocks.glowstone_stairs, "glowstone", new ResourceLocation("minecraft", "block/glowstone"));
        this.stairsBlock(AdditionalBlocks.limestone_bricks_stairs, "limestone_bricks", new ResourceLocation("abstoneedition", "limestone_bricks"));
        this.stairsBlock(AdditionalBlocks.smooth_limestone_stairs, "smooth_limestone", new ResourceLocation("abstoneedition", "smooth_limestone"));
        this.stairsBlock(AdditionalBlocks.smooth_stone_stairs, "smooth_stone", new ResourceLocation("minecraft", "block/smooth_stone"));

        this.itemModels().withExistingParent("item/brown_stone_path_straight_stairs", new ResourceLocation("abstoneedition", "block/brown_stone_path_straight_stairs"));
        this.itemModels().withExistingParent("item/brown_stone_path_curved_stairs", new ResourceLocation("abstoneedition", "block/brown_stone_path_curved_stairs"));
        this.itemModels().withExistingParent("item/brown_stone_pattern_stairs", new ResourceLocation("abstoneedition", "block/brown_stone_pattern_stairs"));
        this.itemModels().withExistingParent("item/brown_stone_tiles_stairs", new ResourceLocation("abstoneedition", "block/brown_stone_tiles_stairs"));
        this.itemModels().withExistingParent("item/old_stone_path_straight_stairs", new ResourceLocation("abstoneedition", "block/old_stone_path_straight_stairs"));
        this.itemModels().withExistingParent("item/old_stone_path_curved_stairs", new ResourceLocation("abstoneedition", "block/old_stone_path_curved_stairs"));
        this.itemModels().withExistingParent("item/old_stone_pattern_stairs", new ResourceLocation("abstoneedition", "block/old_stone_pattern_stairs"));
        this.itemModels().withExistingParent("item/old_stone_tiles_stairs", new ResourceLocation("abstoneedition", "block/old_stone_tiles_stairs"));
        this.itemModels().withExistingParent("item/stone_path_straight_stairs", new ResourceLocation("abstoneedition", "block/stone_path_straight_stairs"));
        this.itemModels().withExistingParent("item/stone_path_curved_stairs", new ResourceLocation("abstoneedition", "block/stone_path_curved_stairs"));
        this.itemModels().withExistingParent("item/stone_pattern_stairs", new ResourceLocation("abstoneedition", "block/stone_pattern_stairs"));
        this.itemModels().withExistingParent("item/stone_tiles_stairs", new ResourceLocation("abstoneedition", "block/stone_tiles_stairs"));
        this.itemModels().withExistingParent("item/glowstone_stairs", new ResourceLocation("abstoneedition", "block/glowstone_stairs"));
        this.itemModels().withExistingParent("item/limestone_bricks_stairs", new ResourceLocation("abstoneedition", "block/limestone_bricks_stairs"));
        this.itemModels().withExistingParent("item/smooth_limestone_stairs", new ResourceLocation("abstoneedition", "block/smooth_limestone_stairs"));
        this.itemModels().withExistingParent("item/smooth_stone_stairs", new ResourceLocation("abstoneedition", "block/smooth_stone_stairs"));
    }

    private void addStoneSlabModels() {
        this.slabBlock(AdditionalBlocks.brown_stone_path_straight_slab, new ResourceLocation("abstoneedition", "block/brown_stone_path_straight"), new ResourceLocation("abstoneedition", "brown_stone_path_straight"));
        this.slabBlock(AdditionalBlocks.brown_stone_path_curved_slab, new ResourceLocation("abstoneedition", "block/brown_stone_path_curved"), new ResourceLocation("abstoneedition", "brown_stone_path_curved"));
        this.slabBlock(AdditionalBlocks.brown_stone_pattern_slab, new ResourceLocation("abstoneedition", "block/brown_stone_pattern"), new ResourceLocation("abstoneedition", "brown_stone_pattern"));
        this.slabBlock(AdditionalBlocks.brown_stone_tiles_slab, new ResourceLocation("abstoneedition", "block/brown_stone_tiles"), new ResourceLocation("abstoneedition", "brown_stone_tiles"));
        this.slabBlock(AdditionalBlocks.old_stone_path_straight_slab, new ResourceLocation("abstoneedition", "block/old_stone_path_straight"), new ResourceLocation("abstoneedition", "old_stone_path_straight"));
        this.slabBlock(AdditionalBlocks.old_stone_path_curved_slab, new ResourceLocation("abstoneedition", "block/old_stone_path_curved"), new ResourceLocation("abstoneedition", "old_stone_path_curved"));
        this.slabBlock(AdditionalBlocks.old_stone_pattern_slab, new ResourceLocation("abstoneedition", "block/old_stone_pattern"), new ResourceLocation("abstoneedition", "old_stone_pattern"));
        this.slabBlock(AdditionalBlocks.old_stone_tiles_slab, new ResourceLocation("abstoneedition", "block/old_stone_tiles"), new ResourceLocation("abstoneedition", "old_stone_tiles"));
        this.slabBlock(AdditionalBlocks.stone_path_straight_slab, new ResourceLocation("abstoneedition", "block/stone_path_straight"), new ResourceLocation("abstoneedition", "stone_path_straight"));
        this.slabBlock(AdditionalBlocks.stone_path_curved_slab, new ResourceLocation("abstoneedition", "block/stone_path_curved"), new ResourceLocation("abstoneedition", "stone_path_curved"));
        this.slabBlock(AdditionalBlocks.stone_pattern_slab, new ResourceLocation("abstoneedition", "block/stone_pattern"), new ResourceLocation("abstoneedition", "stone_pattern"));
        this.slabBlock(AdditionalBlocks.stone_tiles_slab, new ResourceLocation("abstoneedition", "block/stone_tiles"), new ResourceLocation("abstoneedition", "stone_tiles"));
        this.slabBlock(AdditionalBlocks.glowstone_slab, new ResourceLocation("minecraft", "block/glowstone"), new ResourceLocation("minecraft", "block/glowstone"));
        this.slabBlock(AdditionalBlocks.limestone_bricks_slab, new ResourceLocation("abstoneedition", "block/limestone_bricks"), new ResourceLocation("abstoneedition", "limestone_bricks"));
        this.slabBlock(AdditionalBlocks.smooth_limestone_slab, new ResourceLocation("abstoneedition", "block/smooth_limestone"), new ResourceLocation("abstoneedition", "smooth_limestone"));

        this.itemModels().withExistingParent("item/brown_stone_path_straight_slab", new ResourceLocation("abstoneedition", "block/brown_stone_path_straight_slab"));
        this.itemModels().withExistingParent("item/brown_stone_path_curved_slab", new ResourceLocation("abstoneedition", "block/brown_stone_path_curved_slab"));
        this.itemModels().withExistingParent("item/brown_stone_pattern_slab", new ResourceLocation("abstoneedition", "block/brown_stone_pattern_slab"));
        this.itemModels().withExistingParent("item/brown_stone_tiles_slab", new ResourceLocation("abstoneedition", "block/brown_stone_tiles_slab"));
        this.itemModels().withExistingParent("item/old_stone_path_straight_slab", new ResourceLocation("abstoneedition", "block/old_stone_path_straight_slab"));
        this.itemModels().withExistingParent("item/old_stone_path_curved_slab", new ResourceLocation("abstoneedition", "block/old_stone_path_curved_slab"));
        this.itemModels().withExistingParent("item/old_stone_pattern_slab", new ResourceLocation("abstoneedition", "block/old_stone_pattern_slab"));
        this.itemModels().withExistingParent("item/old_stone_tiles_slab", new ResourceLocation("abstoneedition", "block/old_stone_tiles_slab"));
        this.itemModels().withExistingParent("item/stone_path_straight_slab", new ResourceLocation("abstoneedition", "block/stone_path_straight_slab"));
        this.itemModels().withExistingParent("item/stone_path_curved_slab", new ResourceLocation("abstoneedition", "block/stone_path_curved_slab"));
        this.itemModels().withExistingParent("item/stone_pattern_slab", new ResourceLocation("abstoneedition", "block/stone_pattern_slab"));
        this.itemModels().withExistingParent("item/stone_tiles_slab", new ResourceLocation("abstoneedition", "block/stone_tiles_slab"));
        this.itemModels().withExistingParent("item/glowstone_slab", new ResourceLocation("abstoneedition", "block/glowstone_slab"));
        this.itemModels().withExistingParent("item/limestone_bricks_slab", new ResourceLocation("abstoneedition", "block/limestone_bricks_slab"));
        this.itemModels().withExistingParent("item/smooth_limestone_slab", new ResourceLocation("abstoneedition", "block/smooth_limestone_slab"));
    }

    private void addStoneWallModels() {
        this.wallBlock(AdditionalBlocks.polished_andesite_wall, new ResourceLocation("minecraft", "block/polished_andesite"));
        this.wallBlock(AdditionalBlocks.polished_diorite_wall, new ResourceLocation("minecraft", "block/polished_diorite"));
        this.wallBlock(AdditionalBlocks.polished_granite_wall, new ResourceLocation("minecraft", "block/polished_granite"));
        this.wallBlock(AdditionalBlocks.andesite_bricks_wall, new ResourceLocation("abstoneedition", "andesite_bricks"));
        this.wallBlock(AdditionalBlocks.diorite_bricks_wall, new ResourceLocation("abstoneedition", "diorite_bricks"));
        this.wallBlock(AdditionalBlocks.granite_bricks_wall, new ResourceLocation("abstoneedition", "granite_bricks"));
        this.wallBlock(AdditionalBlocks.black_marble_wall, new ResourceLocation("abstoneedition", "black_marble"));
        this.wallBlock(AdditionalBlocks.black_marble_bricks_wall, new ResourceLocation("abstoneedition", "black_marble_bricks"));
        this.wallBlock(AdditionalBlocks.bloodstone_wall, new ResourceLocation("abstoneedition", "bloodstone"));
        this.wallBlock(AdditionalBlocks.bloodstone_bricks_wall, new ResourceLocation("abstoneedition", "bloodstone_bricks"));
        this.wallBlock(AdditionalBlocks.glowstone_wall, new ResourceLocation("minecraft", "block/glowstone"));
        this.wallBlock(AdditionalBlocks.glowstone_bricks_wall, new ResourceLocation("abstoneedition", "glowstone_bricks"));
        this.wallBlock(AdditionalBlocks.gray_bricks_wall, new ResourceLocation("abstoneedition", "gray_bricks"));
        this.wallBlock(AdditionalBlocks.limestone_bricks_wall, new ResourceLocation("abstoneedition", "limestone_bricks"));
        this.wallBlock(AdditionalBlocks.marble_wall, new ResourceLocation("abstoneedition", "marble"));
        this.wallBlock(AdditionalBlocks.marble_bricks_wall, new ResourceLocation("abstoneedition", "marble_bricks"));
        this.wallBlock(AdditionalBlocks.smooth_black_marble_wall, new ResourceLocation("abstoneedition", "smooth_black_marble"));
        this.wallBlock(AdditionalBlocks.smooth_bloodstone_wall, new ResourceLocation("abstoneedition", "smooth_bloodstone"));
        this.wallBlock(AdditionalBlocks.smooth_glowstone_wall, new ResourceLocation("abstoneedition", "smooth_glowstone"));
        this.wallBlock(AdditionalBlocks.smooth_limestone_wall, new ResourceLocation("abstoneedition", "smooth_limestone"));
        this.wallBlock(AdditionalBlocks.smooth_marble_wall, new ResourceLocation("abstoneedition", "smooth_marble"));
        this.wallBlock(AdditionalBlocks.smooth_stone_wall, new ResourceLocation("minecraft", "block/smooth_stone"));
        this.wallBlock(AdditionalBlocks.smooth_stone_bricks_wall, new ResourceLocation("abstoneedition", "smooth_stone_bricks"));
        this.wallBlock(AdditionalBlocks.stone_brick_block_wall, new ResourceLocation("abstoneedition", "stone_brick_block"));
        this.wallBlock(AdditionalBlocks.volcanic_stone_wall, new ResourceLocation("abstoneedition", "volcanic_stone"));
        this.wallBlock(AdditionalBlocks.volcanic_stone_bricks_wall, new ResourceLocation("abstoneedition", "volcanic_stone_bricks"));

        this.itemModels().withExistingParent("item/polished_andesite_wall", new ResourceLocation("abstoneedition", "block/polished_andesite_wall"));
        this.itemModels().withExistingParent("item/polished_diorite_wall", new ResourceLocation("abstoneedition", "block/polished_diorite_wall"));
        this.itemModels().withExistingParent("item/polished_granite_wall", new ResourceLocation("abstoneedition", "block/polished_granite_wall"));
        this.itemModels().withExistingParent("item/andesite_bricks_wall", new ResourceLocation("abstoneedition", "block/andesite_bricks_wall"));
        this.itemModels().withExistingParent("item/diorite_bricks_wall", new ResourceLocation("abstoneedition", "block/diorite_bricks_wall"));
        this.itemModels().withExistingParent("item/granite_bricks_wall", new ResourceLocation("abstoneedition", "block/granite_bricks_wall"));
        this.itemModels().withExistingParent("item/black_marble_wall", new ResourceLocation("abstoneedition", "block/polished_andesite_wall"));
        this.itemModels().withExistingParent("item/black_marble_bricks_wall", new ResourceLocation("abstoneedition", "block/black_marble_bricks_wall"));
        this.itemModels().withExistingParent("item/bloodstone_wall", new ResourceLocation("abstoneedition", "block/bloodstone_wall"));
        this.itemModels().withExistingParent("item/bloodstone_bricks_wall", new ResourceLocation("abstoneedition", "block/bloodstone_bricks_wall"));
        this.itemModels().withExistingParent("item/glowstone_wall", new ResourceLocation("abstoneedition", "block/glowstone_wall"));
        this.itemModels().withExistingParent("item/glowstone_bricks_wall", new ResourceLocation("abstoneedition", "block/glowstone_bricks_wall"));
        this.itemModels().withExistingParent("item/gray_bricks_wall", new ResourceLocation("abstoneedition", "block/gray_bricks_wall"));
        this.itemModels().withExistingParent("item/limestone_bricks_wall", new ResourceLocation("abstoneedition", "block/limestone_bricks_wall"));
        this.itemModels().withExistingParent("item/marble_wall", new ResourceLocation("abstoneedition", "block/marble_wall"));
        this.itemModels().withExistingParent("item/marble_bricks_wall", new ResourceLocation("abstoneedition", "block/marble_bricks_wall"));
        this.itemModels().withExistingParent("item/smooth_black_marble_wall", new ResourceLocation("abstoneedition", "block/smooth_black_marble_wall"));
        this.itemModels().withExistingParent("item/smooth_bloodstone_wall", new ResourceLocation("abstoneedition", "block/smooth_bloodstone_wall"));
        this.itemModels().withExistingParent("item/smooth_glowstone_wall", new ResourceLocation("abstoneedition", "block/smooth_glowstone_wall"));
        this.itemModels().withExistingParent("item/smooth_limestone_wall", new ResourceLocation("abstoneedition", "block/smooth_limestone_wall"));
        this.itemModels().withExistingParent("item/smooth_marble_wall", new ResourceLocation("abstoneedition", "block/smooth_marble_wall"));
        this.itemModels().withExistingParent("item/smooth_stone_wall", new ResourceLocation("abstoneedition", "block/smooth_stone_wall"));
        this.itemModels().withExistingParent("item/smooth_stone_bricks_wall", new ResourceLocation("abstoneedition", "block/smooth_stone_bricks_wall"));
        this.itemModels().withExistingParent("item/stone_brick_block_wall", new ResourceLocation("abstoneedition", "block/stone_brick_block_wall"));
        this.itemModels().withExistingParent("item/volcanic_stone_wall", new ResourceLocation("abstoneedition", "block/volcanic_stone_wall"));
        this.itemModels().withExistingParent("item/volcanic_stone_bricks_wall", new ResourceLocation("abstoneedition", "block/volcanic_stone_bricks_wall"));
    }
}