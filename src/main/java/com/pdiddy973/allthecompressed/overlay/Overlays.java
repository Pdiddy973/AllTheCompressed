package com.pdiddy973.allthecompressed.overlay;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.ModList;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Overlays {
    // allthecompressed
    BLAZE(Mods.ALLTHECOMPRESSED, "blaze_rod_block"),
    FLINT(Mods.ALLTHECOMPRESSED, "flint_block"),
    ANTIMATTER(Mods.ALLTHECOMPRESSED, "antimatter_block"),

    // allthemodium
    ALLTHEMODIUM(Mods.ALLTHEMODIUM, "allthemodium_block"),
    VIBRANIUM(Mods.ALLTHEMODIUM, "vibranium_block"),
    UNOBTAINIUM(Mods.ALLTHEMODIUM, "unobtainium_block"),
    RAW_ALLTHEMODIUM(Mods.ALLTHEMODIUM, "raw_allthemodium_block"),
    RAW_VIBRANIUM(Mods.ALLTHEMODIUM, "raw_vibranium_block"),
    RAW_UNOBTAINIUM(Mods.ALLTHEMODIUM, "raw_unobtainium_block"),
    UA_ALLOY(Mods.ALLTHEMODIUM, "unobtainium_allthemodium_block"),
    UV_ALLOY(Mods.ALLTHEMODIUM, "unobtainium_vibranium_block"),
    VA_ALLOY(Mods.ALLTHEMODIUM, "vibranium_allthemodium_block"),
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

    // ae2
    FLUIX(Mods.AE2, "fluix_block"),
    SKY_STONE(Mods.AE2, "sky_stone_block"),
    CERTUS_QUARTZ(Mods.AE2, "quartz_block", "certus_quartz_block"),

    // aoa3
//    LIMONITE(Mods.AOA3, "limonite_block"),
//    RAW_LIMONITE(Mods.AOA3, "raw_limonite_block"),
//    JADE(Mods.AOA3, "jade_block"),
//    EMBERSTONE(Mods.AOA3, "emberstone_block"),
//    RAW_EMBERSTONE(Mods.AOA3, "raw_emberstone_block"),
//    SKELETAL_INGOT(Mods.AOA3, "skeletal_ingot_block"),
//    ANCIENT_ROCK(Mods.AOA3, "ancient_rock"),
//    PRECASIAN_COBBLESTONE(Mods.AOA3, "precasian_cobblestone"),
//    PRECASIAN_STONE(Mods.AOA3, "precasian_stone"),
//    PRECASIAN_SOIL(Mods.AOA3, "precasian_soil"),
//    BAOBAB_LOG(Mods.AOA3, "baobab_log"),
//    STRANGLEWOOD_LOG(Mods.AOA3, "stranglewood_log"),
//    BAOBAB_PLANKS(Mods.AOA3, "baobab_planks"),
//    STRANGLEWOOD_PLANKS(Mods.AOA3, "stranglewood_planks"),

    // appflux
    CHARGED_REDSTONE(Mods.APPFLUX, "charged_redstone_block"),

    // exdeorum
//    DUST(Mods.EXDEORUM, "dust"),
//    CRUSHED_NETHERRACK(Mods.EXDEORUM, "crushed_netherrack"),
//    CRUSHED_END_STONE(Mods.EXDEORUM, "crushed_end_stone"),
//    CRUSHED_DEEPSLATE(Mods.EXDEORUM, "crushed_deepslate"),
//    CRUSHED_BLACKSTONE(Mods.EXDEORUM, "crushed_blackstone"),

    // extendedae
    ENTRO(Mods.EXTENDEDAE, "entro_block"),
    SILICON(Mods.EXTENDEDAE, "silicon_block"),

    // megacells
//    SKY_STEEL(Mods.MEGACELLS, "sky_steel_block"),
//    SKY_BRONZE(Mods.MEGACELLS, "sky_bronze_block"),
//    SKY_OSMIUM(Mods.MEGACELLS, "sky_osmium_block"),

    // botania
//    BLAZE(Mods.BOTANIA, "blaze_block"),

    // enderio
    ENERGETIC_ALLOY(Mods.ENDERIO, "energetic_alloy_block"),
    VIBRANT_ALLOY(Mods.ENDERIO, "vibrant_alloy_block"),
    REDSTONE_ALLOY(Mods.ENDERIO, "redstone_alloy_block"),
    CONDUCTIVE_ALLOY(Mods.ENDERIO, "conductive_alloy_block"),
    PULSATING_ALLOY(Mods.ENDERIO, "pulsating_alloy_block"),
    DARK_STEEL(Mods.ENDERIO, "dark_steel_block"),
    SOULARIUM(Mods.ENDERIO, "soularium_block"),
    END_STEEL(Mods.ENDERIO, "end_steel_block"),

    // forbidden_arcanus
    DARKSTONE(Mods.FORBIDDEN_ARCANUS, "darkstone"),

    // minecraft
    ACACIA_LOG(Mods.MINECRAFT, "acacia_log"),
    ACACIA_PLANKS(Mods.MINECRAFT, "acacia_planks"),
    AMETHYST(Mods.MINECRAFT, "amethyst_block"),
    ANDESITE(Mods.MINECRAFT, "andesite"),
    BASALT(Mods.MINECRAFT, "basalt"),
    BIRCH_LOG(Mods.MINECRAFT, "birch_log"),
    BIRCH_PLANKS(Mods.MINECRAFT, "birch_planks"),
    BLACKSTONE(Mods.MINECRAFT, "blackstone"),
    BLUE_ICE(Mods.MINECRAFT, "blue_ice"),
    BONE(Mods.MINECRAFT, "bone_block"),
    BRICKS(Mods.MINECRAFT, "bricks"),
    CALCITE(Mods.MINECRAFT, "calcite"),
    CHERRY_LOG(Mods.MINECRAFT, "cherry_log"),
    CHERRY_PLANKS(Mods.MINECRAFT, "cherry_planks"),
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
    HONEYCOMB(Mods.MINECRAFT, "honeycomb_block"),
    IRON(Mods.MINECRAFT, "iron_block"),
    JUNGLE_LOG(Mods.MINECRAFT, "jungle_log"),
    JUNGLE_PLANKS(Mods.MINECRAFT, "jungle_planks"),
    LAPIS(Mods.MINECRAFT, "lapis_block"),
    MAGMA(Mods.MINECRAFT, "magma_block"),
    MANGROVE_LOG(Mods.MINECRAFT, "mangrove_log"),
    MANGROVE_PLANKS(Mods.MINECRAFT, "mangrove_planks"),
    MELON(Mods.MINECRAFT, "melon"),
    MOSS(Mods.MINECRAFT, "moss_block"),
    MYCELIUM(Mods.MINECRAFT, "mycelium"),
    MUD(Mods.MINECRAFT, "mud"),
    NETHERITE(Mods.MINECRAFT, "netherite_block"),
    NETHERRACK(Mods.MINECRAFT, "netherrack"),
    NETHER_WART_BLOCK(Mods.MINECRAFT, "nether_wart_block"),
    WARPED_WART_BLOCK(Mods.MINECRAFT, "warped_wart_block"),
    OAK_LOG(Mods.MINECRAFT, "oak_log"),
    OAK_PLANKS(Mods.MINECRAFT, "oak_planks"),
    OBSIDIAN(Mods.MINECRAFT, "obsidian"),
    PACKED_MUD(Mods.MINECRAFT, "packed_mud"),
    PODZOL(Mods.MINECRAFT, "podzol"),
    PUMPKIN(Mods.MINECRAFT, "pumpkin"),
    QUARTZ(Mods.MINECRAFT, "quartz_block"),
    RAW_COPPER(Mods.MINECRAFT, "raw_copper_block"),
    RAW_GOLD(Mods.MINECRAFT, "raw_gold_block"),
    RAW_IRON(Mods.MINECRAFT, "raw_iron_block"),
    RED_SAND(Mods.MINECRAFT, "red_sand"),
    REDSTONE(Mods.MINECRAFT, "redstone_block"),
    SAND(Mods.MINECRAFT, "sand"),
    SMOOTH_STONE(Mods.MINECRAFT, "smooth_stone"),
    SNOW(Mods.MINECRAFT, "snow_block", "snow"), // override to keep backwards compat for 1.21
    SOUL_SAND(Mods.MINECRAFT, "soul_sand"),
    SOUL_SOIL(Mods.MINECRAFT, "soul_soil"),
    SPONGE(Mods.MINECRAFT, "sponge"),
    SPRUCE_LOG(Mods.MINECRAFT, "spruce_log"),
    SPRUCE_PLANKS(Mods.MINECRAFT, "spruce_planks"),
    STONE(Mods.MINECRAFT, "stone"),
    TERRACOTTA(Mods.MINECRAFT, "terracotta"),
    TUFF(Mods.MINECRAFT, "tuff"),

    // minecraft concrete
    WHITE_CONCRETE(Mods.MINECRAFT, "white_concrete"),
    LIGHT_GRAY_CONCRETE(Mods.MINECRAFT, "light_gray_concrete"),
    GRAY_CONCRETE(Mods.MINECRAFT, "gray_concrete"),
    BLACK_CONCRETE(Mods.MINECRAFT, "black_concrete"),
    BROWN_CONCRETE(Mods.MINECRAFT, "brown_concrete"),
    RED_CONCRETE(Mods.MINECRAFT, "red_concrete"),
    ORANGE_CONCRETE(Mods.MINECRAFT, "orange_concrete"),
    YELLOW_CONCRETE(Mods.MINECRAFT, "yellow_concrete"),
    LIME_CONCRETE(Mods.MINECRAFT, "lime_concrete"),
    GREEN_CONCRETE(Mods.MINECRAFT, "green_concrete"),
    CYAN_CONCRETE(Mods.MINECRAFT, "cyan_concrete"),
    LIGHT_BLUE_CONCRETE(Mods.MINECRAFT, "light_blue_concrete"),
    BLUE_CONCRETE(Mods.MINECRAFT, "blue_concrete"),
    PURPLE_CONCRETE(Mods.MINECRAFT, "purple_concrete"),
    MAGENTA_CONCRETE(Mods.MINECRAFT, "magenta_concrete"),
    PINK_CONCRETE(Mods.MINECRAFT, "pink_concrete"),

    // PneumaticCraft
//    COMPRESSED_IRON(Mods.PNEUMATICCRAFT, "compressed_iron_block"),

    // Powah
    BLAZING_CRYSTAL(Mods.POWAH, "blazing_crystal_block"),
    ENERGIZED_STEEL(Mods.POWAH, "energized_steel_block"),
    NIOTIC_CRYSTAL(Mods.POWAH, "niotic_crystal_block"),
    NITRO_CRYSTAL(Mods.POWAH, "nitro_crystal_block"),
    SPIRITED_CRYSTAL(Mods.POWAH, "spirited_crystal_block"),
    URANINITE(Mods.POWAH, "uraninite_block"),

    // productivebees
    WAX(Mods.PRODUCTIVEBEES, "wax_block"),

    // XyCraft
    KIVI(Mods.XYCRAFT_WORLD, "kivi"),
    BLUE_XYCHORIUM(Mods.XYCRAFT_WORLD, "xychorium_storage_blue"),
    GREEN_XYCHORIUM(Mods.XYCRAFT_WORLD, "xychorium_storage_green"),
    RED_XYCHORIUM(Mods.XYCRAFT_WORLD, "xychorium_storage_red"),
    DARK_XYCHORIUM(Mods.XYCRAFT_WORLD, "xychorium_storage_dark"),
    LIGHT_XYCHORIUM(Mods.XYCRAFT_WORLD, "xychorium_storage_light"),
    ;

    public final Mods mod;
    public final OverlayEntry overlay;
    Overlays(Mods mod, String block) {
        this(mod, block, null);
    }

    Overlays(Mods mod, String block, @Nullable String override) {
        this.mod = mod;
        this.overlay = new OverlayEntry(Identifier.fromNamespaceAndPath(mod.toString(), block), override);
    }

    public static void init() {
        Map<Boolean, List<String>> mods = Arrays.stream(Mods.values())
            .map(Mods::toString)
            .collect(Collectors.partitioningBy(ModList.get()::isLoaded));

        AllTheCompressed.LOGGER.info("Registering overlays for loaded mods: {}", mods.get(true));
        AllTheCompressed.LOGGER.info("Skipping overlays for absent mods: {}", mods.get(false));
    }
}
