package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.custom.IzumiCropBlock;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class IzumiLootTableProvider extends FabricBlockLootTableProvider
{
    public IzumiLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        // 掉落物
        addDrop(IzumiBlocks.IZUMI_ETHER_AMBER);
        addDrop(IzumiBlocks.IZUMI_FLUX_CRYSTAL);
        addDrop(IzumiBlocks.IZUMI_VOID_MIST);

        addDrop(IzumiBlocks.IZUMI_AI_YIN);
//        addDrop(ModBlocks.ICE_QCF_BLOCK);

        addDrop(IzumiBlocks.IZUMI_ETHER_STAIRS);
        addDrop(IzumiBlocks.IZUMI_ETHER_SLAB);
        addDrop(IzumiBlocks.IZUMI_ETHER_BUTTON);
        addDrop(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE);
        addDrop(IzumiBlocks.IZUMI_ETHER_FENCE);
        addDrop(IzumiBlocks.IZUMI_ETHER_FENCE_GATE);
        addDrop(IzumiBlocks.IZUMI_ETHER_WALL);
        addDrop(IzumiBlocks.IZUMI_ETHER_DOOR);
        addDrop(IzumiBlocks.IZUMI_ETHER_TRAPDOOR);

        /*
            自定义方块
         */
        addDrop(IzumiBlocks.IZUMI_SIMPLE_BLOCK);

        // 一般矿石写法
        addDrop(IzumiBlocks.IZUMI_FLUOR_ICE, copperOreLikeDrops(IzumiBlocks.IZUMI_FLUOR_ICE, IzumiItems.IZUMI_MIMI));

        addDrop(IzumiBlocks.IZUMI_LOG);
        addDrop(IzumiBlocks.IZUMI_WOOD);
        addDrop(IzumiBlocks.STRIPPED_IZUMI_LOG);
        addDrop(IzumiBlocks.STRIPPED_IZUMI_WOOD);
        addDrop(IzumiBlocks.IZUMI_PLANKS);

        addDrop(IzumiBlocks.IZUMI_SIMPLE_FLOWER);

        // 作物
        // LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(IzumiBlocks.IZUMI_CROP).properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 3));

        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(IzumiBlocks.IZUMI_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(IzumiCropBlock.AGE, 3));
        addDrop(IzumiBlocks.IZUMI_CROP, cropDrops(IzumiBlocks.IZUMI_CROP, IzumiItems.IZUMI_MIMI, IzumiItems.IZUMI_SEED, builder2));

        LootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(IzumiBlocks.IZUMI_MULTI_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(IzumiCropBlock.AGE, 8));
        addDrop(IzumiBlocks.IZUMI_MULTI_CROP, cropDrops(IzumiBlocks.IZUMI_MULTI_CROP, IzumiItems.IZUMI_MIMI, IzumiItems.IZUMI_MULTI_CROP_SEED, builder3));

//        addDrop(IzumiBlocks.IZUMI_CROP,
//                cropDrops(IzumiBlocks.IZUMI_CROP,   // 作物
//                        IzumiItems.IZUMI_FOOD_PAI_MENG,  // 产物
//                         IzumiItems.IZUMI_SEED,      //种子
//                         builder2
//                 )
//         );
    }

    public LootTable.Builder copperOreLikeDrops(Block drop, Item dropItem)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 10.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
