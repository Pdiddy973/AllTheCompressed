package com.Pdiddy973.AllTheCompressed.blocks.powah;


import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum PowahType {
    BLAZING_CRYSTAL("blazing_crystal", Blazing_Crystal::new),
    ENERGIZED_STEEL("energized_steel", Energized_Steel::new),
    NIOTIC_CRYSTAL("niotic_crystal", Niotic_Crystal::new),
    NITRO_CRYSTAL("nitro_crystal", Nitro_Crystal::new),
    SPIRITED_CRYSTAL("spirited_crystal", Spirited_Crystal::new),
    URANINITE("uraninite", Uraninite::new);


    public static final PowahType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    PowahType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}

