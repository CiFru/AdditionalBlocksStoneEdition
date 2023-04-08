package com.cifru.additionalblocks.stone;

import com.cifru.additionalblocks.stone.entities.AdditionalBlocksEntities;
import com.cifru.additionalblocks.stone.entities.NuclearTntEntityRenderer;
import com.supermartijn642.core.registry.ClientRegistrationHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

/**
 * Created 7/11/2020 by SuperMartijn642
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdditionalBlocksClient {

    public static void init(){
        ClientRegistrationHandler handler = ClientRegistrationHandler.get("abstoneedition");
        handler.registerEntityRenderer(() -> AdditionalBlocksEntities.NUCLEAR_TNT, NuclearTntEntityRenderer::new);
    }
}
