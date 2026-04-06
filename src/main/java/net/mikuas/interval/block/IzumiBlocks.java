package net.mikuas.interval.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.custom.*;
import net.mikuas.interval.block.entity.IzumiBoxBlockEntities;
import net.mikuas.interval.sound.IzumiSoundEvents;
import net.mikuas.interval.world.tree.IzumiTreeGenerator;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class IzumiBlocks
{
    public static final Block IZUMI_FLUOR_ICE = register("izumi_fluor_ice",
            new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(1.0F, 1.0F))
                    .setTooltip("block.interval.izumi_fluor_ice.tooltip")
//                    .setTooltip("永雏塔菲你的头顶怎么尖尖的?")
    );
    public static final Block IZUMI_FLUX_CRYSTAL = register("izumi_flux_crystal",
            new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(3.0F, 1.0F))
                    .hasShiftTooltip()
                    .setTooltip("block.interval.izumi_flux_crystal.tooltip", "block.interval.izumi_flux_crystal.shift_tooltip")
//                    .setTooltip("好像什么提示都没有呢?!", "别看了, 这里也什么都没有呢!")
    );

    public static final Block IZUMI_VOID_MIST = register("izumi_void_mist",
            new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(0.5F, 1.0F))
                    .setTooltip("block.interval.izumi_void_mist.tooltip")
//                    .setTooltip("和泉妃爱世界第一可爱!!")
    );

    public static final Block IZUMI_AI_YIN = register("izumi_ai_yin",
            new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(3.5F, 1.0F)
                    .sounds(IzumiSoundEvents.IZUMI_AI_YIN_BLOCK_SOUND_GROUP) // 方块音效
            ).setTooltip("block.interval.izumi_ai_yin.tooltip")
//                    .setTooltip("一个特殊的方块, EiHiEiHiEiHi!!&&")
    );

    public static final Block IZUMI_VOID_DOOR = register("izumi_void_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_VOID_MIST))
    );

    public static final Block IZUMI_VOID_TRAPDOOR = register("izumi_void_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_VOID_MIST)
            .nonOpaque() // 不是不透明的
//            .pistonBehavior() // 活塞推动动作
            .burnable() // 可以燃烧
    ));

    // requiresTool 需要工具采集
//    public static final Block ICE_QCF_BLOCK = register("ice_qcf_block", new Block(AbstractBlock.Settings.create().strength(1.0F, 1.0F)));

    public static final Block IZUMI_ETHER_AMBER = register("izumi_ether_amber",
            new IzumiBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0F, 1.0F))
                    .setTooltip("关注塔菲喵, 关注永雏塔菲喵!")
    );
    // 楼梯
    public static final Block IZUMI_ETHER_STAIRS = register("izumi_ether_stairs",
            new StairsBlock(IZUMI_ETHER_AMBER.getDefaultState(), AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 半砖
    public static final Block IZUMI_ETHER_SLAB = register("izumi_ether_slab",
            new SlabBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0F, 1.0F))
//            new SlabBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 按钮
    public static final Block IZUMI_ETHER_BUTTON = register("izumi_ether_button",
            new ButtonBlock(BlockSetType.OAK, 32,  AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 压力板
    public static final Block IZUMI_ETHER_PRESSURE_PLATE = register("izumi_ether_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 围栏
    public static final Block IZUMI_ETHER_FENCE = register("izumi_ether_fence",
            new FenceBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 栅栏门 OKA 木头材质 可以被手动开启
    public static final Block IZUMI_ETHER_FENCE_GATE = register("izumi_ether_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 石头围栏
    public static final Block IZUMI_ETHER_WALL = register("izumi_ether_wall",
            new WallBlock(AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 门
    public static final Block IZUMI_ETHER_DOOR = register("izumi_ether_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 活扳门
    public static final Block IZUMI_ETHER_TRAPDOOR = register("izumi_ether_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(IZUMI_ETHER_AMBER))
    );

    // 作物
    public static final Block IZUMI_CROP = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_crop"),
            new IzumiCropBlock(AbstractBlock.Settings
                    .create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision() // 无碰撞箱
                    .ticksRandomly() // 随机刻度
                    .breakInstantly() // 瞬间被破环
                    .sounds(BlockSoundGroup.CROP) // 声音
                    .pistonBehavior(PistonBehavior.DESTROY) // 活塞动作
            )
    );

    // 多方块作物
    public static final Block IZUMI_MULTI_CROP = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_multi_crop"),
            new IzumiMultiCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT))
    );

    // 流体
    public static final Block FEN_DA = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "fen_da"),
            new FluidBlock(IzumiFluids.FEN_DA, AbstractBlock.Settings.copy(Blocks.WATER))
    );

    // 箱子(方块实体)
    public static final Block IZUMI_BOX = register("izumi_box", new IzumiBoxBlock(AbstractBlock.Settings.copy(Blocks.CHEST), () -> IzumiBoxBlockEntities.IZUMI_BOX));

    public static void registerBlockItems(String id, Block block)
    {
        Item item = Registry.register(Registries.ITEM, Identifier.of(Interval.MOD_ID, id), new BlockItem(block, new Item.Settings()));

        if (item instanceof BlockItem)
        {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    // 自定义方块实体
    public static final Block POLISHING_MACHINE = register("polishing_machine", new PolishingMachine(AbstractBlock.Settings.copy(Blocks.STONE)));

    // 自定义方块
    public static final Block IZUMI_SIMPLE_BLOCK =  register("izumi_simple_block", new IzumiSimpleBlock(AbstractBlock.Settings.copy(Blocks.STONE)
            .requiresTool().strength(5.0F, 1.0F)
    ));
    public static final Block IZUMI_SIMPLE_FENCE = register("izumi_simple_fence",
            new IzumiSimpleFence(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque())
    );

    // 木头
    //原木
    public static final Block IZUMI_LOG = register("izumi_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    // 木块(6面一样)
    public static final Block IZUMI_WOOD = register("izumi_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    // 去皮原木
    public static final Block STRIPPED_IZUMI_LOG = register("stripped_izumi_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    // 去皮木块
    public static final Block STRIPPED_IZUMI_WOOD = register("stripped_izumi_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    // 木板
    public static final Block IZUMI_PLANKS = register("izumi_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    // 树叶
    public static final Block IZUMI_LEAVES = register("izumi_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    // 告示牌
    public static final Identifier IZUMI_SIGN_TEXTURE = Identifier.of(Interval.MOD_ID, "entity/signs/izumi");
    public static final Identifier IZUMI_HANGING_SIGN_TEXTURE = Identifier.of(Interval.MOD_ID, "entity/signs/hanging/izumi");
    public static final Identifier IZUMI_HANGING_SIGN_GUI = Identifier.of(Interval.MOD_ID, "textures/gui/hanging_signs/izumi");

    public static final Block IZUMI_SIGN = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_sign"),
            new TerraformSignBlock(IZUMI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN))
    );

    public static final Block IZUMI_WALL_SIGN = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_wall_sign"),
            new TerraformWallSignBlock(IZUMI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN))
    );

    public static final Block IZUMI_HANGING_SIGN = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_hanging_sign"),
            new TerraformHangingSignBlock(IZUMI_HANGING_SIGN_TEXTURE, IZUMI_HANGING_SIGN_GUI, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN))
    );

    public static final Block IZUMI_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK, Identifier.of(Interval.MOD_ID, "izumi_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(IZUMI_HANGING_SIGN_TEXTURE, IZUMI_HANGING_SIGN_GUI, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN))
    );

    // 树苗
    public static final Block IZUMI_SAPLING = register("izumi_tree_sapling", new SaplingBlock(IzumiTreeGenerator.IZUMI_TREE,
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING))
    );

    // 花
    public static final Block IZUMI_SIMPLE_FLOWER = register("izumi_simple_flower", new FlowerBlock(
            StatusEffects.NIGHT_VISION, 4F, AbstractBlock.Settings.copy(Blocks.DANDELION)
    ));

    // 盆栽花
    public static final Block IZUMI_POTTED_SIMPLE_FLOWER = Registry.register(Registries.BLOCK,
            Identifier.of(Interval.MOD_ID, "izumi_potted_simple_flower"),
            new FlowerPotBlock(IZUMI_SIMPLE_FLOWER, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION))
    );

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
