package net.mikuas.interval.block;

import net.mikuas.interval.Interval;
import net.mikuas.interval.block.custom.IzumiBlock;
import net.mikuas.interval.block.custom.IzumiCropBlock;
import net.mikuas.interval.block.custom.IzumiMultiCropBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IzumiBlocks
{
    public static final Block IZUMI_FLUOR_ICE = register("izumi_fluor_ice", new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(1.0F, 1.0F)).setTooltip("永雏塔菲你的头顶怎么尖尖的?"));
    public static final Block IZUMI_FLUX_CRYSTAL = register("izumi_flux_crystal", new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(3.0F, 1.0F)).setTooltip("好像什么提示都没有呢!", "别看了, 这里也什么都没有呢!").hasShiftTooltip());

    public static final Block IZUMI_VOID_MIST = register("izumi_void_mist", new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(0.5F, 1.0F)).setTooltip("和泉妃爱世界第一可爱!!"));
    public static final Block IZUMI_VOID_DOOR = register("izumi_void_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_VOID_MIST)));
    public static final Block IZUMI_VOID_TRAPDOOR = register("izumi_void_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_VOID_MIST)
            .nonOpaque() // 不是不透明的
//            .pistonBehavior() // 活塞推动动作
            .burnable() // 可以燃烧
    ));

    // requiresTool 需要工具采集
//    public static final Block ICE_QCF_BLOCK = register("ice_qcf_block", new Block(AbstractBlock.Settings.create().strength(1.0F, 1.0F)));


    public static final Block IZUMI_ETHER_AMBER = register("izumi_ether_amber", new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0F, 1.0F)).setTooltip("关注塔菲喵, 关注永雏塔菲喵!"));
    // 楼梯
    public static final Block IZUMI_ETHER_STAIRS = register("izumi_ether_stairs", new StairsBlock(IZUMI_ETHER_AMBER.getDefaultState(), AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 半砖
    public static final Block IZUMI_ETHER_SLAB = register("izumi_ether_slab", new SlabBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 按钮
    public static final Block IZUMI_ETHER_BUTTON = register("izumi_ether_button", new ButtonBlock(BlockSetType.OAK, 32,  AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 压力板
    public static final Block IZUMI_ETHER_PRESSURE_PLATE = register("izumi_ether_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 围栏
    public static final Block IZUMI_ETHER_FENCE = register("izumi_ether_fence", new FenceBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 栅栏门 OKA 木头材质 可以被手动开启
    public static final Block IZUMI_ETHER_FENCE_GATE = register("izumi_ether_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 石头围栏
    public static final Block IZUMI_ETHER_WALL = register("izumi_ether_wall", new WallBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 门
    public static final Block IZUMI_ETHER_DOOR = register("izumi_ether_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 活扳门
    public static final Block IZUMI_ETHER_TRAPDOOR = register("izumi_ether_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER)));

    // 作物
//            new StrawberryCropBlock(
//                    AbstractBlock.Settings.create()
//                            .mapColor(MapColor.DARK_GREEN)
//                            .noCollision() // 无碰撞箱
//                            .ticksRandomly() // 随机刻度
//                            .breakInstantly() // 瞬间被破环
//                            .sounds(BlockSoundGroup.CROP) // 声音
//                            .pistonBehavior(PistonBehavior.DESTROY) // 活塞动作
//            )
    public static final Block IZUMI_CROP = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_crop"),
            new IzumiCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    // 多方块作物
    public static final Block IZUMI_MULTI_CROP = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_multi_crop"),
            new IzumiMultiCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static void registerBlockItems(String id, Block block)
    {
        Item item = Registry.register(Registries.ITEM, Identifier.of(Interval.MOD_ID, id), new BlockItem(block, new Item.Settings()));

        if (item instanceof BlockItem)
        {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block)
    {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, id), block);
    }

    public static void registerBlockItems()
    {
        Interval.LOGGER.info("Registering Blocks");
    }
}
