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
    private boolean isHasShiftTooltip = false;
    private String shiftTooltip = null;
    private String tooltip = null;

    public IzumiItem(Settings settings)
    {
        super(settings);
    }

    public IzumiItem hasShiftTooltip()
    {
        this.isHasShiftTooltip = true;
        return this;
    }

    public boolean isHasShiftTooltip()
    {
        return this.isHasShiftTooltip;
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
        if (this.tooltip != null)
        {
            MutableText text = Text.translatable(this.isHasShiftTooltip() && Screen.hasShiftDown() ? this.shiftTooltip : this.tooltip);
            tooltip.add(text);
        }
    }
}
