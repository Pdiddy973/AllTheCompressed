package com.Pdiddy973.AllTheCompressed.config;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;


@Mod.EventBusSubscriber(modid = "allthecompressed", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static boolean allthemodium;
    public static boolean alltheores;
    public static boolean mekanism;
    public static boolean compressium;
    public static boolean thermal;

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        bakeConfigs();
    }

    private static void bakeConfigs() {
        allthemodium = Config.COMMON.allthemodium.get();
        alltheores = Config.COMMON.alltheores.get();
        mekanism = Config.COMMON.mekanism.get();
        compressium = Config.COMMON.compressium.get();
        thermal = Config.COMMON.thermal.get();

    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue allthemodium;
        public final ForgeConfigSpec.BooleanValue alltheores;
        public final ForgeConfigSpec.BooleanValue mekanism;
        public final ForgeConfigSpec.BooleanValue compressium;
        public final ForgeConfigSpec.BooleanValue thermal;


        public Common(ForgeConfigSpec.Builder BUILDER) {

            BUILDER.push("AllTheCompressed Blocks");
            allthemodium = BUILDER.comment("Enable AllTheModium Blocks").define("AllTheModium", true);
            alltheores = BUILDER.comment("Enable AllTheOres Blocks").define("AllTheOres", true);
            mekanism = BUILDER.comment("Enable Mekanism Blocks").define("Mekanism", true);
            compressium = BUILDER.comment("Enable Compressium Blocks").define("Compressium", true);
            thermal = BUILDER.comment("Enable Thermal Blocks").define("Thermal", true);
            BUILDER.pop();

        }
    }

}
