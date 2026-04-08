package net.mikuas.interval.entity.client;

import net.mikuas.interval.Interval;
import net.mikuas.interval.entity.custom.IzumiTigerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class IzumiTigerRenderer extends MobEntityRenderer<IzumiTigerEntity, IzumiTigerModel<IzumiTigerEntity>>
{
    public static final Identifier TEXTURE = Identifier.of(Interval.MOD_ID, "textures/entity/tiger.png");

    public IzumiTigerRenderer(EntityRendererFactory.Context context)
    {
        super(context, new IzumiTigerModel<>(context.getPart(IzumiModelLayers.TIGER)), 0.5F);
    }

    @Override
    public Identifier getTexture(IzumiTigerEntity entity)
    {
        return TEXTURE;
    }

    @Override
    public void render(IzumiTigerEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        if (livingEntity.isBaby())
        {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
        }
        else
        {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
