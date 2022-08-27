package com.supermartijn642.additionalblocks.stone;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

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
    public static Holder<PlacedFeature> ore_bismuth;


    //
    public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e) {
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

        ConfiguredFeature<?, ?> bismuthFeature = new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, AdditionalBlocks.bismuth_ore.defaultBlockState(), 4));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation("abstoneedition", "ore_bismuth"), bismuthFeature);
        ore_bismuth = Holder.direct(new PlacedFeature(Holder.direct(silverFeature), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)))));

    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onBiomeLoad(BiomeLoadingEvent e) {
        ResourceKey<Biome> biomeKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, e.getName());

        // all overworld biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {
            if (AdditionalBlocksConfig.enableSilver.get()) {
                e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_silver);
            }
            if (AdditionalBlocksConfig.enableBismuth.get()) {
                e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_bismuth);
            }
            if (!(e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("desert") || e.getName().getPath().equals("desert_hills") || e.getName().getPath().equals("desert_lakes")))) {
                if (AdditionalBlocksConfig.enableMarble.get())
                    e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_marble);
            }
            if (e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("desert") || e.getName().getPath().equals("desert_hills") || e.getName().getPath().equals("desert_lakes"))) {
                if (AdditionalBlocksConfig.enableLimestone.get())
                    e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_limestone);
            }
            if (e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("dripstone_caves") || e.getName().getPath().equals("jagged_peaks") || e.getName().getPath().equals("stony_peaks") || e.getName().getPath().equals("stony_shore") || e.getName().getPath().equals("windswept_gravelly_hills"))) {
                if (AdditionalBlocksConfig.enableVolcanicStone.get())
                    e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_volcanic_stone);
            }
        }

        // all nether biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).contains(biomeKey)) {
            if (e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("soul_sand_valley") || e.getName().getPath().equals("basalt_deltas"))) {
                if (AdditionalBlocksConfig.enableBlackMarble.get())
                    e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_black_marble);
                if (AdditionalBlocksConfig.enableVolcanicStone.get())
                    e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_volcanic_stone_bricks);
            }
            if (AdditionalBlocksConfig.enableBloodstone.get())
                e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore_bloodstone);
        }

        // all end biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {

        }

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
