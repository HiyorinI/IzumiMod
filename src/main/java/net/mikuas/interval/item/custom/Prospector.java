package net.mikuas.interval.item.custom;

import net.mikuas.interval.tags.IzumiBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class Prospector extends IzumiItem
{
    public static final int WIDTH = 5;
    public static final int LENGTH = 5;
    public static final int MAX_DAMAGE = 255;

    public Prospector(Settings settings)
    {
        super(settings.maxDamage(MAX_DAMAGE) // max damage: 耐久
                .fireproof() // 防火
        );
        this.hasShiftTooltip().setTooltip("item.interval.prospector.tooltip", "item.interval.prospector.shift_tooltip");
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        // 方块位置
        BlockPos pos = context.getBlockPos();
        // 玩家
        PlayerEntity player = context.getPlayer();
        // 世界
        World world = context.getWorld();

        if (!world.isClient())
        {
            boolean foundBlock = Screen.hasShiftDown() ? preciseSearch(pos, player, world) : fuzzySearch(pos, player, world);
            if (!foundBlock) player.sendMessage(Text.of("未发现矿石!"));

            // 消耗耐久值
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND); // MAINHAND 主手
//            context.getStack().damage(1, player, LivingEntity.getSlotForHand(context.getHand()));
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean fuzzySearch(BlockPos pos, PlayerEntity player, World world)
    {
        for (int i = 0; i <= pos.getY() + 64; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                for (int k = 0; k < LENGTH; k++)
                {
                    BlockPos pos1 = pos.down().north(j).east(k);
                    BlockState blockState = world.getBlockState(pos1);
                    String name = blockState.getBlock().getName().getString();

                    if (isRightBlock(blockState))
                    {
                        player.sendMessage(Text.of("Found " + name + "!" + " X: " + pos1.getX() + " Y: " + pos1.getY()));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean preciseSearch(BlockPos pos, PlayerEntity player, World world)
    {
        for (int i = 0; i <= pos.getY() + 64; i++)
        {
            BlockPos pos1 = pos.down();
            BlockState blockState = world.getBlockState(pos1);
            String name = blockState.getBlock().getName().getString();

            if (isRightBlock(blockState))
            {
                player.sendMessage(Text.of("Found " + name + "!" + " X: " + pos1.getX() + " Y: " + pos1.getY()));
                return true;
            }
        }
        return false;
    }

    private boolean isRightBlock(BlockState blockState)
    {
        // 探测的矿物是否存在标签里
        return (blockState.isIn(IzumiBlockTags.ORE_LIST));
//        return (blockState.isOf(Blocks.DIAMOND_ORE) || blockState.isOf(Blocks.IRON_ORE));
    }
}