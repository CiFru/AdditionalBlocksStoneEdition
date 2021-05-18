package com.supermartijn642.additionalblocks.stone;

import com.supermartijn642.additionalblocks.stone.ToolItemClasses.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("abstoneedition")
public class AdditionalBlocks {

    public static final IRecipeSerializer<ShapedRecipe> SHAPED_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapedSerializer();
    public static final IRecipeSerializer<ShapelessRecipe> SHAPELESS_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapelessSerializer();
    public static final IRecipeSerializer<FurnaceRecipe> FURNACE_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.FurnaceSerializer();
    public static final IRecipeSerializer<BlastingRecipe> BLASTING_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.BlastFurnaceSerializer();

    private static final ItemGroup ITEM_GROUP = new AbItemGroup();

    private static final List<Block> blocks = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();

    public static BasicBlock marble;
    public static BasicBlock smooth_marble;
    public static BasicBlock stone_brick_block;
    public static BasicBlock marble_bricks;
    public static BasicBlock diorite_bricks;
    public static BasicBlock andesite_bricks;
    public static BasicBlock granite_bricks;
    public static BasicBlock water_stone;
    public static BasicBlock marble_pillar;
    public static BasicBlock bloodstone;
    public static BasicBlock smooth_bloodstone;
    public static BasicBlock bloodstone_bricks;
    public static BasicBlock black_marble;
    public static BasicBlock smooth_black_marble;
    public static BasicBlock black_marble_bricks;
    public static BasicBlock mud;
    public static BasicBlock brown_bricks;
    public static BasicBlock volcanic_stone;
    public static BasicBlock volcanic_stone_bricks;
    public static BasicBlock gray_bricks;
    public static BasicBlock stone_path_curved;
    public static BasicBlock stone_path_straight;
    public static BasicBlock stone_pattern;
    public static BasicBlock asphalt;
    public static BasicBlock limestone;
    public static BasicBlock smooth_limestone;
    public static BasicBlock limestone_bricks;
    public static BasicBlock pebbles;
    public static BasicBlock charred_log;
    public static BasicBlock charred_wood;
    public static BasicBlock charred_planks;
    public static BasicBlock watery_pebbles;
    public static Block marble_stairs;
    public static Block andesite_bricks_stairs;
    public static Block black_marble_stairs;
    public static Block black_marble_bricks_stairs;
    public static Block bloodstone_stairs;
    public static Block bloodstone_bricks_stairs;
    public static Block brown_bricks_stairs;
    public static Block diorite_bricks_stairs;
    public static Block granite_bricks_stairs;
    public static Block marble_bricks_stairs;
    public static Block smooth_black_marble_stairs;
    public static Block smooth_bloodstone_stairs;
    public static Block smooth_marble_stairs;
    public static Block stone_brick_block_stairs;
    public static Block volcanic_stone_stairs;
    public static Block volcanic_stone_bricks_stairs;
    public static Block marble_slab;
    public static Block andesite_bricks_slab;
    public static Block black_marble_slab;
    public static Block black_marble_bricks_slab;
    public static Block bloodstone_slab;
    public static Block bloodstone_bricks_slab;
    public static Block brown_bricks_slab;
    public static Block diorite_bricks_slab;
    public static Block granite_bricks_slab;
    public static Block marble_bricks_slab;
    public static Block smooth_black_marble_slab;
    public static Block smooth_bloodstone_slab;
    public static Block smooth_marble_slab;
    public static Block stone_brick_block_slab;
    public static Block volcanic_stone_slab;
    public static Block volcanic_stone_bricks_slab;
    public static Block charred_stairs;
    public static Block charred_slab;
    public static Block gray_bricks_stairs;
    public static Block gray_bricks_slab;
    public static Block limestone_slab;
    public static Block limestone_stairs;
    public static Block asphalt_slab;
    public static Block asphalt_stairs;
    public static Block stone_tiles;
    public static Block brown_stone_path_straight;
    public static Block brown_stone_path_curved;
    public static Block brown_stone_pattern;
    public static Block brown_stone_tiles;
    public static BasicBlock smooth_glowstone;
    public static Block smooth_glowstone_stairs;
    public static Block smooth_glowstone_slab;
    public static Block glowstone_stairs;
    public static Block glowstone_slab;
    public static BasicBlock glowstone_bricks;
    public static Block glowstone_bricks_stairs;
    public static Block glowstone_bricks_slab;
    public static Block silver_ore;
    public static Block copper_ore;
    public static BasicBlock silver_block;
    public static BasicBlock copper_block;

    public AdditionalBlocks() {
        AdditionalBlocksConfig.create();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {

            marble = registerBlock(e, new BasicBlock("marble",AdditionalBlocksConfig.enableMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            marble_stairs = registerBlock(e, new StairBlock(marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            marble_slab = registerBlock(e, new SlabBlock(marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_marble = registerBlock(e, new BasicBlock("smooth_marble",AdditionalBlocksConfig.enableMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            stone_brick_block = registerBlock(e, new BasicBlock("stone_brick_block",AdditionalBlocksConfig.enableStoneBrickBlock, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(1.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            marble_bricks = registerBlock(e, new BasicBlock("marble_bricks",AdditionalBlocksConfig.enableMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            diorite_bricks = registerBlock(e, new BasicBlock("diorite_bricks",AdditionalBlocksConfig.enableDioriteBricks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE).hardnessAndResistance(1.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            andesite_bricks = registerBlock(e, new BasicBlock("andesite_bricks",AdditionalBlocksConfig.enableAndesiteBricks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(1.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            granite_bricks = registerBlock(e, new BasicBlock("granite_bricks",AdditionalBlocksConfig.enableGraniteBricks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(1.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            water_stone = registerBlock(e, new BasicBlock("water_stone",AdditionalBlocksConfig.enableWaterStone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.5f,0.5f).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            marble_pillar = registerBlock(e, new AxisRotationBlock("marble_pillar",AdditionalBlocksConfig.enableMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            bloodstone = registerBlock(e, new BasicBlock("bloodstone",AdditionalBlocksConfig.enableBloodstone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            smooth_bloodstone = registerBlock(e, new BasicBlock("smooth_bloodstone",AdditionalBlocksConfig.enableBloodstone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            bloodstone_bricks = registerBlock(e, new BasicBlock("bloodstone_bricks",AdditionalBlocksConfig.enableBloodstone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            black_marble = registerBlock(e, new BasicBlock("black_marble",AdditionalBlocksConfig.enableBlackMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_black_marble = registerBlock(e, new BasicBlock("smooth_black_marble",AdditionalBlocksConfig.enableBlackMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            black_marble_bricks = registerBlock(e, new BasicBlock("black_marble_bricks",AdditionalBlocksConfig.enableBlackMarble, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            mud = registerBlock(e, new BasicBlock("mud",AdditionalBlocksConfig.enableMud, AbstractBlock.Properties.create(Material.EARTH, MaterialColor.BROWN).sound(SoundType.WET_GRASS).hardnessAndResistance(0.5F).harvestTool(ToolType.SHOVEL)));
            brown_bricks = registerBlock(e, new BasicBlock("brown_bricks",AdditionalBlocksConfig.enableBrownBricks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone = registerBlock(e, new BasicBlock("volcanic_stone",AdditionalBlocksConfig.enableVolcanicStone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone_bricks = registerBlock(e, new BasicBlock("volcanic_stone_bricks",AdditionalBlocksConfig.enableVolcanicStone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            andesite_bricks_stairs = registerBlock(e, new StairBlock(andesite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            black_marble_stairs = registerBlock(e, new StairBlock(black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            black_marble_bricks_stairs = registerBlock(e, new StairBlock(black_marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            bloodstone_stairs = registerBlock(e, new StairBlock(bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            bloodstone_bricks_stairs = registerBlock(e, new StairBlock(bloodstone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            brown_bricks_stairs = registerBlock(e, new StairBlock(brown_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            diorite_bricks_stairs = registerBlock(e, new StairBlock(diorite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE).hardnessAndResistance(1.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            granite_bricks_stairs = registerBlock(e, new StairBlock(granite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            marble_bricks_stairs = registerBlock(e, new StairBlock(marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_black_marble_stairs = registerBlock(e, new StairBlock(smooth_black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_bloodstone_stairs = registerBlock(e, new StairBlock(smooth_bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            smooth_marble_stairs = registerBlock(e, new StairBlock(smooth_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            stone_brick_block_stairs = registerBlock(e, new StairBlock(stone_brick_block,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone_stairs = registerBlock(e, new StairBlock(volcanic_stone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone_bricks_stairs = registerBlock(e, new StairBlock(volcanic_stone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            andesite_bricks_slab = registerBlock(e, new SlabBlock(andesite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            black_marble_slab = registerBlock(e, new SlabBlock(black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            black_marble_bricks_slab = registerBlock(e, new SlabBlock(black_marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            bloodstone_slab = registerBlock(e, new SlabBlock(bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            bloodstone_bricks_slab = registerBlock(e, new SlabBlock(bloodstone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            brown_bricks_slab = registerBlock(e, new SlabBlock(brown_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            diorite_bricks_slab = registerBlock(e, new SlabBlock(diorite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            granite_bricks_slab = registerBlock(e, new SlabBlock(granite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            marble_bricks_slab = registerBlock(e, new SlabBlock(marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_black_marble_slab = registerBlock(e, new SlabBlock(smooth_black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_bloodstone_slab = registerBlock(e, new SlabBlock(smooth_bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE).hardnessAndResistance(3,8).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            smooth_marble_slab = registerBlock(e, new SlabBlock(smooth_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            stone_brick_block_slab = registerBlock(e, new SlabBlock(stone_brick_block,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone_slab = registerBlock(e, new SlabBlock(volcanic_stone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            volcanic_stone_bricks_slab = registerBlock(e, new SlabBlock(volcanic_stone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            stone_path_straight = registerBlock(e, new HorizontalRotationBlock("stone_path_straight", AdditionalBlocksConfig.enableStonePath, true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            stone_path_curved = registerBlock(e, new HorizontalRotationBlock("stone_path_curved", AdditionalBlocksConfig.enableStonePath,true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            stone_pattern = registerBlock(e, new BasicBlock("stone_pattern",AdditionalBlocksConfig.enableStonePattern, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            limestone = registerBlock(e, new BasicBlock("limestone",AdditionalBlocksConfig.enableLimestone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.NETHER_BRICK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            smooth_limestone = registerBlock(e, new BasicBlock("smooth_limestone",AdditionalBlocksConfig.enableLimestone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.NETHER_BRICK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            limestone_bricks = registerBlock(e, new BasicBlock("limestone_bricks",AdditionalBlocksConfig.enableLimestone, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.NETHER_BRICK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            asphalt = registerBlock(e, new BasicBlock("asphalt",AdditionalBlocksConfig.enableAsphalt, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            pebbles = registerBlock(e, new BasicBlock("pebbles",AdditionalBlocksConfig.enablePebbles, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE).hardnessAndResistance(2.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            charred_log = registerBlock(e, new AxisRotationBlock("charred_log",AdditionalBlocksConfig.enableAsphalt, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            charred_wood = registerBlock(e, new BasicBlock("charred_wood",AdditionalBlocksConfig.enableCharredBlocks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            charred_planks = registerBlock(e, new BasicBlock("charred_planks",AdditionalBlocksConfig.enableCharredBlocks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            charred_slab = registerBlock(e, new SlabBlock(charred_planks, "charred_slab",AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            charred_stairs = registerBlock(e, new StairBlock(charred_planks, "charred_stairs",AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.8f,0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            watery_pebbles = registerBlock(e, new BasicBlock("watery_pebbles",AdditionalBlocksConfig.enablePebbles, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(0.5f,0.5f).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            gray_bricks = registerBlock(e, new BasicBlock("gray_bricks",AdditionalBlocksConfig.enableGrayBricks, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            gray_bricks_stairs = registerBlock(e, new StairBlock(gray_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            gray_bricks_slab = registerBlock(e, new SlabBlock(gray_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            limestone_slab = registerBlock(e, new SlabBlock(limestone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.NETHER_BRICK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            limestone_stairs = registerBlock(e, new StairBlock(limestone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.YELLOW).sound(SoundType.NETHER_BRICK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).setRequiresTool()));
            asphalt_slab = registerBlock(e, new SlabBlock(asphalt,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.5f,6).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            asphalt_stairs = registerBlock(e, new StairBlock(asphalt,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.5F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
            stone_tiles = registerBlock(e, new BasicBlock("stone_tiles",AdditionalBlocksConfig.enableStoneTiles, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            brown_stone_path_curved = registerBlock(e, new HorizontalRotationBlock("brown_stone_path_curved", AdditionalBlocksConfig.enableStonePath, true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            brown_stone_path_straight = registerBlock(e, new HorizontalRotationBlock("brown_stone_path_straight", AdditionalBlocksConfig.enableStonePath, true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            brown_stone_pattern = registerBlock(e, new BasicBlock("brown_stone_pattern",AdditionalBlocksConfig.enableStonePattern, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            brown_stone_tiles = registerBlock(e, new BasicBlock("brown_stone_tiles",AdditionalBlocksConfig.enableStoneTiles, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.NETHER_BRICK).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
            smooth_glowstone = registerBlock(e, new BasicBlock("smooth_glowstone",AdditionalBlocksConfig.enableSmoothGlowstone, AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.2f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            smooth_glowstone_stairs = registerBlock(e, new StairBlock(smooth_glowstone,AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.2f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            smooth_glowstone_slab = registerBlock(e, new SlabBlock(smooth_glowstone,AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.2f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            glowstone_bricks = registerBlock(e, new BasicBlock("glowstone_bricks",AdditionalBlocksConfig.enableGlowstoneBricks, AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.4f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            glowstone_bricks_stairs = registerBlock(e, new StairBlock(glowstone_bricks,AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.4f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            glowstone_bricks_slab = registerBlock(e, new SlabBlock(glowstone_bricks,AbstractBlock.Properties.create(Material.GLASS, MaterialColor.YELLOW).sound(SoundType.GLASS).hardnessAndResistance(0.4f, 0.8f).harvestTool(ToolType.PICKAXE).harvestLevel(0).setLightLevel(state -> 15)));
            copper_ore = registerBlock(e, new OorBlock("copper_ore", AdditionalBlocksConfig.enableCopper, AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)));
            silver_ore = registerBlock(e, new OorBlock("silver_ore", AdditionalBlocksConfig.enableSilver, AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)));
            copper_block = registerBlock(e, new BasicBlock("copper_block",AdditionalBlocksConfig.enableCopper, AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.METAL)));
            silver_block = registerBlock(e, new BasicBlock("silver_block",AdditionalBlocksConfig.enableSilver, AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.METAL)));
        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            for (Block block : blocks)
                registerItem(e, new BlockItem(block, new Item.Properties().group(ITEM_GROUP)).setRegistryName(block.getRegistryName()));
            e.getRegistry().register(new OreItem("copper_ingot", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP)));
            e.getRegistry().register(new OreItem("silver_ingot", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP)));
            e.getRegistry().register(new OreItem("copper_nugget", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP)));
            e.getRegistry().register(new OreItem("silver_nugget", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP)));
            e.getRegistry().register(new BijlItem("copper_axe", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP), 6.0F, -2.5F));
            e.getRegistry().register(new BijlItem("silver_axe", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP), 6.0F, -2.5F));
            e.getRegistry().register(new HouweelItem("copper_pickaxe", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP), 1, -1.8F));
            e.getRegistry().register(new HouweelItem("silver_pickaxe", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP), 1, -1.8F));
            e.getRegistry().register(new SchepItem("copper_shovel", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP), 1.5F, -3.0F));
            e.getRegistry().register(new SchepItem("silver_shovel", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP), 1.5F, -3.0F));
            e.getRegistry().register(new SchoffelItem("copper_hoe", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP), -2, 0.0F));
            e.getRegistry().register(new SchoffelItem("silver_hoe", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP), -2, 0.0F));
            e.getRegistry().register(new ZwaardItem("copper_sword", AdditionalBlocksConfig.enableCopper, new Item.Properties().group(ITEM_GROUP), 3, -2.4F));
            e.getRegistry().register(new ZwaardItem("silver_sword", AdditionalBlocksConfig.enableSilver, new Item.Properties().group(ITEM_GROUP), 3, -2.4F));
        }

        @SubscribeEvent
        public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> e){
            e.getRegistry().register(SHAPED_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abstoneedition", "shaped")));
            e.getRegistry().register(SHAPELESS_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abstoneedition", "shapeless")));
            e.getRegistry().register(FURNACE_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abstoneedition", "furnace")));
            e.getRegistry().register(BLASTING_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abstoneedition", "blastfurnace")));
        }
    }

    public static <T extends Block> T registerBlock(RegistryEvent.Register<Block> e, T block) {
        e.getRegistry().register(block);
        blocks.add(block);
        return block;
    }

    public static <T extends Item> T registerItem(RegistryEvent.Register<Item> e, T item) {
        e.getRegistry().register(item);
        items.add(item);
        return item;
    }

}
