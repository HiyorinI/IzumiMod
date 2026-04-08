package net.mikuas.interval.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mikuas.interval.Interval;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/// 粒子
public class IzumiParticles
{
    public static final SimpleParticleType IZUMI_GREEN_FLAME = register("izumi_green_flame", FabricParticleTypes.simple());

    private static SimpleParticleType register(String name, SimpleParticleType type)
    {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Interval.MOD_ID, name), type);
    }

    public static void registerModParticles()
    {
    }
}
