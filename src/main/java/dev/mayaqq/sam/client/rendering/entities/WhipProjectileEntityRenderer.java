package dev.mayaqq.sam.client.rendering.entities;

import dev.mayaqq.sam.registry.entities.WhipProjectileEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FishingBobberEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Identifier;

public class WhipProjectileEntityRenderer extends EntityRenderer<WhipProjectileEntity> {
    public WhipProjectileEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(WhipProjectileEntity entity) {
        return null;
    }
}
