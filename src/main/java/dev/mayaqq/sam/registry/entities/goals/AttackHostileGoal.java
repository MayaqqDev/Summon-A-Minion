package dev.mayaqq.sam.registry.entities.goals;

import dev.mayaqq.sam.registry.entities.SummonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.Monster;

import java.util.EnumSet;

public class AttackHostileGoal extends TrackTargetGoal {
    private final SummonEntity entity;
    private LivingEntity attacking;

    public AttackHostileGoal(SummonEntity entity, boolean checkVisibility) {
        super(entity, checkVisibility);
        this.entity = entity;
        this.setControls(EnumSet.of(Control.TARGET));
    }


    public boolean canStart() {
        LivingEntity livingEntity = this.entity.getOwner();
        if (livingEntity != null) {
            return false;
        } else {
            this.attacking = entity.getWorld().getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT, this.entity, this.entity.getX(), this.entity.getY(), this.entity.getZ(), this.entity.getBoundingBox().expand(16.0D, 16.0D, 16.0D));
            if (attacking instanceof Monster) {
                return this.canTrack(this.attacking, TargetPredicate.DEFAULT);
            } else return false;
        }
    }

    public void start() {
        this.mob.setTarget(this.attacking);
        super.start();
    }
}
