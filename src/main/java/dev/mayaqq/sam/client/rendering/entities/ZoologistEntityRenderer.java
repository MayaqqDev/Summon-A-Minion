package dev.mayaqq.sam.client.rendering.entities;

import dev.mayaqq.sam.registry.entities.ZoologistEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ZoologistEntityRenderer extends MobEntityRenderer<ZoologistEntity, VillagerResemblingModel<ZoologistEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/wandering_trader.png");

    public ZoologistEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new VillagerResemblingModel(context.getPart(EntityModelLayers.WANDERING_TRADER)), 0.5F);
        this.addFeature(new HeadFeatureRenderer(this, context.getModelLoader(), context.getHeldItemRenderer()));
    }

    public Identifier getTexture(ZoologistEntity zoologistEntity) {
        return TEXTURE;
    }

    protected void scale(ZoologistEntity zoologistEntity, MatrixStack matrixStack, float f) {
        matrixStack.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
