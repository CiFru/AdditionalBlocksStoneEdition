package com.cifru.additionalblocks.stone;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
public class WorldGeneration {

    public static void registerFeatures(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.DESERT).negate()), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_marble"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.DESERT)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_limestone"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_silver"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_bismuth"));
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_bloodstone"));
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether().and(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_black_marble"));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld().and(BiomeSelectors.tag(ConventionalBiomeTags.MOUNTAIN_PEAK).or(BiomeSelectors.tag(ConventionalBiomeTags.MOUNTAIN))), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_volcanic_stone"));
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether().and(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)), GenerationStep.Decoration.UNDERGROUND_ORES, key("ore_volcanic_stone_bricks"));
    }

    private static ResourceKey<PlacedFeature> key(String identifier){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("abstoneedition", identifier));
    }
}
