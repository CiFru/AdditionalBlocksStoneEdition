package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABSwordItem extends ABToolItem {

    public ABSwordItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.SWORD);
    }

    @Override
    public boolean canAttackBlock(BlockState state, World level, BlockPos pos, PlayerEntity player){
        return !player.isCreative();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        if(state.is(Blocks.COBWEB)){
            return 15.0F;
        }else{
            Material material = state.getMaterial();
            if(material == Material.PLANT || material == Material.REPLACEABLE_PLANT || material == Material.CORAL || state.is(BlockTags.LEAVES) || material == Material.VEGETABLE)
                return 1.5F;
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity user, LivingEntity enemy){
        stack.hurtAndBreak(1, enemy, entity -> entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, World level, BlockState state, BlockPos pos, LivingEntity entity){
        if(!level.isClientSide && state.getDestroySpeed(level, pos) != 0)
            stack.hurtAndBreak(2, entity, e -> e.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state){
        return state.is(Blocks.COBWEB) || super.isCorrectToolForDrops(state);
    }
}
