package com.Pdiddy973.AllTheCompressed.data.server;

import com.Pdiddy973.AllTheCompressed.overlay.Overlays;
import com.google.common.math.IntMath;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class DataMaps extends DataMapProvider {
    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    public DataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        final var fuels = builder(NeoForgeDataMaps.FURNACE_FUELS);

        fuels.add(Overlays.BLAZE.overlay.parent, new FurnaceFuel(24000), false);

        for (int i = 0;i < 9;i++) {
            var coal = Overlays.COAL.overlay.iall.get(i);
            long burnTime = 16000L * IntMath.checkedPow(9,1 + i);
            if (burnTime < Integer.MAX_VALUE) {
                fuels.add(coal, new FurnaceFuel((int) burnTime), false);
            }

            var blaze = Overlays.BLAZE.overlay.iall.get(i);
            long blazeBurnTime = 24000L * IntMath.checkedPow(9,1 + i);
            if (blazeBurnTime < Integer.MAX_VALUE) {
                fuels.add(blaze, new FurnaceFuel((int) blazeBurnTime), false);
            }
        }
    }
}
