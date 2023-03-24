package com.supermartijn642.additionalblocks.stone.mixin;

import com.supermartijn642.additionalblocks.stone.blocks.custom.ABStairBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created 17/03/2023 by SuperMartijn642
 */
@Mixin(StairBlock.class)
public class StairBlockMixin {

    @Inject(
        method = "isStairs(Lnet/minecraft/world/level/block/state/BlockState;)Z",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void isStairs(BlockState state, CallbackInfoReturnable<Boolean> ci){
        if(state.getBlock() instanceof ABStairBlock)
            ci.setReturnValue(true);
    }
}
