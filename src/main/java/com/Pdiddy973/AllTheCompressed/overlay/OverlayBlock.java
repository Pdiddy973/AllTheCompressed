package com.Pdiddy973.AllTheCompressed.overlay;

import com.Pdiddy973.AllTheCompressed.util.TranslationKey;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.text.NumberFormat;
import java.util.List;

public class OverlayBlock extends Block {
    private final String quantity;

    public OverlayBlock(Properties properties, int level) {
        super(properties);
        double pow = Math.pow(9, level);
        this.quantity = NumberFormat.getInstance().format(pow);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(TranslationKey.translateTooltip("quantity", quantity));
    }
}
