package net.mikuas.interval.block.custom;

import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.IzumiFluid;
import net.mikuas.interval.block.IzumiFluids;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;

public abstract class IzumiFenDaFluid extends IzumiFluid
{
    @Override
    public Fluid getStill()
    {
        return IzumiFluids.FEN_DA;
    }

    @Override
    public Fluid getFlowing()
    {
        return IzumiFluids.FLOWING_FEN_DA;
    }

    @Override
    public Item getBucketItem()
    {
        return IzumiItems.FEN_DA_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state)
    {
        return IzumiBlocks.FEN_DA.getDefaultState().with(FluidBlock.LEVEL, WaterFluid.getBlockStateLevel(state));
    }

    public static class Flowing extends IzumiFenDaFluid
    {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends IzumiFenDaFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
