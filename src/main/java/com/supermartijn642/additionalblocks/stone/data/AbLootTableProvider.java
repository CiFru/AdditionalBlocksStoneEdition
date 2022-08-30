package com.supermartijn642.additionalblocks.stone.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
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

                this.registerLootTable(AdditionalBlocks.bismuth_ore, (block) -> droppingWithSilkTouch(block, withExplosionDecay(block, ItemLootEntry.builder(AdditionalBlocks.raw_bismuth_chunk).acceptFunction(SetCount.builder(RandomValueRange.of(1, 3))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE)))));
                this.registerLootTable(AdditionalBlocks.silver_ore, (block) -> droppingWithSilkTouch(block, withExplosionDecay(block, ItemLootEntry.builder(AdditionalBlocks.raw_silver).acceptFunction(SetCount.builder(RandomValueRange.of(1, 3))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE)))));
                allBlocks.remove(AdditionalBlocks.bismuth_ore);
                allBlocks.remove(AdditionalBlocks.silver_ore);

                for (Block block : allBlocks) {
                    this.registerDropSelfLootTable(block);
                }
            }
        };
        return ImmutableList.of(Pair.of(() -> lootTables, LootParameterSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((a, b) -> LootTableManager.func_227508_a_(validationtracker, a, b));
    }
}
