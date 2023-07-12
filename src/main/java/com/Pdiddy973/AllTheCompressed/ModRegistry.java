package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.Pdiddy973.AllTheCompressed.util.TranslationKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRegistry {
    private ModRegistry() {
        // nothing to do
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AllTheCompressed.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AllTheCompressed.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AllTheCompressed.MODID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
        .icon(() -> Overlays.GOLD.overlay.i4.get().getDefaultInstance())
        .title(Component.translatable(TranslationKey.tab()))
        .displayItems((parameters, output) -> {
            for (Overlays value : Overlays.values()) {
                if (ModList.get().isLoaded(value.mod.toString())) {
                    value.overlay.iall.stream()
                        .map(RegistryObject::get)
                        .map(Item::getDefaultInstance)
                        .forEach(output::accept);
                }
            }
        }).build()
    );

    public static void register() {
        Overlays.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
