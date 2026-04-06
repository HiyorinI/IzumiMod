package net.mikuas.interval.block;

import net.mikuas.interval.Interval;
import net.mikuas.interval.block.custom.IzumiFenDaFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiFluids
{
    public static final FlowableFluid FLOWING_FEN_DA = register("flowing_fen_da", new IzumiFenDaFluid.Flowing());
    public static final FlowableFluid FEN_DA = register("fen_da", new IzumiFenDaFluid.Still());

    private static <T extends Fluid> T register(String id, T value)
    {
        return Registry.register(Registries.FLUID, Identifier.of(Interval.MOD_ID, id), value);
    }

    static
    {
        for (Fluid fluid : Registries.FLUID)
        {
            for (FluidState fluidState : fluid.getStateManager().getStates())
            {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }

    public static void registerIzumiFluids()
    {

    }
}
