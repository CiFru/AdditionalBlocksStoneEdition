package com.supermartijn642.additionalblocks.stone;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGeneration {

    public static ConfiguredFeature<?, ?> ore_marble;
    public static ConfiguredFeature<?, ?> ore_limestone;
    public static ConfiguredFeature<?, ?> ore_bloodstone;
    public static ConfiguredFeature<?, ?> mud;
    public static ConfiguredFeature<?, ?> ore_volcanic_stone;
    public static ConfiguredFeature<?, ?> ore_volcanic_stone_bricks;
    public static ConfiguredFeature<?, ?> ore_black_marble;
    public static ConfiguredFeature<?, ?> ore_silver;
    public static ConfiguredFeature<?, ?> ore_copper;

    @SubscribeEvent
    public static void onFeatureRegistry(FMLCommonSetupEvent e) {
        ore_marble = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocks.marble.getDefaultState(), 25));
        ore_marble = ore_marble.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80)));

        ore_limestone = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocks.limestone.getDefaultState(), 25));
        ore_limestone = ore_limestone.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80)));

        ore_copper = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocks.copper_ore.getDefaultState(), 10));
        ore_copper = ore_copper.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64)));

        ore_silver = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocks.silver_ore.getDefaultState(), 9));
        ore_silver = ore_silver.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64)));

        ore_bloodstone = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, AdditionalBlocks.bloodstone.getDefaultState(), 25));
        ore_bloodstone = ore_bloodstone.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 5, 0, 90)));

        ore_black_marble = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, AdditionalBlocks.black_marble.getDefaultState(), 25));
        ore_black_marble = ore_black_marble.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 5, 0, 90)));

        ore_volcanic_stone_bricks = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, AdditionalBlocks.volcanic_stone_bricks.getDefaultState(), 25));
        ore_volcanic_stone_bricks = ore_volcanic_stone_bricks.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 5, 0, 90)));

        ore_volcanic_stone = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocks.volcanic_stone.getDefaultState(), 30));
        ore_volcanic_stone = ore_volcanic_stone.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 256)));

        for (Biome biome : ForgeRegistries.BIOMES.getValues())
            onBiomeLoad(biome);
    }

    public static void onBiomeLoad(Biome e) {

        // all overworld biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(e)) {
            if (!(e.getRegistryName().getNamespace().equals("minecraft") && (e.getRegistryName().getPath().equals("desert") || e.getRegistryName().getPath().equals("desert_hills") || e.getRegistryName().getPath().equals("desert_lakes")))) {
                e.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_marble);
            }
            if (e.getRegistryName().getNamespace().equals("minecraft") && (e.getRegistryName().getPath().equals("desert") || e.getRegistryName().getPath().equals("desert_hills") || e.getRegistryName().getPath().equals("desert_lakes"))) {
                e.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_limestone);
            }
            if (e.getRegistryName().getNamespace().equals("minecraft") && (e.getRegistryName().getPath().equals("snowy_mountains") || e.getRegistryName().getPath().equals("modified_gravelly_mountains") || e.getRegistryName().getPath().equals("gravelly_mountains") || e.getRegistryName().getPath().equals("stone_shore"))) {
                e.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_volcanic_stone);
            }
            e.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_copper);
            e.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_silver);
        }

        // all nether biomes
        if (e == Biomes.BASALT_DELTAS || e == Biomes.CRIMSON_FOREST || e == Biomes.NETHER_WASTES || e == Biomes.SOUL_SAND_VALLEY || e == Biomes.WARPED_FOREST) {
            System.out.println("netherbiome: " + e.getRegistryName());
            if (e.getRegistryName().getNamespace().equals("minecraft") && (e.getRegistryName().getPath().equals("soul_sand_valley") || e.getRegistryName().getPath().equals("basalt_deltas"))) {
                e.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ore_black_marble);
                e.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ore_volcanic_stone_bricks);
            }
            e.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, ore_bloodstone);
        }
        System.out.println("biome: " + e.getRegistryName());

        // all end biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(e)) {

        }
    }

}
