package dev.mayaqq.sam.client.rendering.entities.summons.slime;

import dev.mayaqq.sam.registry.entities.summons.SlimeSummonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SlimeSummonModel extends EntityModel<SlimeSummonEntity> {
    private final ModelPart body;
    private final ModelPart right_eye;
    private final ModelPart left_eye;
    private final ModelPart mouth;
    public SlimeSummonModel(ModelPart root) {
        this.body = root.getChild("body");
        this.right_eye = root.getChild("right_eye");
        this.left_eye = root.getChild("left_eye");
        this.mouth = root.getChild("mouth");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 18.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_eye = modelPartData.addChild("right_eye", ModelPartBuilder.create().uv(32, 0).cuboid(1.3F, 19.0F, -3.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_eye = modelPartData.addChild("left_eye", ModelPartBuilder.create().uv(32, 4).cuboid(-3.3F, 19.0F, -3.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData mouth = modelPartData.addChild("mouth", ModelPartBuilder.create().uv(32, 8).cuboid(-1.0F, 22.0F, -3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    @Override
    public void setAngles(SlimeSummonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        right_eye.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        left_eye.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        mouth.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
