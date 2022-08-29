package com.supermartijn642.additionalblocks.stone.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AbLootTableProvider extends LootTableProvider {

    public AbLootTableProvider(DataGenerator gen) {

        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        BlockLoot lootTables = new BlockLoot() {
            @Override
            protected Iterable<Block> getKnownBlocks() {
                return AdditionalBlocks.blocks;
            }

            @Override
            protected void addTables() {
                List<Block> allBlocks = new ArrayList<>(AdditionalBlocks.blocks);

                this.add(AdditionalBlocks.bismuth_ore, BlockLoot.createOreDrop(AdditionalBlocks.bismuth_ore, AdditionalBlocks.raw_bismuth_chunk));
                this.add(AdditionalBlocks.silver_ore, BlockLoot.createOreDrop(AdditionalBlocks.silver_ore, AdditionalBlocks.raw_silver));
                allBlocks.remove(AdditionalBlocks.bismuth_ore);
                allBlocks.remove(AdditionalBlocks.silver_ore);

                for (Block block : allBlocks) {
                    this.dropSelf(block);
                }
            }
        };

        return ImmutableList.of(Pair.of(() -> lootTables, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((a, b) -> LootTables.validate(validationtracker, a, b));
    }
}
