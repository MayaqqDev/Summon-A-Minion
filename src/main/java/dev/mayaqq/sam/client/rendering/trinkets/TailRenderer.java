package dev.mayaqq.sam.client.rendering.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.isxander.yacl3.api.Option;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class TailRenderer implements TrinketRenderer {
    @Override
    public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        if (livingEntity instanceof ClientPlayerEntity playerEntity) {
            PlayerEntityModel<AbstractClientPlayerEntity> playerModel = (PlayerEntityModel<AbstractClientPlayerEntity>) entityModel;
            TrinketRenderer.translateToChest(matrixStack, playerModel, playerEntity);
            MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformationMode.FIXED, 0, 0, matrixStack, vertexConsumerProvider, playerEntity.getWorld(), 0);
        }
    }
}
