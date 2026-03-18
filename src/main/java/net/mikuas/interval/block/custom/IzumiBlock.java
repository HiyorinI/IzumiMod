package net.mikuas.interval.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class IzumiBlock extends Block
{
    private boolean HAS_SHIFT_TOOLTIP = false;
    private String shiftTooltip = "";
    private String tooltip = "";

    public IzumiBlock(Settings settings)
    {
        super(settings);
    }

    public IzumiBlock hasShiftTooltip()
    {
        HAS_SHIFT_TOOLTIP = true;
        return this;
    }

    public IzumiBlock setTooltip(String tooltip)
    {
        this.tooltip = tooltip;
        return this;
    }

    public IzumiBlock setTooltip(String tooltip  , String shiftTooltip)
    {
        this.tooltip = tooltip;
        this.shiftTooltip = shiftTooltip;
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        super.appendTooltip(stack, context, tooltip, type);
        MutableText text = Text.translatable(HAS_SHIFT_TOOLTIP && Screen.hasShiftDown() ? this.shiftTooltip : this.tooltip);
        tooltip.add(text);
    }
}
