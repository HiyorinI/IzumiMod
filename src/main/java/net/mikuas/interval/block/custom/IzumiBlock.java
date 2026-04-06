package net.mikuas.interval.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IzumiBlock extends Block
{
    private boolean isHasShiftTooltip = false;
    private String shiftTooltip = null;
    private String tooltip = null;

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public IzumiBlock(Settings settings)
    {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    public IzumiBlock hasShiftTooltip()
    {
        this.isHasShiftTooltip = true;
        return this;
    }

    public boolean isHasShiftTooltip()
    {
        return this.isHasShiftTooltip;
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
        if (this.tooltip != null)
        {
            MutableText text = Text.translatable((this.isHasShiftTooltip() && Screen.hasShiftDown()) ? this.shiftTooltip : this.tooltip);
            tooltip.add(text);
        }
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation)
    {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror)
    {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }
}
