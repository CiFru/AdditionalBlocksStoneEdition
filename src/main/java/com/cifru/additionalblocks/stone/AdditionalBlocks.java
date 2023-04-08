package com.cifru.additionalblocks.stone;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.condition.BlockEnabledResourceCondition;
import com.cifru.additionalblocks.stone.condition.ItemEnabledResourceCondition;
import com.cifru.additionalblocks.stone.entities.AdditionalBlocksEntities;
import com.cifru.additionalblocks.stone.generators.*;
import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.mojang.serialization.Codec;
import com.supermartijn642.core.CommonUtils;
import com.supermartijn642.core.item.CreativeItemGroup;
import com.supermartijn642.core.registry.GeneratorRegistrationHandler;
import com.supermartijn642.core.registry.RegistrationHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegisterEvent;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("abstoneedition")
public class AdditionalBlocks {

    public static final CreativeModeTab ITEM_GROUP = CreativeItemGroup.create("abstoneedition", () -> AdditionalBlocksBlocks.MARBLE_BRICKS.getItem()).sortAlphabetically();

    public AdditionalBlocks(){
        AdditionalBlocksConfig.create();
        AdditionalBlocksItems.init();
        AdditionalBlocksBlocks.init();
        AdditionalBlocksEntities.init();
        if(CommonUtils.getEnvironmentSide().isClient())
            AdditionalBlocksClient.init();
        registerConditions();
        registerGenerators();
    }

    private static void registerConditions(){
        RegistrationHandler handler = RegistrationHandler.get("abstoneedition");
        handler.registerResourceConditionSerializer("block_enabled", BlockEnabledResourceCondition.SERIALIZER);
        handler.registerResourceConditionSerializer("item_enabled", ItemEnabledResourceCondition.SERIALIZER);
    }

    private static void registerGenerators(){
        GeneratorRegistrationHandler handler = GeneratorRegistrationHandler.get("abstoneedition");
        handler.addGenerator(ABModelGenerator::new);
        handler.addGenerator(ABBlockStateGenerator::new);
        handler.addGenerator(ABLanguageGenerator::new);
        handler.addGenerator(ABLootTableGenerator::new);
        handler.addGenerator(ABTagGenerator::new);
        handler.addGenerator(ABRecipeGenerator::new);
        handler.addGenerator(ABStoneCuttingRecipeGenerator::new);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onRegistryEvent(RegisterEvent e){
            if(e.getRegistryKey() == ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS)
                onBiomeModifierRegistry(e.getForgeRegistry());
        }

        public static void onBiomeModifierRegistry(final IForgeRegistry<Codec<? extends BiomeModifier>> registry){
            registry.register("all", ABBiomeModifier.ALL_BIOME_MODIFIER_CODEC);
        }
    }
}
