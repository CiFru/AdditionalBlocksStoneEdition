package com.cifru.additionalblocks.stone.mixin;

import com.cifru.additionalblocks.stone.blocks.custom.ABStairBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
@Mixin(StairsBlock.class)
public class StairBlockMixin {

    @Inject(
        method = "isStairs(Lnet/minecraft/block/BlockState;)Z",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void isStairs(BlockState state, CallbackInfoReturnable<Boolean> ci){
        if(state.getBlock() instanceof ABStairBlock)
            ci.setReturnValue(true);
    }
}
