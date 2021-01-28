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
    public static final Supplier<Boolean> enableSmoothMarble;

    static {
        ModConfigBuilder config = new ModConfigBuilder("abstoneedition");
        config.push("blocks");
        enableMarble = config.comment("if true, Marble is enabled").define("enableMarble", true);
        enableSmoothMarble = config.comment("if true, Smooth Marble is enabled").define("enableSmoothMarble", true);
//        enableMarble = config.dontSync().comment("if true, Marble is enabled").define("enableMarble", true);
        config.pop();

        config.build();
    }
}
