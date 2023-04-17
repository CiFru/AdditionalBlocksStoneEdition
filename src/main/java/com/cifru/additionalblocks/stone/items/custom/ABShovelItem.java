package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABShovelItem extends ABToolItem {

    public ABShovelItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.SHOVEL);
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        if(context.getClickedFace() != Direction.DOWN){
            Player player = context.getPlayer();
            BlockState flattenedState = ShovelItem.FLATTENABLES.get(state.getBlock());
            BlockState resultState = null;
            if(flattenedState != null && level.getBlockState(pos.above()).isAir()){
                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultState = flattenedState;
            }else if(state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)){
                if(!level.isClientSide())
                    level.levelEvent(null, 1009, pos, 0);

                CampfireBlock.dowse(player, level, pos, state);
                resultState = state.setValue(CampfireBlock.LIT, false);
            }

            if(resultState != null){
                if(!level.isClientSide){
                    level.setBlock(pos, resultState, 11);
                    if(player != null)
                        context.getItemInHand().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(context.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }
}
