package com.cifru.additionalblocks.stone;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
public class WorldGeneration {

    public static void registerFeatures(){
        ConfiguredFeature<?,?> marbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.MARBLE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_marble"), marbleFeature);
        PlacedFeature marblePlacedFeature = new PlacedFeature(Holder.direct(marbleFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_marble"), marblePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.DESERT).negate()), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_marble"));

        ConfiguredFeature<?,?> limestoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.LIMESTONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_limestone"), limestoneFeature);
        PlacedFeature limestonePlacedFeature = new PlacedFeature(Holder.direct(limestoneFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_limestone"), limestonePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.DESERT)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_limestone"));

        ConfiguredFeature<?,?> silverFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.SILVER_ORE.getBlock().defaultBlockState(), 8));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_silver"), silverFeature);
        PlacedFeature silverPlacedFeature = new PlacedFeature(Holder.direct(silverFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(75))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_silver"), silverPlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_silver"));

        ConfiguredFeature<?,?> bismuthFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.BISMUTH_ORE.getBlock().defaultBlockState(), 5));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bismuth"), bismuthFeature);
        PlacedFeature bismuthPlacedFeature = new PlacedFeature(Holder.direct(bismuthFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_bismuth"), bismuthPlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_bismuth"));

        ConfiguredFeature<?,?> bloodstoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLOODSTONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bloodstone"), bloodstoneFeature);
        PlacedFeature bloodstonePlacedFeature = new PlacedFeature(Holder.direct(bloodstoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_bloodstone"), bloodstonePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_bloodstone"));

        ConfiguredFeature<?,?> blackMarbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLACK_MARBLE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_black_marble"), blackMarbleFeature);
        PlacedFeature blackMarblePlacedFeature = new PlacedFeature(Holder.direct(blackMarbleFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_black_marble"), blackMarblePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether().and(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_black_marble"));

        ConfiguredFeature<?,?> volcanicStoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.VOLCANIC_STONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone"), volcanicStoneFeature);
        PlacedFeature volcanicStonePlacedFeature = new PlacedFeature(Holder.direct(volcanicStoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone"), volcanicStonePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.MOUNTAIN_PEAK).or(BiomeSelectors.tag(ConventionalBiomeTags.MOUNTAIN))), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_volcanic_stone"));

        ConfiguredFeature<?,?> volcanicStoneBricksFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS.getBlock().defaultBlockState(), 30));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"), volcanicStoneBricksFeature);
        PlacedFeature volcanicStoneBricksPlacedFeature = new PlacedFeature(Holder.direct(volcanicStoneBricksFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"), volcanicStoneBricksPlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether().and(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_volcanic_stone_bricks"));
    }

    private static ResourceKey<PlacedFeature> key(String identifier){
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation("abstoneedition", identifier));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_){
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_){
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_){
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
