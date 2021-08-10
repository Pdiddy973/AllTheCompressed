package com.Pdiddy973.allthecompressed.blocks;

import com.Pdiddy973.allthecompressed.AllTheCompressed;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class block {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AllTheCompressed.MOD_ID);

    //Aluminum Blocks
    public static final RegistryObject<Block> ALUMINUM_BLOCK_1X = BLOCKS.register("aluminum_block_1x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_2X = BLOCKS.register("aluminum_block_2x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_3X = BLOCKS.register("aluminum_block_3x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_4X = BLOCKS.register("aluminum_block_4x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_5X = BLOCKS.register("aluminum_block_5x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_6X = BLOCKS.register("aluminum_block_6x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_7X = BLOCKS.register("aluminum_block_7x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_8X = BLOCKS.register("aluminum_block_8x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUM_BLOCK_9X = BLOCKS.register("aluminum_block_9x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    //Copper Blocks
    public static final RegistryObject<Block> COPPER_BLOCK_1X = BLOCKS.register("copper_block_1x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_2X = BLOCKS.register("copper_block_2x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_3X = BLOCKS.register("copper_block_3x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_4X = BLOCKS.register("copper_block_4x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_5X = BLOCKS.register("copper_block_5x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_6X = BLOCKS.register("copper_block_6x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_7X = BLOCKS.register("copper_block_7x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_8X = BLOCKS.register("copper_block_8x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BLOCK_9X = BLOCKS.register("copper_block_9x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    //Lead Blocks
    public static final RegistryObject<Block> LEAD_BLOCK_1X = BLOCKS.register("lead_block_1x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_2X = BLOCKS.register("lead_block_2x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_3X = BLOCKS.register("lead_block_3x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_4X = BLOCKS.register("lead_block_4x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_5X = BLOCKS.register("lead_block_5x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_6X = BLOCKS.register("lead_block_6x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_7X = BLOCKS.register("lead_block_7x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_8X = BLOCKS.register("lead_block_8x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK_9X = BLOCKS.register("lead_block_9x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    //Nickel Blocks
    public static final RegistryObject<Block> NICKEL_BLOCK_1X = BLOCKS.register("nickel_block_1x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_2X = BLOCKS.register("nickel_block_2x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_3X = BLOCKS.register("nickel_block_3x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_4X = BLOCKS.register("nickel_block_4x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_5X = BLOCKS.register("nickel_block_5x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_6X = BLOCKS.register("nickel_block_6x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_7X = BLOCKS.register("nickel_block_7x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_8X = BLOCKS.register("nickel_block_8x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKEL_BLOCK_9X = BLOCKS.register("nickel_block_9x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    //Osmium Blocks
    public static final RegistryObject<Block> OSMIUM_BLOCK_1X = BLOCKS.register("osmium_block_1x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_2X = BLOCKS.register("osmium_block_2x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_3X = BLOCKS.register("osmium_block_3x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_4X = BLOCKS.register("osmium_block_4x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_5X = BLOCKS.register("osmium_block_5x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_6X = BLOCKS.register("osmium_block_6x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_7X = BLOCKS.register("osmium_block_7x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_8X = BLOCKS.register("osmium_block_8x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK_9X = BLOCKS.register("osmium_block_9x", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).strength(15f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL).requiresCorrectToolForDrops()));

}
