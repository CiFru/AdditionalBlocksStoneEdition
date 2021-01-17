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

    @ObjectHolder("additionalblocks:marble")
    public static Block marble;
    @ObjectHolder("additionalblocks:smooth_marble")
    public static Block smooth_marble;
    @ObjectHolder("additionalblocks:stone_brick_block")
    public static Block stone_brick_block;
    @ObjectHolder("additionalblocks:marble_bricks")
    public static Block marble_bricks;
    @ObjectHolder("additionalblocks:diorite_bricks")
    public static Block diorite_bricks;
    @ObjectHolder("additionalblocks:andesite_bricks")
    public static Block andesite_bricks;
    @ObjectHolder("additionalblocks:granite_bricks")
    public static Block granite_bricks;
    @ObjectHolder("additionalblocks:animated_block")
    public static Block animated_block;
    @ObjectHolder("additionalblocks:marble_pillar")
    public static Block marble_pillar;
    @ObjectHolder("additionalblocks:bloodstone")
    public static Block bloodstone;
    @ObjectHolder("additionalblocks:smooth_bloodstone")
    public static Block smooth_bloodstone;
    @ObjectHolder("additionalblocks:bloodstone_bricks")
    public static Block bloodstone_bricks;

    public AdditionalBlocks(){
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e){
            e.getRegistry().register(new BasicBlock("marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("smooth_marble", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("stone_brick_block", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("marble_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("diorite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.LIGHT_GRAY).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("andesite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("granite_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE)));
            e.getRegistry().register(new BasicBlock("animated_block", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
            e.getRegistry().register(new AxisRotationBlock("marble_pillar", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE)));
            e.getRegistry().register(new AxisRotationBlock("bloodstone", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            e.getRegistry().register(new AxisRotationBlock("smooth_bloodstone", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
            e.getRegistry().register(new AxisRotationBlock("bloodstone_bricks", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).sound(SoundType.STONE)));
        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e){
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e){
            for(Block block : blocks)
                registerItem(e, new BlockItem(block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(block.getRegistryName()));

            e.getRegistry().register(new BlockItem(marble, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(marble.getRegistryName()));
            e.getRegistry().register(new BlockItem(smooth_marble, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(smooth_marble.getRegistryName()));
            e.getRegistry().register(new BlockItem(stone_brick_block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(stone_brick_block.getRegistryName()));
            e.getRegistry().register(new BlockItem(marble_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(marble_bricks.getRegistryName()));
            e.getRegistry().register(new BlockItem(diorite_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(diorite_bricks.getRegistryName()));
            e.getRegistry().register(new BlockItem(andesite_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(andesite_bricks.getRegistryName()));
            e.getRegistry().register(new BlockItem(granite_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(granite_bricks.getRegistryName()));
            e.getRegistry().register(new BlockItem(animated_block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(animated_block.getRegistryName()));
            e.getRegistry().register(new BlockItem(marble_pillar, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(marble_pillar.getRegistryName()));
            e.getRegistry().register(new BlockItem(bloodstone, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(bloodstone.getRegistryName()));
            e.getRegistry().register(new BlockItem(smooth_bloodstone, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(smooth_bloodstone.getRegistryName()));
            e.getRegistry().register(new BlockItem(bloodstone_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(bloodstone_bricks.getRegistryName()));
        }
    }

    public static <T extends Block> T registerBlock(RegistryEvent.Register<Block> e, T block){
        e.getRegistry().register(block);
        blocks.add(block);
        return block;
    }

    public static <T extends Item> T registerItem(RegistryEvent.Register<Item> e, T item){
        e.getRegistry().register(item);
        items.add(item);
        return item;
    }

}
