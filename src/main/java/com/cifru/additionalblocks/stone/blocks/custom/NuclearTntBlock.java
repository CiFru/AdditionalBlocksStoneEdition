package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.entities.NuclearTntEntity;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

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
    protected InteractionFeedback interact(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, Direction hitSide, Vector3d hitLocation){
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if(item instanceof FlintAndSteelItem || stack.getItem() == Items.FIRE_CHARGE){
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

    private void ignite(World level, BlockPos pos, BlockState state, LivingEntity igniter, boolean randomFuseTime){
        if(level.getBlockState(pos).is(this))
            level.removeBlock(pos, false);
        if(!level.isClientSide){
            NuclearTntEntity tnt = new NuclearTntEntity(level, pos, state, igniter);
            if(randomFuseTime)
                tnt.setFuse(level.random.nextInt(tnt.getFuse() / 4) + tnt.getFuse() / 8);
            level.addFreshEntity(tnt);
            level.playSound(null, tnt.getX(), tnt.getY(), tnt.getZ(), SoundEvents.TNT_PRIMED, SoundCategory.BLOCKS, 1, 1);
        }
    }

    @Override
    public void catchFire(BlockState state, World level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter){
        this.ignite(level, pos, state, igniter, false);
    }

    @Override
    public void onPlace(BlockState state, World level, BlockPos pos, BlockState oldState, boolean bl){
        if(!oldState.is(state.getBlock()) && level.hasNeighborSignal(pos))
            this.ignite(level, pos, state, null, false);
    }

    @Override
    public void neighborChanged(BlockState state, World level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean bl){
        if(level.hasNeighborSignal(pos))
            this.ignite(level, pos, state, null, false);
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, bl);
    }

    @Override
    public void wasExploded(World level, BlockPos pos, Explosion explosion){
        this.ignite(level, pos, this.defaultBlockState(), explosion.getSourceMob(), true);
    }

    @Override
    public void onProjectileHit(World level, BlockState state, BlockRayTraceResult hitResult, ProjectileEntity projectile){
        if(!level.isClientSide){
            BlockPos pos = hitResult.getBlockPos();
            if(projectile.isOnFire()){
                Entity owner = projectile.getOwner();
                this.ignite(level, pos, state, owner instanceof LivingEntity ? ((LivingEntity)owner) : null, false);
            }
        }
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader level, BlockPos pos, Explosion explosion){
        return false;
    }
}
