package net.mikuas.interval.world;

import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class IzumiConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?, ?>> IZUMI_TREE_KEY = of("izumi_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SIMPLE_FLOWER_KEY = of("simple_flower");

    public static final RegistryKey<ConfiguredFeature<?, ?>> IZUMI_ORE_KEY = of("izumi_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_IZUMI_ORE_KEY = of("nether_izumi_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_IZUMI_ORE_KEY = of("end_izumi_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable)
    {
        /*
         * 树的世界生成
         */
        register(featureRegisterable, IZUMI_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(IzumiBlocks.IZUMI_LOG),       // 原木
                new StraightTrunkPlacer(4, 3, 2),          // 树干 [最小高度, 随机增加高度, 第二随机基础上的随机增加高度]
                BlockStateProvider.of(IzumiBlocks.IZUMI_LEAVES),    // 树叶
                new BlobFoliagePlacer(
                        ConstantIntProvider.create(2),              // 树叶半径：2 (比你的 4 小很多)
                        ConstantIntProvider.create(0),              // 树叶偏移：0 (树叶从顶端开始包住)
                        3                                           // 树叶高度：3层
                ),
                new TwoLayersFeatureSize(1, 0, 2) //
        ).build());

        /*
         * 花的世界生成
         */
        register(featureRegisterable, SIMPLE_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        32,              // 一个区块的生成次数
                        6,                  // 每次生成最大数量
                        2,                  // 每次生成的最小数量
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(IzumiBlocks.IZUMI_SIMPLE_FLOWER))
                        )
                )
        );

        // 替换方块
        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);                 // 浅层矿
        RuleTest deepSlateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);         // 深层矿
        RuleTest netherReplace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);                     // 下界矿
        RuleTest endReplace = new BlockMatchRuleTest(Blocks.END_STONE);                                 // 末地矿

        List<OreFeatureConfig.Target> overWorldTargets = List.of(
                OreFeatureConfig.createTarget(stoneReplace, IzumiBlocks.IZUMI_FLUOR_ICE.getDefaultState()),       // 浅层矿对应的方块
                OreFeatureConfig.createTarget(deepSlateReplace, IzumiBlocks.IZUMI_ETHER_AMBER.getDefaultState())    // 深层矿对应的方块
        );
        List<OreFeatureConfig.Target> netherTargets = List.of(OreFeatureConfig.createTarget(netherReplace, IzumiBlocks.IZUMI_ETHER_AMBER.getDefaultState()));   // 下界矿对应的方块
        List<OreFeatureConfig.Target> endTargets = List.of(OreFeatureConfig.createTarget(endReplace, IzumiBlocks.IZUMI_AI_YIN.getDefaultState()));         // 末地矿对应的方块

        register(featureRegisterable, IZUMI_ORE_KEY, Feature.ORE, new OreFeatureConfig(overWorldTargets, 8));   // size: 矿脉最大数量
        register(featureRegisterable, NETHER_IZUMI_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTargets, 16));
        register(featureRegisterable, END_IZUMI_ORE_KEY, Feature.ORE, new OreFeatureConfig(endTargets, 32));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Interval.MOD_ID, id));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config)
    {
        registerable.register(key, new ConfiguredFeature<FC, F>(feature, config));
    }
}
