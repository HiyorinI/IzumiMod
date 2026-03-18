package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class IzumiZHCNLanProvider extends FabricLanguageProvider
{
    public IzumiZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
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

        // 作物
        translationBuilder.add(IzumiBlocks.IZUMI_CROP, "作物");
        translationBuilder.add(IzumiItems.IZUMI_SEED, "种子");
        translationBuilder.add(IzumiBlocks.IZUMI_MULTI_CROP, "多方块作物");
        translationBuilder.add(IzumiItems.IZUMI_MULTI_CROP_SEED, "多方快种子");

        // Blocks
        translationBuilder.add(IzumiBlocks.IZUMI_FLUOR_ICE, "帽子塔菲");
        translationBuilder.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL, "Flux Crystal");

        translationBuilder.add(IzumiBlocks.IZUMI_VOID_MIST, "和泉妃爱");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_DOOR, "星空鉄道とシロの旅全");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_TRAPDOOR, "活板门");

        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_AMBER, "永雏塔菲");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_STAIRS, "塔菲楼梯");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_SLAB, "塔菲半砖");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_BUTTON, "塔菲按钮");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE, "塔菲压力板");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE, "塔菲围栏");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE_GATE, "他为栅栏门");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_WALL, "塔菲石围栏");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_DOOR, "塔菲门");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_TRAPDOOR, "塔菲活板门");

        // Tooltip
        translationBuilder.add("item.interval.prospector.tooltip", "用来寻找矿石的工具");
//        translationBuilder.add("item.interval.prospector.tooltip", "Hold \u00A76SHIFT\u00A7r from more information"); // 颜色转义字符
        translationBuilder.add("item.interval.prospector.shift_tooltip", "用来寻找矿石的工具(5x5x5), 默认模糊探索 按住§6SHIFT§r执行精准探索(§6Y§r)");
    }
}
