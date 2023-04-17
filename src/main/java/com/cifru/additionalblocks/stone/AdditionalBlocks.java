package com.cifru.additionalblocks.stone;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.condition.BlockEnabledResourceCondition;
import com.cifru.additionalblocks.stone.condition.ItemEnabledResourceCondition;
import com.cifru.additionalblocks.stone.entities.AdditionalBlocksEntities;
import com.cifru.additionalblocks.stone.generators.*;
import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.supermartijn642.core.item.CreativeItemGroup;
import com.supermartijn642.core.registry.GeneratorRegistrationHandler;
import com.supermartijn642.core.registry.RegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.CreativeModeTab;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
public class AdditionalBlocks implements ModInitializer {

    public static final CreativeModeTab ITEM_GROUP = CreativeItemGroup.create("abstoneedition", () -> AdditionalBlocksBlocks.MARBLE_BRICKS.getItem()).sortAlphabetically();

    @Override
    public void onInitialize(){
        AdditionalBlocksConfig.create();
        AdditionalBlocksItems.init();
        AdditionalBlocksBlocks.init();
        AdditionalBlocksEntities.init();
        registerConditions();
        registerGenerators();
        WorldGeneration.registerFeatures();
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
}
