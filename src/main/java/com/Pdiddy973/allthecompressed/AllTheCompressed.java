package com.Pdiddy973.allthecompressed;

import com.Pdiddy973.allthecompressed.blocks.block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


@Mod("allthecompressed")
public class AllTheCompressed<iEventBus>
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "allthecompressed";

    public AllTheCompressed() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        block.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}

@Mod.EventBusSubscriber(modid = AllTheCompressed.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
class ModEventBusSubscriber {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        block.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .forEach(block -> {
                    final Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_MATERIALS);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
                    registry.register(blockItem);
                });
    }
}