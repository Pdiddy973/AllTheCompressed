package com.Pdiddy973.AllTheCompressed;


import net.minecraftforge.common.ForgeConfigSpec;

public final class AllTheCompressedConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> compressium;

    static {
        BUILDER.push("Use Compressium Blocks");
        compressium = BUILDER.comment("true/false").define("Compressium Blocks", true);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
