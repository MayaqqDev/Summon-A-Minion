package dev.mayaqq.sam.mixin;

import dev.mayaqq.sam.SummonAMinion;
import dev.mayaqq.sam.datagen.tags.SamTags;
import dev.mayaqq.sam.registry.SamEntities;
import dev.mayaqq.sam.registry.entities.WhipProjectileEntity;
import me.shedaniel.rei.api.client.gui.widgets.Arrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public boolean handSwinging;

    @Shadow public int handSwingTicks;

    @Inject(method = "tickHandSwing", at = @At("HEAD"))
    private void tickHandSwing(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        ItemStack item = self.getMainHandStack();
        if (handSwinging && item.isIn(SamTags.ItemTags.WHIPS) && handSwingTicks == 1) {
            if (self.getWorld().isClient) {

            } else {
                WhipProjectileEntity whipProjectile = new WhipProjectileEntity(SamEntities.WHIP_PROJECTILE, self.getWorld(), 30, self);
                whipProjectile.setNoGravity(true);
                whipProjectile.setPos(self.getPos().x + (self.getRotationVector().x * 2), self.getY() + 1, self.getPos().z + (self.getRotationVector().z * 2));
                self.getWorld().spawnEntity(whipProjectile);
                whipProjectile.setVelocity(self.getRotationVector().multiply(10));
            }
        }
    }
}
