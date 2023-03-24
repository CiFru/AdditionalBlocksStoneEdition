package com.supermartijn642.additionalblocks.stone;

import com.supermartijn642.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldGeneration {

    public static void onFeatureRegistry(final IForgeRegistry<Feature<?>> registry) {
        ConfiguredFeature<?, ?> marbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.MARBLE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_marble"), marbleFeature);
        PlacedFeature marblePlacedFeature = new PlacedFeature(Holder.direct(marbleFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_marble"), marblePlacedFeature);

        ConfiguredFeature<?, ?> limestoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.LIMESTONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_limestone"), limestoneFeature);
        PlacedFeature limestonePlacedFeature = new PlacedFeature(Holder.direct(limestoneFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_limestone"), limestonePlacedFeature);

        ConfiguredFeature<?, ?> silverFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.SILVER_ORE.getBlock().defaultBlockState(), 8));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_silver"), silverFeature);
        PlacedFeature silverPlacedFeature = new PlacedFeature(Holder.direct(silverFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(75))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_silver"), silverPlacedFeature);

        ConfiguredFeature<?, ?> bismuthFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.BISMUTH_ORE.getBlock().defaultBlockState(), 5));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bismuth"), bismuthFeature);
        PlacedFeature bismuthPlacedFeature = new PlacedFeature(Holder.direct(bismuthFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_bismuth"), bismuthPlacedFeature);

        ConfiguredFeature<?, ?> bloodstoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLOODSTONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bloodstone"), bloodstoneFeature);
        PlacedFeature bloodstonePlacedFeature = new PlacedFeature(Holder.direct(bloodstoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_bloodstone"), bloodstonePlacedFeature);

        ConfiguredFeature<?, ?> blackMarbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLACK_MARBLE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_black_marble"), blackMarbleFeature);
        PlacedFeature blackMarblePlacedFeature = new PlacedFeature(Holder.direct(blackMarbleFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_black_marble"), blackMarblePlacedFeature);

        ConfiguredFeature<?, ?> volcanicStoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocksBlocks.VOLCANIC_STONE.getBlock().defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone"), volcanicStoneFeature);
        PlacedFeature volcanicStonePlacedFeature = new PlacedFeature(Holder.direct(volcanicStoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone"), volcanicStonePlacedFeature);

        ConfiguredFeature<?, ?> volcanicStoneBricksFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS.getBlock().defaultBlockState(), 30));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"), volcanicStoneBricksFeature);
        PlacedFeature volcanicStoneBricksPlacedFeature = new PlacedFeature(Holder.direct(volcanicStoneBricksFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120))));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"), volcanicStoneBricksPlacedFeature);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier placementChance, PlacementModifier heightModifier) {
        return List.of(placementChance, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier heightModifier) {
        return orePlacement(CountPlacement.of(p_195344_), heightModifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), p_195351_);
    }
}
