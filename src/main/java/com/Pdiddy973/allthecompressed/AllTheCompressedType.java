package com.Pdiddy973.AllTheCompressed;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.SoulSandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public enum AllTheCompressedType {
    //Minecraft
    CLAY("clay",//
            new ResourceLocation("minecraft", "clay"),
            new ResourceLocation("minecraft", "block/clay"),
            new ResourceLocation("minecraft", "block/clay"),
            Block::new),
    COAL("coal",//
            new ResourceLocation("minecraft", "coal_block"),
            new ResourceLocation("minecraft", "block/coal_block"),
            new ResourceLocation("minecraft", "block/coal_block"),
            Block::new),
    COBBLESTONE("cobblestone",//
            new ResourceLocation("minecraft", "cobblestone"),
            new ResourceLocation("minecraft", "block/cobblestone"),
            new ResourceLocation("minecraft", "block/cobblestone"),
            Block::new),
    COPPER("copper",//
            new ResourceLocation("minecraft", "copper"),
            new ResourceLocation("minecraft", "block/copper_block"),
            new ResourceLocation("minecraft", "block/copper_block"),
        Block::new),
    DIAMOND("diamond",//
            new ResourceLocation("minecraft", "diamond_block"),
            new ResourceLocation("minecraft", "block/diamond_block"),
            new ResourceLocation("minecraft", "block/diamond_block"),
            Block::new),
    DIRT("dirt",//
            new ResourceLocation("minecraft", "dirt"),
            new ResourceLocation("minecraft", "block/dirt"),
            new ResourceLocation("minecraft", "block/dirt"),
            Block::new),
    EMERALD("emerald",//
            new ResourceLocation("minecraft", "emerald_block"),
            new ResourceLocation("minecraft", "block/emerald_block"),
            new ResourceLocation("minecraft", "block/emerald_block"),
            Block::new),
    END_STONE("end_stone",//
            new ResourceLocation("minecraft", "end_stone"),
            new ResourceLocation("minecraft", "block/end_stone"),
            new ResourceLocation("minecraft", "block/end_stone"),
            Block::new),
    GOLD("gold",//
            new ResourceLocation("minecraft", "gold_block"),
            new ResourceLocation("minecraft", "block/gold_block"),
            new ResourceLocation("minecraft", "block/gold_block"),
            Block::new),
    GRAVEL("gravel",//
            new ResourceLocation("minecraft", "gravel"),
            new ResourceLocation("minecraft", "block/gravel"),
            new ResourceLocation("minecraft", "block/gravel"),
            FallingDamageBlock::new),
    IRON("iron",//
            new ResourceLocation("minecraft", "iron_block"),
            new ResourceLocation("minecraft", "block/iron_block"),
            new ResourceLocation("minecraft", "block/iron_block"),
            Block::new),
    //LAPIS("lapis",
            //new ResourceLocation("minecraft", "lapis_block"),
            //new ResourceLocation("minecraft", "block/lapis_block"),
            //new ResourceLocation("minecraft", "block/lapis_block"),
           // Block::new),
    NETHERITE("netherite",//
            new ResourceLocation("minecraft", "netherite_block"),
            new ResourceLocation("minecraft", "block/netherite_block"),
            new ResourceLocation("minecraft", "block/netherite_block"),
            Block::new),
    NETHERRACK("netherrack",//
            new ResourceLocation("minecraft", "netherrack"),
            new ResourceLocation("minecraft", "block/netherrack"),
            new ResourceLocation("minecraft", "block/netherrack"),
            NetherrackBlock::new),
    OBSIDIAN("obsidian",//
            new ResourceLocation("minecraft", "obsidian"),
            new ResourceLocation("minecraft", "block/obsidian"),
            new ResourceLocation("minecraft", "block/obsidian"),
            Block::new),
    QUARTZ("quartz",//
            new ResourceLocation("minecraft", "quartz_block"),
            new ResourceLocation("minecraft", "block/quartz_block_side"),
            new ResourceLocation("minecraft", "block/quartz_block"),
            Block::new),
    RED_SAND("red_sand",//
            new ResourceLocation("minecraft", "red_sand"),
            new ResourceLocation("minecraft", "block/red_sand"),
            new ResourceLocation("minecraft", "block/red_sand"),
            FallingDamageBlock::new),
    REDSTONE("redstone",//
            new ResourceLocation("minecraft", "redstone_block"),
            new ResourceLocation("minecraft", "block/redstone_block"),
            new ResourceLocation("minecraft", "block/redstone_block"),
            PoweredBlock::new),
    SAND("sand",//
            new ResourceLocation("minecraft", "sand"),
            new ResourceLocation("minecraft", "block/sand"),
            new ResourceLocation("minecraft", "block/sand"),
            FallingDamageBlock::new),
    SNOW("snow",//
            new ResourceLocation("minecraft", "snow"),
            new ResourceLocation("minecraft", "block/snow"),
            new ResourceLocation("minecraft", "block/snow_block"),
            Block::new),
    SOUL_SAND("soul_sand",//
            new ResourceLocation("minecraft", "soul_sand"),
            new ResourceLocation("minecraft", "block/soul_sand"),
            new ResourceLocation("minecraft", "block/soul_sand"),
            SoulSandBlock::new),
    STONE("stone",//
            new ResourceLocation("minecraft", "stone"),
            new ResourceLocation("minecraft", "block/stone"),
            new ResourceLocation("minecraft", "block/stone"),
            Block::new),

    //Allthemodium
    ALLTHEMODIUM("allthemodium",
            new ResourceLocation("allthemodium", "allthemodium_block"),
            new ResourceLocation("allthemodium", "block/allthemodium_block"),
            new ResourceLocation("allthemodium", "block/allthemodium_block"),
            Block::new),
    //AllTheOres
    ALUMINUM("aluminum",
            new ResourceLocation("alltheores", "aluminum_block"),
            new ResourceLocation("alltheores", "block/aluminum_block"),
            new ResourceLocation("alltheores", "block/aluminum_block"),
            Block::new);

    public static final AllTheCompressedType[] VALUES = values();

    public final String name;
    public final ResourceLocation baseResourceLocation;
    public final List<Block> blocks;
    public final ResourceLocation particlePath;
    public final ResourceLocation baseBlockModel;
    private final Function<BlockBehaviour.Properties, Block> constructor;

    AllTheCompressedType(String n, ResourceLocation baseResourceLocation,
                         ResourceLocation particlePath, ResourceLocation baseBlockModel,
                         Function<BlockBehaviour.Properties, Block> constructor) {
        this.name = n;
        this.blocks = new ArrayList<>();
        this.particlePath = particlePath;
        this.baseBlockModel = baseBlockModel;
        this.baseResourceLocation = baseResourceLocation;
        this.constructor = constructor;
    }

    public Block getBaseBlock() {
        return ForgeRegistries.BLOCKS.getValue(baseResourceLocation);
    }

    public Block getBlock() {
        return constructor.apply(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(baseResourceLocation)));
    }
}
