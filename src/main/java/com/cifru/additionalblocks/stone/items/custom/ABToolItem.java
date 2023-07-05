package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABToolItem extends ABItem {

    private final ABToolMaterial toolMaterial;
    private final ToolType toolType;
    private final Multimap<Attribute,AttributeModifier> defaultModifiers;
    private final Set<net.minecraftforge.common.ToolType> forgeToolTypes;

    public ABToolItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial, ToolType toolType){
        super(properties.maxStackSize(1).durability(toolMaterial.getDurability()), enabled);
        this.toolMaterial = toolMaterial;
        this.toolType = toolType;
        ImmutableMultimap.Builder<Attribute,AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", toolType.getBaseAttackDamage() + toolMaterial.getAttackDamage(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", toolType.getBaseAttackSpeed(), AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
        net.minecraftforge.common.ToolType forgeToolType =
            toolType == ToolType.AXE ? net.minecraftforge.common.ToolType.AXE :
                toolType == ToolType.HOE ? net.minecraftforge.common.ToolType.HOE :
                    toolType == ToolType.SHOVEL ? net.minecraftforge.common.ToolType.SHOVEL :
                        toolType == ToolType.PICKAXE ? net.minecraftforge.common.ToolType.PICKAXE : null;
        this.forgeToolTypes = forgeToolType == null ? Collections.emptySet() : Collections.singleton(forgeToolType);
    }

    @Override
    public int getEnchantmentValue(){
        return this.toolMaterial.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient){
        return ingredient.getItem() == this.toolMaterial.getRepairItem().get();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        return this.forgeToolTypes.stream().anyMatch(state::isToolEffective) ? this.toolMaterial.getMiningSpeed() : 1;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity user, LivingEntity enemy){
        stack.hurtAndBreak(2, enemy, entity -> entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, World level, BlockState state, BlockPos pos, LivingEntity entity){
        if(!level.isClientSide && state.getDestroySpeed(level, pos) != 0)
            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public Multimap<Attribute,AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slot){
        return slot == EquipmentSlotType.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state){
        return this.forgeToolTypes.stream().anyMatch(state::isToolEffective) && this.toolMaterial.getMiningTier().getVanillaTier().getLevel() >= state.getHarvestLevel();
    }

    @Override
    public Set<net.minecraftforge.common.ToolType> getToolTypes(ItemStack stack){
        return this.forgeToolTypes;
    }

    @Override
    public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState){
        return this.forgeToolTypes.contains(tool) ? this.toolMaterial.getMiningTier().getVanillaTier().getLevel() : -1;
    }
}
