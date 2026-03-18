package net.mikuas.interval.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class IzumiItem extends Item
{
    private boolean HAS_SHIFT_TOOLTIP = false;
    private String shiftTooltip = "";
    private String tooltip = "";

    public IzumiItem(Settings settings)
    {
        super(settings);
    }

    public IzumiItem hasShiftTooltip()
    {
        HAS_SHIFT_TOOLTIP = true;
        return this;
    }

    public IzumiItem setTooltip(String tooltip)
    {
        this.tooltip = tooltip;
        return this;
    }

    public IzumiItem setTooltip(String tooltip  , String shiftTooltip)
    {
        this.tooltip = tooltip;
        this.shiftTooltip = shiftTooltip;
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        super.appendTooltip(stack, context, tooltip, type);
        MutableText text = Text.translatable(HAS_SHIFT_TOOLTIP && Screen.hasShiftDown() ? this.shiftTooltip : this.tooltip);
        tooltip.add(text);
    }
}
