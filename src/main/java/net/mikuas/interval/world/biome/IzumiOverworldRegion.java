package net.mikuas.interval.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class IzumiOverworldRegion extends Region
{
    public IzumiOverworldRegion(Identifier name, int weight)
    {
        /// OVERWORLD 主世界
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper,modifiedVanillaOverworldBuilder ->
        {
            ///  replaceBiome 置换群系[FOREST -> 森林群系] => IZUMI_VOID_MIST_BIOME
            // modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FOREST, IzumiBiomes.IZUMI_VOID_MIST_BIOME);
            ///  replaceBiome 置换群系[PLAINS -> 平原群系] => IZUMI_VOID_MIST_BIOME
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, IzumiBiomes.IZUMI_VOID_MIST_BIOME);
        });
    }
}
