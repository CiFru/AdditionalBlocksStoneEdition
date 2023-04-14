package com.cifru.additionalblocks.stone.generators;

import com.cifru.additionalblocks.stone.blocks.ABBlockProperties;
import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.supermartijn642.core.generator.BlockStateGenerator;
import com.supermartijn642.core.generator.ResourceCache;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.block.state.properties.WallSide;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created 10/03/2023 by SuperMartijn642
 */
public class ABBlockStateGenerator extends BlockStateGenerator {

    public static final BlockPreset SIMPLE = (generator, blockType) -> generator.blockState(blockType.getBlock()).emptyVariant(variant -> variant.model(blockType.getIdentifier().getNamespace(), "block/" + blockType.getIdentifier().getPath()));
    public static final BlockPreset SLAB = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        PartialBlockState topState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.SLAB_TYPE, SlabType.TOP).build();
        PartialBlockState bottomState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.SLAB_TYPE, SlabType.BOTTOM).build();
        PartialBlockState fullState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.SLAB_TYPE, SlabType.DOUBLE).build();
        generator.blockState(blockType.getBlock())
            .variant(topState, variant -> variant.model(namespace, "block/" + identifier + "_top"))
            .variant(bottomState, variant -> variant.model(namespace, "block/" + identifier + "_bottom"))
            .variant(fullState, variant -> variant.model(namespace, "block/" + identifier));
    };
    public static final BlockPreset STAIRS = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        generator.blockState(blockType.getBlock())
            .variantsForAllExcept((state, variant) -> {
                Direction facing = state.get(StairBlock.FACING);
                Half half = state.get(StairBlock.HALF);
                StairsShape shape = state.get(StairBlock.SHAPE);
                int yRotation = (int)facing.getClockWise().toYRot();
                if(shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT)
                    yRotation += 270;
                if(shape != StairsShape.STRAIGHT && half == Half.TOP)
                    yRotation += 90;
                yRotation %= 360;
                boolean uvLock = yRotation != 0 || half == Half.TOP; // Don't set uv lock for states that have no rotation
                String suffix = shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? "_inner" :
                    shape == StairsShape.OUTER_LEFT || shape == StairsShape.OUTER_RIGHT ? "_outer" : "";
                variant.model(namespace, "block/" + identifier + suffix, half == Half.TOP ? 180 : 0, yRotation, uvLock);
            }, ABBlockProperties.WATERLOGGED);
    };
    public static final BlockPreset WALL = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        generator.blockState(blockType.getBlock())
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_POST, true), variant -> variant.model(namespace, "block/" + identifier + "_post"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_NORTH, WallSide.LOW), variant -> variant.model(namespace, "block/" + identifier + "_side", 0, ((int)Direction.NORTH.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_EAST, WallSide.LOW), variant -> variant.model(namespace, "block/" + identifier + "_side", 0, ((int)Direction.EAST.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_SOUTH, WallSide.LOW), variant -> variant.model(namespace, "block/" + identifier + "_side", 0, ((int)Direction.SOUTH.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_WEST, WallSide.LOW), variant -> variant.model(namespace, "block/" + identifier + "_side", 0, ((int)Direction.WEST.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_NORTH, WallSide.TALL), variant -> variant.model(namespace, "block/" + identifier + "_side_tall", 0, ((int)Direction.NORTH.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_EAST, WallSide.TALL), variant -> variant.model(namespace, "block/" + identifier + "_side_tall", 0, ((int)Direction.EAST.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_SOUTH, WallSide.TALL), variant -> variant.model(namespace, "block/" + identifier + "_side_tall", 0, ((int)Direction.SOUTH.toYRot() + 180) % 360, true))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.WALL_WEST, WallSide.TALL), variant -> variant.model(namespace, "block/" + identifier + "_side_tall", 0, ((int)Direction.WEST.toYRot() + 180) % 360, true));
    };
    public static final BlockPreset PILLAR = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        PartialBlockState xState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.AXIS, Direction.Axis.X).build();
        PartialBlockState yState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.AXIS, Direction.Axis.Y).build();
        PartialBlockState zState = generator.createPartialStateBuilder(blockType.getBlock()).set(ABBlockProperties.AXIS, Direction.Axis.Z).build();
        generator.blockState(blockType.getBlock())
            .variant(xState, variant -> variant.model(namespace, "block/" + identifier, 90, 90))
            .variant(yState, variant -> variant.model(namespace, "block/" + identifier))
            .variant(zState, variant -> variant.model(namespace, "block/" + identifier, 90, 0));
    };
    public static final BlockPreset HORIZONTAL_ROTATION = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        generator.blockState(blockType.getBlock())
            .variantsForProperty(ABBlockProperties.HORIZONTAL_FACING, (state, variant) -> {
                Direction rotation = state.get(ABBlockProperties.HORIZONTAL_FACING);
                variant.model(namespace, "block/" + identifier, 0, (int)rotation.toYRot());
            });
    };
    public static final BlockPreset PANES = (generator, blockType) -> {
        String namespace = blockType.getIdentifier().getNamespace();
        String identifier = blockType.getIdentifier().getPath();
        generator.blockState(blockType.getBlock())
            .unconditionalMultipart(variant -> variant.model(namespace, "block/" + identifier + "_post"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_NORTH, true), variant -> variant.model(namespace, "block/" + identifier + "_side"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_NORTH, false), variant -> variant.model(namespace, "block/" + identifier + "_noside"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_EAST, true), variant -> variant.model(namespace, "block/" + identifier + "_side", 0, 90))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_EAST, false), variant -> variant.model(namespace, "block/" + identifier + "_noside_alt"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_SOUTH, true), variant -> variant.model(namespace, "block/" + identifier + "_side_alt"))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_SOUTH, false), variant -> variant.model(namespace, "block/" + identifier + "_noside_alt", 0, 90))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_WEST, true), variant -> variant.model(namespace, "block/" + identifier + "_side_alt", 0, 90))
            .multipart(condition -> condition.requireProperty(ABBlockProperties.CONNECTION_WEST, false), variant -> variant.model(namespace, "block/" + identifier + "_noside", 0, 270));
    };

    private final Map<BlockType<?>,Consumer<BlockType<?>>> builders = new HashMap<>();

    public ABBlockStateGenerator(ResourceCache cache){
        super("abstoneedition", cache);
        this.populateBuilders();
    }

    private void populateBuilders(){
        // Add block states manually
    }

    @Override
    public void generate(){
        // Generate block states for all blocks
        for(BlockType<?> blockType : AdditionalBlocksBlocks.ALL_BLOCKS){
            BlockPreset preset = blockType.getBlockStatePreset();
            Consumer<BlockType<?>> builder = this.builders.get(blockType);
            if(preset != null && builder != null)
                throw new IllegalStateException("Block type '" + blockType.getIdentifier() + "' has both a block state preset and a manual builder!");
            if(preset == null && builder == null)
                throw new IllegalStateException("Missing block state generator for block type '" + blockType.getIdentifier() + "'!");

            if(preset != null)
                preset.createBlockState(this, blockType);
            if(builder != null)
                builder.accept(blockType);
        }
    }

    public interface BlockPreset {

        void createBlockState(ABBlockStateGenerator generator, BlockType<?> blockType);
    }
}
