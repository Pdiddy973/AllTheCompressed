package com.Pdiddy973.AllTheCompressed.config;


import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;


@Mod.EventBusSubscriber(modid = "allthecompressed", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static boolean allthemodium;
    public static boolean alltheores;
    public static boolean mekanism;
    public static boolean powah;
    public static boolean thermal;

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue allthemodium;
        public final ForgeConfigSpec.BooleanValue alltheores;
        public final ForgeConfigSpec.BooleanValue mekanism;
        public final ForgeConfigSpec.BooleanValue powah;
        public final ForgeConfigSpec.BooleanValue thermal;

        public Common(ForgeConfigSpec.Builder BUILDER) {

            BUILDER.push("AllTheCompressed Blocks");
            allthemodium = BUILDER.comment("Enable AllTheModium Blocks").define("AllTheModium", true);
            alltheores = BUILDER.comment("Enable AllTheOres Blocks").define("AllTheOres", true);
            mekanism = BUILDER.comment("Enable Mekanism Blocks").define("Mekanism", true);
            powah = BUILDER.comment("Enable Powah Blocks").define("Powah", true);
            thermal = BUILDER.comment("Enable Thermal Blocks").define("Thermal", true);
            BUILDER.pop();

        }
    }

}
