package com.cifru.additionalblocks.stone.entities;

import com.supermartijn642.core.registry.RegistrationHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class AdditionalBlocksEntities {

    public static EntityType<NuclearTntEntity> NUCLEAR_TNT;

    public static void init(){
        RegistrationHandler handler = RegistrationHandler.get("abstoneedition");
        handler.registerEntityType("nuclear_tnt", () -> NUCLEAR_TNT = EntityType.Builder.<NuclearTntEntity>of(NuclearTntEntity::new, EntityClassification.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10).build("nuclear_tnt"));
    }
}
