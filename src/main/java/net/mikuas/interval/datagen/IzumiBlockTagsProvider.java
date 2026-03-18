package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.tags.IzumiBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class IzumiBlockTagsProvider extends FabricTagProvider.BlockTagProvider
{
    public IzumiBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(IzumiBlocks.IZUMI_FLUOR_ICE) // 1.0
                .add(IzumiBlocks.IZUMI_ETHER_AMBER)
                .add(IzumiBlocks.IZUMI_FLUX_CRYSTAL);

        // 石工具
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(IzumiBlocks.IZUMI_FLUOR_ICE);

        // 铁工具
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(IzumiBlocks.IZUMI_ETHER_AMBER)
                .add(IzumiBlocks.IZUMI_FLUX_CRYSTAL);

        // Ore Tags
        getOrCreateTagBuilder(IzumiBlockTags.ORE_LIST)
                .add(IzumiBlocks.IZUMI_FLUOR_ICE)
                .forceAddTag(BlockTags.DIAMOND_ORES)    // 钻石矿石
                .forceAddTag(BlockTags.GOLD_ORES)       // 黄金矿石
                .forceAddTag(BlockTags.COAL_ORES)       // 煤炭矿石
                .forceAddTag(BlockTags.COPPER_ORES)     // 铜矿石
                .forceAddTag(BlockTags.EMERALD_ORES)    // 绿宝石矿石
                .forceAddTag(BlockTags.IRON_ORES)       // 铁矿石
                .forceAddTag(BlockTags.LAPIS_ORES)      // 青金石矿石
                .forceAddTag(BlockTags.REDSTONE_ORES);  // 红石矿石

        // 连接 Tag
        getOrCreateTagBuilder(BlockTags.FENCES) // 围栏连接, 默认和下界砖连接
                .add(IzumiBlocks.IZUMI_ETHER_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES) // 和木制连接
                .add(IzumiBlocks.IZUMI_ETHER_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES) // 栅栏门
                .add(IzumiBlocks.IZUMI_ETHER_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.BUTTONS) // Button
                .add(IzumiBlocks.IZUMI_ETHER_BUTTON);

        getOrCreateTagBuilder(BlockTags.WALLS) // 石头围墙
                .add(IzumiBlocks.IZUMI_ETHER_WALL);
    }
}
