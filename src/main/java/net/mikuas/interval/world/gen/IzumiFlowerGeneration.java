package net.mikuas.interval.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mikuas.interval.world.IzumiPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class IzumiFlowerGeneration
{
    public static void generateFlowers()
    {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, IzumiPlacedFeatures.IZUMI_SIMPLE_FLOWER_PLACED_KEY
        );
    }
}
