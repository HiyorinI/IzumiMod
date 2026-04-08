package net.mikuas.interval.world.biome;

import net.mikuas.interval.Interval;
import net.mikuas.interval.world.biome.surface.IzumiMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class IzumiTerraBlenderAPI implements TerraBlenderApi
{
    @Override
    public void onTerraBlenderInitialized()
    {
        Regions.register(new IzumiOverworldRegion(Identifier.of(Interval.MOD_ID, "overworld"), 4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Interval.MOD_ID, IzumiMaterialRules.makeRules());
    }
}
