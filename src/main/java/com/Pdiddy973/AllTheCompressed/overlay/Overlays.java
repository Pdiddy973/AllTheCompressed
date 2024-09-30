package com.Pdiddy973.AllTheCompressed.overlay;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Overlays {
    // allthecompressed
    BLAZE(Mods.ALLTHECOMPRESSED, "blaze_rod_block"),
    FLINT(Mods.ALLTHECOMPRESSED, "flint_block"),

    // allthemodium
    ALLTHEMODIUM(Mods.ALLTHEMODIUM, "allthemodium_block"),
    VIBRANIUM(Mods.ALLTHEMODIUM, "vibranium_block"),
    UNOBTAINIUM(Mods.ALLTHEMODIUM, "unobtainium_block"),
    RAW_ALLTHEMODIUM(Mods.ALLTHEMODIUM, "raw_allthemodium_block"),
    RAW_VIBRANIUM(Mods.ALLTHEMODIUM, "raw_vibranium_block"),
    RAW_UNOBTAINIUM(Mods.ALLTHEMODIUM, "raw_unobtainium_block"),
    UA_ALLOY(Mods.ALLTHEMODIUM, "unobtainium_allthemodium_alloy_block"),
    UV_ALLOY(Mods.ALLTHEMODIUM, "unobtainium_vibranium_alloy_block"),
    VA_ALLOY(Mods.ALLTHEMODIUM, "vibranium_allthemodium_alloy_block"),
    ANCIENT_STONE(Mods.ALLTHEMODIUM, "ancient_stone"),
    ANCIENT_LOG(Mods.ALLTHEMODIUM, "ancient_log_0"),
    PIGLICH_HEART_BLOCK(Mods.ALLTHEMODIUM, "piglich_heart_block"),

    //alltheores
    ALUMINUM(Mods.ALLTHEORES, "aluminum_block"),
    BRASS(Mods.ALLTHEORES, "brass_block"),
    BRONZE(Mods.ALLTHEORES, "bronze_block"),
    CONSTANTAN(Mods.ALLTHEORES, "constantan_block"),
    ELECTRUM(Mods.ALLTHEORES, "electrum_block"),
    ENDERIUM(Mods.ALLTHEORES, "enderium_block"),
    INVAR(Mods.ALLTHEORES, "invar_block"),
    IRIDIUM(Mods.ALLTHEORES, "iridium_block"),
    LEAD(Mods.ALLTHEORES, "lead_block"),
    LUMIUM(Mods.ALLTHEORES, "lumium_block"),
    NICKEL(Mods.ALLTHEORES, "nickel_block"),
    OSMIUM(Mods.ALLTHEORES, "osmium_block"),
    PERIDOT(Mods.ALLTHEORES, "peridot_block"),
    PLATINUM(Mods.ALLTHEORES, "platinum_block"),
    RUBY(Mods.ALLTHEORES, "ruby_block"),
    SAPPHIRE(Mods.ALLTHEORES, "sapphire_block"),
    SIGNALUM(Mods.ALLTHEORES, "signalum_block"),
    SILVER(Mods.ALLTHEORES, "silver_block"),
    STEEL(Mods.ALLTHEORES, "steel_block"),
    TIN(Mods.ALLTHEORES, "tin_block"),
    URANIUM(Mods.ALLTHEORES, "uranium_block"),
    ZINC(Mods.ALLTHEORES, "zinc_block"),

    RAW_ALUMINUM(Mods.ALLTHEORES, "raw_aluminum_block"),
    RAW_IRIDIUM(Mods.ALLTHEORES, "raw_iridium_block"),
    RAW_LEAD(Mods.ALLTHEORES, "raw_lead_block"),
    RAW_NICKEL(Mods.ALLTHEORES, "raw_nickel_block"),
    RAW_OSMIUM(Mods.ALLTHEORES, "raw_osmium_block"),
    RAW_PLATINUM(Mods.ALLTHEORES, "raw_platinum_block"),
    RAW_SILVER(Mods.ALLTHEORES, "raw_silver_block"),
    RAW_TIN(Mods.ALLTHEORES, "raw_tin_block"),
    RAW_URANIUM(Mods.ALLTHEORES, "raw_uranium_block"),
    RAW_ZINC(Mods.ALLTHEORES, "raw_zinc_block"),

    CINNABAR(Mods.ALLTHEORES, "cinnabar_block"),
    FLUORITE(Mods.ALLTHEORES, "fluorite_block"),
    SALT(Mods.ALLTHEORES, "salt_block"),
    SULFUR(Mods.ALLTHEORES, "sulfur_block"),

    // allthetweaks
    ATM_STAR(Mods.ALLTHETWEAKS, "atm_star_block"),
    GREG_STAR(Mods.ALLTHETWEAKS, "greg_star_block"),
    ENDER_PEARL(Mods.ALLTHETWEAKS, "ender_pearl_block"),
    NETHER_STAR(Mods.ALLTHETWEAKS, "nether_star_block"),

    // botania
//    BLAZE(Mods.BOTANIA, "blaze_block"),

    // enderio
//    COPPER_ALLOY(Mods.ENDERIO, "copper_alloy_block"),
//    ENERGETIC_ALLOY(Mods.ENDERIO, "energetic_alloy_block"),
//    VIBRANT_ALLOY(Mods.ENDERIO, "vibrant_alloy_block"),
//    REDSTONE_ALLOY(Mods.ENDERIO, "redstone_alloy_block"),
//    CONDUCTIVE_ALLOY(Mods.ENDERIO, "conductive_alloy_block"),
//    PULSATING_ALLOY(Mods.ENDERIO, "pulsating_alloy_block"),
//    DARK_STEEL(Mods.ENDERIO, "dark_steel_block"),
//    SOULARIUM(Mods.ENDERIO, "soularium_block"),
//    END_STEEL(Mods.ENDERIO, "end_steel_block"),

    // minecraft
    ACACIA_LOG(Mods.MINECRAFT, "acacia_log"),
    ACACIA_PLANKS(Mods.MINECRAFT, "acacia_planks"),
    AMETHYST(Mods.MINECRAFT, "amethyst_block"),
    ANDESITE(Mods.MINECRAFT, "andesite"),
    BASALT(Mods.MINECRAFT, "basalt"),
    BIRCH_LOG(Mods.MINECRAFT, "birch_log"),
    BIRCH_PLANKS(Mods.MINECRAFT, "birch_planks"),
    BLACKSTONE(Mods.MINECRAFT, "blackstone"),
    BONE(Mods.MINECRAFT, "bone_block"),
    CALCITE(Mods.MINECRAFT, "calcite"),
    CLAY(Mods.MINECRAFT, "clay"),
    COAL(Mods.MINECRAFT, "coal_block"),
    COBBLED_DEEPSLATE(Mods.MINECRAFT, "cobbled_deepslate"),
    COBBLESTONE(Mods.MINECRAFT, "cobblestone"),
    COPPER(Mods.MINECRAFT, "copper_block"),
    DARK_OAK_LOG(Mods.MINECRAFT, "dark_oak_log"),
    DARK_OAK_PLANKS(Mods.MINECRAFT, "dark_oak_planks"),
    DEEPSLATE(Mods.MINECRAFT, "deepslate"),
    DIAMOND(Mods.MINECRAFT, "diamond_block"),
    DIORITE(Mods.MINECRAFT, "diorite"),
    DIRT(Mods.MINECRAFT, "dirt"),
    DRIED_KELP(Mods.MINECRAFT, "dried_kelp_block"),
    DRIPSTONE(Mods.MINECRAFT, "dripstone_block"),
    EMERALD(Mods.MINECRAFT, "emerald_block"),
    END_STONE(Mods.MINECRAFT, "end_stone"),
    GLASS(Mods.MINECRAFT, "glass"),
    GLOWSTONE(Mods.MINECRAFT, "glowstone"),
    GOLD(Mods.MINECRAFT, "gold_block"),
    GRANITE(Mods.MINECRAFT, "granite"),
    GRASS(Mods.MINECRAFT, "grass_block"),
    GRAVEL(Mods.MINECRAFT, "gravel"),
    HAY(Mods.MINECRAFT, "hay_block"),
    HONEY(Mods.MINECRAFT, "honey_block"),
    IRON(Mods.MINECRAFT, "iron_block"),
    JUNGLE_LOG(Mods.MINECRAFT, "jungle_log"),
    JUNGLE_PLANKS(Mods.MINECRAFT, "jungle_planks"),
    LAPIS(Mods.MINECRAFT, "lapis_block"),
    MAGMA(Mods.MINECRAFT, "magma_block"),
    MANGROVE_LOG(Mods.MINECRAFT, "mangrove_log"),
    MANGROVE_PLANKS(Mods.MINECRAFT, "mangrove_planks"),
    MELON(Mods.MINECRAFT, "melon"),
    MOSS(Mods.MINECRAFT, "moss_block"),
    NETHERITE(Mods.MINECRAFT, "netherite_block"),
    NETHERRACK(Mods.MINECRAFT, "netherrack"),
    OAK_LOG(Mods.MINECRAFT, "oak_log"),
    OAK_PLANKS(Mods.MINECRAFT, "oak_planks"),
    OBSIDIAN(Mods.MINECRAFT, "obsidian"),
    PODZOL(Mods.MINECRAFT, "podzol"),
    PUMPKIN(Mods.MINECRAFT, "pumpkin"),
    QUARTZ(Mods.MINECRAFT, "quartz_block"),
    RED_SAND(Mods.MINECRAFT, "red_sand"),
    REDSTONE(Mods.MINECRAFT, "redstone_block"),
    SAND(Mods.MINECRAFT, "sand"),
    SNOW(Mods.MINECRAFT, "snow"),
    SOUL_SAND(Mods.MINECRAFT, "soul_sand"),
    SOUL_SOIL(Mods.MINECRAFT, "soul_soil"),
    SPONGE(Mods.MINECRAFT, "sponge"),
    SPRUCE_LOG(Mods.MINECRAFT, "spruce_log"),
    SPRUCE_PLANKS(Mods.MINECRAFT, "spruce_planks"),
    STONE(Mods.MINECRAFT, "stone"),
    TERRACOTTA(Mods.MINECRAFT, "terracotta"),
    TUFF(Mods.MINECRAFT, "tuff"),

    // Powah
    BLAZING_CRYSTAL(Mods.POWAH, "blazing_crystal_block"),
    ENERGIZED_STEEL(Mods.POWAH, "energized_steel_block"),
    NIOTIC_CRYSTAL(Mods.POWAH, "niotic_crystal_block"),
    NITRO_CRYSTAL(Mods.POWAH, "nitro_crystal_block"),
    SPIRITED_CRYSTAL(Mods.POWAH, "spirited_crystal_block"),
    URANINITE(Mods.POWAH, "uraninite_block"),

    // supplementaries
//    FLINT(Mods.SUPPLEMENTARIES, "flint_block"),

    // productivebees
    WAX(Mods.PRODUCTIVEBEES, "wax_block"),
    ;

    public final Mods mod;
    public final OverlayEntry overlay;
    Overlays(Mods mod, String block) {
        this.mod = mod;
        this.overlay = new OverlayEntry(ResourceLocation.fromNamespaceAndPath(mod.toString(), block));
    }

    public static void init() {
        Map<Boolean, List<String>> mods = Arrays.stream(Mods.values())
            .map(Mods::toString)
            .collect(Collectors.partitioningBy(ModList.get()::isLoaded));

        AllTheCompressed.LOGGER.info("Registering overlays for loaded mods: {}", mods.get(true));
        AllTheCompressed.LOGGER.info("Skipping overlays for absent mods: {}", mods.get(false));
    }
}
