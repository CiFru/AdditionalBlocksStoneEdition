package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.supermartijn642.core.generator.LootTableGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.util.IItemProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABLootTableGenerator extends LootTableGenerator {

    public static final BlockPreset DROP_SELF = (generator, blockType) -> generator.dropSelf(blockType.getBlock());

    public static BlockPreset orePreset(Supplier<IItemProvider> rawOreItem){
        return (generator, blockType) -> generator.lootTable(blockType.getBlock())
            .pool(pool -> pool.itemEntry(blockType.getBlock()).hasEnchantmentCondition(Enchantments.SILK_TOUCH))
            .pool(pool -> pool.itemEntry(() -> rawOreItem.get().asItem()).function(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE).build()).condition(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))).invert().build()));
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
