package com.cifru.additionalblocks.stone.tools;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public enum ToolType {

    SWORD(BlockTags.SWORD_EFFICIENT, 3, -2.4f), PICKAXE(BlockTags.MINEABLE_WITH_PICKAXE, 1, -2.8f), SHOVEL(BlockTags.MINEABLE_WITH_SHOVEL, 1.5f, -3), AXE(BlockTags.MINEABLE_WITH_AXE, 6, -3.1f), HOE(BlockTags.MINEABLE_WITH_HOE, -2, -1.5f);

    private final TagKey<Block> mineableTag;
    private final float baseAttackDamage;
    private final float baseAttackSpeed;

    ToolType(TagKey<Block> mineableTag, float baseAttackDamage, float baseAttackSpeed){
        this.mineableTag = mineableTag;
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
    }

    public TagKey<Block> getMineableTag(){
        return this.mineableTag;
    }

    public float getBaseAttackDamage(){
        return this.baseAttackDamage;
    }

    public float getBaseAttackSpeed(){
        return this.baseAttackSpeed;
    }
}
