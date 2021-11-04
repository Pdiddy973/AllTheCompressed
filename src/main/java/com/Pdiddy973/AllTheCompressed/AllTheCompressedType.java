package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.blocks.atm.*;
import com.Pdiddy973.AllTheCompressed.blocks.ato.*;
import com.Pdiddy973.AllTheCompressed.blocks.att.*;
import com.Pdiddy973.AllTheCompressed.blocks.minecraft.*;
import net.minecraft.world.level.block.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum AllTheCompressedType {
    //ATM
    ALLTHEMODIUM("allthemodium", Allthemodium::new),
    VIBRANIUM("vibranium", Vibranium::new),
    UNOBTAINIUM("unobtainium", Unobtainium::new),
    VA_ALLOY("va_alloy", va_alloy::new),
    UA_ALLOY("ua_alloy", ua_alloy::new),
    UV_ALLOY("uv_alloy", uv_alloy::new),

    //ATO
    ALUMINUM("aluminum", Aluminum::new),
    BRONZE("bronze", Bronze::new),
    CONSTANTAN("constantan", Constantan::new),
    ELECTRUM("electrum", Electrum::new),
    ENDERIUM("enderium", Enderium::new),
    INVAR("invar", Invar::new),
    LEAD("lead", Lead::new),
    LUMIUM("lumium", Lumium::new),
    NICKEL("nickel", Nickel::new),
    OSMIUM("osmium", Osmium::new),
    PLATINUM("platinum", Platinum::new),
    SIGNALUM("signalum", Signalum::new),
    SILVER("silver", Silver::new),
    STEEL("steel", Steel::new),
    TIN("tin", Tin::new),
    URANIUM("uranium", Uranium::new),
    ZINC("zinc", Zinc::new),

    //ATT
    ATM_STAR("atm_star", ATM_Star::new),
    ENDER_PEARL("ender_pearl", Ender_Pearl::new),
    NETHER_STAR("nether_star", Nether_Star::new),

    //Minecraft
    AMETHYST("amethyst", Amethyst::new),
    ANDESITE("andesite", Andesite::new),
    BASALT("basalt", Basalt::new),
    BLACKSTONE("blackstone", Blackstone::new),
    CLAY("clay", Clay::new),
    COAL("coal", Coal::new),
    COBBLED_DEEPSLATE("cobbled_deepslate", Cobbled_Deepslate::new),
    COBBLESTONE("cobblestone", Cobblestone::new),
    COPPER("copper", Copper::new),
    DEEPSLATE("deepslate", Deepslate::new),
    DIAMOND("diamond", Diamond::new),
    DIORITE("diorite", Diorite::new),
    DIRT("dirt", Dirt::new),
    EMERALD("emerald", Emerald::new),
    END_STONE("end_stone", End_Stone::new),
    GLASS("glass", Glass::new),
    GLOWSTONE("glowstone", Glowstone::new),
    GOLD("gold", Gold::new),
    GRANITE("granite", Granite::new),
    GRASS("grass", Grass::new),
    GRAVEL("gravel", Gravel::new),
    HAY("hay", Hay::new),
    HONEY("honey", Honey::new),
    IRON("iron", Iron::new),
    LAPIS("lapis", Lapis::new),
    MELON("melon", Melon::new),
    NETHERITE("netherite", Netherite::new),
    NETHERRACK("netherrack", Netherrack::new),
    OBSIDIAN("obsidian", Obsidian::new),
    PODZOL("podzol", Podzol::new),
    PUMPKIN("pumpkin", Pumpkin::new),
    QUARTZ("quartz", Quartz::new),
    RED_SAND("red_sand", Red_Sand::new),
    REDSTONE("redstone", Redstone::new),
    SAND("sand", Sand::new),
    SNOW("snow", Snow::new),
    SOUL_SAND("soul_sand", Soul_Sand::new),
    SOUL_SOIL("soul_soil", Soul_Soil::new),
    STONE("stone", Stone::new);


    public static final AllTheCompressedType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    AllTheCompressedType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}
