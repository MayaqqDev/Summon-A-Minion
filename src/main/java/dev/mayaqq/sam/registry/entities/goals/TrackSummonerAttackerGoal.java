package dev.mayaqq.sam.registry.entities.goals;

import dev.mayaqq.sam.registry.entities.SummonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.TrackTargetGoal;

import java.util.EnumSet;

public class TrackSummonerAttackerGoal extends TrackTargetGoal {
    private final SummonEntity entity;
    private LivingEntity attacker;
    private int lastAttackedTime;

    public TrackSummonerAttackerGoal(SummonEntity entity) {
        super(entity, false);
        this.entity = entity;
        this.setControls(EnumSet.of(Control.TARGET));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.entity.getOwner();
        if (livingEntity == null) {
            return false;
        } else {
            this.attacker = livingEntity.getAttacker();
            int i = livingEntity.getLastAttackedTime();
            return i != this.lastAttackedTime && this.canTrack(this.attacker, TargetPredicate.DEFAULT);
        }
    }

    public void start() {
        this.mob.setTarget(this.attacker);
        LivingEntity livingEntity = this.entity.getOwner();
        if (livingEntity != null) {
            this.lastAttackedTime = livingEntity.getLastAttackedTime();
        }

        super.start();
    }
}