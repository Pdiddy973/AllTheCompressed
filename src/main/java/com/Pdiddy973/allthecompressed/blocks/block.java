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

    public static final RegistryObject<Block> ALUMINUM_BLOCK_1X = BLOCKS.register("aluminum_block_1x",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                    .strength(15f, 30f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.METAL)));
}
