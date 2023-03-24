package com.supermartijn642.additionalblocks.stone.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.supermartijn642.additionalblocks.stone.tools.ABToolMaterial;
import com.supermartijn642.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolAction;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABToolItem extends ABItem {

    private final ABToolMaterial toolMaterial;
    private final ToolType toolType;
    private final Multimap<Attribute,AttributeModifier> defaultModifiers;

    public ABToolItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial, ToolType toolType){
        super(properties, enabled);
        this.toolMaterial = toolMaterial;
        this.toolType = toolType;
        ImmutableMultimap.Builder<Attribute,AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", toolType.getBaseAttackDamage() + toolMaterial.getAttackDamage(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", toolType.getBaseAttackSpeed(), AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public int getEnchantmentValue(ItemStack stack){
        return this.toolMaterial.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient){
        return ingredient.is(this.toolMaterial.getRepairItem().get());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        return state.is(this.toolType.getMineableTag()) ? this.toolMaterial.getMiningSpeed() : 1;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity user, LivingEntity enemy){
        stack.hurtAndBreak(2, enemy, entity -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity){
        if(!level.isClientSide && state.getDestroySpeed(level, pos) != 0)
            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public Multimap<Attribute,AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot){
        return super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state){
        return this.toolType.getMineableTag() != null && state.is(this.toolType.getMineableTag()) && TierSortingRegistry.isCorrectTierForDrops(this.toolMaterial.getMiningTier().getVanillaTier(), state);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction){
        return this.toolType.getToolActions().contains(toolAction);
    }
}
