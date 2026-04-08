package net.mikuas.interval.enchantment;

import net.mikuas.interval.Interval;
import net.mikuas.interval.enchantment.custom.IzumiEnchantmentEffect;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class IzumiEnchantments
{
    public static final RegistryKey<Enchantment> IZUMI_ENCHANTMENT = of("izumi_enchantment");

    public static void bootstrap(Registerable<Enchantment> registry)
    {
        RegistryEntryLookup<Enchantment> registryEntryLookup = registry.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        RegistryEntryLookup<Item> registryEntryLookup1 = registry.getRegistryLookup(RegistryKeys.ITEM);

        register(registry, IZUMI_ENCHANTMENT, Enchantment.builder(
                Enchantment.definition(
                        registryEntryLookup1.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        registryEntryLookup1.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 10),
                        2,
                        AttributeModifierSlot.MAINHAND
                ))
                .exclusiveSet(registryEntryLookup.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(
                        EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new IzumiEnchantmentEffect()
                )
        );
    }

    private static RegistryKey<Enchantment> of(String id)
    {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Interval.MOD_ID, id));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder)
    {
        registry.register(key, builder.build(key.getValue()));
    }
}
