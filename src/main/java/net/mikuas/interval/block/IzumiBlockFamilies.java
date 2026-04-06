package net.mikuas.interval.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class IzumiBlockFamilies
{
    public static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    public static final BlockFamily IZUMI_ETHER_AMBER_BLOCK_FAMILY = register(IzumiBlocks.IZUMI_ETHER_AMBER)
            .stairs(IzumiBlocks.IZUMI_ETHER_STAIRS)
            .slab(IzumiBlocks.IZUMI_ETHER_SLAB)
            .button(IzumiBlocks.IZUMI_ETHER_BUTTON)
            .pressurePlate(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE)
            .fence(IzumiBlocks.IZUMI_ETHER_FENCE)
            .fenceGate(IzumiBlocks.IZUMI_ETHER_FENCE_GATE)
            .wall(IzumiBlocks.IZUMI_ETHER_WALL)
            .door(IzumiBlocks.IZUMI_ETHER_DOOR)
            .trapdoor(IzumiBlocks.IZUMI_ETHER_TRAPDOOR)
            .unlockCriterionName("has_izumi_ether_amber")
            .build();

    public static final BlockFamily IZUMI_WOOD = register(IzumiBlocks.IZUMI_PLANKS)
            .sign(IzumiBlocks.IZUMI_SIGN, IzumiBlocks.IZUMI_WALL_SIGN)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

    public static final BlockFamily IZUMI_VOID_MIST_BLOCK_FAMILY = register(IzumiBlocks.IZUMI_VOID_MIST)
            .door(IzumiBlocks.IZUMI_VOID_DOOR)
            .trapdoor(IzumiBlocks.IZUMI_VOID_TRAPDOOR)
            .unlockCriterionName("has_izumi_void_mist")
            .build();

    public static BlockFamily.Builder register(Block baseBlock)
    {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null)
        {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        }
        else
        {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() { return BASE_BLOCKS_TO_FAMILIES.values().stream(); };
}
