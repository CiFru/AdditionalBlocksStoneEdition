package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.block.BlockShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created 14/04/2023 by SuperMartijn642
 */
public class ABGlassPaneBlock extends BaseBlock implements BeaconBeamBlock, SimpleWaterloggedBlock {

    private static final Map<Direction,BooleanProperty> PROPERTY_BY_DIRECTION = new EnumMap<>(Direction.class);
    private static final BlockShape[] SHAPES = new BlockShape[16];

    static{
        PROPERTY_BY_DIRECTION.put(Direction.NORTH, ABBlockProperties.CONNECTION_NORTH);
        PROPERTY_BY_DIRECTION.put(Direction.EAST, ABBlockProperties.CONNECTION_EAST);
        PROPERTY_BY_DIRECTION.put(Direction.SOUTH, ABBlockProperties.CONNECTION_SOUTH);
        PROPERTY_BY_DIRECTION.put(Direction.WEST, ABBlockProperties.CONNECTION_WEST);

        BlockShape postShape = BlockShape.createBlockShape(7, 0, 7, 9, 16, 9);
        BlockShape northShape = BlockShape.createBlockShape(7, 0, 0, 9, 16, 7);
        BlockShape eastShape = BlockShape.createBlockShape(9, 0, 7, 16, 16, 9);
        BlockShape southShape = BlockShape.createBlockShape(7, 0, 9, 9, 16, 16);
        BlockShape westShape = BlockShape.createBlockShape(0, 0, 7, 7, 16, 9);
        boolean[] booleans = {true, false};
        for(boolean north : booleans){
            for(boolean east : booleans){
                for(boolean south : booleans){
                    for(boolean west : booleans){
                        BlockShape shape = postShape;
                        if(north)
                            shape = BlockShape.or(shape, northShape);
                        if(east)
                            shape = BlockShape.or(shape, eastShape);
                        if(south)
                            shape = BlockShape.or(shape, southShape);
                        if(west)
                            shape = BlockShape.or(shape, westShape);
                        int index = stateIndex(north, east, south, west);
                        SHAPES[index] = shape;
                    }
                }
            }
        }
    }

    public ABGlassPaneBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.CONNECTION_NORTH, false).setValue(ABBlockProperties.CONNECTION_EAST, false).setValue(ABBlockProperties.CONNECTION_SOUTH, false).setValue(ABBlockProperties.CONNECTION_WEST, false).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        boolean waterlogged = level.getFluidState(pos).getType() == Fluids.WATER;
        BlockState state = this.defaultBlockState().setValue(ABBlockProperties.WATERLOGGED, waterlogged);
        for(Map.Entry<Direction,BooleanProperty> side : PROPERTY_BY_DIRECTION.entrySet()){
            BlockPos sidePos = pos.relative(side.getKey());
            BlockState sideState = level.getBlockState(sidePos);
            state = state.setValue(side.getValue(), attachesTo(sideState, sideState.isFaceSturdy(level, sidePos, side.getKey().getOpposite())));
        }
        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return neighborSide.getAxis().isHorizontal() ?
            state.setValue(PROPERTY_BY_DIRECTION.get(neighborSide), attachesTo(neighborState, neighborState.isFaceSturdy(level, neighborPos, neighborSide.getOpposite()))) :
            super.updateShape(state, neighborSide, neighborState, level, pos, neighborPos);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        boolean north = state.getValue(ABBlockProperties.CONNECTION_NORTH);
        boolean east = state.getValue(ABBlockProperties.CONNECTION_EAST);
        boolean south = state.getValue(ABBlockProperties.CONNECTION_SOUTH);
        boolean west = state.getValue(ABBlockProperties.CONNECTION_WEST);
        return SHAPES[stateIndex(north, east, south, west)].getUnderlying();
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        return Shapes.empty();
    }

    public boolean skipRendering(BlockState state, BlockState neighborState, Direction neighborSide){
        if(neighborState.is(this)){
            if(!neighborSide.getAxis().isHorizontal())
                return true;

            if(state.getValue(PROPERTY_BY_DIRECTION.get(neighborSide)) && neighborState.getValue(PROPERTY_BY_DIRECTION.get(neighborSide.getOpposite())))
                return true;
        }

        return super.skipRendering(state, neighborState, neighborSide);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos){
        return !state.getValue(ABBlockProperties.WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state){
        return state.getValue(ABBlockProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathType){
        return false;
    }

    @Override
    public DyeColor getColor(){
        return DyeColor.GREEN;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation rotation){
        if(rotation == Rotation.NONE)
            return state;
        BlockState newState = state;
        for(Map.Entry<Direction,BooleanProperty> side : PROPERTY_BY_DIRECTION.entrySet())
            newState = newState.setValue(PROPERTY_BY_DIRECTION.get(rotation.rotate(side.getKey())), state.getValue(side.getValue()));
        return newState;
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror){
        if(mirror == Mirror.LEFT_RIGHT)
            return state.setValue(ABBlockProperties.CONNECTION_NORTH, state.getValue(ABBlockProperties.CONNECTION_SOUTH)).setValue(ABBlockProperties.CONNECTION_SOUTH, state.getValue(ABBlockProperties.CONNECTION_NORTH));
        if(mirror == Mirror.FRONT_BACK)
            return state.setValue(ABBlockProperties.CONNECTION_EAST, state.getValue(ABBlockProperties.CONNECTION_WEST)).setValue(ABBlockProperties.CONNECTION_WEST, state.getValue(ABBlockProperties.CONNECTION_EAST));
        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.CONNECTION_NORTH,
            ABBlockProperties.CONNECTION_EAST,
            ABBlockProperties.CONNECTION_SOUTH,
            ABBlockProperties.CONNECTION_WEST,
            ABBlockProperties.WATERLOGGED);
    }

    private static boolean attachesTo(BlockState state, boolean isSturdy){
        return !isExceptionForConnection(state) && (isSturdy || state.getBlock() instanceof IronBarsBlock || state.getBlock() instanceof ABGlassPaneBlock || state.is(BlockTags.WALLS));
    }

    private static int stateIndex(boolean north, boolean east, boolean south, boolean west){
        int i = 0;
        if(north)
            i |= 1;
        if(east)
            i |= 2;
        if(west)
            i |= 4;
        if(south)
            i |= 8;
        return i;
    }
}
