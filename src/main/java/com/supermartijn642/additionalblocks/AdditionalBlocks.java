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

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("additionalblocks")
public class AdditionalBlocks {

    @ObjectHolder("additionalblocks:marble")
    public static Block marble;
    @ObjectHolder("additionalblocks:smooth_marble")
    public static Block smooth_marble;
    @ObjectHolder("additionalblocks:stone_brick_block")
    public static Block stone_brick_block;
    @ObjectHolder("additionalblocks:marble_bricks")
    public static Block marble_bricks;
    @ObjectHolder("additionalblocks:animated_block")
    public static Block animated_block;

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
            e.getRegistry().register(new BasicBlock("animated_block", AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE)));
        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e){
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e){
            e.getRegistry().register(new BlockItem(marble, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(marble.getRegistryName()));
            e.getRegistry().register(new BlockItem(smooth_marble, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(smooth_marble.getRegistryName()));
            e.getRegistry().register(new BlockItem(stone_brick_block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(stone_brick_block.getRegistryName()));
            e.getRegistry().register(new BlockItem(marble_bricks, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(marble_bricks.getRegistryName()));
            e.getRegistry().register(new BlockItem(animated_block, new Item.Properties().group(ItemGroup.SEARCH)).setRegistryName(animated_block.getRegistryName()));
        }
    }

}
