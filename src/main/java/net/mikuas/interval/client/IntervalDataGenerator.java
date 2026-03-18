package net.mikuas.interval.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mikuas.interval.Interval;
import net.mikuas.interval.datagen.*;

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

        Interval.LOGGER.info("Data Generator");

        /*
            RUN DATA GENERATION

         */
    }
}
