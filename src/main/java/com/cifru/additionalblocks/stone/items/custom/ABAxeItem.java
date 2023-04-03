package com.cifru.additionalblocks.stone.items.custom;

import com.cifru.additionalblocks.stone.tools.ABToolMaterial;
import com.cifru.additionalblocks.stone.tools.ToolType;
import com.supermartijn642.core.item.ItemProperties;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ABAxeItem extends ABToolItem {

    public ABAxeItem(ItemProperties properties, Supplier<Boolean> enabled, ABToolMaterial toolMaterial){
        super(properties, enabled, toolMaterial, ToolType.AXE);
    }

    @Override
    public InteractionFeedback interactWithBlock(ItemStack stack, PlayerEntity player, Hand hand, World level, BlockPos hitPos, Direction hitSide, Vector3d hitLocation){
        BlockState state = level.getBlockState(hitPos);
        BlockState modifiedState = state.getToolModifiedState(level, hitPos, player, stack, net.minecraftforge.common.ToolType.AXE);
        if(modifiedState != null){
            level.playSound(player, hitPos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1, 1);
            if(!level.isClientSide){
                level.setBlock(hitPos, modifiedState, 11);
                if(player != null)
                    stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(hand));
            }
            return InteractionFeedback.SUCCESS;
        }
        return InteractionFeedback.PASS;
    }
}
