package net.mikuas.interval.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class IzumiBoats
{
    public static final Identifier IZUMI_BOAT = Identifier.of(Interval.MOD_ID, "izumi_boat");
    public static final Identifier IZUMI_CHEST_BOAT = Identifier.of(Interval.MOD_ID, "izumi_chest_boat");

    public static final RegistryKey<TerraformBoatType> IZUMI_BOAT_KEY = TerraformBoatTypeRegistry.createKey(IZUMI_BOAT);

    public static void registerIzumiBoats()
    {
        TerraformBoatType izumiBoat = new TerraformBoatType.Builder()
                .item(IzumiItems.IZUMI_BOAT)
                .chestItem(IzumiItems.IZUMI_CHEST_BOAT)
                .planks(IzumiBlocks.IZUMI_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, IZUMI_BOAT_KEY, izumiBoat);
    }
}
