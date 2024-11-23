package com.Pdiddy973.AllTheCompressed.overlay;

import com.Pdiddy973.AllTheCompressed.util.TranslationKey;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(TranslationKey.translateTooltip("quantity", quantity));
    }
}
