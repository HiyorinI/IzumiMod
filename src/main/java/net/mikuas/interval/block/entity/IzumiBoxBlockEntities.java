package net.mikuas.interval.block.entity;

import com.mojang.datafixers.types.Type;
import net.mikuas.interval.block.IzumiBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

public class IzumiBoxBlockEntities
{
    public static final BlockEntityType<IzumiBoxBlockEntity> IZUMI_BOX = create("izumi_box", BlockEntityType.Builder.create(IzumiBoxBlockEntity::new, IzumiBlocks.IZUMI_BOX));
    public static final BlockEntityType<PolishingMachineBlockEntity> POLISHING_MACHINE_BLOCK_ENTITY = create("polishing_machine_block_entity", BlockEntityType.Builder.create(PolishingMachineBlockEntity::new, IzumiBlocks.POLISHING_MACHINE));

//    public static final BlockEntityType<>

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
//        if (builder.blocks.isEmpty()) {
//            Interval.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", id);
//        }

        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }

    public static void registerIzumiBoxBlockEntities()
    {

    }
}
