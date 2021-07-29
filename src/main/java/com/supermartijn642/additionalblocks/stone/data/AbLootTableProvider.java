package com.supermartijn642.additionalblocks.stone.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.additionalblocks.stone.AdditionalBlocks;
import com.supermartijn642.additionalblocks.stone.WallyBlock;
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

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AbLootTableProvider extends LootTableProvider {

    public AbLootTableProvider(DataGenerator gen){

        super(gen);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation,LootTable.Builder>>>,LootContextParamSet>> getTables(){
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

        for(Block block : AdditionalBlocks.blocks){
            if(block instanceof WallyBlock)
                blocks.add(block);
        }

        BlockLoot lootTables = new BlockLoot() {
            @Override
            protected Iterable<Block> getKnownBlocks(){
                return blocks;
            }

            @Override
            protected void addTables(){
                for(Block block : blocks){
                    this.dropSelf(block);
                }
            }
        };

        return ImmutableList.of(Pair.of(() -> lootTables, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation,LootTable> map, ValidationContext validationtracker){
        map.forEach((a, b) -> LootTables.validate(validationtracker, a, b));
    }
}
