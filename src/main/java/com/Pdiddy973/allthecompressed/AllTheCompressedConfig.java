package com.Pdiddy973.AllTheCompressed;


import net.minecraftforge.common.ForgeConfigSpec;

public final class AllTheCompressedConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> allthemodium;
    public static final ForgeConfigSpec.ConfigValue<Boolean> alltheores;
    public static final ForgeConfigSpec.ConfigValue<Boolean> mekanism;
    public static final ForgeConfigSpec.ConfigValue<Boolean> compressium;
    public static final ForgeConfigSpec.ConfigValue<Boolean> thermal;

    static {
        BUILDER.push("Use AllTheModium Blocks");
        allthemodium = BUILDER.comment("true/false").define("AllTheModium Blocks", true);
        BUILDER.pop();

        BUILDER.push("Use AllTheOres Blocks");
        alltheores = BUILDER.comment("true/false").define("AllTheOres Blocks", true);
        BUILDER.pop();

        BUILDER.push("Use Mekanism Blocks");
        mekanism = BUILDER.comment("true/false").define("Mekanism Blocks", true);
        BUILDER.pop();

        BUILDER.push("Use Compressium Blocks");
        compressium = BUILDER.comment("true/false").define("Compressium Blocks", true);
        BUILDER.pop();

        BUILDER.push("Use Thermal Blocks");
        thermal = BUILDER.comment("true/false").define("Thermal Blocks", true);
        BUILDER.pop();

        SPEC = BUILDER.build();

    }

}
