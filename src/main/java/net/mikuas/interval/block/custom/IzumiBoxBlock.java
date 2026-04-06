package net.mikuas.interval.block.custom;

import com.mojang.serialization.MapCodec;
import net.mikuas.interval.block.entity.IzumiBoxBlockEntities;
import net.mikuas.interval.block.entity.IzumiBoxBlockEntity;
import net.minecraft.block.AbstractChestBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class IzumiBoxBlock extends AbstractChestBlock<IzumiBoxBlockEntity>
{
    public static final MapCodec<IzumiBoxBlock> CODEC = createCodec(settings -> new IzumiBoxBlock(settings, () -> IzumiBoxBlockEntities.IZUMI_BOX));

    public IzumiBoxBlock(Settings settings, Supplier<BlockEntityType<? extends IzumiBoxBlockEntity>> blockEntityTypeSupplier)
    {
        super(settings, blockEntityTypeSupplier);
    }

    @Override
    protected MapCodec<? extends AbstractChestBlock<IzumiBoxBlockEntity>> getCodec()
    {
        return CODEC;
    }

    @Override
    public DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked)
    {
        return null;
    }

    @Nullable
    @Override
    public  BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new IzumiBoxBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        if (!world.isClient())
        {
            NamedScreenHandlerFactory factory = this.createScreenHandlerFactory(state, world, pos);
            if (factory != null)
            {
                player.openHandledScreen(factory);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.CONSUME;
    }
}
