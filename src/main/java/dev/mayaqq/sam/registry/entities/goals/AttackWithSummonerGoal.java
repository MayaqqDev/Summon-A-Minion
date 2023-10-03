package dev.mayaqq.sam.registry.entities.goals;

import dev.mayaqq.sam.registry.entities.summons.SummonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.TrackTargetGoal;

import java.util.EnumSet;

public class AttackWithSummonerGoal extends TrackTargetGoal {
    private final SummonEntity entity;
    private LivingEntity attacking;
    private int lastAttackTime;

    public AttackWithSummonerGoal(SummonEntity entity) {
        super(entity, false);
        this.entity = entity;
        this.setControls(EnumSet.of(Control.TARGET));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.entity.getOwner();
        if (livingEntity == null) {
            return false;
        } else {
            this.attacking = livingEntity.getAttacking();
            int i = livingEntity.getLastAttackTime();
            return i != this.lastAttackTime && this.canTrack(this.attacking, TargetPredicate.DEFAULT);
        }
    }

    public void start() {
        this.mob.setTarget(this.attacking);
        LivingEntity livingEntity = this.entity.getOwner();
        if (livingEntity != null) {
            this.lastAttackTime = livingEntity.getLastAttackTime();
        }

        super.start();
    }

    @Override
    public boolean shouldContinue() {
        return super.shouldContinue() && this.attacking == this.entity.getOwner().getAttacking();
    }
}

