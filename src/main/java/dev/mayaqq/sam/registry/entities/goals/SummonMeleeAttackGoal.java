package dev.mayaqq.sam.registry.entities.goals;

import dev.mayaqq.sam.registry.entities.summons.SummonEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class SummonMeleeAttackGoal extends MeleeAttackGoal {
    public SummonMeleeAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    @Override
    public boolean shouldContinue() {
        SummonEntity summonEntity = (SummonEntity) this.mob;
        return super.shouldContinue() && !(this.mob.getSquaredDistanceToAttackPosOf(summonEntity.getOwner()) > 600);
    }
}
