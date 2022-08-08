package com.supermartijn642.additionalblocks.stone;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record AbBiomeModifier(HolderSet<Biome> includedBiomes, HolderSet<Biome> excludedBiomes,
                              HolderSet<PlacedFeature> features,
                              GenerationStep.Decoration step) implements BiomeModifier {

    public static final Codec<AbBiomeModifier> ALL_BIOME_MODIFIER_CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Biome.LIST_CODEC.fieldOf("included_biomes").forGetter(AbBiomeModifier::includedBiomes),
                    Biome.LIST_CODEC.fieldOf("excluded_biomes").forGetter(AbBiomeModifier::excludedBiomes),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AbBiomeModifier::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AbBiomeModifier::step)
            ).apply(builder, AbBiomeModifier::new)
    );

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && (this.includedBiomes.size() == 0 || this.includedBiomes.contains(biome)) && !this.excludedBiomes.contains(biome)) {
            BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
            this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return ALL_BIOME_MODIFIER_CODEC;
    }
}
