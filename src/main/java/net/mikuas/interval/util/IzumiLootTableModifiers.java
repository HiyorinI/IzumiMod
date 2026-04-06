package net.mikuas.interval.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class IzumiLootTableModifiers
{
    /*
        // 战利品列表

        assets -> data -> loot_table -> ...

        locate structure ...
     */

    // jungle_temple, 丛林神庙
    private static final Identifier JUNGLE_TEMPLE = Identifier.ofVanilla("chests/jungle_temple"); // chests 文件夹 jungle_temple JSON

    // 苦力怕
    private static final Identifier CREEPER = Identifier.ofVanilla("entities/creeper");
//    creeper

    // 僵尸
    private static final Identifier ZOMBIE = Identifier.ofVanilla("entities/zombie");

    public static void modifyLootTable()
    {
        LootTableEvents.MODIFY.register((key,  builder, lootTableSource, wrapperLookup) ->
        {
            if (JUNGLE_TEMPLE.equals(key.getValue()))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(1.0F))
                        .with(ItemEntry.builder(IzumiItems.PROSPECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)));

                builder.pool(poolBuilder);
            }

            if (CREEPER.equals(key.getValue()))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(1.0F))
                        .with(ItemEntry.builder(IzumiItems.IZUMI_CLSY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 12.0F)));

                builder.pool(poolBuilder);
            }

            if (ZOMBIE.equals(key.getValue()))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(1.0F))
                        .with(ItemEntry.builder(IzumiItems.IZUMI_FOOD_PAI_MENG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 3.0F)));

                builder.pool(poolBuilder);
            }
        }
        );
    }
}
