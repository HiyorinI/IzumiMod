package net.mikuas.interval.datagen;

import net.mikuas.interval.Interval;
import net.mikuas.interval.villager.IzumiWorkKeys;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.concurrent.CompletableFuture;

public class IzumiPointTagProvider extends TagProvider<PointOfInterestType>
{

    public IzumiPointTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture)
    {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup)
    {
        // 职业 Tags
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(Identifier.of(Interval.MOD_ID, IzumiWorkKeys.IZUMI_VOID_MIST_KEY))
                .addOptional(Identifier.of(Interval.MOD_ID, IzumiWorkKeys.IZUMI_FLUOR_ICE_KEY));
    }
}
