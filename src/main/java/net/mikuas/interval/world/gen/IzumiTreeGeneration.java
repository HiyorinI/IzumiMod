package net.mikuas.interval.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mikuas.interval.world.IzumiPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class IzumiTreeGeneration
{

    public static void registerTrees()
    {
        // locate biome
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(            // 生成群系
                        BiomeKeys.PLAINS,        // 平原
                        BiomeKeys.FOREST                // 森林
                ),
                GenerationStep.Feature.VEGETAL_DECORATION, IzumiPlacedFeatures.IZUMI_TREE_PLACED_KEY
        );
    }
}
