package com.Pdiddy973.AllTheCompressed.data;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.resources.ClientPackSource;
import net.minecraft.client.resources.IndexedAssetSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.ServerPacksSource;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.resource.ResourcePackLoader;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ResourceUtil {
    public final MultiPackResourceManager clientResources, serverData;
    private final boolean enable;
    private final Multimap<PackType, ResourceLocation> generated = HashMultimap.create();

    public ResourceUtil(Collection<Path> existingPacks, final Set<String> existingMods, boolean enable, @Nullable final String assetIndex, @Nullable final File assetsDir) {
        List<PackResources> candidateClientResources = new ArrayList<>();
        List<PackResources> candidateServerResources = new ArrayList<>();

        if (assetIndex != null && assetsDir != null && assetsDir.exists())
        {
            candidateClientResources.add(ClientPackSource.createVanillaPackSource(IndexedAssetSource.createIndexFs(assetsDir.toPath(), assetIndex)));
        }
        candidateServerResources.add(ServerPacksSource.createVanillaPackSource());
        for (Path existing : existingPacks) {
            File file = existing.toFile();
            PackResources pack = file.isDirectory() ? new PathPackResources(file.getName(), file.toPath(), false) : new FilePackResources(file.getName(), file, false);
            candidateClientResources.add(pack);
            candidateServerResources.add(pack);
        }
        for (String existingMod : existingMods) {
            IModFileInfo modFileInfo = ModList.get().getModFileById(existingMod);
            if (modFileInfo != null) {
                PackResources pack = ResourcePackLoader.createPackForMod(modFileInfo);
                candidateClientResources.add(pack);
                candidateServerResources.add(pack);
            }
        }

        this.clientResources = new MultiPackResourceManager(PackType.CLIENT_RESOURCES, candidateClientResources);
        this.serverData = new MultiPackResourceManager(PackType.SERVER_DATA, candidateServerResources);

        this.enable = enable;
    }
}
