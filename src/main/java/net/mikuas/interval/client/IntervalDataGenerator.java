package net.mikuas.interval.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mikuas.interval.Interval;
import net.mikuas.interval.datagen.*;
import net.mikuas.interval.enchantment.IzumiEnchantments;
import net.mikuas.interval.sound.IzumiJukeboxSongs;
import net.mikuas.interval.world.IzumiConfiguredFeatures;
import net.mikuas.interval.world.IzumiPlacedFeatures;
import net.mikuas.interval.world.biome.IzumiBiomes;
import net.mikuas.interval.world.dimension.IzumiDimensions;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class IntervalDataGenerator implements DataGeneratorEntrypoint
{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
    {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(IzumiBlockTagsProvider::new);

        pack.addProvider(IzumiENUSLanProvider::new);
        pack.addProvider(IzumiZHCNLanProvider::new);

        pack.addProvider(IzumiItemTagsProvider::new);
        pack.addProvider(IzumiLootTableProvider::new);
        pack.addProvider(IzumiModelsProvider::new);
        pack.addProvider(IzumiRecipesProvider::new);

        pack.addProvider(IzumiPointTagProvider::new);

        pack.addProvider(IzumiWorldGenProvider::new);

        Interval.LOGGER.info("Data Generator");

        /*
            RUN DATA GENERATION

         */
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder)
    {
        registryBuilder.addRegistry(RegistryKeys.JUKEBOX_SONG, IzumiJukeboxSongs::bootstrap);
        // 树苗
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, IzumiConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, IzumiPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, IzumiBiomes::bootstrap);

        // 维度
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, IzumiDimensions::bootstrap);

        // 附魔
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, IzumiEnchantments::bootstrap);
    }
}
