package net.mikuas.interval.world.biome;

import net.mikuas.interval.Interval;
import net.mikuas.interval.entity.IzumiEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

/// 生物群系
public class IzumiBiomes
{
    /// 群系
    public static final RegistryKey<Biome> IZUMI_VOID_MIST_BIOME = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Interval.MOD_ID, "izumi_void_mist_biome"));

    public static void globalOverWorldGeneration(GenerationSettings.LookupBackedBuilder builder)
    {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    private static Biome diamondBiome(Registerable<Biome> context)
    {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        /// 生物
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(IzumiEntities.TIGER, 2, 3, 5));

        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
        );

        globalOverWorldGeneration(generationSettings);
        DefaultBiomeFeatures.addMossyRocks(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addExtraGoldOre(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        DefaultBiomeFeatures.addForestFlowers(generationSettings);
        DefaultBiomeFeatures.addLargeFerns(generationSettings);

        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.7f)
                .generationSettings(generationSettings.build())
                .spawnSettings(spawnSettings.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x7BD4FF)       // 水颜色
                        .waterFogColor(0x7BD4FF)    // 雾颜色
                        .skyColor(0xFDD3CC)         // 天空颜色
                        .grassColor(0xCCB3BC)       // 草颜色
                        .foliageColor(0xFFA7A4)     // 树叶颜色
                        .fogColor(0xC0D8FF)         //
                        .build()
                ).build();
    }

    public static void bootstrap(Registerable<Biome> context)
    {
        context.register(IZUMI_VOID_MIST_BIOME, diamondBiome(context));
    }
}
