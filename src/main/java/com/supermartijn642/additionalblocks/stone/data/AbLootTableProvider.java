package com.supermartijn642.additionalblocks.stone.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import com.supermartijn642.additionalblocks.stone.WallyBlock;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

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
        List<Block> blocks = Lists.newArrayList(
                AdditionalBlocks.brown_stone_path_straight_slab,
                AdditionalBlocks.brown_stone_path_curved_slab,
                AdditionalBlocks.brown_stone_pattern_slab,
                AdditionalBlocks.brown_stone_tiles_slab,
                AdditionalBlocks.old_stone_path_straight_slab,
                AdditionalBlocks.old_stone_path_curved_slab,
                AdditionalBlocks.old_stone_pattern_slab,
                AdditionalBlocks.old_stone_tiles_slab,
                AdditionalBlocks.stone_path_straight_slab,
                AdditionalBlocks.stone_path_curved_slab,
                AdditionalBlocks.stone_pattern_slab,
                AdditionalBlocks.stone_tiles_slab,
                AdditionalBlocks.glowstone_slab,
                AdditionalBlocks.limestone_bricks_slab,
                AdditionalBlocks.smooth_limestone_slab,

                AdditionalBlocks.brown_stone_path_straight_stairs,
                AdditionalBlocks.brown_stone_path_curved_stairs,
                AdditionalBlocks.brown_stone_pattern_stairs,
                AdditionalBlocks.brown_stone_tiles_stairs,
                AdditionalBlocks.old_stone_path_straight_stairs,
                AdditionalBlocks.old_stone_path_curved_stairs,
                AdditionalBlocks.old_stone_pattern_stairs,
                AdditionalBlocks.old_stone_tiles_stairs,
                AdditionalBlocks.stone_path_straight_stairs,
                AdditionalBlocks.stone_path_curved_stairs,
                AdditionalBlocks.stone_pattern_stairs,
                AdditionalBlocks.stone_tiles_stairs,
                AdditionalBlocks.glowstone_stairs,
                AdditionalBlocks.limestone_bricks_stairs,
                AdditionalBlocks.smooth_limestone_stairs,
                AdditionalBlocks.smooth_stone_stairs
        );

        for (Block block : AdditionalBlocks.blocks) {
            if (block instanceof WallyBlock)
                blocks.add(block);
        }

        BlockLootTables lootTables = new BlockLootTables() {
            @Override
            protected Iterable<Block> getKnownBlocks() {
                return blocks;
            }

            @Override
            protected void addTables() {
                for (Block block : blocks) {
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
