package com.Pdiddy973.allthecompressed;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;


@Mod("allthecompressed")
public class AllTheCompressed {
    public static final ItemGroup creativeTab = new ItemGroup("AllTheCompressed") {
        @Override
        // @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:unobtainium_block_1x")));
        }
    };

    public AllTheCompressed() {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItems);

        DistExecutor.runForDist(() -> () -> new AllTheCompressedClient(), () -> () -> new AllTheCompressedCommon()).init();
    }

    private void registerBlocks(RegistryEvent.Register<Block> event) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (int i = 0; i < 9; i++) {
                Block block = type.factory.get();
                event.getRegistry().register(block.setRegistryName(type.name + "_block_" + (i + 1) + "x"));
                type.blocks.add(block);
            }
        }
    }

    private void registerItems(RegistryEvent.Register<Item> event) {
        for (AllTheCompressedType type : AllTheCompressedType.VALUES) {
            for (Block block : type.blocks) {
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(creativeTab)).setRegistryName(block.getRegistryName()));
            }
        }
    }
}