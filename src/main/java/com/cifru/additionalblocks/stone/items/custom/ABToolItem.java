package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABToolItem extends ABItem {

    private final ABToolMaterial toolMaterial;
    private final ToolType toolType;
    private final Multimap<Attribute,AttributeModifier> defaultModifiers;

    public ABToolItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial, ToolType toolType){
        super(properties.maxStackSize(1), enabled);
        this.toolMaterial = toolMaterial;
        this.toolType = toolType;
        ImmutableMultimap.Builder<Attribute,AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", toolType.getBaseAttackDamage() + toolMaterial.getAttackDamage(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", toolType.getBaseAttackSpeed(), AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public int getEnchantmentValue(){
        return this.toolMaterial.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient){
        return ingredient.is(this.toolMaterial.getRepairItem().get());
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        return this.toolType.getMineableTag() != null && state.is(this.toolType.getMineableTag()) ? this.toolMaterial.getMiningSpeed() : 1;
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
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state){
        if(state.is(this.toolType.getMineableTag())){
            int level = this.toolMaterial.getMiningTier().getVanillaTier().getLevel();
            return level >= 3 || (!state.is(BlockTags.NEEDS_DIAMOND_TOOL) && (level >= 2 || (!state.is(BlockTags.NEEDS_IRON_TOOL) && (level >= 1 || !state.is(BlockTags.NEEDS_STONE_TOOL)))));
        }
        return false;
    }

    @Override
    public int getMaxDamage(){
        return this.toolMaterial.getDurability();
    }

    @Override
    public boolean canBeDepleted(){
        return true;
    }
}
