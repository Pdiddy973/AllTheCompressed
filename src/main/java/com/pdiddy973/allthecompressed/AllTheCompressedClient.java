package com.pdiddy973.allthecompressed;

import com.pdiddy973.allthecompressed.client.StackingSource;
import com.pdiddy973.allthecompressed.util.ResourceUtil;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterSpriteSourcesEvent;

import static com.pdiddy973.allthecompressed.util.ResourceUtil.prefix;

@Mod(value = AllTheCompressed.MODID, dist = Dist.CLIENT)
public class AllTheCompressedClient {
    public AllTheCompressedClient(IEventBus modBus) {
        modBus.addListener(AllTheCompressedClient::onRegisterSpriteSources);
    }

    private static void onRegisterSpriteSources(RegisterSpriteSourcesEvent event) {
        event.register(StackingSource.ID, StackingSource.CODEC);
    }
}
