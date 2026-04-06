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

                            // 音乐唱片
                            entries.add(IzumiItems.NO_GOOD_MUSIC_DISC);
                            entries.add(IzumiItems.THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC);
                            entries.add(IzumiItems.PINKY_OATH_MUSIC_DISC);
                            entries.add(IzumiItems.FLOWER_TOWER_MUSIC_DISC);

                            // 作物
//                            entries.add(IzumiBlocks.IZUMI_CROP);
                            entries.add(IzumiItems.IZUMI_SEED);
                            entries.add(IzumiItems.IZUMI_MULTI_CROP_SEED);

                            // 流体
                            entries.add(IzumiItems.FEN_DA_BUCKET);

                            // 马凯
                            entries.add(IzumiItems.IZUMI_CPHN_HORSE_ARMOR);

                            // Blocks
                            entries.add(IzumiBlocks.IZUMI_FLUOR_ICE);
                            entries.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL);

                            entries.add(IzumiBlocks.IZUMI_AI_YIN);

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

                            // 箱子(方块实体)
                            entries.add(IzumiBlocks.IZUMI_BOX);

                            // 自定义方块实体
                            entries.add(IzumiBlocks.POLISHING_MACHINE);

                            // 自定义物品, 方块
                            entries.add(IzumiItems.IZUMI_SIMPLE_ITEM);
                            entries.add(IzumiBlocks.IZUMI_SIMPLE_BLOCK);
                            entries.add(IzumiBlocks.IZUMI_SIMPLE_FENCE);

                            // 木头
                            entries.add(IzumiBlocks.IZUMI_LOG);
                            entries.add(IzumiBlocks.IZUMI_WOOD);
                            entries.add(IzumiBlocks.STRIPPED_IZUMI_LOG);
                            entries.add(IzumiBlocks.STRIPPED_IZUMI_WOOD);
                            entries.add(IzumiBlocks.IZUMI_PLANKS);
                            entries.add(IzumiBlocks.IZUMI_LEAVES);

                            // 告示牌
                            entries.add(IzumiItems.IZUMI_SIGN);
                            entries.add(IzumiItems.IZUMI_HANGING_SIGN);

                            // 船
                            entries.add(IzumiItems.IZUMI_BOAT);
                            entries.add(IzumiItems.IZUMI_CHEST_BOAT);

                            // 树苗
                            entries.add(IzumiBlocks.IZUMI_SAPLING);

                            // 花, 盆栽
                            entries.add(IzumiBlocks.IZUMI_SIMPLE_FLOWER);
                            // entries.add(IzumiBlocks.IZUMI_POTTED_SIMPLE_FLOWER);
                        }))
                        .build()
        );
        Interval.LOGGER.info("Registering Item Groups");
    }
}
