package net.mikuas.interval.item.custom;

import com.google.common.collect.ImmutableMap;
import net.mikuas.interval.item.IzumiArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IzumiArmorItem extends ArmorItem
{
    public IzumiArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings)
    {
        super(material, type, settings);
    }

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MAP = (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
            .put(IzumiArmorMaterials.IZUMI_LXTL.value(), Arrays.asList(
                    new StatusEffectInstance(
                            StatusEffects.WATER_BREATHING,  // 效果
                            1000,                           // 持续时间
                            1,
                            false,
                            false,
                            true
                    ),
                    new StatusEffectInstance(StatusEffects.SPEED, 1000, 1, false, false, true)
                    )
            ).build();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
//        if (entity instanceof PlayerEntity player && hasHelmetArmor(player)) {
        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player))
        {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player)
    {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MAP.entrySet())
        {
            ArmorMaterial material = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if (hasCorrectArmorSet(player, material)) {
                for (StatusEffectInstance effect : effects) {
                    addStatusEffectForMaterial(player, effect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance effect)
    {
        boolean hasEffect = player.hasStatusEffect(effect.getEffectType());

        if (!hasEffect)
        {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }
    }

    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material)
    {
        for (ItemStack stack : player.getInventory().armor)
        {
            if (!(stack.getItem() instanceof ArmorItem))
            {
                return false;
            }
        }

        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
//
//        return helmet.getMaterial().value() == material;
        return helmet.getMaterial().value() == material && chestplate.getMaterial().value() == material && leggings.getMaterial().value() == material && boots.getMaterial().value() == material;
    }

    private boolean hasHelmetArmor(PlayerEntity player)
    {
        return !player.getInventory().getArmorStack(3).isEmpty();
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
}
