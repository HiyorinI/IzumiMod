package net.mikuas.interval.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mikuas.interval.world.IzumiPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class IzumiOreGeneration
{
    public static void generateOres()
    {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, IzumiPlacedFeatures.IZUMI_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, IzumiPlacedFeatures.NETHER_IZUMI_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, IzumiPlacedFeatures.END_IZUMI_ORE_PLACED_KEY);
    }
}
