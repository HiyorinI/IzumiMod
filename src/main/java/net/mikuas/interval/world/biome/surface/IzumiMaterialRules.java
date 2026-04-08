package net.mikuas.interval.world.biome.surface;

import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.world.biome.IzumiBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class IzumiMaterialRules
{
    private static final MaterialRules.MaterialRule DIRT = makeRule(Blocks.DIRT);                       // 土
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeRule(Blocks.GRASS_BLOCK);         // 草快
    /// 自定义群戏方块
    private static final MaterialRules.MaterialRule IZUMI_AI_YIN = makeRule(IzumiBlocks.IZUMI_AI_YIN);
    private static final MaterialRules.MaterialRule IZUMI_VOID_MIST = makeRule(IzumiBlocks.IZUMI_VOID_MIST);
    private static final MaterialRules.MaterialRule DIAMOND = makeRule(Blocks.DIAMOND_BLOCK);

    public static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1,0);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel,GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(
                        MaterialRules.condition(
                                MaterialRules.biome(IzumiBiomes.IZUMI_VOID_MIST_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, IZUMI_VOID_MIST) // STONE_DEPTH_FLOOR 替换为 IZUMI_VOID_MIST
                        ),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, IZUMI_AI_YIN)
                ),

                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
