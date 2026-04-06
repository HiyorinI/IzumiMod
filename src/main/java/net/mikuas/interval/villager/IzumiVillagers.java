package net.mikuas.interval.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

public class IzumiVillagers
{
    /*
        // 自定义村民
     */

    public static final VillagerProfession IZUMI_VOID_MIST_MASTER = register(
            "izumi_void_mist_master",
            IzumiPointOfInterestTypes.IZUMI_VOID_MIST_POINT,
            SoundEvents.ENTITY_VILLAGER_WORK_ARMORER // 声音
    ); // 资源同名

    public static final VillagerProfession IZUMI_FLUOR_ICE_MASTER = register(
            "izumi_fluor_ice_master",
            IzumiPointOfInterestTypes.IZUMI_FLUOR_ICE_POINT,
            SoundEvents.ENTITY_VILLAGER_WORK_CLERIC
    );

    public static final PointOfInterestType IZUMI_VOID_MIST_POINT = registerPointOfInterestType(IzumiWorkKeys.IZUMI_VOID_MIST_KEY, IzumiBlocks.IZUMI_VOID_MIST);
    public static final PointOfInterestType IZUMI_FLUOR_ICE_POINT = registerPointOfInterestType(IzumiWorkKeys.IZUMI_FLUOR_ICE_KEY, IzumiBlocks.IZUMI_FLUOR_ICE);

    private static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound)
    {
        return Registry.register(
                Registries.VILLAGER_PROFESSION,
                Identifier.of(Interval.MOD_ID, id),
                new VillagerProfession(
                        id,
                        entry -> entry.matchesKey(heldWorkstation),
                        entry -> entry.matchesKey(heldWorkstation),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        workSound
                )
        );
    }

    private static PointOfInterestType registerPointOfInterestType(String id, Block block)
    {
        return PointOfInterestHelper.register(
                Identifier.of(Interval.MOD_ID, id),
                1,              // 一个工作方块可容纳的人数
                1,                         // 搜索范围
                block
        );
    }

    public static void registerIzumiVillagers()
    {

    }
}
