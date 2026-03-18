package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mikuas.interval.block.IzumiBlockFamilies;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.block.custom.IzumiMultiCropBlock;
import net.mikuas.interval.item.IzumiItems;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;

public class IzumiModelsProvider extends FabricModelProvider
{
    public IzumiModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        // 注册方块
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_FLUOR_ICE);
        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_FLUX_CRYSTAL);

//        blockStateModelGenerator.registerSimpleCubeAll(IzumiBlocks.IZUMI_ETHER_AMBER);
        IzumiBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(blockFamily -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock()).family(blockFamily));

//        blockStateModelGenerator.registerCrop(IzumiBlocks.IZUMI_CROP, Properties.AGE_3, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(IzumiBlocks.IZUMI_CROP, Properties.AGE_7, 0, 0, 1, 1, 2, 2, 2, 3);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(IzumiBlocks.IZUMI_MULTI_CROP)
                        .coordinate(BlockStateVariantMap.create(IzumiMultiCropBlock.AGE)
                                .register(stage -> BlockStateVariant.create()
                                        .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                IzumiBlocks.IZUMI_MULTI_CROP, "_stage" + stage, Models.CROSS, TextureMap::cross))
                                )
                        )
        );

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
        // Items
        itemModelGenerator.register(IzumiItems.IZUMI_CPHN, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_MIMI, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_CLSY, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_LXTL, Models.GENERATED);

//        itemModelGenerator.register(IzumiItems.IZUMI_SEED, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_MULTI_CROP_SEED, Models.GENERATED);

        // Fuel
        itemModelGenerator.register(IzumiItems.IZUMI_FUEL_HK3, Models.GENERATED);

        // Tool
        itemModelGenerator.register(IzumiItems.PROSPECTOR, Models.GENERATED);

        itemModelGenerator.register(IzumiItems.IZUMI_SWORD, Models.HANDHELD); // 手持
        itemModelGenerator.register(IzumiItems.IZUMI_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_AXE, Models.HANDHELD);
        itemModelGenerator.register(IzumiItems.IZUMI_HOE, Models.HANDHELD);

        // 头盔
        itemModelGenerator.registerArmor((ArmorItem)IzumiItems.IZUMI_HELMET);

        // Food Items
        itemModelGenerator.register(IzumiItems.IZUMI_FOOD_PAI_MENG, Models.GENERATED);
        itemModelGenerator.register(IzumiItems.IZUMI_FOOD_STAR_RAIL, Models.GENERATED);
    }
}
