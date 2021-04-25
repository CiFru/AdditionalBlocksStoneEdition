package com.supermartijn642.additionalblocks.stone;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
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

    //
    public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e) {
        ore_marble = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AdditionalBlocks.marble.getDefaultState(), 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 64, 100)));
        ore_marble.range(80).square().func_242731_b(10);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
                new ResourceLocation("abstoneedition", "ore_marble"),
                ore_marble
        );
        ore_limestone = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AdditionalBlocks.limestone.getDefaultState(), 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 64, 100)));
        ore_limestone.range(80).square().func_242731_b(10);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
                new ResourceLocation("abstoneedition", "ore_limestone"),
                ore_limestone
        );
        ore_copper = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AdditionalBlocks.copper_ore.getDefaultState(), 10)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(10, 55, 90)));
        ore_copper.range(64).square().func_242731_b(20);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
                new ResourceLocation("abstoneedition", "ore_copper"),
                ore_copper
        );
        ore_silver = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AdditionalBlocks.bloodstone.getDefaultState(), 9));
        ore_silver.range(64).square().func_242731_b(20);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
                new ResourceLocation("abstoneedition", "ore_silver"),
                ore_silver
        );
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onBiomeLoad(BiomeLoadingEvent e) {
        RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, e.getName());

        // all overworld biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {
            e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_marble);

        }

        if (e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("desert")||e.getName().getPath().equals("desert_hills")||e.getName().getPath().equals("desert_lakes"))) {
            e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_limestone);

        }
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {
            e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_copper);

        }
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {
            e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_silver);

        }
        System.out.println("Biome: " + e.getName());

        // all nether biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {

        }

        // all end biomes
        if (BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)) {

        }
    }

}
