package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.villager.IzumiVillagers;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class IzumiZHCNLanProvider extends FabricLanguageProvider
{
    private static final String Villager = "entity.minecraft.villager.";

    public IzumiZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, FabricLanguageProvider.TranslationBuilder translationBuilder)
    {
        // Panel
        translationBuilder.add("itemGroup.interval.izumi_group", "Izumi 组");

        // 语言文件生成
        // Items
        translationBuilder.add(IzumiItems.IZUMI_CPHN, "常磐华乃");
        translationBuilder.add(IzumiItems.IZUMI_MIMI, "迷迷");
        translationBuilder.add(IzumiItems.IZUMI_CLSY, "仓镰诗樱");
        translationBuilder.add(IzumiItems.IZUMI_LXTL, "龙闲天梨");

        // Food Items
        translationBuilder.add(IzumiItems.IZUMI_FOOD_PAI_MENG, "应急食品");
        translationBuilder.add(IzumiItems.IZUMI_FOOD_STAR_RAIL, "Star Rail");

        // Fuel Items
        translationBuilder.add(IzumiItems.IZUMI_FUEL_HK3, "HK 燃料");

        // Tool Items
        translationBuilder.add(IzumiItems.PROSPECTOR, "勘探者");
        translationBuilder.add(IzumiItems.IZUMI_SWORD, "雾切");
        translationBuilder.add(IzumiItems.IZUMI_SHOVEL, "寰宇");
        translationBuilder.add(IzumiItems.IZUMI_PICKAXE, "Pickaxe");
        translationBuilder.add(IzumiItems.IZUMI_AXE, "秒人斧");
        translationBuilder.add(IzumiItems.IZUMI_HOE, "金铲铲");

        // 盔甲
        translationBuilder.add(IzumiItems.IZUMI_HELMET, "迷迷帽");
        translationBuilder.add(IzumiItems.IZUMI_CHESTPLATE, "迷迷护甲");
        translationBuilder.add(IzumiItems.IZUMI_LEGGINGS, "迷迷护腿");
        translationBuilder.add(IzumiItems.IZUMI_BOOTS, "迷迷靴子");

        // 作物
        translationBuilder.add(IzumiBlocks.IZUMI_CROP, "作物");
        translationBuilder.add(IzumiItems.IZUMI_SEED, "种子");
        translationBuilder.add(IzumiBlocks.IZUMI_MULTI_CROP, "多方块作物");
        translationBuilder.add(IzumiItems.IZUMI_MULTI_CROP_SEED, "多方快种子");

        // Blocks
        translationBuilder.add(IzumiBlocks.IZUMI_FLUOR_ICE, "帽子塔菲");
        translationBuilder.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL, "Flux Crystal");

        translationBuilder.add(IzumiBlocks.IZUMI_AI_YIN, "千早爱音");

        translationBuilder.add(IzumiBlocks.IZUMI_VOID_MIST, "和泉妃爱");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_DOOR, "星空鉄道とシロの旅全");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_TRAPDOOR, "活板门");

        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_AMBER, "永雏塔菲");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_STAIRS, "塔菲楼梯");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_SLAB, "塔菲半砖");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_BUTTON, "塔菲按钮");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE, "塔菲压力板");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE, "塔菲围栏");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE_GATE, "塔菲栅栏门");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_WALL, "塔菲石围栏");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_DOOR, "塔菲门");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_TRAPDOOR, "塔菲活板门");

        //
        translationBuilder.add(Villager + IzumiVillagers.IZUMI_VOID_MIST_MASTER, "奸商迪亚");
        translationBuilder.add(Villager + IzumiVillagers.IZUMI_FLUOR_ICE_MASTER, "奸商罗靖文");

        // Sounds
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_break", "Ai Yin 方块破坏");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_step", "Ai Yin 方块步行");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_place", "Ai Yin 方块放置");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_hit", "Ai Yin 方块打击");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_fall", "Ai Yin 方块落下");

        // 流体
        translationBuilder.add(IzumiItems.FEN_DA_BUCKET, "芬达");

        // 马凯
        translationBuilder.add(IzumiItems.IZUMI_CPHN_HORSE_ARMOR, "Izumi 马凯");

        // 箱子(方块实体)
        translationBuilder.add(IzumiBlocks.IZUMI_BOX, "Izumi 箱子");
        translationBuilder.add("container.izumi_box", "Izumi 箱子");

        // 自定义方块实体
        translationBuilder.add(IzumiBlocks.POLISHING_MACHINE, "抛光机");
        translationBuilder.add("container.polishing_machine", "抛光机");

        // 自定义 物品, 方块
        translationBuilder.add(IzumiItems.IZUMI_SIMPLE_ITEM, "简单物品");
        translationBuilder.add(IzumiBlocks.IZUMI_SIMPLE_BLOCK, "简单方块");
        translationBuilder.add(IzumiBlocks.IZUMI_SIMPLE_FENCE, "简单围栏");

        // 音乐唱片
        translationBuilder.add("jukebox_song.interval.no_good", "史蒂文·黄 - No Good"); // 播放 tool tip 翻译
        translationBuilder.add("jukebox_song.interval.the_way_that_i_loved_you", "史蒂文·黄 - The Way That I Loved You");
        translationBuilder.add("jukebox_song.interval.pinky_oath", "hanser - 勾指起誓");
        translationBuilder.add("jukebox_song.interval.flower_tower", "酸欠少女さユり (Sayuri) - 花の塔 (花之塔)");
        translationBuilder.add(IzumiItems.NO_GOOD_MUSIC_DISC, "No Good");
        translationBuilder.add(IzumiItems.THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC, "The Way That I Loved You");
        translationBuilder.add(IzumiItems.PINKY_OATH_MUSIC_DISC, "勾指起誓");
        translationBuilder.add(IzumiItems.FLOWER_TOWER_MUSIC_DISC, "花の塔 (花之塔)");

        // Tooltip
        // translationBuilder.add("item.interval.prospector.tooltip", "Hold \u00A76SHIFT\u00A7r from more information"); // 颜色转义字符
        translationBuilder.add("item.interval.prospector.tooltip", "用来寻找矿石的工具");
        translationBuilder.add("item.interval.prospector.shift_tooltip", "用来寻找矿石的工具(5x5x5), 默认模糊探索 按住§6SHIFT§r执行精准探索(§6Y§r)");

        /*
            Items Tooltip
         */
        translationBuilder.add("item.interval.izumi_mimi.tooltip", "可以被冶炼为应急食品的神奇物品");
        translationBuilder.add("item.interval.izumi_lxtl.tooltip", "可能是一种高级合成材料??");
        translationBuilder.add("item.interval.izumi_food_pai_meng.tooltip", "才不是什么应急食品呢!");
        translationBuilder.add("item.interval.izumi_food_star_rail.tooltip", "右键有好事发生");
        translationBuilder.add("item.interval.izumi_fuel_hk3.tooltip", "一种燃烧料");
        translationBuilder.add("item.interval.izumi_fuel_hk3.shift_tooltip", "一种燃烧材料 燃烧时间: §61600tick§r");

        /*
            Blocks Tooltip
         */
        translationBuilder.add("block.interval.izumi_fluor_ice.tooltip", "永雏塔菲你的头顶怎么尖尖的?");
        translationBuilder.add("block.interval.izumi_flux_crystal.tooltip", "好像什么提示都没有呢?!");
        translationBuilder.add("block.interval.izumi_flux_crystal.shift_tooltip", "别看了, 这里也什么都没有呢!");
        translationBuilder.add("block.interval.izumi_void_mist.tooltip", "和泉妃爱世界第一可爱!!");
        translationBuilder.add("block.interval.izumi_ai_yin.tooltip", "一个特殊的方块, EiHiEiHiEiHi!!&&");
        translationBuilder.add("block.interval.izumi_ether_amber.tooltip", "关注塔菲喵, 关注永雏塔菲喵!");

        translationBuilder.add("item.interval.no_good_music_disc.tooltip", "这才是真正的音乐!!");
    }
}
