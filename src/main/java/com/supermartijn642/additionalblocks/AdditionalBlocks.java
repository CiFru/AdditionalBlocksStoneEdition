package com.supermartijn642.additionalblocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("additionalblocks")
public class AdditionalBlocks {

    private static final List<Block> blocks = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();


    public static Block marble;
    public static Block smooth_marble;
    public static Block stone_brick_block;
    public static Block marble_bricks;
    public static Block diorite_bricks;
    public static Block andesite_bricks;
    public static Block granite_bricks;
    public static Block animated_block;
    public static Block marble_pillar;
    public static Block bloodstone;
    public static Block smooth_bloodstone;
    public static Block bloodstone_bricks;
    public static Block black_marble;
    public static Block smooth_black_marble;
    public static Block black_marble_bricks;
    public static Block mud;
    public static Block brown_bricks;
    public static Block volcanic_stone;
    public static Block volcanic_stone_bricks;
    public static Block marble_stairs;
    public static Block andesite_bricks_stairs;
    public static Block black_marble_stairs;
    public static Block black_marble_bricks_stairs;
    public static Block bloodstone_stairs;
    public static Block bloodstone_bricks_stairs;
    public static Block brown_bricks_stairs;
    public static Block diorite_bricks_stairs;
    public static Block granite_bricks_stairs;
    public static Block marble_bricks_stairs;
    public static Block smooth_black_marble_stairs;
    public static Block smooth_bloodstone_stairs;
    public static Block smooth_marble_stairs;
    public static Block stone_brick_block_stairs;
    public static Block volcanic_stone_stairs;
    public static Block volcanic_stone_bricks_stairs;
    public static Block marble_slab;
    public static Block andesite_bricks_slab;
    public static Block black_marble_slab;
    public static Block black_marble_bricks_slab;
    public static Block bloodstone_slab;
    public static Block bloodstone_bricks_slab;
    public static Block brown_bricks_slab;
    public static Block diorite_bricks_slab;
    public static Block granite_bricks_slab;
    public static Block marble_bricks_slab;
    public static Block smooth_black_marble_slab;
    public static Block smooth_bloodstone_slab;
    public static Block smooth_marble_slab;
    public static Block stone_brick_block_slab;
    public static Block volcanic_stone_slab;
    public static Block volcanic_stone_bricks_slab;
    public static Block stone_path_curved;
    public static Block stone_path_straight;
    public static Block stone_pattern;

    public AdditionalBlocks() {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {
            marble = registerBlock(e, new BasicBlock("marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            smooth_marble = registerBlock(e, new BasicBlock("smooth_marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            stone_brick_block = registerBlock(e, new BasicBlock("stone_brick_block", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            marble_bricks = registerBlock(e, new BasicBlock("marble_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            diorite_bricks = registerBlock(e, new BasicBlock("diorite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE)));
            andesite_bricks = registerBlock(e, new BasicBlock("andesite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            granite_bricks = registerBlock(e, new BasicBlock("granite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            animated_block = registerBlock(e, new BasicBlock("animated_block", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            marble_pillar = registerBlock(e, new AxisRotationBlock("marble_pillar", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            bloodstone = registerBlock(e, new BasicBlock("bloodstone", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_bloodstone = registerBlock(e, new BasicBlock("smooth_bloodstone", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            bloodstone_bricks = registerBlock(e, new BasicBlock("bloodstone_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            black_marble = registerBlock(e, new BasicBlock("black_marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_black_marble = registerBlock(e, new BasicBlock("smooth_black_marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            black_marble_bricks = registerBlock(e, new BasicBlock("black_marble_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            mud = registerBlock(e, new BasicBlock("mud", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.WET_GRASS)));
            brown_bricks = registerBlock(e, new BasicBlock("brown_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.NETHER_BRICK)));
            volcanic_stone = registerBlock(e, new BasicBlock("volcanic_stone", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK)));
            volcanic_stone_bricks = registerBlock(e, new BasicBlock("volcanic_stone_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK)));
            marble_stairs = registerBlock(e, new StairBlock(marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            andesite_bricks_stairs = registerBlock(e, new StairBlock(andesite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            black_marble_stairs = registerBlock(e, new StairBlock(black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            black_marble_bricks_stairs = registerBlock(e, new StairBlock(black_marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            bloodstone_stairs = registerBlock(e, new StairBlock(bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            bloodstone_bricks_stairs = registerBlock(e, new StairBlock(bloodstone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            brown_bricks_stairs = registerBlock(e, new StairBlock(brown_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            diorite_bricks_stairs = registerBlock(e, new StairBlock(diorite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE)));
            granite_bricks_stairs = registerBlock(e, new StairBlock(granite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            marble_bricks_stairs = registerBlock(e, new StairBlock(marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            smooth_black_marble_stairs = registerBlock(e, new StairBlock(smooth_black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_bloodstone_stairs = registerBlock(e, new StairBlock(smooth_bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_marble_stairs = registerBlock(e, new StairBlock(smooth_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            stone_brick_block_stairs = registerBlock(e, new StairBlock(stone_brick_block,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            volcanic_stone_stairs = registerBlock(e, new StairBlock(volcanic_stone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            volcanic_stone_bricks_stairs = registerBlock(e, new StairBlock(volcanic_stone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            marble_slab = registerBlock(e, new SlabBlock(marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            andesite_bricks_slab = registerBlock(e, new SlabBlock(andesite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            black_marble_slab = registerBlock(e, new SlabBlock(black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            black_marble_bricks_slab = registerBlock(e, new SlabBlock(black_marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            bloodstone_slab = registerBlock(e, new SlabBlock(bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            bloodstone_bricks_slab = registerBlock(e, new SlabBlock(bloodstone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            brown_bricks_slab = registerBlock(e, new SlabBlock(brown_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            diorite_bricks_slab = registerBlock(e, new SlabBlock(diorite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE)));
            granite_bricks_slab = registerBlock(e, new SlabBlock(granite_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            marble_bricks_slab = registerBlock(e, new SlabBlock(marble_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            smooth_black_marble_slab = registerBlock(e, new SlabBlock(smooth_black_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_bloodstone_slab = registerBlock(e, new SlabBlock(smooth_bloodstone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            smooth_marble_slab = registerBlock(e, new SlabBlock(smooth_marble,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            stone_brick_block_slab = registerBlock(e, new SlabBlock(stone_brick_block,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            volcanic_stone_slab = registerBlock(e, new SlabBlock(volcanic_stone,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            volcanic_stone_bricks_slab = registerBlock(e, new SlabBlock(volcanic_stone_bricks,AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            stone_path_straight = registerBlock(e, new HorizontalRotationBlock("stone_path_straight", true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            stone_path_curved = registerBlock(e, new HorizontalRotationBlock("stone_path_curved", true, AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            stone_pattern = registerBlock(e, new BasicBlock("stone_pattern", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.NETHER_BRICK)));
        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            for (Block block : blocks)
                registerItem(e, new BlockItem(block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(block.getRegistryName()));
        }
    }

    public static <T extends Block> T registerBlock(RegistryEvent.Register<Block> e, T block) {
        e.getRegistry().register(block);
        blocks.add(block);
        return block;
    }

    public static <T extends Item> T registerItem(RegistryEvent.Register<Item> e, T item) {
        e.getRegistry().register(item);
        items.add(item);
        return item;
    }

}
