package dev.mayaqq.sam.client.rendering.entities.summons.slime;

import dev.mayaqq.sam.registry.entities.summons.SlimeSummonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static dev.mayaqq.sam.SummonAMinion.id;

public class SlimeSummonRenderer extends MobEntityRenderer<SlimeSummonEntity, SlimeSummonModel> {

    public static final EntityModelLayer MODEL_SLIME_SUMMON_LAYER = new EntityModelLayer(id( "cube"), "main");

    public SlimeSummonRenderer(EntityRendererFactory.Context context) {
        super(context, new SlimeSummonModel(context.getPart(MODEL_SLIME_SUMMON_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(SlimeSummonEntity entity) {
        return id("textures/entity/summons/slime/slime_summon.png");
    }
}
