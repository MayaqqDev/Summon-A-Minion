package dev.mayaqq.sam.registry.entities.goals;

import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;

public class ActiveSummonTargetGoal extends ActiveTargetGoal {
    public ActiveSummonTargetGoal(MobEntity mob, Class targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
    }

    @Override
    public boolean canStart() {
        return super.canStart() && this.targetEntity instanceof Monster;
    }
}
