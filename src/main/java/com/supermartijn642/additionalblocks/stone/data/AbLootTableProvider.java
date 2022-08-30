package com.supermartijn642.additionalblocks.stone.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

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
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        BlockLootTables lootTables = new BlockLootTables() {
            @Override
            protected Iterable<Block> getKnownBlocks() {
                return AdditionalBlocks.blocks;
            }

            @Override
            protected void addTables() {
                List<Block> allBlocks = new ArrayList<>(AdditionalBlocks.blocks);

                this.add(AdditionalBlocks.bismuth_ore, BlockLootTables.createOreDrop(AdditionalBlocks.bismuth_ore, AdditionalBlocks.raw_bismuth_chunk));
                this.add(AdditionalBlocks.silver_ore, BlockLootTables.createOreDrop(AdditionalBlocks.silver_ore, AdditionalBlocks.raw_silver));
                allBlocks.remove(AdditionalBlocks.bismuth_ore);
                allBlocks.remove(AdditionalBlocks.silver_ore);

                for (Block block : allBlocks) {
                    this.dropSelf(block);
                }
            }
        };

        return ImmutableList.of(Pair.of(() -> lootTables, LootParameterSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((a, b) -> LootTableManager.validate(validationtracker, a, b));
    }
}
