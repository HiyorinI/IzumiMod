package net.mikuas.interval.entity;

import net.mikuas.interval.Interval;
import net.mikuas.interval.entity.custom.IzumiTigerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiEntities
{
    public static final EntityType<IzumiTigerEntity> TIGER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Interval.MOD_ID, "tiger"),
            EntityType.Builder.create(IzumiTigerEntity::new, SpawnGroup.CREATURE).dimensions(1F, 1F).build()
            // FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IzumiTigerEntity::new).dimensions(EntityDimensions.fixed(1F,1F)).build()
    );
}
