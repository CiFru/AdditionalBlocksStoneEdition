package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.block.BlockShape;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

/**
 * Created 16/03/2023 by SuperMartijn642
 */
public class ABWallBlock extends BaseBlock implements IWaterLoggable {

    private static final BlockShape[] SHAPES = createShapes(14, 16), COLLISION_SHAPES = createShapes(24, 24);
    private static final BlockShape POST_TEST = BlockShape.createBlockShape(7, 0, 7, 9, 16, 9);
    private static final BlockShape NORTH_TEST = BlockShape.createBlockShape(7, 0, 0, 9, 16, 9);
    private static final BlockShape SOUTH_TEST = BlockShape.createBlockShape(7, 0, 7, 9, 16, 16);
    private static final BlockShape WEST_TEST = BlockShape.createBlockShape(0, 0, 7, 9, 16, 9);
    private static final BlockShape EAST_TEST = BlockShape.createBlockShape(7, 0, 7, 16, 16, 9);

    private static BlockShape[] createShapes(int lowHeight, int tallHeight){
        // Create the separate parts
        BlockShape postShape = BlockShape.createBlockShape(4, 0, 4, 12, tallHeight, 12);
        BlockShape northLow = BlockShape.createBlockShape(5, 0, 0, 11, lowHeight, 11);
        BlockShape northTall = BlockShape.createBlockShape(5, 0, 0, 11, tallHeight, 11);
        BlockShape eastLow = BlockShape.createBlockShape(5, 0, 5, 16, lowHeight, 11);
        BlockShape eastTall = BlockShape.createBlockShape(5, 0, 5, 16, tallHeight, 11);
        BlockShape southLow = BlockShape.createBlockShape(5, 0, 5, 11, lowHeight, 16);
        BlockShape southTall = BlockShape.createBlockShape(5, 0, 5, 11, tallHeight, 16);
        BlockShape westLow = BlockShape.createBlockShape(0, 0, 5, 11, lowHeight, 11);
        BlockShape westTall = BlockShape.createBlockShape(0, 0, 5, 11, tallHeight, 11);
        // Combine the shapes
        BlockShape[] shapes = new BlockShape[162];
        for(Boolean post : ABBlockProperties.WALL_POST.getPossibleValues()){
            for(WallHeight north : ABBlockProperties.WALL_NORTH.getPossibleValues()){
                for(WallHeight east : ABBlockProperties.WALL_EAST.getPossibleValues()){
                    for(WallHeight south : ABBlockProperties.WALL_SOUTH.getPossibleValues()){
                        for(WallHeight west : ABBlockProperties.WALL_WEST.getPossibleValues()){
                            BlockShape shape = BlockShape.empty();
                            if(post) shape = BlockShape.or(shape, postShape);
                            if(north == WallHeight.LOW) shape = BlockShape.or(shape, northLow);
                            if(north == WallHeight.TALL) shape = BlockShape.or(shape, northTall);
                            if(east == WallHeight.LOW) shape = BlockShape.or(shape, eastLow);
                            if(east == WallHeight.TALL) shape = BlockShape.or(shape, eastTall);
                            if(south == WallHeight.LOW) shape = BlockShape.or(shape, southLow);
                            if(south == WallHeight.TALL) shape = BlockShape.or(shape, southTall);
                            if(west == WallHeight.LOW) shape = BlockShape.or(shape, westLow);
                            if(west == WallHeight.TALL) shape = BlockShape.or(shape, westTall);
                            shapes[getShapeIndex(post, north, east, south, west)] = shape;
                        }
                    }
                }
            }
        }
        return shapes;
    }

    private static int getShapeIndex(boolean post, WallHeight north, WallHeight east, WallHeight south, WallHeight west){
        return (post ? 1 : 0) + ((north.ordinal() + east.ordinal() * 3 + south.ordinal() * 9 + west.ordinal() * 27) << 1);
    }

    public ABWallBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.WALL_POST, false).setValue(ABBlockProperties.WALL_NORTH, WallHeight.NONE).setValue(ABBlockProperties.WALL_EAST, WallHeight.NONE).setValue(ABBlockProperties.WALL_SOUTH, WallHeight.NONE).setValue(ABBlockProperties.WALL_WEST, WallHeight.NONE).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return getProperState(context.getLevel(), this.defaultBlockState().setValue(ABBlockProperties.WATERLOGGED, waterlogged), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState otherState, IWorld level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return neighborSide == Direction.UP ? getProperState(level, state, pos) :
            neighborSide == Direction.DOWN ? state :
                getProperPost(level, pos, getProperConnection(level, pos, state, neighborSide, otherState));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld level, BlockPos pos, Rotation rotation){
        switch(rotation){
            case CLOCKWISE_180:
                return state.setValue(ABBlockProperties.WALL_NORTH, state.getValue(ABBlockProperties.WALL_SOUTH)).setValue(ABBlockProperties.WALL_EAST, state.getValue(ABBlockProperties.WALL_WEST)).setValue(ABBlockProperties.WALL_SOUTH, state.getValue(ABBlockProperties.WALL_NORTH)).setValue(ABBlockProperties.WALL_WEST, state.getValue(ABBlockProperties.WALL_EAST));
            case COUNTERCLOCKWISE_90:
                return state.setValue(ABBlockProperties.WALL_NORTH, state.getValue(ABBlockProperties.WALL_EAST)).setValue(ABBlockProperties.WALL_EAST, state.getValue(ABBlockProperties.WALL_SOUTH)).setValue(ABBlockProperties.WALL_SOUTH, state.getValue(ABBlockProperties.WALL_WEST)).setValue(ABBlockProperties.WALL_WEST, state.getValue(ABBlockProperties.WALL_NORTH));
            case CLOCKWISE_90:
                return state.setValue(ABBlockProperties.WALL_NORTH, state.getValue(ABBlockProperties.WALL_WEST)).setValue(ABBlockProperties.WALL_EAST, state.getValue(ABBlockProperties.WALL_NORTH)).setValue(ABBlockProperties.WALL_SOUTH, state.getValue(ABBlockProperties.WALL_EAST)).setValue(ABBlockProperties.WALL_WEST, state.getValue(ABBlockProperties.WALL_SOUTH));
            default:
                return state;
        }
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror){
        return mirror == Mirror.FRONT_BACK ? state.setValue(ABBlockProperties.WALL_EAST, state.getValue(ABBlockProperties.WALL_EAST)).setValue(ABBlockProperties.WALL_WEST, state.getValue(ABBlockProperties.WALL_EAST)) :
            mirror == Mirror.LEFT_RIGHT ? state.setValue(ABBlockProperties.WALL_NORTH, state.getValue(ABBlockProperties.WALL_SOUTH)).setValue(ABBlockProperties.WALL_SOUTH, state.getValue(ABBlockProperties.WALL_NORTH)) :
                state;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader level, BlockPos pos, ISelectionContext context){
        return SHAPES[getShapeIndex(state.getValue(ABBlockProperties.WALL_POST), state.getValue(ABBlockProperties.WALL_NORTH), state.getValue(ABBlockProperties.WALL_EAST), state.getValue(ABBlockProperties.WALL_SOUTH), state.getValue(ABBlockProperties.WALL_WEST))].getUnderlying();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader level, BlockPos pos, ISelectionContext context){
        return COLLISION_SHAPES[getShapeIndex(state.getValue(ABBlockProperties.WALL_POST), state.getValue(ABBlockProperties.WALL_NORTH), state.getValue(ABBlockProperties.WALL_EAST), state.getValue(ABBlockProperties.WALL_SOUTH), state.getValue(ABBlockProperties.WALL_WEST))].getUnderlying();
    }

    @Override
    public FluidState getFluidState(BlockState state){
        return state.getValue(ABBlockProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader level, BlockPos pos){
        return !state.getValue(ABBlockProperties.WATERLOGGED);
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader level, BlockPos pos, PathType pathType){
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.WALL_POST, ABBlockProperties.WALL_NORTH, ABBlockProperties.WALL_EAST, ABBlockProperties.WALL_SOUTH, ABBlockProperties.WALL_WEST, ABBlockProperties.WATERLOGGED);
    }

    private static BlockState getProperState(IBlockReader level, BlockState currentState, BlockPos pos){
        return getProperPost(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, currentState, Direction.NORTH, level.getBlockState(pos.north())), Direction.EAST, level.getBlockState(pos.east())), Direction.SOUTH, level.getBlockState(pos.south())), Direction.WEST, level.getBlockState(pos.west())));
    }

    private static BlockState getProperConnection(IBlockReader level, BlockPos pos, BlockState currentState, Direction side, BlockState sideState){
        if(side == Direction.UP || side == Direction.DOWN)
            return currentState;

        // Find the correct property
        EnumProperty<WallHeight> property = side == Direction.NORTH ? ABBlockProperties.WALL_NORTH
            : side == Direction.EAST ? ABBlockProperties.WALL_EAST
            : side == Direction.SOUTH ? ABBlockProperties.WALL_SOUTH
            : ABBlockProperties.WALL_WEST;

        // Update the given side
        boolean shouldConnect = (sideState.getBlock() instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(sideState, side.getOpposite()))
            || sideState.getBlock() instanceof PaneBlock || sideState.is(BlockTags.WALLS)
            || (!WallBlock.isExceptionForConnection(sideState.getBlock()) && sideState.isFaceSturdy(level, pos.relative(side), side.getOpposite()));
        if(shouldConnect){
            BlockShape testShape = side == Direction.NORTH ? NORTH_TEST
                : side == Direction.EAST ? EAST_TEST
                : side == Direction.SOUTH ? SOUTH_TEST
                : WEST_TEST;
            boolean coversSideTop = VoxelShapes.joinIsNotEmpty(level.getBlockState(pos.above()).getCollisionShape(level, pos.above()).getFaceShape(Direction.DOWN), testShape.getUnderlying(), IBooleanFunction.ONLY_FIRST);
            return currentState.setValue(property, coversSideTop ? WallHeight.TALL : WallHeight.LOW);
        }
        return currentState.setValue(property, WallHeight.NONE);
    }

    private static BlockState getProperPost(IBlockReader level, BlockPos pos, BlockState currentState){
        WallHeight north = currentState.getValue(ABBlockProperties.WALL_NORTH);
        WallHeight east = currentState.getValue(ABBlockProperties.WALL_EAST);
        WallHeight south = currentState.getValue(ABBlockProperties.WALL_SOUTH);
        WallHeight west = currentState.getValue(ABBlockProperties.WALL_WEST);
        boolean northDisconnected = north == WallHeight.NONE;
        boolean eastDisconnected = east == WallHeight.NONE;
        boolean southDisconnected = south == WallHeight.NONE;
        boolean westDisconnected = west == WallHeight.NONE;
        if((northDisconnected && eastDisconnected && southDisconnected && westDisconnected) || northDisconnected != southDisconnected || eastDisconnected != westDisconnected)
            return currentState.setValue(ABBlockProperties.WALL_POST, true);
        if((north == WallHeight.TALL && south == WallHeight.TALL) || (east == WallHeight.TALL && west == WallHeight.TALL))
            return currentState.setValue(ABBlockProperties.WALL_POST, false);
        BlockState stateAbove = level.getBlockState(pos.above());
        return currentState.setValue(ABBlockProperties.WALL_POST, stateAbove.is(BlockTags.WALL_POST_OVERRIDE) || VoxelShapes.joinIsNotEmpty(stateAbove.getCollisionShape(level, pos.above()).getFaceShape(Direction.DOWN), POST_TEST.getUnderlying(), IBooleanFunction.ONLY_FIRST));
    }
}
