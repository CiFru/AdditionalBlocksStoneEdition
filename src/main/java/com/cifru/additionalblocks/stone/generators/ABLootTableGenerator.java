package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.supermartijn642.core.generator.LootTableGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABLootTableGenerator extends LootTableGenerator {

    public static final BlockPreset DROP_SELF = (generator, blockType) -> generator.dropSelf(blockType.getBlock());

    public static BlockPreset orePreset(Supplier<ItemLike> rawOreItem){
        return (generator, blockType) -> generator.lootTable(blockType.getBlock())
            .pool(pool -> pool.itemEntry(blockType.getBlock()).hasEnchantmentCondition(Enchantments.SILK_TOUCH))
            .pool(pool -> pool.itemEntry(() -> rawOreItem.get().asItem()).function(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE).build()).condition(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).invert().build()));
    }

    private final Map<BlockType<?>,Consumer<BlockType<?>>> builders = new HashMap<>();

    public ABLootTableGenerator(ResourceCache cache){
        super("abstoneedition", cache);
        this.populateBuilders();
    }

    private void populateBuilders(){
        // Create block loot tables manually
    }

    @Override
    public void generate(){
        // Generate loot tables for all blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            BlockPreset preset = blockType.getLootTablePreset();
            Consumer<BlockType<?>> builder = this.builders.get(blockType);
            if(preset != null && builder != null)
                throw new IllegalStateException("Block type '" + blockType.getIdentifier() + "' has both a loot table preset and a manual builder!");
            if(preset == null && builder == null)
                throw new IllegalStateException("Missing loot table generator for block type '" + blockType.getIdentifier() + "'!");

            if(preset != null)
                preset.createLootTable(this, blockType);
            if(builder != null)
                builder.accept(blockType);
        }
    }

    public interface BlockPreset {

        void createLootTable(ABLootTableGenerator generator, BlockType<?> blockType);
    }
}
