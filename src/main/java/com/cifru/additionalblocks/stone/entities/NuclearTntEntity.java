package com.cifru.additionalblocks.stone.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class NuclearTntEntity extends Entity implements TraceableEntity {

    private static final EntityDataAccessor<Integer> DATA_FUSE = SynchedEntityData.defineId(NuclearTntEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE = SynchedEntityData.defineId(NuclearTntEntity.class, EntityDataSerializers.BLOCK_STATE);

    private final LivingEntity igniter;

    public NuclearTntEntity(EntityType<?> type, Level level){
        super(type, level);
        this.igniter = null;
    }

    public NuclearTntEntity(Level level, BlockPos pos, BlockState state, LivingEntity igniter){
        super(AdditionalBlocksEntities.NUCLEAR_TNT, level);
        this.entityData.set(DATA_BLOCK_STATE, state);
        this.igniter = igniter;
        this.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        double momentum = level.random.nextDouble() * Math.PI * 2;
        this.setDeltaMovement(-Math.sin(momentum) * 0.02, 0.2, -Math.cos(momentum) * 0.02);
    }

    @Override
    public void tick(){
        if(!this.isNoGravity())
            this.setDeltaMovement(this.getDeltaMovement().add(0, -0.04, 0));

        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if(this.onGround)
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.7, -0.5, 0.7));

        int fuse = this.getFuse() - 1;
        this.setFuse(fuse);
        if(fuse <= 0){
            this.discard();
            if(!this.level.isClientSide){
                this.level.explode(this, this.getX(), this.getY(0.0625), this.getZ(), 10, Level.ExplosionInteraction.TNT);
                AreaEffectCloud cloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
                cloud.setOwner(this.igniter);
                cloud.setRadius(5);
                cloud.setRadiusPerTick(0.02f);
                cloud.setWaitTime(4);
                cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 2, false, false, true));
                this.level.addFreshEntity(cloud);
            }
        }else{
            this.updateInWaterStateAndDoFluidPushing();
            if(this.level.isClientSide)
                this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0, 0, 0);
        }
    }

    @Override
    protected void defineSynchedData(){
        this.entityData.define(DATA_FUSE, 80);
        this.entityData.define(DATA_BLOCK_STATE, Blocks.AIR.defaultBlockState());
    }

    @Override
    protected MovementEmission getMovementEmission(){
        return MovementEmission.NONE;
    }

    @Override
    public boolean isPickable(){
        return !this.isRemoved();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag data){
        this.entityData.set(DATA_FUSE, data.getInt("fuse"));
        this.entityData.set(DATA_BLOCK_STATE, NbtUtils.readBlockState(this.level.holderLookup(Registries.BLOCK), data.getCompound("block_state")));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag data){
        data.putInt("fuse", this.entityData.get(DATA_FUSE));
        data.put("block_state", NbtUtils.writeBlockState(this.entityData.get(DATA_BLOCK_STATE)));
    }

    @Nullable
    @Override
    public Entity getOwner(){
        return this.igniter;
    }

    @Override
    protected float getEyeHeight(Pose pos, EntityDimensions dimensions){
        return 0.15f;
    }

    public int getFuse(){
        return this.entityData.get(DATA_FUSE);
    }

    public void setFuse(int fuse){
        this.entityData.set(DATA_FUSE, fuse);
    }

    public BlockState getBlockState(){
        return this.entityData.get(DATA_BLOCK_STATE);
    }
}
