package com.pdiddy973.allthecompressed.data;

import com.pdiddy973.allthecompressed.AllTheCompressed;
import com.pdiddy973.allthecompressed.data.client.BlockModels;
import com.pdiddy973.allthecompressed.data.client.Languages;
import com.pdiddy973.allthecompressed.data.server.BlockLoot;
import com.pdiddy973.allthecompressed.data.server.BlockTags;
import com.pdiddy973.allthecompressed.data.server.CraftingRecipes;
import com.pdiddy973.allthecompressed.data.server.DataMaps;
import com.pdiddy973.allthecompressed.data.server.ItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;


@EventBusSubscriber(modid = AllTheCompressed.MODID)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherServer(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        ResourceManager server = event.getResourceManager(PackType.SERVER_DATA);

        generator.addProvider(true, new BlockTags(generator, event.getLookupProvider(), server));
        generator.addProvider(true, new ItemTags(generator, event.getLookupProvider()));
        generator.addProvider(true, new CraftingRecipes.Runner(packOutput, event.getLookupProvider()));
        generator.addProvider(true, new DataMaps(packOutput, event.getLookupProvider()));
        generator.addProvider(true, new LootTableProvider(
            packOutput,
            Collections.emptySet(),
            List.of(new LootTableProvider.SubProviderEntry(BlockLoot::new, LootContextParamSets.BLOCK)),
            event.getLookupProvider()
        ));
    }

    @SubscribeEvent
    public static void gatherClient(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        ResourceManager client = event.getResourceManager(PackType.CLIENT_RESOURCES);

        generator.addProvider(true, new BlockModels(packOutput));
        generator.addProvider(true, new Languages.English(packOutput, client));
    }
}
