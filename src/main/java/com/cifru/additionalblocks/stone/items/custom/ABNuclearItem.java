package com.cifru.additionalblocks.stone.items.custom;

import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class ABNuclearItem extends ABItem {

    public ABNuclearItem(ItemProperties properties, Supplier<Boolean> enabled){
        super(properties, enabled);
    }

    @Override
    public void inventoryUpdate(ItemStack stack, World level, Entity entity, int itemSlot, boolean isSelected){
        if(entity instanceof LivingEntity){
            EffectInstance currentEffect = ((LivingEntity)entity).getEffect(Effects.POISON);
            if(currentEffect == null || currentEffect.getDuration() < 2)
                ((LivingEntity)entity).addEffect(new EffectInstance(Effects.POISON, 10, 2, true, true, true));
        }
    }
}
