package com.supermartijn642.additionalblocks.stone;

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

    public static Holder<PlacedFeature> ore_marble;
    public static Holder<PlacedFeature> ore_limestone;
    public static Holder<PlacedFeature> ore_bloodstone;
    public static Holder<PlacedFeature> mud;
    public static Holder<PlacedFeature> ore_volcanic_stone;
    public static Holder<PlacedFeature> ore_volcanic_stone_bricks;
    public static Holder<PlacedFeature> ore_black_marble;
    public static Holder<PlacedFeature> ore_silver;

    //
    public static void onFeatureRegistry(final IForgeRegistry<Feature<?>> e) {
        ConfiguredFeature<?, ?> marbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.marble.defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_marble"), marbleFeature);
        ore_marble = Holder.direct(new PlacedFeature(Holder.direct(marbleFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90)))));

        ConfiguredFeature<?, ?> limestoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.limestone.defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_limestone"), limestoneFeature);
        ore_limestone = Holder.direct(new PlacedFeature(Holder.direct(limestoneFeature), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90)))));

        ConfiguredFeature<?, ?> silverFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.silver_ore.defaultBlockState(), 6));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_silver"), silverFeature);
        ore_silver = Holder.direct(new PlacedFeature(Holder.direct(silverFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(60)))));

        ConfiguredFeature<?, ?> bloodstoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocks.bloodstone.defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bloodstone"), bloodstoneFeature);
        ore_bloodstone = Holder.direct(new PlacedFeature(Holder.direct(bloodstoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));

        ConfiguredFeature<?, ?> blackMarbleFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, AdditionalBlocks.black_marble.defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_black_marble"), blackMarbleFeature);
        ore_black_marble = Holder.direct(new PlacedFeature(Holder.direct(blackMarbleFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));

        ConfiguredFeature<?, ?> volcanicStoneFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.volcanic_stone.defaultBlockState(), 20));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone"), volcanicStoneFeature);
        ore_volcanic_stone = Holder.direct(new PlacedFeature(Holder.direct(volcanicStoneFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120)))));

        ConfiguredFeature<?, ?> volcanicStoneBricksFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.volcanic_stone_bricks.defaultBlockState(), 30));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"), volcanicStoneBricksFeature);
        ore_volcanic_stone_bricks = Holder.direct(new PlacedFeature(Holder.direct(volcanicStoneBricksFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(120)))));
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
