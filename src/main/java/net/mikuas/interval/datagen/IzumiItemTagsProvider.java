package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.tags.IzumiItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class IzumiItemTagsProvider extends FabricTagProvider.ItemTagProvider
{

    public IzumiItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(IzumiItemTags.APPLE_TAG)
                .add(IzumiItems.IZUMI_CPHN)
                .add(IzumiItems.IZUMI_CLSY)
                .add(IzumiItems.IZUMI_LXTL);

        // 锻造模板 Tag
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(IzumiItems.IZUMI_HELMET)
                .add(IzumiItems.IZUMI_CHESTPLATE)
                .add(IzumiItems.IZUMI_LEGGINGS)
                .add(IzumiItems.IZUMI_BOOTS);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(IzumiItems.NO_GOOD_MUSIC_DISC)
                .add(IzumiItems.THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC)
                .add(IzumiItems.PINKY_OATH_MUSIC_DISC)
                .add(IzumiItems.FLOWER_TOWER_MUSIC_DISC);

        // 木头
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(IzumiBlocks.IZUMI_LOG.asItem())
                .add(IzumiBlocks.IZUMI_WOOD.asItem())
                .add(IzumiBlocks.STRIPPED_IZUMI_LOG.asItem())
                .add(IzumiBlocks.STRIPPED_IZUMI_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(IzumiBlocks.IZUMI_PLANKS.asItem());
    }
}
