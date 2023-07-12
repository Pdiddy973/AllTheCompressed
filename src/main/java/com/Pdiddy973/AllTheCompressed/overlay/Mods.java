package com.Pdiddy973.AllTheCompressed.overlay;

import java.util.Locale;

public enum Mods {
    ALLTHEMODIUM,
    ALLTHEORES,
    ALLTHETWEAKS,
    BOTANIA,
    ENDERIO,
    MINECRAFT,
    POWAH,
    PRODUCTIVEBEES,
    SUPPLEMENTARIES,
    ;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
