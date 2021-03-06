package com.supermartijn642.additionalblocks.stone;

import com.supermartijn642.configlib.ModConfigBuilder;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class AdditionalBlocksConfig {

    public static void create(){
    }

    public static final Supplier<Boolean> enableMarble;
//    public static final Supplier<Boolean> enableSmoothMarble;
    public static final Supplier<Boolean> enableStoneBrickBlock;
//    public static final Supplier<Boolean> enableMarbleBricks;
    public static final Supplier<Boolean> enableDioriteBricks;
    public static final Supplier<Boolean> enableAndesiteBricks;
    public static final Supplier<Boolean> enableGraniteBricks;
    public static final Supplier<Boolean> enableWaterStone;
//    public static final Supplier<Boolean> enableMarblePillar;
    public static final Supplier<Boolean> enableBloodstone;
//    public static final Supplier<Boolean> enableSmoothBloodstone;
//    public static final Supplier<Boolean> enableBloodstoneBricks;
    public static final Supplier<Boolean> enableBlackMarble;
//    public static final Supplier<Boolean> enableSmoothBlackMarble;
//    public static final Supplier<Boolean> enableBlackMarbleBricks;
    public static final Supplier<Boolean> enableMud;
    public static final Supplier<Boolean> enableBrownBricks;
    public static final Supplier<Boolean> enableVolcanicStone;
//    public static final Supplier<Boolean> enableVolcanicStoneBricks;
    public static final Supplier<Boolean> enableGrayBricks;
//    public static final Supplier<Boolean> enableStonePathCurved;
    public static final Supplier<Boolean> enableStonePath;
    public static final Supplier<Boolean> enableStonePattern;
    public static final Supplier<Boolean> enableAsphalt;
    public static final Supplier<Boolean> enableLimestone;
//    public static final Supplier<Boolean> enableLimestoneBricks;
    public static final Supplier<Boolean> enablePebbles;
    public static final Supplier<Boolean> enableCharredBlocks;
//    public static final Supplier<Boolean> enableCharredLog;
//    public static final Supplier<Boolean> enableCharredWood;
//    public static final Supplier<Boolean> enableCharredPlanks;
//    public static final Supplier<Boolean> enableWateryPebbles;

    static {
        ModConfigBuilder config = new ModConfigBuilder("abstoneedition");
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
//        enableMud = config.comment("if true, Mud is enabled").define("enableMud", true);
//        enableMarble = config.dontSync().comment("if true, Marble is enabled").define("enableMarble", true);
        config.pop();

        config.build();
    }
}
