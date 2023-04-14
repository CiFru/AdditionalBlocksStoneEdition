package com.cifru.additionalblocks.stone.mixin;

import com.cifru.additionalblocks.stone.blocks.custom.ABGlassPaneBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created 14/04/2023 by SuperMartijn642
 */
@Mixin(IronBarsBlock.class)
public class IronBarsBlockMixin {

    @Inject(
        method = "attachsTo(Lnet/minecraft/world/level/block/state/BlockState;Z)Z",
        at = @At("HEAD"),
        cancellable = true
    )
    private void attachesTo(BlockState state, boolean isSturdy, CallbackInfoReturnable<Boolean> ci){
        if(state.getBlock() instanceof ABGlassPaneBlock)
            ci.setReturnValue(true);
    }
}
