package net.mikuas.interval.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.math.Rectangle;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.recipe.PolishingMachineRecipe;
import net.mikuas.interval.screen.PolishingMachineScreen;

import java.awt.*;

public class IzumiREIClientPlugins implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        registry.add(new PolishingMachineCategory());
        registry.addWorkstations(PolishingMachineCategory.POLISHING_MACHINE, EntryStacks.of(IzumiBlocks.POLISHING_MACHINE));
//        REIClientPlugin.super.registerCategories(registry);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        registry.registerRecipeFiller(PolishingMachineRecipe.class, PolishingMachineRecipe.Type.INSTANCE, PolishingMachineDisplay::new);
//        REIClientPlugin.super.registerDisplays(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry)
    {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), PolishingMachineScreen.class, PolishingMachineCategory.POLISHING_MACHINE);
//        REIClientPlugin.super.registerScreens(registry);
    }
}
