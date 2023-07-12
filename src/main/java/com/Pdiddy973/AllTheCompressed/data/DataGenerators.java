package com.Pdiddy973.AllTheCompressed.data;

import com.Pdiddy973.AllTheCompressed.AllTheCompressed;
import com.Pdiddy973.AllTheCompressed.data.client.BlockStates;
import com.Pdiddy973.AllTheCompressed.data.client.Languages;
import com.Pdiddy973.AllTheCompressed.data.server.BlockLoot;
import com.Pdiddy973.AllTheCompressed.data.server.BlockTags;
import com.Pdiddy973.AllTheCompressed.data.server.CraftingRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AllTheCompressed.MODID)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(true, new BlockTags(generator, event.getLookupProvider(), fileHelper));
            generator.addProvider(true, new CraftingRecipes(packOutput));
            generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLoot::new, LootContextParamSets.BLOCK))));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(packOutput, fileHelper));
            generator.addProvider(true, new Languages.English(packOutput, fileHelper));
        }

    }
}
