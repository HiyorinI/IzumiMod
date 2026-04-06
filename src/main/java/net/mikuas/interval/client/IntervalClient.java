package net.mikuas.interval.client;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.mikuas.interval.block.IzumiFluids;
import net.mikuas.interval.entity.IzumiBoats;
import net.mikuas.interval.screen.IzumiScreenHandlers;
import net.mikuas.interval.screen.PolishingMachineScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class IntervalClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {

        /*
            流体
         */
        // 材质
        FluidRenderHandlerRegistry.INSTANCE.register(IzumiFluids.FEN_DA, IzumiFluids.FLOWING_FEN_DA,
                new SimpleFluidRenderHandler(
                        Identifier.of("minecraft:block/water_still"),
                        Identifier.of("minecraft:block/water_flow"),
                        0XFDD319 // Color
                )
        );
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), IzumiFluids.FEN_DA, IzumiFluids.FLOWING_FEN_DA);

        HandledScreens.register(IzumiScreenHandlers.POLISHING_MACHINE_SCREEN_HANDLER, PolishingMachineScreen::new);

        /*
            船
         */
        TerraformBoatClientHelper.registerModelLayers(IzumiBoats.IZUMI_BOAT, false // 是否为竹筏
        );
    }
}
