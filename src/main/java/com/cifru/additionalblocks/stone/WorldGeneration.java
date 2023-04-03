package com.cifru.additionalblocks.stone;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
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

    public static ConfiguredFeature<?,?> ore_marble;
    public static ConfiguredFeature<?,?> ore_limestone;
    public static ConfiguredFeature<?,?> ore_bloodstone;
    public static ConfiguredFeature<?,?> mud;
    public static ConfiguredFeature<?,?> ore_volcanic_stone;
    public static ConfiguredFeature<?,?> ore_volcanic_stone_bricks;
    public static ConfiguredFeature<?,?> ore_black_marble;
    public static ConfiguredFeature<?,?> ore_silver;
    public static ConfiguredFeature<?,?> ore_copper;
    public static ConfiguredFeature<?,?> ore_bismuth;

    public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e){
        ore_marble = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.MARBLE.getBlock().defaultBlockState(), 20));
        ore_marble = ore_marble.range(60).squared().count(6);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_marble"),
            ore_marble
        );
        ore_limestone = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.LIMESTONE.getBlock().defaultBlockState(), 20));
        ore_limestone = ore_limestone.range(60).squared().count(6);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_limestone"),
            ore_limestone
        );
        ore_copper = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.COPPER_ORE.getBlock().defaultBlockState(), 10));
        ore_copper = ore_copper.range(64).squared().count(20);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_copper"),
            ore_copper
        );
        ore_silver = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.SILVER_ORE.getBlock().defaultBlockState(), 6));
        ore_silver = ore_silver.range(64).squared().count(20);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_silver"),
            ore_silver
        );
        ore_bismuth = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.BISMUTH_ORE.getBlock().defaultBlockState(), 5));
        ore_bismuth = ore_bismuth.range(50).squared().count(15);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_bismuth"),
            ore_bismuth
        );
        ore_bloodstone = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLOODSTONE.getBlock().defaultBlockState(), 20));
        ore_bloodstone = ore_bloodstone.range(60).squared().count(6);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_bloodstone"),
            ore_bloodstone
        );
        ore_black_marble = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.BLACK_MARBLE.getBlock().defaultBlockState(), 20));
        ore_black_marble = ore_black_marble.range(60).squared().count(6);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_black_marble"),
            ore_black_marble
        );
        ore_volcanic_stone_bricks = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, AdditionalBlocksBlocks.VOLCANIC_STONE_BRICKS.getBlock().defaultBlockState(), 20));
        ore_volcanic_stone_bricks = ore_volcanic_stone_bricks.range(60).squared().count(6);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_volcanic_stone_bricks"),
            ore_volcanic_stone_bricks
        );
        ore_volcanic_stone = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AdditionalBlocksBlocks.VOLCANIC_STONE.getBlock().defaultBlockState(), 30));
        ore_volcanic_stone = ore_volcanic_stone.range(60).squared().count(8);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abstoneedition", "ore_volcanic_stone"),
            ore_volcanic_stone
        );
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onBiomeLoad(BiomeLoadingEvent e){
        RegistryKey<Biome> biomeKey = RegistryKey.create(ForgeRegistries.Keys.BIOMES, e.getName());

        // all overworld biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)){
            if(AdditionalBlocksConfig.enableSilver.get()){
                e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_silver);
            }
            if(AdditionalBlocksConfig.enableCopper.get()){
                e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_copper);
            }
            if(AdditionalBlocksConfig.enableBismuth.get()){
                e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_bismuth);
            }
            if(!(e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("desert") || e.getName().getPath().equals("desert_hills") || e.getName().getPath().equals("desert_lakes")))){
                if(AdditionalBlocksConfig.enableMarble.get())
                    e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_marble);
            }
            if(e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("desert") || e.getName().getPath().equals("desert_hills") || e.getName().getPath().equals("desert_lakes"))){
                if(AdditionalBlocksConfig.enableLimestone.get())
                    e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_limestone);
            }
            if(e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("snowy_mountains") || e.getName().getPath().equals("modified_gravelly_mountains") || e.getName().getPath().equals("gravelly_mountains") || e.getName().getPath().equals("stone_shore"))){
                if(AdditionalBlocksConfig.enableVolcanicStone.get())
                    e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_volcanic_stone);
            }
        }

        // all nether biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).contains(biomeKey)){
            if(e.getName().getNamespace().equals("minecraft") && (e.getName().getPath().equals("soul_sand_valley") || e.getName().getPath().equals("basalt_deltas"))){
                if(AdditionalBlocksConfig.enableBlackMarble.get())
                    e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_black_marble);
                if(AdditionalBlocksConfig.enableVolcanicStone.get())
                    e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_volcanic_stone_bricks);
            }
            if(AdditionalBlocksConfig.enableBloodstone.get())
                e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore_bloodstone);
        }

        // all end biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)){

        }
    }
}
