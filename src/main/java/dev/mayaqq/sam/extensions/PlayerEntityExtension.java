package dev.mayaqq.sam.extensions;

import dev.mayaqq.sam.registry.entities.summons.SummonEntity;

import java.util.ArrayList;

public interface PlayerEntityExtension {
    void summonAMinion$addSummonedMinion(SummonEntity entity);
    void summonAMinion$removeSummonedMinion(SummonEntity entity);
    int summonAMinion$getSummonedMinionCount();
    int summonAMinion$getSummonedMinionLimit();
    ArrayList<SummonEntity> summonAMinion$getSummonedMinions();
    float summonAMinion$getSummonedMinionDamage();
}
