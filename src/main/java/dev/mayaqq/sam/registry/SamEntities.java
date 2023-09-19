package dev.mayaqq.sam.registry;

import dev.mayaqq.sam.registry.entities.SlimeSummonEntity;
import dev.mayaqq.sam.registry.entities.SummonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


import static dev.mayaqq.sam.SummonAMinion.id;

public class SamEntities {
    public static final EntityType<SlimeSummonEntity> SLIME_SUMMON = registerSummon("slime_summon", SlimeSummonEntity::new, EntityDimensions.fixed(0.75F, 0.75F), SlimeSummonEntity.createMobAttributes());

    public static void register() {}

    public static <T extends Entity> EntityType<T> registerSummon(String id, EntityType.EntityFactory<T> factory, EntityDimensions dimensions, DefaultAttributeContainer.Builder attributes) {
        EntityType<T> summon = Registry.register(Registries.ENTITY_TYPE, id(id), FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(dimensions).build());
        FabricDefaultAttributeRegistry.register((EntityType<? extends SummonEntity>) summon, attributes);
        return summon;
    }
}