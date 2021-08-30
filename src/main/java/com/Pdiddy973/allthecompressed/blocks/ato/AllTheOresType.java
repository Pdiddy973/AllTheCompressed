package com.Pdiddy973.AllTheCompressed.blocks.ato;


import net.minecraft.block.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum AllTheOresType {
    ALUMINUM("aluminum", Aluminum::new),
    COPPER("copper", Copper::new),
    LEAD("lead", Lead::new),
    NICKEL("nickel", Nickel::new),
    OSMIUM("osmium", Osmium::new),
    PLATINUM("platinum", Platinum::new),
    SILVER("silver", Silver::new),
    TIN("tin", Tin::new),
    URANIUM("uranium", Uranium::new),
    ZINC("zinc", Zinc::new);

    public static final AllTheOresType[] VALUES = values();

    public final String name;
    public final Supplier<Block> factory;
    public final List<Block> blocks;

    AllTheOresType(String n, Supplier<Block> f) {
        name = n;
        factory = f;
        blocks = new ArrayList<>();
    }
}
