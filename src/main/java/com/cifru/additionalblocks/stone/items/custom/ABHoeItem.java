package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.mojang.datafixers.util.Pair;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABHoeItem extends ABToolItem {

    public ABHoeItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.HOE);
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Pair<Predicate<UseOnContext>,Consumer<UseOnContext>> pair = HoeItem.TILLABLES.get(level.getBlockState(pos).getBlock());
        if(pair != null && pair.getFirst().test(context)){
            Player player = context.getPlayer();
            level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(!level.isClientSide){
                pair.getSecond().accept(context);
                if(player != null)
                    context.getItemInHand().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(context.getHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }else
            return InteractionResult.PASS;
    }
}
