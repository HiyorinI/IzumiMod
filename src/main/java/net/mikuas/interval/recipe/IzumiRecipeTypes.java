package net.mikuas.interval.recipe;

import net.mikuas.interval.Interval;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiRecipeTypes
{
    public static void registerRecipeTypes()
    {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Interval.MOD_ID, PolishingMachineRecipe.Serializer.ID), PolishingMachineRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(Interval.MOD_ID, PolishingMachineRecipe.Type.ID), PolishingMachineRecipe.Type.INSTANCE);
    }
}
