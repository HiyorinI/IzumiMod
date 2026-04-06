package net.mikuas.interval.villager;

import net.mikuas.interval.Interval;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class IzumiPointOfInterestTypes
{
    public static final RegistryKey<PointOfInterestType> IZUMI_VOID_MIST_POINT = of(IzumiWorkKeys.IZUMI_VOID_MIST_KEY);
    public static final RegistryKey<PointOfInterestType> IZUMI_FLUOR_ICE_POINT = of(IzumiWorkKeys.IZUMI_FLUOR_ICE_KEY);

    private static RegistryKey<PointOfInterestType> of (String id)
    {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Interval.MOD_ID, id));
    }
}
