package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABHoeItem extends ABToolItem {

    public ABHoeItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.HOE);
    }

    public ActionResultType useOn(ItemUseContext context){
        int hook = ForgeEventFactory.onHoeUse(context);
        if(hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;

        World level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        if(context.getClickedFace() != Direction.DOWN && level.isEmptyBlock(pos.above())){
            BlockState modifiedState = level.getBlockState(pos).getToolModifiedState(level, pos, context.getPlayer(), context.getItemInHand(), net.minecraftforge.common.ToolType.HOE);
            if(modifiedState != null){
                PlayerEntity player = context.getPlayer();
                level.playSound(player, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1, 1);
                if(!level.isClientSide){
                    level.setBlock(pos, modifiedState, 11);
                    if(player != null)
                        context.getItemInHand().hurtAndBreak(1, player, e -> e.broadcastBreakEvent(context.getHand()));
                }
                return ActionResultType.sidedSuccess(level.isClientSide);
            }
        }

        return ActionResultType.PASS;
    }
}
