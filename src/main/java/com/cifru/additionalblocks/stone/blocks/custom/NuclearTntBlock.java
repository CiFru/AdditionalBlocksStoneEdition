package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.entities.NuclearTntEntity;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class NuclearTntBlock extends BaseBlock {

    public NuclearTntBlock(BlockProperties properties){
        super(false, properties);
        ((FireBlock)Blocks.FIRE).setFlammable(this, 15, 100);
    }

    @Override
    protected InteractionFeedback interact(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, Direction hitSide, Vec3 hitLocation){
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if(item instanceof FlintAndSteelItem || stack.is(Items.FIRE_CHARGE)){
            this.ignite(level, pos, state, player, false);
            if(!player.isCreative()){
                if(item instanceof FlintAndSteelItem)
                    stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(hand));
                else
                    stack.shrink(1);
            }
            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionFeedback.SUCCESS;
        }
        return super.interact(state, level, pos, player, hand, hitSide, hitLocation);
    }

    private void ignite(Level level, BlockPos pos, BlockState state, LivingEntity igniter, boolean randomFuseTime){
        if(level.getBlockState(pos).is(this))
            level.removeBlock(pos, false);
        if(!level.isClientSide){
            NuclearTntEntity tnt = new NuclearTntEntity(level, pos, state, igniter);
            if(randomFuseTime)
                tnt.setFuse(level.random.nextInt(tnt.getFuse() / 4) + tnt.getFuse() / 8);
            level.addFreshEntity(tnt);
            level.playSound(null, tnt.getX(), tnt.getY(), tnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1, 1);
            level.gameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }

    @Override
    public void catchFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter){
        this.ignite(level, pos, state, igniter, false);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean bl){
        if(!oldState.is(state.getBlock()) && level.hasNeighborSignal(pos))
            this.ignite(level, pos, state, null, false);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean bl){
        if(level.hasNeighborSignal(pos))
            this.ignite(level, pos, state, null, false);
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, bl);
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion){
        this.ignite(level, pos, this.defaultBlockState(), explosion.getSourceMob(), true);
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hitResult, Projectile projectile){
        if(!level.isClientSide){
            BlockPos pos = hitResult.getBlockPos();
            if(projectile.isOnFire() && projectile.mayInteract(level, pos)){
                Entity owner = projectile.getOwner();
                this.ignite(level, pos, state, owner instanceof LivingEntity ? ((LivingEntity)owner) : null, false);
            }
        }
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion){
        return false;
    }
}
