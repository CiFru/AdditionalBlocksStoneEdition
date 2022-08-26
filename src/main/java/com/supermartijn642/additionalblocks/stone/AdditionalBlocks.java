package com.supermartijn642.additionalblocks.stone;

import com.mojang.serialization.Codec;
import com.supermartijn642.additionalblocks.stone.ToolItemClasses.*;
import com.supermartijn642.additionalblocks.stone.data.AbBlockStateProvider;
import com.supermartijn642.additionalblocks.stone.data.AbLootTableProvider;
import com.supermartijn642.additionalblocks.stone.data.AbRecipeProvider;
import com.supermartijn642.additionalblocks.stone.data.AbTagsProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("abstoneedition")
public class AdditionalBlocks {

    public static final RecipeSerializer<ShapedRecipe> SHAPED_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapedSerializer();
    public static final RecipeSerializer<ShapelessRecipe> SHAPELESS_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapelessSerializer();
    public static final RecipeSerializer<SmeltingRecipe> FURNACE_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.FurnaceSerializer();
    public static final RecipeSerializer<BlastingRecipe> BLASTING_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.BlastFurnaceSerializer();
    public static final RecipeSerializer<StonecutterRecipe> STONE_CUTTING_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.StoneCutterSerializer();


    private static final CreativeModeTab ITEM_GROUP = new AbItemGroup();

    public static final List<Block> blocks = new ArrayList<>();
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
    public static StairBlock marble_stairs;
    public static StairBlock andesite_bricks_stairs;
    public static StairBlock black_marble_stairs;
    public static StairBlock black_marble_bricks_stairs;
    public static StairBlock bloodstone_stairs;
    public static StairBlock bloodstone_bricks_stairs;
    public static StairBlock brown_bricks_stairs;
    public static StairBlock diorite_bricks_stairs;
    public static StairBlock granite_bricks_stairs;
    public static StairBlock marble_bricks_stairs;
    public static StairBlock smooth_black_marble_stairs;
    public static StairBlock smooth_bloodstone_stairs;
    public static StairBlock smooth_marble_stairs;
    public static StairBlock stone_brick_block_stairs;
    public static StairBlock volcanic_stone_stairs;
    public static StairBlock volcanic_stone_bricks_stairs;
    public static SlabBlock marble_slab;
    public static SlabBlock andesite_bricks_slab;
    public static SlabBlock black_marble_slab;
    public static SlabBlock black_marble_bricks_slab;
    public static SlabBlock bloodstone_slab;
    public static SlabBlock bloodstone_bricks_slab;
    public static SlabBlock brown_bricks_slab;
    public static SlabBlock diorite_bricks_slab;
    public static SlabBlock granite_bricks_slab;
    public static SlabBlock marble_bricks_slab;
    public static SlabBlock smooth_black_marble_slab;
    public static SlabBlock smooth_bloodstone_slab;
    public static SlabBlock smooth_marble_slab;
    public static SlabBlock stone_brick_block_slab;
    public static SlabBlock volcanic_stone_slab;
    public static SlabBlock volcanic_stone_bricks_slab;
    public static StairBlock charred_stairs;
    public static SlabBlock charred_slab;
    public static StairBlock gray_bricks_stairs;
    public static SlabBlock gray_bricks_slab;
    public static SlabBlock limestone_slab;
    public static StairBlock limestone_stairs;
    public static SlabBlock asphalt_slab;
    public static StairBlock asphalt_stairs;
    public static BasicBlock stone_tiles;
    public static BasicBlock brown_stone_path_straight;
    public static BasicBlock brown_stone_path_curved;
    public static BasicBlock brown_stone_pattern;
    public static BasicBlock brown_stone_tiles;
    public static BasicBlock smooth_glowstone;
    public static StairBlock smooth_glowstone_stairs;
    public static SlabBlock smooth_glowstone_slab;
    public static BasicBlock glowstone_bricks;
    public static StairBlock glowstone_bricks_stairs;
    public static SlabBlock glowstone_bricks_slab;
    public static Block silver_ore;
    public static BasicBlock silver_block;
    public static BasicBlock old_stone_path_straight;
    public static BasicBlock old_stone_path_curved;
    public static BasicBlock old_stone_pattern;
    public static BasicBlock old_stone_tiles;
    public static BasicBlock smooth_stone_bricks;
    public static StairBlock smooth_stone_bricks_stairs;
    public static SlabBlock smooth_stone_bricks_slab;
    public static BasicBlock aztec_pattern;
    public static BasicBlock aztec_patterned_wall;
    public static BasicBlock aztec_tiles;
    public static BasicBlock sunstone;
    public static BasicBlock aztec_pillar;
    public static BasicBlock raw_silver_block;
    public static BasicBlock smooth_smooth_stone;
    public static SlabBlock smooth_smooth_stone_slab;
    public static StairBlock smooth_smooth_stone_stairs;
    public static WallyBlock smooth_smooth_stone_wall;

    public static WallyBlock polished_andesite_wall;
    public static WallyBlock andesite_bricks_wall;
    public static WallyBlock black_marble_wall;
    public static WallyBlock black_marble_bricks_wall;
    public static WallyBlock bloodstone_wall;
    public static WallyBlock bloodstone_bricks_wall;
    public static StairBlock brown_stone_path_straight_stairs;
    public static SlabBlock brown_stone_path_straight_slab;
    public static StairBlock brown_stone_path_curved_stairs;
    public static SlabBlock brown_stone_path_curved_slab;
    public static StairBlock brown_stone_pattern_stairs;
    public static SlabBlock brown_stone_pattern_slab;
    public static StairBlock brown_stone_tiles_stairs;
    public static SlabBlock brown_stone_tiles_slab;
    public static WallyBlock polished_diorite_wall;
    public static WallyBlock diorite_bricks_wall;
    public static StairBlock glowstone_stairs;
    public static SlabBlock glowstone_slab;
    public static WallyBlock glowstone_wall;
    public static WallyBlock glowstone_bricks_wall;
    public static WallyBlock polished_granite_wall;
    public static WallyBlock granite_bricks_wall;
    public static WallyBlock gray_bricks_wall;
    public static WallyBlock limestone_wall;
    public static SlabBlock limestone_bricks_slab;
    public static StairBlock limestone_bricks_stairs;
    public static WallyBlock limestone_bricks_wall;
    public static WallyBlock marble_wall;
    public static WallyBlock marble_bricks_wall;
    public static WallyBlock smooth_black_marble_wall;
    public static WallyBlock smooth_bloodstone_wall;
    public static WallyBlock smooth_glowstone_wall;
    public static StairBlock smooth_limestone_stairs;
    public static SlabBlock smooth_limestone_slab;
    public static WallyBlock smooth_limestone_wall;
    public static WallyBlock smooth_marble_wall;
    public static StairBlock smooth_stone_stairs;
    public static WallyBlock smooth_stone_wall;
    public static WallyBlock smooth_stone_bricks_wall;
    public static WallyBlock stone_brick_block_wall;
    public static StairBlock old_stone_path_straight_stairs;
    public static SlabBlock old_stone_path_straight_slab;
    public static StairBlock old_stone_path_curved_stairs;
    public static SlabBlock old_stone_path_curved_slab;
    public static StairBlock old_stone_pattern_stairs;
    public static SlabBlock old_stone_pattern_slab;
    public static StairBlock old_stone_tiles_stairs;
    public static SlabBlock old_stone_tiles_slab;
    public static StairBlock stone_path_straight_stairs;
    public static SlabBlock stone_path_straight_slab;
    public static StairBlock stone_path_curved_stairs;
    public static SlabBlock stone_path_curved_slab;
    public static StairBlock stone_pattern_stairs;
    public static SlabBlock stone_pattern_slab;
    public static StairBlock stone_tiles_stairs;
    public static SlabBlock stone_tiles_slab;
    public static WallyBlock volcanic_stone_wall;
    public static WallyBlock volcanic_stone_bricks_wall;
    public static WallyBlock stone_wall;

    public static Block bismuth_ore;
    public static BasicBlock bismuth_cluster;
    public static BasicBlock bismuth_block;



    public AdditionalBlocks() {
        AdditionalBlocksConfig.create();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onRegistryEvent(RegisterEvent e) {
            if (e.getRegistryKey() == ForgeRegistries.Keys.BLOCKS)
                onBlockRegistry(e.getForgeRegistry());
            else if (e.getRegistryKey() == ForgeRegistries.Keys.ITEMS)
                onItemRegistry(e.getForgeRegistry());
            else if (e.getRegistryKey() == ForgeRegistries.Keys.FEATURES)
                onFeatureRegistry(e.getForgeRegistry());
            else if (e.getRegistryKey() == ForgeRegistries.Keys.RECIPE_SERIALIZERS)
                onRecipeRegistry(e.getForgeRegistry());
            else if (e.getRegistryKey() == ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS)
                onBiomeModifierRegistry(e.getForgeRegistry());
        }

        public static void onBlockRegistry(final IForgeRegistry<Block> e) {

            marble = registerBlock(e, new BasicBlock("marble", AdditionalBlocksConfig.enableMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_stairs = registerBlock(e, new StairBlock(marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_slab = registerBlock(e, new SlabBlock(marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_marble = registerBlock(e, new BasicBlock("smooth_marble", AdditionalBlocksConfig.enableMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            stone_brick_block = registerBlock(e, new BasicBlock("stone_brick_block", AdditionalBlocksConfig.enableStoneBrickBlock, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            marble_bricks = registerBlock(e, new BasicBlock("marble_bricks", AdditionalBlocksConfig.enableMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            diorite_bricks = registerBlock(e, new BasicBlock("diorite_bricks", AdditionalBlocksConfig.enableDioriteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            andesite_bricks = registerBlock(e, new BasicBlock("andesite_bricks", AdditionalBlocksConfig.enableAndesiteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            granite_bricks = registerBlock(e, new BasicBlock("granite_bricks", AdditionalBlocksConfig.enableGraniteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            water_stone = registerBlock(e, new BasicBlock("water_stone", AdditionalBlocksConfig.enableWaterStone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.5f, 0.5f), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            marble_pillar = registerBlock(e, new AxisRotationBlock("marble_pillar", AdditionalBlocksConfig.enableMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            bloodstone = registerBlock(e, new BasicBlock("bloodstone", AdditionalBlocksConfig.enableBloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            smooth_bloodstone = registerBlock(e, new BasicBlock("smooth_bloodstone", AdditionalBlocksConfig.enableBloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            bloodstone_bricks = registerBlock(e, new BasicBlock("bloodstone_bricks", AdditionalBlocksConfig.enableBloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            black_marble = registerBlock(e, new BasicBlock("black_marble", AdditionalBlocksConfig.enableBlackMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_black_marble = registerBlock(e, new BasicBlock("smooth_black_marble", AdditionalBlocksConfig.enableBlackMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_bricks = registerBlock(e, new BasicBlock("black_marble_bricks", AdditionalBlocksConfig.enableBlackMarble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            mud = registerBlock(e, new BasicBlock("mud", AdditionalBlocksConfig.enableMud, BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN).sound(SoundType.WET_GRASS).strength(0.5F), IHarvestableBlock.ToolType.SHOVEL, IHarvestableBlock.ToolTier.STONE));
            brown_bricks = registerBlock(e, new BasicBlock("brown_bricks", AdditionalBlocksConfig.enableBrownBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone = registerBlock(e, new BasicBlock("volcanic_stone", AdditionalBlocksConfig.enableVolcanicStone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_bricks = registerBlock(e, new BasicBlock("volcanic_stone_bricks", AdditionalBlocksConfig.enableVolcanicStone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            andesite_bricks_stairs = registerBlock(e, new StairBlock(andesite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_stairs = registerBlock(e, new StairBlock(black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_bricks_stairs = registerBlock(e, new StairBlock(black_marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            bloodstone_stairs = registerBlock(e, new StairBlock(bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            bloodstone_bricks_stairs = registerBlock(e, new StairBlock(bloodstone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            brown_bricks_stairs = registerBlock(e, new StairBlock(brown_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            diorite_bricks_stairs = registerBlock(e, new StairBlock(diorite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            granite_bricks_stairs = registerBlock(e, new StairBlock(granite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_bricks_stairs = registerBlock(e, new StairBlock(marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_black_marble_stairs = registerBlock(e, new StairBlock(smooth_black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_bloodstone_stairs = registerBlock(e, new StairBlock(smooth_bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            smooth_marble_stairs = registerBlock(e, new StairBlock(smooth_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            stone_brick_block_stairs = registerBlock(e, new StairBlock(stone_brick_block, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_stairs = registerBlock(e, new StairBlock(volcanic_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_bricks_stairs = registerBlock(e, new StairBlock(volcanic_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            andesite_bricks_slab = registerBlock(e, new SlabBlock(andesite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_slab = registerBlock(e, new SlabBlock(black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_bricks_slab = registerBlock(e, new SlabBlock(black_marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            bloodstone_slab = registerBlock(e, new SlabBlock(bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            bloodstone_bricks_slab = registerBlock(e, new SlabBlock(bloodstone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            brown_bricks_slab = registerBlock(e, new SlabBlock(brown_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            diorite_bricks_slab = registerBlock(e, new SlabBlock(diorite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            granite_bricks_slab = registerBlock(e, new SlabBlock(granite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_bricks_slab = registerBlock(e, new SlabBlock(marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_black_marble_slab = registerBlock(e, new SlabBlock(smooth_black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_bloodstone_slab = registerBlock(e, new SlabBlock(smooth_bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            smooth_marble_slab = registerBlock(e, new SlabBlock(smooth_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            stone_brick_block_slab = registerBlock(e, new SlabBlock(stone_brick_block, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_slab = registerBlock(e, new SlabBlock(volcanic_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_bricks_slab = registerBlock(e, new SlabBlock(volcanic_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_straight = registerBlock(e, new HorizontalRotationBlock("stone_path_straight", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_curved = registerBlock(e, new HorizontalRotationBlock("stone_path_curved", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_pattern = registerBlock(e, new BasicBlock("stone_pattern", AdditionalBlocksConfig.enableStonePattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            limestone = registerBlock(e, new BasicBlock("limestone", AdditionalBlocksConfig.enableLimestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_limestone = registerBlock(e, new BasicBlock("smooth_limestone", AdditionalBlocksConfig.enableLimestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            limestone_bricks = registerBlock(e, new BasicBlock("limestone_bricks", AdditionalBlocksConfig.enableLimestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            asphalt = registerBlock(e, new BasicBlock("asphalt", AdditionalBlocksConfig.enableAsphalt, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.5f, 6), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            pebbles = registerBlock(e, new BasicBlock("pebbles", AdditionalBlocksConfig.enablePebbles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            charred_log = registerBlock(e, new AxisRotationBlock("charred_log", AdditionalBlocksConfig.enableAsphalt, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            charred_wood = registerBlock(e, new BasicBlock("charred_wood", AdditionalBlocksConfig.enableCharredBlocks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            charred_planks = registerBlock(e, new BasicBlock("charred_planks", AdditionalBlocksConfig.enableCharredBlocks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            charred_slab = registerBlock(e, new SlabBlock(charred_planks, "charred_slab", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            charred_stairs = registerBlock(e, new StairBlock(charred_planks, "charred_stairs", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            watery_pebbles = registerBlock(e, new BasicBlock("watery_pebbles", AdditionalBlocksConfig.enablePebbles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.5f, 0.5f), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            gray_bricks = registerBlock(e, new BasicBlock("gray_bricks", AdditionalBlocksConfig.enableGrayBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            gray_bricks_stairs = registerBlock(e, new StairBlock(gray_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            gray_bricks_slab = registerBlock(e, new SlabBlock(gray_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            limestone_slab = registerBlock(e, new SlabBlock(limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            limestone_stairs = registerBlock(e, new StairBlock(limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            asphalt_slab = registerBlock(e, new SlabBlock(asphalt, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.5f, 6), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            asphalt_stairs = registerBlock(e, new StairBlock(asphalt, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            stone_tiles = registerBlock(e, new BasicBlock("stone_tiles", AdditionalBlocksConfig.enableStoneTiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_path_curved = registerBlock(e, new HorizontalRotationBlock("brown_stone_path_curved", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_path_straight = registerBlock(e, new HorizontalRotationBlock("brown_stone_path_straight", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_pattern = registerBlock(e, new BasicBlock("brown_stone_pattern", AdditionalBlocksConfig.enableStonePattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_tiles = registerBlock(e, new BasicBlock("brown_stone_tiles", AdditionalBlocksConfig.enableStoneTiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_glowstone = registerBlock(e, new BasicBlock("smooth_glowstone", AdditionalBlocksConfig.enableSmoothGlowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_glowstone_stairs = registerBlock(e, new StairBlock(smooth_glowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_glowstone_slab = registerBlock(e, new SlabBlock(smooth_glowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_bricks = registerBlock(e, new BasicBlock("glowstone_bricks", AdditionalBlocksConfig.enableGlowstoneBricks, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.4f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_bricks_stairs = registerBlock(e, new StairBlock(glowstone_bricks, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.4f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_bricks_slab = registerBlock(e, new SlabBlock(glowstone_bricks, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.4f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            silver_ore = registerBlock(e, new OorBlock("silver_ore", AdditionalBlocksConfig.enableSilver, BlockBehaviour.Properties.of(Material.STONE).strength(3.5F, 3.5F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            silver_block = registerBlock(e, new BasicBlock("silver_block", AdditionalBlocksConfig.enableSilver, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            raw_silver_block = registerBlock(e, new BasicBlock("raw_silver_block", AdditionalBlocksConfig.enableSilver, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            old_stone_path_curved = registerBlock(e, new HorizontalRotationBlock("old_stone_path_curved", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_path_straight = registerBlock(e, new HorizontalRotationBlock("old_stone_path_straight", AdditionalBlocksConfig.enableStonePath, true, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_pattern = registerBlock(e, new BasicBlock("old_stone_pattern", AdditionalBlocksConfig.enableStonePattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_tiles = registerBlock(e, new BasicBlock("old_stone_tiles", AdditionalBlocksConfig.enableStoneTiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_stone_bricks = registerBlock(e, new BasicBlock("smooth_stone_bricks", AdditionalBlocksConfig.enableSmoothStoneBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_stone_bricks_stairs = registerBlock(e, new StairBlock(smooth_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_stone_bricks_slab = registerBlock(e, new SlabBlock(smooth_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            aztec_pattern = registerBlock(e, new BasicBlock("aztec_pattern", AdditionalBlocksConfig.enableAztec, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            aztec_patterned_wall = registerBlock(e, new BasicBlock("aztec_patterned_wall", AdditionalBlocksConfig.enableAztec, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            aztec_tiles = registerBlock(e, new BasicBlock("aztec_tiles", AdditionalBlocksConfig.enableAztec, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            sunstone = registerBlock(e, new BasicBlock("sunstone", AdditionalBlocksConfig.enableAztec, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GILDED_BLACKSTONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            aztec_pillar = registerBlock(e, new AxisRotationBlock("aztec_pillar", AdditionalBlocksConfig.enableAztec, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0f, 6.0f), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));

            brown_stone_path_straight_stairs = registerBlock(e, new StairBlock(brown_stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_path_curved_stairs = registerBlock(e, new StairBlock(brown_stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_pattern_stairs = registerBlock(e, new StairBlock(brown_stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_tiles_stairs = registerBlock(e, new StairBlock(brown_stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_path_straight_stairs = registerBlock(e, new StairBlock(old_stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_path_curved_stairs = registerBlock(e, new StairBlock(old_stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_pattern_stairs = registerBlock(e, new StairBlock(old_stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_tiles_stairs = registerBlock(e, new StairBlock(old_stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_straight_stairs = registerBlock(e, new StairBlock(stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_curved_stairs = registerBlock(e, new StairBlock(stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_pattern_stairs = registerBlock(e, new StairBlock(stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_tiles_stairs = registerBlock(e, new StairBlock(stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_stairs = registerBlock(e, new StairBlock(Blocks.GLOWSTONE, AdditionalBlocksConfig.enableGlowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_stone_stairs = registerBlock(e, new StairBlock(Blocks.SMOOTH_STONE, AdditionalBlocksConfig.enableSmoothStoneBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            limestone_bricks_stairs = registerBlock(e, new StairBlock(limestone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_limestone_stairs = registerBlock(e, new StairBlock(smooth_limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            brown_stone_path_straight_slab = registerBlock(e, new SlabBlock(brown_stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_path_curved_slab = registerBlock(e, new SlabBlock(brown_stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_pattern_slab = registerBlock(e, new SlabBlock(brown_stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            brown_stone_tiles_slab = registerBlock(e, new SlabBlock(brown_stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_path_straight_slab = registerBlock(e, new SlabBlock(old_stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_path_curved_slab = registerBlock(e, new SlabBlock(old_stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_pattern_slab = registerBlock(e, new SlabBlock(old_stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            old_stone_tiles_slab = registerBlock(e, new SlabBlock(old_stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_straight_slab = registerBlock(e, new SlabBlock(stone_path_straight, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_path_curved_slab = registerBlock(e, new SlabBlock(stone_path_curved, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_pattern_slab = registerBlock(e, new SlabBlock(stone_pattern, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_tiles_slab = registerBlock(e, new SlabBlock(stone_tiles, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_slab = registerBlock(e, new SlabBlock(Blocks.GLOWSTONE, AdditionalBlocksConfig.enableGlowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            limestone_bricks_slab = registerBlock(e, new SlabBlock(limestone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_limestone_slab = registerBlock(e, new SlabBlock(smooth_limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_smooth_stone = registerBlock(e, new BasicBlock("smooth_smooth_stone", AdditionalBlocksConfig.enableSmoothStone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_smooth_stone_slab = registerBlock(e, new SlabBlock(smooth_smooth_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_smooth_stone_stairs = registerBlock(e, new StairBlock(smooth_smooth_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_smooth_stone_wall = registerBlock(e, new WallyBlock(smooth_smooth_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));

            polished_andesite_wall = registerBlock(e, new WallyBlock(Blocks.POLISHED_ANDESITE, AdditionalBlocksConfig.enableAndesiteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            andesite_bricks_wall = registerBlock(e, new WallyBlock(andesite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_wall = registerBlock(e, new WallyBlock(black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            black_marble_bricks_wall = registerBlock(e, new WallyBlock(black_marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            bloodstone_wall = registerBlock(e, new WallyBlock(bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            bloodstone_bricks_wall = registerBlock(e, new WallyBlock(bloodstone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            polished_diorite_wall = registerBlock(e, new WallyBlock(Blocks.POLISHED_DIORITE, AdditionalBlocksConfig.enableDioriteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            diorite_bricks_wall = registerBlock(e, new WallyBlock(diorite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            glowstone_wall = registerBlock(e, new WallyBlock(Blocks.GLOWSTONE, AdditionalBlocksConfig.enableGlowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            glowstone_bricks_wall = registerBlock(e, new WallyBlock(glowstone_bricks, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            polished_granite_wall = registerBlock(e, new WallyBlock(Blocks.POLISHED_GRANITE, AdditionalBlocksConfig.enableGraniteBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            granite_bricks_wall = registerBlock(e, new WallyBlock(granite_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            gray_bricks_wall = registerBlock(e, new WallyBlock(gray_bricks, AdditionalBlocksConfig.enableGrayBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            limestone_wall = registerBlock(e, new WallyBlock(limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            limestone_bricks_wall = registerBlock(e, new WallyBlock(limestone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_wall = registerBlock(e, new WallyBlock(marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            marble_bricks_wall = registerBlock(e, new WallyBlock(marble_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_black_marble_wall = registerBlock(e, new WallyBlock(smooth_black_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_bloodstone_wall = registerBlock(e, new WallyBlock(smooth_bloodstone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3, 8), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.IRON));
            smooth_glowstone_wall = registerBlock(e, new WallyBlock(smooth_glowstone, BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(0.2f, 0.8f).lightLevel(state -> 15), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_limestone_wall = registerBlock(e, new WallyBlock(smooth_limestone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).strength(1.5F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_marble_wall = registerBlock(e, new WallyBlock(smooth_marble, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(0.8f, 0.8f), IHarvestableBlock.ToolType.PICKAXE, null));
            smooth_stone_wall = registerBlock(e, new WallyBlock(Blocks.SMOOTH_STONE, AdditionalBlocksConfig.enableSmoothStoneBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            smooth_stone_bricks_wall = registerBlock(e, new WallyBlock(smooth_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_brick_block_wall = registerBlock(e, new WallyBlock(stone_brick_block, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_wall = registerBlock(e, new WallyBlock(volcanic_stone, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            volcanic_stone_bricks_wall = registerBlock(e, new WallyBlock(volcanic_stone_bricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));
            stone_wall = registerBlock(e, new WallyBlock(Blocks.STONE, AdditionalBlocksConfig.enableSmoothStoneBricks, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0F, 6.0F), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.STONE));

            bismuth_ore = registerBlock(e, new OorBlock("bismuth_ore", AdditionalBlocksConfig.enableBismuth, BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 4.5F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.DIAMOND));
            bismuth_cluster = registerBlock(e, new BasicBlock("bismuth_cluster", AdditionalBlocksConfig.enableBismuth, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(6.0F, 7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.DIAMOND));
            bismuth_block = registerBlock(e, new BasicBlock("bismuth_block", AdditionalBlocksConfig.enableBismuth, BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(6.0F, 7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL), IHarvestableBlock.ToolType.PICKAXE, IHarvestableBlock.ToolTier.DIAMOND));

        }

        public static void onItemRegistry(final IForgeRegistry<Item> registry) {
            for (Block block : blocks)
                registerItem(registry, ((RegistryNameHolder) block).getRegistryName(), new BlockItem(block, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("silver_ingot", new OreItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("raw_silver", new OreItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("copper_nugget", new OreItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("silver_nugget", new OreItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("silver_axe", new BijlItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP), 6.0F, -2.5F));
            registry.register("silver_pickaxe", new HouweelItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP), 1, -1.8F));
            registry.register("silver_shovel", new SchepItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP), 1.5F, -3.0F));
            registry.register("silver_hoe", new SchoffelItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP), -2, 0.0F));
            registry.register("silver_sword", new ZwaardItem(AdditionalBlocksConfig.enableSilver, new Item.Properties().tab(ITEM_GROUP), 3, -2.4F));

            registry.register("copper_axe", new BijlItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP), 6.0F, -2.5F));
            registry.register("copper_pickaxe", new HouweelItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP), 1, -1.8F));
            registry.register("copper_shovel", new SchepItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP), 1.5F, -3.0F));
            registry.register("copper_hoe", new SchoffelItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP), -2, 0.0F));
            registry.register("copper_sword", new ZwaardItem(AdditionalBlocksConfig.enableCopper, new Item.Properties().tab(ITEM_GROUP), 3, -2.4F));

            registry.register("bismuth_ingot", new OreItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("raw_bismuth_chunk", new OreItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("bismuth_nugget", new OreItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP)));
            registry.register("bismuth_axe", new BijlItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP), 8.0F, -3.5F));
            registry.register("bismuth_pickaxe", new HouweelItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP), 2, -2.5F));
            registry.register("bismuth_shovel", new SchepItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP), 2.5F, -4.0F));
            registry.register("bismuth_hoe", new SchoffelItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP), -1, 1.0F));
            registry.register("bismuth_sword", new ZwaardItem(AdditionalBlocksConfig.enableBismuth, new Item.Properties().tab(ITEM_GROUP), 6, -3.0F));
        }

        public static void onFeatureRegistry(final IForgeRegistry<Feature<?>> registry) {
            WorldGeneration.onFeatureRegistry(registry);
        }

        public static void onRecipeRegistry(final IForgeRegistry<RecipeSerializer<?>> registry) {
            registry.register("shaped", SHAPED_RECIPE_SERIALIZER);
            registry.register("shapeless", SHAPELESS_RECIPE_SERIALIZER);
            registry.register("furnace", FURNACE_RECIPE_SERIALIZER);
            registry.register("blastfurnace", BLASTING_RECIPE_SERIALIZER);
            registry.register("stonecutting", STONE_CUTTING_RECIPE_SERIALIZER);
        }

        public static void onBiomeModifierRegistry(final IForgeRegistry<Codec<? extends BiomeModifier>> registry) {
            registry.register("all", AbBiomeModifier.ALL_BIOME_MODIFIER_CODEC);
        }

        @SubscribeEvent
        public static void onGatherData(GatherDataEvent e) {
            e.getGenerator().addProvider(e.includeClient(), new AbBlockStateProvider(e.getGenerator(), "abstoneedition", e.getExistingFileHelper()));
            e.getGenerator().addProvider(e.includeServer(), new AbTagsProvider(e.getGenerator(), "abstoneedition", e.getExistingFileHelper()));
            e.getGenerator().addProvider(e.includeServer(), new AbRecipeProvider(e.getGenerator()));
            e.getGenerator().addProvider(e.includeServer(), new AbLootTableProvider(e.getGenerator()));
        }
    }

    public static <T extends Block & RegistryNameHolder> T registerBlock(IForgeRegistry<Block> registry, T block) {
        registry.register(block.getRegistryName(), block);
        blocks.add(block);
        return block;
    }

    public static <T extends Item> T registerItem(IForgeRegistry<Item> registry, String registryName, T item) {
        registry.register(registryName, item);
        items.add(item);
        return item;
    }

}
