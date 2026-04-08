package net.mikuas.interval.world.dimension;

import net.mikuas.interval.Interval;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

/// 维度
public class IzumiDimensions
{
    public static final RegistryKey<DimensionOptions> IZUMI_KEY = RegistryKey.of(RegistryKeys.DIMENSION, Identifier.of(Interval.MOD_ID, "izumi"));
    public static final RegistryKey<World> IZUMI_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Interval.MOD_ID, "izumi"));
    public static final RegistryKey<DimensionType> IZUMI_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(Interval.MOD_ID, "izumi_type"));

    public static void bootstrap(Registerable<DimensionType> context)
    {
        context.register(IZUMI_DIMENSION_TYPE_KEY, new DimensionType(
                OptionalLong.of(12000),               // fixedTime: 固定时间。这里设为 12000（黄昏）。如果不固定（跟随昼夜循环），应传入 OptionalLong.empty()
                false,                                      // hasSkylight: 是否有天空光照（类似主世界）。false 则光照表现类似地底或下界
                false,                                      // hasCeiling: 是否有天花板（如下界顶部的基岩层）
                false,                                      // ultraWarm: 是否为超热维度。true 时水分会蒸发，岩浆流动极快（类似下界）
                true,                                       // natural: 是否为“自然”维度。true 时罗盘正常工作，床会爆炸（如果在该维度不能睡觉的话）
                1.0,                                        // coordinateScale: 坐标比例。主世界与下界比例通常是 8.0。1.0 表示与主世界 1:1
                true,                                       // bedWorks: 床是否可用。
                false,                                      // respawnAnchorWorks: 复活锚是否可用。
                0,                                          // minY: 维度最低高度（Y轴起始位置）
                1024,                                        // height: 总高度（必须是 16 的倍数）
                1024,                                        // logicalHeight: 逻辑高度（如鞘翅滑翔限制、地底生成等参考的高度）
                BlockTags.INFINIBURN_OVERWORLD,             // infiniburn: 哪些方块上的火会永不熄灭（此处引用主世界设置，如泥土/草方块上的火）
                DimensionTypes.OVERWORLD_ID,                // effectsLocation: 环境效果。这里指向 "minecraft:overworld"，决定了云、雾、天空的渲染风格
                1.0F,                                       // ambientLight: 环境亮度。0.0 会有完全的黑暗，值越高阴影处越亮
                new DimensionType.MonsterSettings(
                        false,                          // piglinSafe: 猪灵是否不会僵尸化
                        false,                              // hasRaids: 是否会触发袭击（Raids）
                        UniformIntProvider.create(0, 0),    // monsterSpawnLightLevel: 怪物生成的亮度范围
                        0                                   // monsterSpawnBlockLightLimit: 怪物生成的方块亮度限制
                )
        ));
    }
}
