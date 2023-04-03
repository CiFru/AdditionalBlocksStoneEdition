package com.cifru.additionalblocks.stone.tools;

import net.minecraft.util.ResourceLocation;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public enum ToolType {

    SWORD(null, 3, -2.4f), PICKAXE(new ResourceLocation("minecraft", "mineable/pickaxe"), 1, -2.8f), SHOVEL(new ResourceLocation("minecraft", "mineable/sword"), 1.5f, -3), AXE(new ResourceLocation("minecraft", "mineable/axe"), 6, -3.1f), HOE(new ResourceLocation("minecraft", "mineable/hoe"), -2, -1.5f);

    private final ResourceLocation mineableTag;
    private final float baseAttackDamage;
    private final float baseAttackSpeed;

    ToolType(ResourceLocation mineableTag, float baseAttackDamage, float baseAttackSpeed){
        this.mineableTag = mineableTag;
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
    }

    public ResourceLocation getMineableTag(){
        return this.mineableTag;
    }

    public float getBaseAttackDamage(){
        return this.baseAttackDamage;
    }

    public float getBaseAttackSpeed(){
        return this.baseAttackSpeed;
    }
}
