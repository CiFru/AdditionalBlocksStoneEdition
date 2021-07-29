package com.supermartijn642.additionalblocks.stone.data;

import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AbBlockStateProvider extends BlockStateProvider {
    public AbBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.addStoneStairsModels();
        this.addStoneSlabModels();
        this.addStoneWalls();
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

    private void addStoneWalls() {
        this.addStoneWallModels(AdditionalBlocks.polished_andesite_wall, new ResourceLocation("minecraft", "block/polished_andesite"));
        this.addStoneWallModels(AdditionalBlocks.polished_diorite_wall, new ResourceLocation("minecraft", "block/polished_diorite"));
        this.addStoneWallModels(AdditionalBlocks.polished_granite_wall, new ResourceLocation("minecraft", "block/polished_granite"));
        this.addStoneWallModels(AdditionalBlocks.andesite_bricks_wall, new ResourceLocation("abstoneedition", "andesite_bricks"));
        this.addStoneWallModels(AdditionalBlocks.diorite_bricks_wall, new ResourceLocation("abstoneedition", "diorite_bricks"));
        this.addStoneWallModels(AdditionalBlocks.granite_bricks_wall, new ResourceLocation("abstoneedition", "granite_bricks"));
        this.addStoneWallModels(AdditionalBlocks.black_marble_wall, new ResourceLocation("abstoneedition", "black_marble"));
        this.addStoneWallModels(AdditionalBlocks.black_marble_bricks_wall, new ResourceLocation("abstoneedition", "black_marble_bricks"));
        this.addStoneWallModels(AdditionalBlocks.bloodstone_wall, new ResourceLocation("abstoneedition", "bloodstone"));
        this.addStoneWallModels(AdditionalBlocks.bloodstone_bricks_wall, new ResourceLocation("abstoneedition", "bloodstone_bricks"));
        this.addStoneWallModels(AdditionalBlocks.glowstone_wall, new ResourceLocation("minecraft", "block/glowstone"));
        this.addStoneWallModels(AdditionalBlocks.glowstone_bricks_wall, new ResourceLocation("abstoneedition", "glowstone_bricks"));
        this.addStoneWallModels(AdditionalBlocks.gray_bricks_wall, new ResourceLocation("abstoneedition", "gray_bricks"));
        this.addStoneWallModels(AdditionalBlocks.limestone_wall, new ResourceLocation("abstoneedition", "limestone"));
        this.addStoneWallModels(AdditionalBlocks.limestone_bricks_wall, new ResourceLocation("abstoneedition", "limestone_bricks"));
        this.addStoneWallModels(AdditionalBlocks.marble_wall, new ResourceLocation("abstoneedition", "marble"));
        this.addStoneWallModels(AdditionalBlocks.marble_bricks_wall, new ResourceLocation("abstoneedition", "marble_bricks"));
        this.addStoneWallModels(AdditionalBlocks.smooth_black_marble_wall, new ResourceLocation("abstoneedition", "smooth_black_marble"));
        this.addStoneWallModels(AdditionalBlocks.smooth_bloodstone_wall, new ResourceLocation("abstoneedition", "smooth_bloodstone"));
        this.addStoneWallModels(AdditionalBlocks.smooth_glowstone_wall, new ResourceLocation("abstoneedition", "smooth_glowstone"));
        this.addStoneWallModels(AdditionalBlocks.smooth_limestone_wall, new ResourceLocation("abstoneedition", "smooth_limestone"));
        this.addStoneWallModels(AdditionalBlocks.smooth_marble_wall, new ResourceLocation("abstoneedition", "smooth_marble"));
        this.addStoneWallModels(AdditionalBlocks.smooth_stone_wall, new ResourceLocation("minecraft", "block/smooth_stone"));
        this.addStoneWallModels(AdditionalBlocks.smooth_stone_bricks_wall, new ResourceLocation("abstoneedition", "smooth_stone_bricks"));
        this.addStoneWallModels(AdditionalBlocks.stone_brick_block_wall, new ResourceLocation("abstoneedition", "stone_brick_block"));
        this.addStoneWallModels(AdditionalBlocks.volcanic_stone_wall, new ResourceLocation("abstoneedition", "volcanic_stone"));
        this.addStoneWallModels(AdditionalBlocks.volcanic_stone_bricks_wall, new ResourceLocation("abstoneedition", "volcanic_stone_bricks"));
        this.addStoneWallModels(AdditionalBlocks.stone_wall, new ResourceLocation("minecraft", "block/stone"));
    }

    private void addStoneWallModels(WallBlock block, ResourceLocation texture){
        this.wallBlock(block, texture);
        String name = block.getRegistryName().getPath();
        this.itemModels().wallInventory("block/" + name + "_inventory", texture);
        this.itemModels().withExistingParent("item/" + name, new ResourceLocation("abstoneedition", "block/" + name + "_inventory"));
    }
}