package net.mikuas.interval.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

/// 附魔效果
public record IzumiEnchantmentEffect() implements EnchantmentEntityEffect
{
    public static final MapCodec<IzumiEnchantmentEffect> CODEC = MapCodec.unit(IzumiEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos)
    {

        /// 附魔等级一
        if (level == 1)
        {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        /// 附魔等级二
        if (level == 2)
        {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        /// 附魔等级三
        if (level == 3)
        {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec()
    {
        return CODEC;
    }
}
