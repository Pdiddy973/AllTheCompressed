package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.blocks.atm.*;
import com.Pdiddy973.AllTheCompressed.blocks.ato.*;
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

    //Minecraft
    CLAY("clay", Clay::new),
    COAL("coal", Coal::new),
    COBBLESTONE("cobblestone", Cobblestone::new),
    COPPER("copper", Copper::new),
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