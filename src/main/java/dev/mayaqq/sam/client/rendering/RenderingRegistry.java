package dev.mayaqq.sam.client.rendering;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import dev.mayaqq.sam.client.rendering.entities.ZoologistEntityRenderer;
import dev.mayaqq.sam.client.rendering.entities.summons.slime.SlimeSummonModel;
import dev.mayaqq.sam.client.rendering.entities.summons.slime.SlimeSummonRenderer;
import dev.mayaqq.sam.client.rendering.trinkets.TailRenderer;
import dev.mayaqq.sam.registry.SamEntities;
import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RenderingRegistry {
    public static void register() {
        EntityRendererRegistry.register(SamEntities.SLIME_SUMMON, SlimeSummonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SlimeSummonRenderer.MODEL_SLIME_SUMMON_LAYER, SlimeSummonModel::getTexturedModelData);

        EntityRendererRegistry.register(SamEntities.ZOOLOGIST_ENTITY, ZoologistEntityRenderer::new);

        TrinketRendererRegistry.registerRenderer(SamItems.DOG_TAIL, new TailRenderer());
    }
}
