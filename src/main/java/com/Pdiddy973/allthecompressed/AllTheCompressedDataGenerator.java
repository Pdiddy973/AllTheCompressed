package com.Pdiddy973.AllTheCompressed;

import com.Pdiddy973.AllTheCompressed.generators.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = AllTheCompressed.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AllTheCompressedDataGenerator {

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new AllTheCompressedRecipeProvider(generator));
            generator.addProvider(new AllTheCompressedLootTableProvider(generator));
        }
        if (event.includeClient()) {
            generator.addProvider(new AllTheCompressedBlockStateProvider(generator, event.getExistingFileHelper()));
            generator.addProvider(new AllTheCompressedItemModelProvider(generator, event.getExistingFileHelper()));
            //this only generates the english language portion. other languages need their own provider
            generator.addProvider(new AllTheCompressedLanguageProvider(generator, "en_us"));
        }
    }
}

