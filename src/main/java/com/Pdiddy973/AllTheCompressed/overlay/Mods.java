package com.Pdiddy973.AllTheCompressed.overlay;

import java.util.Locale;

public enum Mods {
    ALLTHECOMPRESSED,
    ALLTHEMODIUM,
    ALLTHEORES,
    ALLTHETWEAKS,
    AE2,
    APPFLUX,
    BOTANIA,
    ENDERIO,
    EXTENDEDAE,
    MEGACELLS,
    MINECRAFT,
    PNEUMATICCRAFT,
    POWAH,
    PRODUCTIVEBEES,
    SUPPLEMENTARIES,
    XYCRAFT_WORLD,
    ;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
