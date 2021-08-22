package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.blocks.atm.*;
import com.Pdiddy973.AllTheCompressed.blocks.ato.*;
import com.Pdiddy973.AllTheCompressed.blocks.mekanism.*;
import com.Pdiddy973.AllTheCompressed.blocks.minecraft.*;
import com.Pdiddy973.AllTheCompressed.blocks.thermal.*;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public enum AllTheCompressedType {
    //Minecraft
    CLAY("clay", Clay::new),
    COAL("coal", Coal::new),
    COBBLESTONE("cobblestone", Cobblestone::new),
    DIAMOND("diamond", Diamond::new),
    DIRT("dirt", Dirt::new),
    EMERALD("emerald", Emerald::new),
    END_STONE("end_stone", End_Stone::new),
    GLASS("glass", Glass::new),
    GLOWSTONE("glowstone", Glowstone::new),
    GOLD("gold", Gold::new),
    GRAVEL("gravel", Gravel::new),
    HONEY("honey", Honey::new),
    IRON("iron", Iron::new),
    NETHERITE("netherite", Netherite::new),
    NETHERRACK("netherrack", Netherrack::new),
    OBSIDIAN("obsidian", Obsidian::new),
    QUARTZ("quartz", Quartz::new),
    RED_SAND("red_sand", Red_Sand::new),
    REDSTONE("redstone", Redstone::new),
    SAND("sand", Sand::new),
    SNOW("snow", Snow::new),
    SOUL_SAND("soul_sand", Soul_Sand::new),
    STONE("stone", Stone::new),

    //ATM
    ALLTHEMODIUM("allthemodium", Allthemodium::new),
    VIBRANIUM("vibranium", Vibranium::new),
    UNOBTAINIUM("unobtainium", Unobtainium::new),
    VA_ALLOY("va_alloy", va_alloy::new),
    UA_ALLOY("ua_alloy", ua_alloy::new),
    UV_ALLOY("uv_alloy", uv_alloy::new),

    //ATO
    ALUMINUM("aluminum", Aluminum::new),
    COPPER("copper", Copper::new),
    LEAD("lead", Lead::new),
    NICKEL("nickel", Nickel::new),
    OSMIUM("osmium", Osmium::new),
    PLATINUM("platinum", Platinum::new),
    SILVER("silver", Silver::new),
    TIN("tin", Tin::new),
    URANIUM("uranium", Uranium::new),
    ZINC("zinc", Zinc::new),

    //Mekanism
    STEEL("steel", Steel::new),

    //Thermal
    BRONZE("bronze", Bronze::new),
    CONSTANTAN("constantan", Constantan::new),
    ELECTRUM("electrum", Electrum::new),
    ENDERIUM("enderium", Enderium::new),
    INVAR("invar", Invar::new),
    LUMIUM("lumium", Lumium::new),
    SIGNALUM("signalum", Signalum::new);

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