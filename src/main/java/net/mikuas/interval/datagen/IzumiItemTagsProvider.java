package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.tags.IzumiItemTags;
import net.minecraft.registry.RegistryWrapper;
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
    }
}
