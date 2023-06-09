package com.cifru.additionalblocks.stone.tools;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Set;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public enum ToolType {

    SWORD(BlockTags.SWORD_EFFICIENT, ToolActions.DEFAULT_SWORD_ACTIONS, 3, -2.4f), PICKAXE(BlockTags.MINEABLE_WITH_PICKAXE, ToolActions.DEFAULT_PICKAXE_ACTIONS, 1, -2.8f), SHOVEL(BlockTags.MINEABLE_WITH_SHOVEL, ToolActions.DEFAULT_SHOVEL_ACTIONS, 1.5f, -3), AXE(BlockTags.MINEABLE_WITH_AXE, ToolActions.DEFAULT_AXE_ACTIONS, 6, -3.1f), HOE(BlockTags.MINEABLE_WITH_HOE, ToolActions.DEFAULT_HOE_ACTIONS, -2, -1.5f);

    private final TagKey<Block> mineableTag;
    private final Set<ToolAction> toolActions;
    private final float baseAttackDamage;
    private final float baseAttackSpeed;

    ToolType(TagKey<Block> mineableTag, Set<ToolAction> toolActions, float baseAttackDamage, float baseAttackSpeed){
        this.mineableTag = mineableTag;
        this.toolActions = toolActions;
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
    }

    public TagKey<Block> getMineableTag(){
        return this.mineableTag;
    }

    public Set<ToolAction> getToolActions(){
        return this.toolActions;
    }

    public float getBaseAttackDamage(){
        return this.baseAttackDamage;
    }

    public float getBaseAttackSpeed(){
        return this.baseAttackSpeed;
    }
}
