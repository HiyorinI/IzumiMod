package net.mikuas.interval.mixin;

import net.mikuas.interval.item.IzumiItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin
{
    /*
        燃烧物品注入
     */

    @Shadow private static volatile @Nullable Map<Item, Integer> fuelTimes;

    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    private static void addFuelItems(CallbackInfoReturnable<Map<Item, Integer>> callbackInfoReturnable)
    {
        fuelTimes.put(
                IzumiItems.IZUMI_FUEL_HK3,
                1600 // 燃烧时间 tick
        );

        // API
//        FuelRegistry.INSTANCE.add(ModItems.FUEL_DEMO, 1600);
    }
}
