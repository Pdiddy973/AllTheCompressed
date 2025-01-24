package com.Pdiddy973.AllTheCompressed.data;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.data.client.BlockStates;
import com.Pdiddy973.AllTheCompressed.data.client.Languages;
import com.Pdiddy973.AllTheCompressed.data.client.XycraftBlockStates;
import com.Pdiddy973.AllTheCompressed.data.server.BlockLoot;
import com.Pdiddy973.AllTheCompressed.data.server.BlockTags;
import com.Pdiddy973.AllTheCompressed.data.server.CraftingRecipes;
import com.Pdiddy973.AllTheCompressed.data.server.DataMaps;
import com.Pdiddy973.AllTheCompressed.data.server.ItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = AllTheCompressed.MODID)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        if (!event.getModContainer().getModId().equals(AllTheCompressed.MODID)) return;

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTags blockTags = new BlockTags(generator, event.getLookupProvider(), fileHelper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new ItemTags(generator, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new CraftingRecipes(packOutput, event.getLookupProvider()));
            generator.addProvider(true, new DataMaps(packOutput, event.getLookupProvider()));
            generator.addProvider(true, new LootTableProvider(
                packOutput,
                Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLoot::new, LootContextParamSets.BLOCK)),
                event.getLookupProvider()
            ));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(packOutput, fileHelper));
            generator.addProvider(true, new XycraftBlockStates(packOutput, fileHelper));
            generator.addProvider(true, new Languages.English(packOutput, fileHelper));
        }

    }
}
