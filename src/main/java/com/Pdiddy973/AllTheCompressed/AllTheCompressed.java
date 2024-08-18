package com.Pdiddy973.AllTheCompressed;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AllTheCompressed.MODID)
public class AllTheCompressed {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "allthecompressed";

    @SuppressWarnings("java:S1118")
    public AllTheCompressed(IEventBus eventBus) {
        LOGGER.info("Registering mod: {}", MODID);
        ModRegistry.register(eventBus);
    }
}
