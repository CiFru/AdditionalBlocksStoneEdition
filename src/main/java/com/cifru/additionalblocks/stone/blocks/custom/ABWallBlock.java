package com.cifru.additionalblocks.stone.blocks.custom;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.supermartijn642.core.block.BaseBlock;
import com.supermartijn642.core.block.BlockProperties;
import com.supermartijn642.core.block.BlockShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * Created 16/03/2023 by SuperMartijn642
 */
public class ABWallBlock extends BaseBlock implements SimpleWaterloggedBlock {

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
            for(WallSide north : ABBlockProperties.WALL_NORTH.getPossibleValues()){
                for(WallSide east : ABBlockProperties.WALL_EAST.getPossibleValues()){
                    for(WallSide south : ABBlockProperties.WALL_SOUTH.getPossibleValues()){
                        for(WallSide west : ABBlockProperties.WALL_WEST.getPossibleValues()){
                            BlockShape shape = BlockShape.empty();
                            if(post) shape = BlockShape.or(shape, postShape);
                            if(north == WallSide.LOW) shape = BlockShape.or(shape, northLow);
                            if(north == WallSide.TALL) shape = BlockShape.or(shape, northTall);
                            if(east == WallSide.LOW) shape = BlockShape.or(shape, eastLow);
                            if(east == WallSide.TALL) shape = BlockShape.or(shape, eastTall);
                            if(south == WallSide.LOW) shape = BlockShape.or(shape, southLow);
                            if(south == WallSide.TALL) shape = BlockShape.or(shape, southTall);
                            if(west == WallSide.LOW) shape = BlockShape.or(shape, westLow);
                            if(west == WallSide.TALL) shape = BlockShape.or(shape, westTall);
                            shapes[getShapeIndex(post, north, east, south, west)] = shape;
                        }
                    }
                }
            }
        }
        return shapes;
    }

    private static int getShapeIndex(boolean post, WallSide north, WallSide east, WallSide south, WallSide west){
        return (post ? 1 : 0) + ((north.ordinal() + east.ordinal() * 3 + south.ordinal() * 9 + west.ordinal() * 27) << 1);
    }

    public ABWallBlock(BlockProperties properties){
        super(false, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ABBlockProperties.WALL_POST, false).setValue(ABBlockProperties.WALL_NORTH, WallSide.NONE).setValue(ABBlockProperties.WALL_EAST, WallSide.NONE).setValue(ABBlockProperties.WALL_SOUTH, WallSide.NONE).setValue(ABBlockProperties.WALL_WEST, WallSide.NONE).setValue(ABBlockProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return getProperState(context.getLevel(), this.defaultBlockState().setValue(ABBlockProperties.WATERLOGGED, waterlogged), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborSide, BlockState otherState, LevelAccessor level, BlockPos pos, BlockPos neighborPos){
        if(state.getValue(ABBlockProperties.WATERLOGGED))
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return neighborSide == Direction.UP ? getProperState(level, state, pos) :
            neighborSide == Direction.DOWN ? state :
                getProperPost(level, pos, getProperConnection(level, pos, state, neighborSide, otherState));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation){
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
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        return SHAPES[getShapeIndex(state.getValue(ABBlockProperties.WALL_POST), state.getValue(ABBlockProperties.WALL_NORTH), state.getValue(ABBlockProperties.WALL_EAST), state.getValue(ABBlockProperties.WALL_SOUTH), state.getValue(ABBlockProperties.WALL_WEST))].getUnderlying();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context){
        return COLLISION_SHAPES[getShapeIndex(state.getValue(ABBlockProperties.WALL_POST), state.getValue(ABBlockProperties.WALL_NORTH), state.getValue(ABBlockProperties.WALL_EAST), state.getValue(ABBlockProperties.WALL_SOUTH), state.getValue(ABBlockProperties.WALL_WEST))].getUnderlying();
    }

    @Override
    public FluidState getFluidState(BlockState state){
        return state.getValue(ABBlockProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos){
        return !state.getValue(ABBlockProperties.WATERLOGGED);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathType){
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> builder){
        builder.add(ABBlockProperties.WALL_POST, ABBlockProperties.WALL_NORTH, ABBlockProperties.WALL_EAST, ABBlockProperties.WALL_SOUTH, ABBlockProperties.WALL_WEST, ABBlockProperties.WATERLOGGED);
    }

    private static BlockState getProperState(BlockGetter level, BlockState currentState, BlockPos pos){
        return getProperPost(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, getProperConnection(level, pos, currentState, Direction.NORTH, level.getBlockState(pos.north())), Direction.EAST, level.getBlockState(pos.east())), Direction.SOUTH, level.getBlockState(pos.south())), Direction.WEST, level.getBlockState(pos.west())));
    }

    private static BlockState getProperConnection(BlockGetter level, BlockPos pos, BlockState currentState, Direction side, BlockState sideState){
        if(side == Direction.UP || side == Direction.DOWN)
            return currentState;

        // Find the correct property
        EnumProperty<WallSide> property = side == Direction.NORTH ? ABBlockProperties.WALL_NORTH
            : side == Direction.EAST ? ABBlockProperties.WALL_EAST
            : side == Direction.SOUTH ? ABBlockProperties.WALL_SOUTH
            : ABBlockProperties.WALL_WEST;

        // Update the given side
        boolean shouldConnect = (sideState.getBlock() instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(sideState, side.getOpposite()))
            || sideState.getBlock() instanceof IronBarsBlock || sideState.is(BlockTags.WALLS)
            || (!WallBlock.isExceptionForConnection(sideState) && sideState.isFaceSturdy(level, pos.relative(side), side.getOpposite()));
        if(shouldConnect){
            BlockShape testShape = side == Direction.NORTH ? NORTH_TEST
                : side == Direction.EAST ? EAST_TEST
                : side == Direction.SOUTH ? SOUTH_TEST
                : WEST_TEST;
            boolean coversSideTop = Shapes.joinIsNotEmpty(level.getBlockState(pos.above()).getCollisionShape(level, pos.above()).getFaceShape(Direction.DOWN), testShape.getUnderlying(), BooleanOp.ONLY_FIRST);
            return currentState.setValue(property, coversSideTop ? WallSide.TALL : WallSide.LOW);
        }
        return currentState.setValue(property, WallSide.NONE);
    }

    private static BlockState getProperPost(BlockGetter level, BlockPos pos, BlockState currentState){
        WallSide north = currentState.getValue(ABBlockProperties.WALL_NORTH);
        WallSide east = currentState.getValue(ABBlockProperties.WALL_EAST);
        WallSide south = currentState.getValue(ABBlockProperties.WALL_SOUTH);
        WallSide west = currentState.getValue(ABBlockProperties.WALL_WEST);
        boolean northDisconnected = north == WallSide.NONE;
        boolean eastDisconnected = east == WallSide.NONE;
        boolean southDisconnected = south == WallSide.NONE;
        boolean westDisconnected = west == WallSide.NONE;
        if((northDisconnected && eastDisconnected && southDisconnected && westDisconnected) || northDisconnected != southDisconnected || eastDisconnected != westDisconnected)
            return currentState.setValue(ABBlockProperties.WALL_POST, true);
        if((north == WallSide.TALL && south == WallSide.TALL) || (east == WallSide.TALL && west == WallSide.TALL))
            return currentState.setValue(ABBlockProperties.WALL_POST, false);
        BlockState stateAbove = level.getBlockState(pos.above());
        return currentState.setValue(ABBlockProperties.WALL_POST, stateAbove.is(BlockTags.WALL_POST_OVERRIDE) || Shapes.joinIsNotEmpty(stateAbove.getCollisionShape(level, pos.above()).getFaceShape(Direction.DOWN), POST_TEST.getUnderlying(), BooleanOp.ONLY_FIRST));
    }
}
