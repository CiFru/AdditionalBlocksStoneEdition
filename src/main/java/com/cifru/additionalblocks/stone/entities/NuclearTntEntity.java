package com.cifru.additionalblocks.stone.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Optional;

/**
 * Created 08/04/2023 by SuperMartijn642
 */
public class NuclearTntEntity extends Entity {

    private static final DataParameter<Integer> DATA_FUSE = EntityDataManager.defineId(NuclearTntEntity.class, DataSerializers.INT);
    private static final DataParameter<Optional<BlockState>> DATA_BLOCK_STATE = EntityDataManager.defineId(NuclearTntEntity.class, DataSerializers.BLOCK_STATE);

    private final LivingEntity igniter;
    private int fuse = 80;
    private Optional<BlockState> blockState = Optional.empty();

    public NuclearTntEntity(EntityType<?> type, World level){
        super(type, level);
        this.igniter = null;
    }

    public NuclearTntEntity(World level, BlockPos pos, BlockState state, LivingEntity igniter){
        super(AdditionalBlocksEntities.NUCLEAR_TNT, level);
        this.blockState = Optional.of(state);
        this.entityData.set(DATA_BLOCK_STATE, this.blockState);
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

        this.fuse--;
        if(this.fuse <= 0){
            this.remove();
            if(!this.level.isClientSide){
                this.level.explode(this.igniter, this.getX(), this.getY(0.0625), this.getZ(), 10, Explosion.Mode.BREAK);
                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(this.level, this.getX(), this.getY(), this.getZ());
                cloud.setOwner(this.igniter);
                cloud.setRadius(5);
                cloud.setRadiusPerTick(0.02f);
                cloud.setWaitTime(4);
                cloud.addEffect(new EffectInstance(Effects.POISON, 100, 2, false, false, true));
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
        this.entityData.define(DATA_BLOCK_STATE, Optional.empty());
    }

    @Override
    protected boolean isMovementNoisy(){
        return false;
    }

    @Override
    public boolean isPickable(){
        return !this.removed;
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT data){
        this.fuse = data.getInt("fuse");
        this.entityData.set(DATA_FUSE, this.fuse);
        if(data.contains("block_state", Constants.NBT.TAG_COMPOUND))
            this.blockState = Optional.of(NBTUtil.readBlockState(data.getCompound("block_state")));
        else
            this.blockState = Optional.empty();
        this.entityData.set(DATA_BLOCK_STATE, this.blockState);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT data){
        data.putInt("fuse", this.fuse);
        this.entityData.get(DATA_BLOCK_STATE).ifPresent(state -> data.put("block_state", NBTUtil.writeBlockState(state)));
    }

    @Override
    protected float getEyeHeight(Pose pos, EntitySize dimensions){
        return 0.15f;
    }

    @Override
    public IPacket<?> getAddEntityPacket(){
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public int getFuse(){
        return this.entityData.get(DATA_FUSE);
    }

    public void setFuse(int fuse){
        this.entityData.set(DATA_FUSE, fuse);
        this.fuse = fuse;
    }

    @Override
    public void onSyncedDataUpdated(DataParameter<?> parameter){
        if(DATA_FUSE.equals(parameter))
            this.fuse = this.entityData.get(DATA_FUSE);
        super.onSyncedDataUpdated(parameter);
    }

    public BlockState getBlockState(){
        return this.entityData.get(DATA_BLOCK_STATE).orElseGet(Blocks.AIR::defaultBlockState);
    }
}
