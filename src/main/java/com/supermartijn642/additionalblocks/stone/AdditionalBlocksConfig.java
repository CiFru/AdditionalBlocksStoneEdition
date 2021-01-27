package com.supermartijn642.additionalblocks.stone;

import com.supermartijn642.configlib.ModConfigBuilder;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class AdditionalBlocksConfig {

    public static final Supplier<Boolean> enableMarble;

    static {
        ModConfigBuilder config = new ModConfigBuilder("abstoneedition");
        config.push("general");
        enableMarble = config.comment("if true, Marble is enabled").define("enableMarble", true);
        config.pop();

        config.build();
    }
}
