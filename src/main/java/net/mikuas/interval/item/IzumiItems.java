package net.mikuas.interval.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.IzumiFluids;
import net.mikuas.interval.block.custom.IzumiBlock;
import net.mikuas.interval.entity.IzumiBoats;
import net.mikuas.interval.item.custom.HatItem;
import net.mikuas.interval.item.custom.IzumiArmorItem;
import net.mikuas.interval.item.custom.IzumiItem;
import net.mikuas.interval.item.custom.Prospector;
import net.mikuas.interval.sound.IzumiJukeboxSongs;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class IzumiItems
{
    public static final Item IZUMI_CPHN = registerItems("izumi_cphn", new Item(new Item.Settings()));
    public static final Item IZUMI_MIMI = registerItems("izumi_mimi", new IzumiItem(
            new IzumiItem.Settings())
            .setTooltip("item.interval.izumi_mimi.tooltip")
//            .setTooltip("可以被冶炼为应急食品的神奇物品")
    );
    public static final Item IZUMI_CLSY = registerItems("izumi_clsy", new Item(new Item.Settings()));
    public static final Item IZUMI_LXTL = registerItems("izumi_lxtl", new IzumiItem(
            new Item.Settings())
            .setTooltip("item.interval.izumi_lxtl.tooltip")
//            .setTooltip("可能是一种高级合成材料??")
    );

    // 食物
    public static final Item IZUMI_FOOD_PAI_MENG = registerItems("izumi_food_pai_meng", new IzumiItem(
            new IzumiItem.Settings().food(IzumiFoodComponents.IZUMI_FOOD_PAI_MENG))
            .setTooltip("item.interval.izumi_food_pai_meng.tooltip")
//            .setTooltip("才不是什么应急食品呢!")
    );

    public static final Item IZUMI_FOOD_STAR_RAIL = registerItems("izumi_food_star_rail", new IzumiItem(
            new Item.Settings().food(IzumiFoodComponents.IZUMI_STAR_RAIL))
            .setTooltip("item.interval.izumi_food_star_rail.tooltip")
//            .setTooltip("右键有好事发生")
    );

    // 燃料
    public static final Item IZUMI_FUEL_HK3 = registerItems("izumi_fuel_hk3", new IzumiItem(
            new IzumiItem.Settings())
            .hasShiftTooltip()
            .setTooltip("item.interval.izumi_fuel_hk3.tooltip", "item.interval.izumi_fuel_hk3.shift_tooltip")
//            .setTooltip("一种燃烧料", "一种燃烧材料 燃烧时间: §61600tick§r")
    );

    // 工具 Prospector
    public static final Item PROSPECTOR = registerItems("prospector", new Prospector(new Item.Settings()));

    // 剑
    public static final Item IZUMI_SWORD = registerItems("izumi_sword", new SwordItem(
            IzumiToolMaterials.IZUMI_DIAMOND,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_DIAMOND,
                    12,       // 基础攻击力
                    1.0F  //攻击速度
    )).fireproof()
    ));

    // 铲子
    public static final Item IZUMI_SHOVEL = registerItems("izumi_shovel", new ShovelItem(
            IzumiToolMaterials.IZUMI_DIAMOND,
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_DIAMOND, 1.5F, 0.0F)
            )
    ));

    // 稿子
    public static final Item IZUMI_PICKAXE = registerItems("izumi_pickaxe", new PickaxeItem(
            IzumiToolMaterials.IZUMI_PICKAXE,
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_PICKAXE, 2.5F, 0.0F)
            ).fireproof()
    ));

    // 斧头
    public static final Item IZUMI_AXE = registerItems("izumi_axe", new AxeItem(
            IzumiToolMaterials.IZUMI_DIAMOND,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_DIAMOND, 3.5F, -1.0F)
            )
    ));

    // 锄头
    public static final Item IZUMI_HOE = registerItems("izumi_hoe", new HoeItem(
            IzumiToolMaterials.IZUMI_DIAMOND,
            new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(IzumiToolMaterials.IZUMI_DIAMOND, -1.0F, -2.0F)
            )
    ));

    // 盔甲
    // 头盔
    public static final Item IZUMI_HELMET = registerItems("izumi_helmet", new IzumiArmorItem(
            IzumiArmorMaterials.IZUMI_LXTL,
            ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(24)
    )));
    // 护甲
    public static final Item IZUMI_CHESTPLATE = registerItems("izumi_chestplate", new IzumiArmorItem(
            IzumiArmorMaterials.IZUMI_LXTL,
            ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(24)
    )));
    // 护腿
    public static final Item IZUMI_LEGGINGS = registerItems("izumi_leggings", new IzumiArmorItem(
            IzumiArmorMaterials.IZUMI_LXTL,
            ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(24)
    )));
    // 鞋子
    public static final Item IZUMI_BOOTS = registerItems("izumi_boots", new IzumiArmorItem(
            IzumiArmorMaterials.IZUMI_LXTL,
            ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(24)
    )));

    // 帽子
    public static final Item IZUMI_HAT = registerItems("izumi_hat", new HatItem(
            HatItem.Type.Hat, new Item.Settings().maxDamage(HatItem.Type.Hat.getMaxDamage(12)
    )));

    // 作物
    // 种子
    public static final Item IZUMI_SEED = registerItems("izumi_seed", new AliasedBlockItem(
            IzumiBlocks.IZUMI_CROP, new Item.Settings()
    ));
//    public static final Item IZUMI_SEED = registerItems("izumi_seed", new AliasedBlockItem(IzumiBlocks.IZUMI_CROP, new Item.Settings()));

    // 多方块
    public static final Item IZUMI_MULTI_CROP_SEED = registerItems("izumi_multi_crop_seed", new AliasedBlockItem(
            IzumiBlocks.IZUMI_MULTI_CROP, new Item.Settings()
    ));

    // 音乐唱片
    public static final Item NO_GOOD_MUSIC_DISC = registerItems("no_good_music_disc", new IzumiItem(
            new Item.Settings().maxDamage(1).rarity(Rarity.RARE).jukeboxPlayable(IzumiJukeboxSongs.NO_GOOD))
            .setTooltip("item.interval.no_good_music_disc.tooltip")
    );

    public static final Item THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC = registerItems("the_way_that_i_loved_you_music_disc", new Item(
            new Item.Settings().maxDamage(1).rarity(Rarity.RARE).jukeboxPlayable(IzumiJukeboxSongs.THE_WAY_THAT_I_LOVED_YOU)
    ));

    public static final Item PINKY_OATH_MUSIC_DISC = registerItems("pinky_oath_music_disc", new Item(
            new Item.Settings().maxDamage(1).rarity(Rarity.RARE).jukeboxPlayable(IzumiJukeboxSongs.PINKY_OATH)
    ));

    public static final Item FLOWER_TOWER_MUSIC_DISC = registerItems("flower_tower_music_disc", new Item(
            new Item.Settings().maxDamage(1).rarity(Rarity.RARE).jukeboxPlayable(IzumiJukeboxSongs.FLOWER_TOWER)
    ));

    // 流体
    public static final Item FEN_DA_BUCKET = registerItems("fen_da_bucket", new BucketItem(
            IzumiFluids.FEN_DA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
    ));

    // 马凯
    public static final Item IZUMI_CPHN_HORSE_ARMOR = registerItems("izumi_cphn_horse_armor", new AnimalArmorItem(
            IzumiArmorMaterials.IZUMI_LXTL, AnimalArmorItem.Type.EQUESTRIAN,
            false,
            new Item.Settings().maxCount(1)
    ));

    // 自定义物品
    public static final Item IZUMI_SIMPLE_ITEM = registerItems("izumi_simple_item", new Item(new Item.Settings()));

    // 告示牌
    public static final Item IZUMI_SIGN = registerItems("izumi_sign", new SignItem(
            new Item.Settings().maxCount(16), IzumiBlocks.IZUMI_SIGN, IzumiBlocks.IZUMI_WALL_SIGN
    ));
    public static final Item IZUMI_HANGING_SIGN = registerItems("izumi_hanging_sign", new HangingSignItem(
            IzumiBlocks.IZUMI_HANGING_SIGN, IzumiBlocks.IZUMI_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)
    ));

    // 船
    public static final Item IZUMI_BOAT= TerraformBoatItemHelper.registerBoatItem(IzumiBoats.IZUMI_BOAT, IzumiBoats.IZUMI_BOAT_KEY, false);
    public static final Item IZUMI_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(IzumiBoats.IZUMI_CHEST_BOAT, IzumiBoats.IZUMI_BOAT_KEY, true);

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
