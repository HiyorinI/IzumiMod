package net.mikuas.interval.world;

import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class IzumiPlacedFeatures
{
    public static final RegistryKey<PlacedFeature> IZUMI_TREE_PLACED_KEY = of("izumi_tree_placed");                     // 树
    public static final RegistryKey<PlacedFeature> IZUMI_SIMPLE_FLOWER_PLACED_KEY = of("izumi_simple_flower_placed");   // 花
    public static final RegistryKey<PlacedFeature> IZUMI_ORE_PLACED_KEY = of("izumi_ore_placed");                       // 矿石
    public static final RegistryKey<PlacedFeature> NETHER_IZUMI_ORE_PLACED_KEY = of("nether_izumi_ore_placed");         // 下界矿石
    public static final RegistryKey<PlacedFeature> END_IZUMI_ORE_PLACED_KEY = of("end_izumi_ore_placed");               // 末地矿石

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable)
    {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // 树
        register(featureRegisterable, IZUMI_TREE_PLACED_KEY, registryEntryLookup.getOrThrow(IzumiConfiguredFeatures.IZUMI_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(
                                2,                   // 每个区块生成数量
                                0.1F,                       // 额外生成概率
                                2                           // 额外数量
                        ),
                        IzumiBlocks.IZUMI_SAPLING
                )
        );

        // 花
        register(featureRegisterable,
                IZUMI_SIMPLE_FLOWER_PLACED_KEY,
                registryEntryLookup.getOrThrow(IzumiConfiguredFeatures.SIMPLE_FLOWER_KEY),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        // 矿石
        register(featureRegisterable, IZUMI_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(IzumiConfiguredFeatures.IZUMI_ORE_KEY),
                IzumiOrePlacements.modifiersWithCount(  // 按照数量放置
                        12,                             // 每个区块最大生成多少个矿脉
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))
                        // HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))
                )
        );
        register(featureRegisterable, NETHER_IZUMI_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(IzumiConfiguredFeatures.NETHER_IZUMI_ORE_KEY),
                IzumiOrePlacements.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
        );
        register(featureRegisterable, END_IZUMI_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(IzumiConfiguredFeatures.END_IZUMI_ORE_KEY),
                IzumiOrePlacements.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
        );
    }

    public static RegistryKey<PlacedFeature> of(String id)
    {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Interval.MOD_ID, id));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    )
    {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    )
    {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}
