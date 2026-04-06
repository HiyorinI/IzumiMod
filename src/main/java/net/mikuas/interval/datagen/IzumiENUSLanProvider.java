package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.item.custom.IzumiItem;
import net.mikuas.interval.villager.IzumiVillagers;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class IzumiENUSLanProvider extends FabricLanguageProvider
{
    private static final String Villager = "entity.minecraft.villager.";

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
        translationBuilder.add(IzumiItems.IZUMI_CHESTPLATE, "Chestplate");
        translationBuilder.add(IzumiItems.IZUMI_LEGGINGS, "leggings");
        translationBuilder.add(IzumiItems.IZUMI_BOOTS, "boots");

        // 作物
        translationBuilder.add(IzumiBlocks.IZUMI_CROP, "Crop");
        translationBuilder.add(IzumiItems.IZUMI_SEED, "Seed");
        translationBuilder.add(IzumiBlocks.IZUMI_MULTI_CROP, "Multi Crop");
        translationBuilder.add(IzumiItems.IZUMI_MULTI_CROP_SEED, "Multi Crop Seed");

        // Blocks
        translationBuilder.add(IzumiBlocks.IZUMI_FLUOR_ICE, "Fluor Ice");
        translationBuilder.add(IzumiBlocks.IZUMI_FLUX_CRYSTAL, "Flux Crystal");

        translationBuilder.add(IzumiBlocks.IZUMI_AI_YIN, "Chihaya Aine");

        translationBuilder.add(IzumiBlocks.IZUMI_VOID_MIST, "Void Mist");
        translationBuilder.add(IzumiBlocks.IZUMI_VOID_DOOR, "Starry Sky Railway and Shiro's Journey");
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

        // 自定义村民
        translationBuilder.add(Villager + IzumiVillagers.IZUMI_VOID_MIST_MASTER, "Profiteer DiYa");
        translationBuilder.add(Villager + IzumiVillagers.IZUMI_FLUOR_ICE_MASTER, "Profiteer LuoJingWen");

        // 音乐唱片
        translationBuilder.add("jukebox_song.interval.no_good", "Steven·Wong - No Good"); // 播放 tool tip 翻译
        translationBuilder.add("jukebox_song.interval.the_way_that_i_loved_you", "Steven·Wong - The Way That I Loved You");
        translationBuilder.add("jukebox_song.interval.pinky_oath", "hanser - Hook your fingers and swear");
        translationBuilder.add("jukebox_song.interval.flower_tower", "Oxygen deficiency girl Sayuri - Flower tower");
        translationBuilder.add(IzumiItems.NO_GOOD_MUSIC_DISC, "No Good");
        translationBuilder.add(IzumiItems.THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC, "The Way That I Loved You");
        translationBuilder.add(IzumiItems.PINKY_OATH_MUSIC_DISC, "Hook your fingers and swear");
        translationBuilder.add(IzumiItems.FLOWER_TOWER_MUSIC_DISC, "Flower tower");

        // 流体
        translationBuilder.add(IzumiItems.FEN_DA_BUCKET, "Fanta");

        // 马凯
        translationBuilder.add(IzumiItems.IZUMI_CPHN_HORSE_ARMOR, "Izumi Horse Armor");

        // 箱子(方块实体)
        translationBuilder.add(IzumiBlocks.IZUMI_BOX, "Izumi Box");
        translationBuilder.add("container.izumi_box", "Izumi Box");

        // 自定义方块实体
        translationBuilder.add(IzumiBlocks.POLISHING_MACHINE, "Polishing Machine");
        translationBuilder.add("container.polishing_machine", "Polishing Machine");

        // 自定义 物品, 方块
        translationBuilder.add(IzumiItems.IZUMI_SIMPLE_ITEM, "Simple Item");
        translationBuilder.add(IzumiBlocks.IZUMI_SIMPLE_BLOCK, "Simple Block");
        translationBuilder.add(IzumiBlocks.IZUMI_SIMPLE_FENCE, "Simple Fence");

        // Sounds
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_break", "Ai Yin Block Break");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_step", "Ai Yin Block Step");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_place", "Ai Yin Block Place");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_hit", "Ai Yin Block Hit");
        translationBuilder.add("sounds.interval.izumi_ai_yin_block_fall", "Ai Yin Block Fall");

        // Tooltip
        // translationBuilder.add("item.interval.prospector.tooltip", "Hold \u00A76SHIFT\u00A7r from more information"); // 颜色转义字符
        translationBuilder.add("item.interval.prospector.tooltip", "A tool used to find ores");
        translationBuilder.add("item.interval.prospector.shift_tooltip", "Hold §6SHIFT§r from more information");

        /*
            Items Tooltip
         */
        translationBuilder.add("item.interval.izumi_mimi.tooltip", "A magical item that can be smelted into emergency food");
        translationBuilder.add("item.interval.izumi_lxtl.tooltip", "Probably an advanced synthetic material??");
        translationBuilder.add("item.interval.izumi_food_pai_meng.tooltip", "It's not an emergency food!");
        translationBuilder.add("item.interval.izumi_food_star_rail.tooltip", "right click good things happen");
        translationBuilder.add("item.interval.izumi_fuel_hk3.tooltip", "A combustion material");
        translationBuilder.add("item.interval.izumi_fuel_hk3.shift_tooltip", "A combustion material burns for a burn time: §61600tick§r");

        /*
            Blocks Tooltip
         */
        translationBuilder.add("block.interval.izumi_fluor_ice.tooltip", "Yongchu Taffy, how is the top of your head pointed?");
        translationBuilder.add("block.interval.izumi_flux_crystal.tooltip", "It seems that there is no hint?!");
        translationBuilder.add("block.interval.izumi_flux_crystal.shift_tooltip", "Don't look at it, there's nothing here!");
        translationBuilder.add("block.interval.izumi_void_mist.tooltip", "Izumi loves the world's cutest!!");
        translationBuilder.add("block.interval.izumi_ai_yin.tooltip", "A special block, EiHiEiHiEiHi!!&&");
        translationBuilder.add("block.interval.izumi_ether_amber.tooltip", "Follow Taffy Meow, pay attention to Yongchu Taffy Meow!");

        translationBuilder.add("item.interval.no_good_music_disc.tooltip", "This Is True Music!!");
    }
}
