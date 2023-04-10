package com.cifru.additionalblocks.stone.items.custom;

import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class ABNuclearItem extends ABItem {

    public ABNuclearItem(ItemProperties properties, Supplier<Boolean> enabled){
        super(properties, enabled);
    }

    @Override
    public void inventoryUpdate(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof LivingEntity) {
            MobEffectInstance currentEffect = ((LivingEntity) entity).getEffect(MobEffects.POISON);
            if (currentEffect == null || (!currentEffect.isInfiniteDuration() && currentEffect.getDuration() < 2))
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 10, 2, true, true, true));
        }
    }
}
