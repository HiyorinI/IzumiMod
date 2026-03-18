package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.item.custom.IzumiItem;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class IzumiENUSLanProvider extends FabricLanguageProvider
{
    public IzumiENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder)
    {
        // Panel
        translationBuilder.add("itemGroup.interval.izumi_group", "Izumi Group");

        // 语言文件生成
        // Items
        translationBuilder.add(IzumiItems.IZUMI_CPHN, "Tokiwa Kanano");
        translationBuilder.add(IzumiItems.IZUMI_MIMI, "Mi Mi");
        translationBuilder.add(IzumiItems.IZUMI_CLSY, "Kurama Shiyin");
        translationBuilder.add(IzumiItems.IZUMI_LXTL, "Longxian Tianli");

        // Food Items
        translationBuilder.add(IzumiItems.IZUMI_FOOD_PAI_MENG, "Pai Meng");
        translationBuilder.add(IzumiItems.IZUMI_FOOD_STAR_RAIL, "Star Rail");

        // Fuel Items
        translationBuilder.add(IzumiItems.IZUMI_FUEL_HK3, "HK 3RD");

        // Tool Items
        translationBuilder.add(IzumiItems.PROSPECTOR, "Prospector");
        translationBuilder.add(IzumiItems.IZUMI_SWORD, "Sword");
        translationBuilder.add(IzumiItems.IZUMI_SHOVEL, "Shovel");
        translationBuilder.add(IzumiItems.IZUMI_PICKAXE, "Pickaxe");
        translationBuilder.add(IzumiItems.IZUMI_AXE, "Axe");
        translationBuilder.add(IzumiItems.IZUMI_HOE, "Hoe");

        // 盔甲
        translationBuilder.add(IzumiItems.IZUMI_HELMET, "Helmet");

        // 作物
        translationBuilder.add(IzumiBlocks.IZUMI_CROP, "Crop");
        translationBuilder.add(IzumiItems.IZUMI_SEED, "Seed");
        translationBuilder.add(IzumiBlocks.IZUMI_MULTI_CROP, "Multi Crop");
        translationBuilder.add(IzumiItems.IZUMI_MULTI_CROP_SEED, "Multi Crop Seed");

        // Blocks
        translationBuilder.add(IzumiBlocks.IZUMI_FLUOR_ICE, "Fluor Ice");
        translationBuilder.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL, "Flux Crystal");

        translationBuilder.add(IzumiBlocks.IZUMI_VOID_MIST, "Void Mist");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_DOOR, "星空鉄道とシロの旅全");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_TRAPDOOR, "Void Trapdoor");

        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_AMBER, "Ether Amber");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_STAIRS, "Ether Stairs");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_SLAB, "Ether Slab");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_BUTTON, "Ether Button");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE, "Ether Pressure Plate");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE, "Ether Fence");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_FENCE_GATE, "Ether Fence Gate");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_WALL, "Ether Wall");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_DOOR, "Ether Door");
        translationBuilder.add(IzumiBlocks.IZUMI_ETHER_TRAPDOOR, "Ether Trapdoor");

        // Tooltip
        translationBuilder.add("item.interval.prospector.tooltip", "A tool used to find ores");
//        translationBuilder.add("item.interval.prospector.tooltip", "Hold \u00A76SHIFT\u00A7r from more information"); // 颜色转义字符
        translationBuilder.add("item.interval.prospector.shift_tooltip", "Hold §6SHIFT§r from more information");
    }
}
