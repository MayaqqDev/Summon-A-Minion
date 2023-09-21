package dev.mayaqq.sam.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class SlimeSummonEntity extends SummonEntity {
    public SlimeSummonEntity(EntityType<? extends SummonEntity> entityType, World world) {
        super(entityType, world);
    }
}