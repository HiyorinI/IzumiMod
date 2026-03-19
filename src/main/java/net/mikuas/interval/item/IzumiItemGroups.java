package net.mikuas.interval.item;

import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IzumiItemGroups
{
    public static final RegistryKey<ItemGroup> TUTORIAL_GROUP = register("izumi_group");

    private static RegistryKey<ItemGroup> register(String id)
    {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Interval.MOD_ID, id));
    }

    // 将物品添加到物品栏
    public static void registerModItemGroups()
    {
        // 添加到一页单独的物品栏
        Registry.register(
                Registries.ITEM_GROUP,
                TUTORIAL_GROUP,
                ItemGroup.create(null, -1)
//                ItemGroup.create(ItemGroup.Row.TOP, 10)
                        .displayName(Text.translatable("itemGroup.interval.izumi_group"))
                        .icon(() -> new ItemStack(IzumiItems.IZUMI_LXTL))
                        .entries(((displayContext, entries) -> {
                            // Items
                            entries.add(IzumiItems.IZUMI_CPHN);
                            entries.add(IzumiItems.IZUMI_MIMI);
                            entries.add(IzumiItems.IZUMI_CLSY);
                            entries.add(IzumiItems.IZUMI_LXTL);

                            // Food Items
                            entries.add(IzumiItems.IZUMI_FOOD_PAI_MENG);
                            entries.add(IzumiItems.IZUMI_FOOD_STAR_RAIL);

                            // Fuel
                            entries.add(IzumiItems.IZUMI_FUEL_HK3);

                            // Tool
                            entries.add(IzumiItems.PROSPECTOR);
                            entries.add(IzumiItems.IZUMI_SWORD);
                            entries.add(IzumiItems.IZUMI_SHOVEL);
                            entries.add(IzumiItems.IZUMI_PICKAXE);
                            entries.add(IzumiItems.IZUMI_AXE);
                            entries.add(IzumiItems.IZUMI_HOE);

                            // 盔甲
                            entries.add(IzumiItems.IZUMI_HELMET);
                            entries.add(IzumiItems.IZUMI_CHESTPLATE);
                            entries.add(IzumiItems.IZUMI_LEGGINGS);
                            entries.add(IzumiItems.IZUMI_BOOTS);

                            // 饰品
//                            entries.add(IzumiItems.IZUMI_HAT);

                            // 作物
//                            entries.add(IzumiBlocks.IZUMI_CROP);
                            entries.add(IzumiItems.IZUMI_SEED);
                            entries.add(IzumiItems.IZUMI_MULTI_CROP_SEED);

                            // Blocks
                            entries.add(IzumiBlocks.IZUMI_FLUOR_ICE);
                            entries.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL);

                            entries.add(IzumiBlocks.IZUMI_VOID_MIST);
                            entries.add(IzumiBlocks.IZUMI_VOID_DOOR);
                            entries.add(IzumiBlocks.IZUMI_VOID_TRAPDOOR);

                            entries.add(IzumiBlocks.IZUMI_ETHER_AMBER);
                            entries.add(IzumiBlocks.IZUMI_ETHER_STAIRS);
                            entries.add(IzumiBlocks.IZUMI_ETHER_SLAB);
                            entries.add(IzumiBlocks.IZUMI_ETHER_BUTTON);
                            entries.add(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE);
                            entries.add(IzumiBlocks.IZUMI_ETHER_FENCE);
                            entries.add(IzumiBlocks.IZUMI_ETHER_FENCE_GATE);
                            entries.add(IzumiBlocks.IZUMI_ETHER_WALL);
                            entries.add(IzumiBlocks.IZUMI_ETHER_DOOR);
                            entries.add(IzumiBlocks.IZUMI_ETHER_TRAPDOOR);

                        }))
                        .build()
        );
        Interval.LOGGER.info("Registering Item Groups");
    }
}
