package net.mikuas.interval.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.custom.HatItem;
import net.mikuas.interval.item.custom.IzumiArmorItem;
import net.mikuas.interval.item.custom.IzumiItem;
import net.mikuas.interval.item.custom.Prospector;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiItems
{
    public static final Item IZUMI_CPHN = registerItems("izumi_cphn", new Item(new Item.Settings()));
    public static final Item IZUMI_MIMI = registerItems("izumi_mimi", new IzumiItem(new IzumiItem.Settings()).setTooltip("可以被冶炼为应急食品的神奇物品"));
    public static final Item IZUMI_CLSY = registerItems("izumi_clsy", new Item(new Item.Settings()));
    public static final Item IZUMI_LXTL = registerItems("izumi_lxtl", new Item(new Item.Settings()));

    // 食物
    public static final Item IZUMI_FOOD_PAI_MENG = registerItems("izumi_food_pai_meng", new IzumiItem(new IzumiItem.Settings().food(IzumiFoodComponents.IZUMI_FOOD_PAI_MENG)).setTooltip("才不是什么应急食品呢!"));
    public static final Item IZUMI_FOOD_STAR_RAIL = registerItems("izumi_food_star_rail", new Item(new Item.Settings().food(IzumiFoodComponents.IZUMI_STAR_RAIL)));

    // 燃料
    public static final Item IZUMI_FUEL_HK3 = registerItems("izumi_fuel_hk3", new IzumiItem(new IzumiItem.Settings()).hasShiftTooltip().setTooltip("一种燃烧料", "一种燃烧材料 燃烧时间: §61600tick§r"));

    // 工具 Prospector
    public static final Item PROSPECTOR = registerItems("prospector", new Prospector(new Item.Settings()));

    // 剑
    public static final Item IZUMI_SWORD = registerItems("izumi_sword", new SwordItem(
            IzumiToolMaterials.IZUMI_LXTL,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_LXTL,
                    12,       // 基础攻击力
                    1.0F  //攻击速度
    )).fireproof()
    ));

    // 铲子
    public static final Item IZUMI_SHOVEL = registerItems("izumi_shovel", new ShovelItem(IzumiToolMaterials.IZUMI_LXTL, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_LXTL, 1.5F, 0.0F))));

    // 稿子
    public static final Item IZUMI_PICKAXE = registerItems("izumi_pickaxe", new PickaxeItem(IzumiToolMaterials.IZUMI_PICKAXE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_PICKAXE, 2.5F, 0.0F))));

    // 斧头
    public static final Item IZUMI_AXE = registerItems("izumi_axe", new AxeItem(IzumiToolMaterials.IZUMI_LXTL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_LXTL, 3.5F, -1.0F))));

    // 锄头
    public static final Item IZUMI_HOE = registerItems("izumi_hoe", new HoeItem(IzumiToolMaterials.IZUMI_LXTL, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_LXTL, -1.0F, -2.0F))));

    // 盔甲
    // 头盔
    public static final Item IZUMI_HELMET = registerItems("izumi_helmet", new IzumiArmorItem(IzumiArmorMaterials.IZUMI_LXTL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(24))));
    // 护甲
    public static final Item IZUMI_CHESTPLATE = registerItems("izumi_chestplate", new IzumiArmorItem(IzumiArmorMaterials.IZUMI_LXTL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(24))));
    // 护腿
    public static final Item IZUMI_LEGGINGS = registerItems("izumi_leggings", new IzumiArmorItem(IzumiArmorMaterials.IZUMI_LXTL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(24))));
    // 鞋子
    public static final Item IZUMI_BOOTS = registerItems("izumi_boots", new IzumiArmorItem(IzumiArmorMaterials.IZUMI_LXTL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(24))));

    // 帽子
    public static final Item IZUMI_HAT = registerItems("izumi_hat", new HatItem(HatItem.Type.Hat, new Item.Settings().maxDamage(HatItem.Type.Hat.getMaxDamage(12))));

    // 作物
    // 种子
    public static final Item IZUMI_SEED = registerItems("izumi_seed",
            new AliasedBlockItem(IzumiBlocks.IZUMI_CROP, new Item.Settings()));
//    public static final Item IZUMI_SEED = registerItems("izumi_seed", new AliasedBlockItem(IzumiBlocks.IZUMI_CROP, new Item.Settings()));

    // 多方块
    public static final Item IZUMI_MULTI_CROP_SEED = registerItems("izumi_multi_crop_seed", new AliasedBlockItem(IzumiBlocks.IZUMI_MULTI_CROP, new Item.Settings()));

    private static Item registerItems(String id, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Interval.MOD_ID, id), item);
    }

    private static void addItemToItemGroup(FabricItemGroupEntries fabricItemGroupEntries)
    {
        fabricItemGroupEntries.add(IZUMI_CPHN);
        fabricItemGroupEntries.add(IZUMI_MIMI);
        fabricItemGroupEntries.add(IZUMI_CLSY);
        fabricItemGroupEntries.add(IZUMI_LXTL);

        // 食物
        fabricItemGroupEntries.add(IZUMI_FOOD_PAI_MENG);
        fabricItemGroupEntries.add(IZUMI_FOOD_STAR_RAIL);

        // 燃料
        fabricItemGroupEntries.add(IZUMI_FUEL_HK3);

        // 工具
        fabricItemGroupEntries.add(PROSPECTOR);
    }

    public static void registerModItems()
    {
        // 使用 AIP 添加到原版物品栏
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToItemGroup);
        Interval.LOGGER.info("Registering Items");
    }
}
