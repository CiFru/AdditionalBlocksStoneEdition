package com.cifru.additionalblocks.stone;

import com.supermartijn642.configlib.api.ConfigBuilders;
import com.supermartijn642.configlib.api.IConfigBuilder;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class AdditionalBlocksConfig {

    public static void create() {
    }

    public static final Supplier<Boolean> enableMarble;
    public static final Supplier<Boolean> enableStoneBrickBlock;
    public static final Supplier<Boolean> enableDioriteBricks;
    public static final Supplier<Boolean> enableAndesiteBricks;
    public static final Supplier<Boolean> enableGraniteBricks;
    public static final Supplier<Boolean> enableWaterStone;
    public static final Supplier<Boolean> enableBloodstone;
    public static final Supplier<Boolean> enableBlackMarble;
    public static final Supplier<Boolean> enableMud;
    public static final Supplier<Boolean> enableBrownBricks;
    public static final Supplier<Boolean> enableVolcanicStone;
    public static final Supplier<Boolean> enableGrayBricks;
    public static final Supplier<Boolean> enableStonePath;
    public static final Supplier<Boolean> enableStonePattern;
    public static final Supplier<Boolean> enableAsphalt;
    public static final Supplier<Boolean> enableLimestone;
    public static final Supplier<Boolean> enablePebbles;
    public static final Supplier<Boolean> enableCharredBlocks;
    public static final Supplier<Boolean> enableStoneTiles;
    public static final Supplier<Boolean> enableSmoothGlowstone;
    public static final Supplier<Boolean> enableGlowstoneBricks;
    public static final Supplier<Boolean> enableGlowstone;
    public static final Supplier<Boolean> enableCopper;
    public static final Supplier<Boolean> enableSilver;
    public static final Supplier<Boolean> enableSmoothStoneBricks;
    public static final Supplier<Boolean> enableAztec;
    public static final Supplier<Boolean> enableSmoothStone;
    public static final Supplier<Boolean> enableBismuth;
    public static final Supplier<Boolean> enableObsidian;
    public static final Supplier<Boolean> enableUranium;
    public static final Supplier<Boolean> enableMinecraft19;

    static {
        IConfigBuilder config = ConfigBuilders.newTomlConfig("abstoneedition", null, false);
        config.push("blocks");
        enableMarble = config.comment("if true, Marble Blocks are enabled").define("enableMarble", true);
        enableBlackMarble = config.comment("if true, Black Marble Blocks are enabled").define("enableBlackMarble", true);
        enableBloodstone = config.comment("if true, Bloodstone Blocks are enabled").define("enableBloodstone", true);
        enableStoneBrickBlock = config.comment("if true, Stone Brick Block is enabled").define("enableStoneBrickBlock", true);
        enableAndesiteBricks = config.comment("if true, Andesite Brick Blocks are enabled").define("enableAndesiteBricks", true);
        enableDioriteBricks = config.comment("if true, Diorite Brick Blocks are enabled").define("enableDioriteBricks", true);
        enableGraniteBricks = config.comment("if true, Granite Brick Blocks are enabled").define("enableGraniteBricks", true);
        enableWaterStone = config.comment("if true, Water Stone is enabled").define("enableWaterStone", true);
        enableMud = config.comment("if true, Mud is enabled").define("enableMud", true);
        enableBrownBricks = config.comment("if true, Brown Brick Blocks are enabled").define("enableBrownBricks", true);
        enableVolcanicStone = config.comment("if true, Volcanic Stone Blocks are enabled").define("enableVolcanicStone", true);
        enableStonePath = config.comment("if true, Stone Path Blocks are enabled").define("enableStonePath", true);
        enableStonePattern = config.comment("if true, Stone Pattern is enabled").define("enableStonePattern", true);
        enableLimestone = config.comment("if true, Limestone Blocks are enabled").define("enableLimestone", true);
        enableAsphalt = config.comment("if true, Asphalt is enabled").define("enableAsphalt", true);
        enablePebbles = config.comment("if true, Pebble Blocks are enabled").define("enablePebbles", true);
        enableCharredBlocks = config.comment("if true, Charred Blocks are enabled").define("enableCharredBlocks", true);
        enableGrayBricks = config.comment("if true, Gray Brick Blocks are enabled").define("enableGrayBricks", true);
        enableStoneTiles = config.comment("if true, Stone Tiles are enabled").define("enableStoneTiles", true);
        enableSmoothGlowstone = config.comment("if true, Smooth Glowstone Blocks are enabled").define("enableSmoothGlowstone", true);
        enableGlowstoneBricks = config.comment("if true, Glowstone Brick Blocks are enabled").define("enableGlowstoneBricks", true);
        enableGlowstone = config.comment("if true, Glowstone Blocks are enabled").define("enableGlowstone", true);
        enableCopper = config.comment("if true, Copper Blocks and Items are enabled").define("enableCopper", true);
        enableSilver = config.comment("if true, Silver Blocks and Items are enabled").define("enableSilver", true);
        enableSmoothStoneBricks = config.comment("if true, Smooth Stone Brick Blocks are enabled").define("enableSmoothStoneBricks", true);
        enableAztec = config.comment("if true, Aztec Blocks are enabled").define("enableAztec", true);
        enableSmoothStone = config.comment("if true, Smooth Stone Blocks are enabled").define("enableSmoothStone", true);
        enableBismuth = config.comment("if true, Bismuth Blocks and Items are enabled").define("enableBismuth", true);
        enableObsidian = config.comment("if true, Obsidian Blocks and Items are enabled").define("enableObsidian", true);
        enableUranium = config.comment("if true, Uranium Blocks and Items are enabled").define("enableUranium", true);
        enableMinecraft19 = config.comment("if true, new blocks added in 1.19+ are enabled").define("enableMinecraft19", true);
        config.pop();

        config.build();
    }
}
