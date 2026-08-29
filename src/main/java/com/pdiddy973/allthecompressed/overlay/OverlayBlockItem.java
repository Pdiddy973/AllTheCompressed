package com.pdiddy973.allthecompressed.overlay;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.text.NumberFormat;
import java.util.function.Consumer;

import static com.pdiddy973.allthecompressed.util.TranslationKey.translateTooltip;

public class OverlayBlockItem extends BlockItem {
    private final String quantity;

    public OverlayBlockItem(Block block, Properties properties, int level) {
        super(block, properties);
        double pow = Math.pow(9, level);
        this.quantity = NumberFormat.getInstance().format(pow);
    }

    @Override
    @SuppressWarnings("deprecation") // deprecated by Mojang
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        builder.accept(translateTooltip("quantity", quantity));
    }
}
