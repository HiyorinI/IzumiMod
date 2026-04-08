package net.mikuas.interval.enchantment;

import com.mojang.serialization.MapCodec;
import net.mikuas.interval.Interval;
import net.mikuas.interval.enchantment.custom.IzumiEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiEnchantmentEffects
{

    public static final MapCodec<? extends EnchantmentEntityEffect> IZUMI_ENCHANTMENT = register("izumi_enchantment", IzumiEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> register(String name, MapCodec<? extends EnchantmentEntityEffect> codec)
    {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Interval.MOD_ID, name), codec);
    }

    public static void registerModEnchantmentEffects()
    {

    }
}
