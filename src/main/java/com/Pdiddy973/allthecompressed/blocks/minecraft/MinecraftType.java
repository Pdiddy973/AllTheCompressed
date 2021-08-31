package com.Pdiddy973.AllTheCompressed.blocks.minecraft;


import net.minecraft.block.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum MinecraftType {
    CLAY("clay", Clay::new),
    COAL("coal", Coal::new),
    COBBLESTONE("cobblestone", Cobblestone::new),
    DIAMOND("diamond", Diamond::new),
    DIRT("dirt", Dirt::new),
    EMERALD("emerald", Emerald::new),
    END_STONE("end_stone", End_Stone::new),
    GOLD("gold", Gold::new),
    GRAVEL("gravel", Gravel::new),
    HONEY("honey", Honey::new),
    IRON("iron", Iron::new),
    LAPIS("lapis", Lapis::new),
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

    public static final MinecraftType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    MinecraftType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}
