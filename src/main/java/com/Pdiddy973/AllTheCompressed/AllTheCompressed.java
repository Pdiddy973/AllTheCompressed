package com.Pdiddy973.AllTheCompressed;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AllTheCompressed.MODID)
public class AllTheCompressed {
    public static final String MODID = "allthecompressed";
    public static final CreativeModeTab creativeTab = new CreativeModeTab(AllTheCompressed.MODID) {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("allthecompressed:gold_block_4x")));
        }
    };

    public AllTheCompressed() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addGenericListener(Block.class, this::registerBlocks);
        eventBus.addGenericListener(Item.class, this::registerItems);
        eventBus.addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        AllTheCompressedClient.setupItemVar();
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
