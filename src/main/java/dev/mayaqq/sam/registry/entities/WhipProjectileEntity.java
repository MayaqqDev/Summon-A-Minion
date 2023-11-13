package dev.mayaqq.sam.registry.entities;

import dev.mayaqq.sam.datagen.tags.SamTags;
import dev.mayaqq.sam.mixin.LivingEntityMixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WhipProjectileEntity extends ProjectileEntity {

    final int lastingTicks;

    public WhipProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        this(entityType, world, 0, null);
    }

    public WhipProjectileEntity(EntityType<? extends ProjectileEntity> entityType, World world, int lastingTicks, LivingEntity owner) {
        super(entityType, world);
        this.lastingTicks = lastingTicks;
        this.setOwner(owner);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity owner = (LivingEntity) this.getOwner();
        if (owner == null) {
            this.discard();
            return;
        }
        removeIfInvalid(owner);
        if (this.age >= this.lastingTicks) {
            returnWhip(owner);
        }
    }


    private void removeIfInvalid(LivingEntity player) {
        ItemStack itemStack = player.getMainHandStack();
        boolean bl = itemStack.isIn(SamTags.ItemTags.WHIPS);
        if (!player.isRemoved() && player.isAlive() && bl && !(this.squaredDistanceTo(player) > 1024.0)) {
            return;
        } else {
            this.discard();
        }
    }

    private void returnWhip(LivingEntity owner) {
        if (this.squaredDistanceTo(owner) < 2.0D) {
            this.discard();
        }
        this.setVelocity(owner.getRotationVector().multiply(-2));
    }
}
