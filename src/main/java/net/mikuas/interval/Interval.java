package net.mikuas.interval;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.IzumiFluids;
import net.mikuas.interval.block.entity.IzumiBoxBlockEntities;
import net.mikuas.interval.entity.IzumiBoats;
import net.mikuas.interval.item.IzumiItemGroups;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.recipe.IzumiRecipeTypes;
import net.mikuas.interval.screen.IzumiScreenHandlers;
import net.mikuas.interval.sound.IzumiSoundEvents;
import net.mikuas.interval.tags.IzumiBlockTags;
import net.mikuas.interval.tags.IzumiItemTags;
import net.mikuas.interval.util.IzumiLootTableModifiers;
import net.mikuas.interval.util.IzumiTrade;
import net.mikuas.interval.villager.IzumiVillagers;
import net.mikuas.interval.world.gen.IzumiWorldGeneration;
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

        IzumiLootTableModifiers.modifyLootTable();
        IzumiTrade.registerIzumiTrade();
        IzumiVillagers.registerIzumiVillagers();

        IzumiSoundEvents.registerIzumiSoundEvents();

        IzumiFluids.registerIzumiFluids();
        IzumiBoxBlockEntities.registerIzumiBoxBlockEntities();

        IzumiScreenHandlers.registerScreenHandlers();
        IzumiRecipeTypes.registerRecipeTypes();

        IzumiBoats.registerIzumiBoats();
        IzumiWorldGeneration.registerWorldGenerations();

        /*
            木头, 去皮
         */
        StrippableBlockRegistry.register(
                IzumiBlocks.IZUMI_LOG, // 源
                IzumiBlocks.STRIPPED_IZUMI_LOG // 去皮结果
        );
        StrippableBlockRegistry.register(IzumiBlocks.IZUMI_WOOD, IzumiBlocks.STRIPPED_IZUMI_WOOD);

        // 可被燃烧 -> 燃料[TAG]
        FlammableBlockRegistry.getDefaultInstance().add(
                IzumiBlocks.IZUMI_LOG,  // 材料
                5,                      // 燃烧速度
                5                       // 扩散概率, 越大越容易被引燃
        );
        FlammableBlockRegistry.getDefaultInstance().add(IzumiBlocks.IZUMI_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(IzumiBlocks.STRIPPED_IZUMI_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(IzumiBlocks.STRIPPED_IZUMI_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(IzumiBlocks.IZUMI_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(IzumiBlocks.IZUMI_PLANKS, 5, 20);
    }
}
