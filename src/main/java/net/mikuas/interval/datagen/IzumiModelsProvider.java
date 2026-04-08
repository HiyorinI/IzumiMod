package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mikuas.interval.block.IzumiBlockFamilies;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.custom.IzumiBlock;
import net.mikuas.interval.block.custom.IzumiMultiCropBlock;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;

public class IzumiModelsProvider extends FabricModelProvider
{
    public IzumiModelsProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        /*
         * Block Register
         */

        // 注册方块
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_FLUOR_ICE);
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_FLUX_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_AI_YIN);

//        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_ETHER_AMBER);
        IzumiBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(blockFamily -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock()).family(blockFamily));

//        blockStateModelGenerator.registerCrop(IzumiBlocks.IZUMI_CROP, Properties.AGE_3, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(IzumiBlocks.IZUMI_CROP, Properties.AGE_7, 0, 0, 1, 1, 2, 2, 2, 3);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(IzumiBlocks.IZUMI_MULTI_CROP)
                .coordinate(BlockStateVariantMap.create(IzumiMultiCropBlock.AGE).register(stage ->
                        BlockStateVariant.create().put(
                                VariantSettings.MODEL,
                                blockStateModelGenerator.createSubModel(
                                        IzumiBlocks.IZUMI_MULTI_CROP,
                                        "_stage" + stage,
                                        Models.CROSS,
                                        TextureMap::cross
                                )
                        )
                ))
        );

        /*
            流体
         */
        blockStateModelGenerator.registerSimpleState(IzumiBlocks.FEN_DA);

        /*
            箱子(方块实体)
         */
        blockStateModelGenerator.registerSimpleState(IzumiBlocks.IZUMI_BOX);

        /*
            自定义实体
         */
        blockStateModelGenerator.registerSimpleState(IzumiBlocks.POLISHING_MACHINE);

        /*
            自定义方块
         */
//        blockStateModelGenerator.registerSimpleState(IzumiBlocks.IZUMI_SIMPLE_BLOCK);
        // 默认北朝向
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(IzumiBlocks.IZUMI_SIMPLE_BLOCK);

        /*
            木头
         */
        blockStateModelGenerator.registerLog(IzumiBlocks.IZUMI_LOG).log(IzumiBlocks.IZUMI_LOG).wood(IzumiBlocks.IZUMI_WOOD);
        blockStateModelGenerator.registerLog(IzumiBlocks.STRIPPED_IZUMI_LOG).log(IzumiBlocks.STRIPPED_IZUMI_LOG).wood(IzumiBlocks.STRIPPED_IZUMI_WOOD);
//        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_LEAVES);

        /*
            树苗
         */
        blockStateModelGenerator.registerTintableCross(IzumiBlocks.IZUMI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        /*
            花, 盆栽
         */
        blockStateModelGenerator.registerFlowerPotPlant(IzumiBlocks.IZUMI_SIMPLE_FLOWER, IzumiBlocks.IZUMI_POTTED_SIMPLE_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

//        blockStateModelGenerator.registerParentedItemModel(IzumiBlocks.IZUMI_ETHER_AMBER, ModelIds.getBlockModelId(IzumiBlocks.IZUMI_ETHER_AMBER));

//        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_VOID_MIST);
//        blockStateModelGenerator.registerParentedItemModel(IzumiBlocks.IZUMI_VOID_MIST, ModelIds.getBlockModelId(IzumiBlocks.IZUMI_VOID_MIST));

        // 方块 Item
//        blockStateModelGenerator.registerParentedItemModel(IzumiBlocks.IZUMI_FLUOR_ICE, ModelIds.getBlockModelId(IzumiBlocks.IZUMI_FLUOR_ICE));
//        blockStateModelGenerator.registerParentedItemModel(IzumiBlocks.IZUMI_FLUX_CRYSTAL, ModelIds.getBlockModelId(IzumiBlocks.IZUMI_FLUX_CRYSTAL));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        /*
         * Item Register
         */

        // 项目
        itemModelGenerator.register(IzumiItems.IZUMI_CPHN, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_MIMI, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_CLSY, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_LXTL, Models.GENERATED);

//        itemModelGenerator.register(IzumiItems.IZUMI_SEED, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_MULTI_CROP_SEED, Models.GENERATED);

        // 燃料
        itemModelGenerator.register(IzumiItems.IZUMI_FUEL_HK3, Models.GENERATED);

        // 工具
        itemModelGenerator.register(IzumiItems.PROSPECTOR, Models.GENERATED);

        itemModelGenerator.register(IzumiItems.IZUMI_SWORD, Models.HANDHELD); // 手持
        itemModelGenerator.register(IzumiItems.IZUMI_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_AXE, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_HOE, Models.HANDHELD);

        // 盔甲
        itemModelGenerator.registerArmor((ArmorItem)IzumiItems.IZUMI_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)IzumiItems.IZUMI_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)IzumiItems.IZUMI_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)IzumiItems.IZUMI_BOOTS);

        // 食物
        itemModelGenerator.register(IzumiItems.IZUMI_FOOD_PAI_MENG, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_FOOD_STAR_RAIL, Models.GENERATED);

        // 音乐唱片
        itemModelGenerator.register(IzumiItems.NO_GOOD_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(IzumiItems.PINKY_OATH_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(IzumiItems.FLOWER_TOWER_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(IzumiItems.THE_WAY_THAT_I_LOVED_YOU_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);

        // 流体
        itemModelGenerator.register(IzumiItems.FEN_DA_BUCKET, Models.GENERATED);

        // 马凯
        itemModelGenerator.register(IzumiItems.IZUMI_CPHN_HORSE_ARMOR, Models.GENERATED);

        // 告示牌
        itemModelGenerator.register(IzumiItems.IZUMI_HANGING_SIGN, Models.GENERATED);

        // 船
        itemModelGenerator.register(IzumiItems.IZUMI_BOAT, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_CHEST_BOAT, Models.GENERATED);

        //
        itemModelGenerator.register(IzumiItems.IZUMI_FIRE_ETHER, Models.GENERATED);
    }
}
