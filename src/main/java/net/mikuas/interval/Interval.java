package net.mikuas.interval;

import net.fabricmc.api.ModInitializer;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItemGroups;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.tags.IzumiBlockTags;
import net.mikuas.interval.tags.IzumiItemTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Interval implements ModInitializer
{
    public static final String MOD_ID = "interval";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize()
    {
        IzumiItems.registerModItems();
        IzumiItemGroups.registerModItemGroups();
        IzumiBlocks.registerBlockItems();
        IzumiBlockTags.registerIzumiBlockTags();
        IzumiItemTags.registerIzumiItemTags();
    }
}
