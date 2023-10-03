package dev.mayaqq.sam.registry;

import dev.mayaqq.sam.registry.entities.ZoologistEntity;
import dev.mayaqq.sam.registry.entities.summons.SlimeSummonEntity;
import dev.mayaqq.sam.registry.entities.summons.SummonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.HashMap;

import static dev.mayaqq.sam.SummonAMinion.id;

public class SamEntities {
    public static HashMap<EntityType<? extends SummonEntity>, Double> summonEntityDamageMap = new HashMap<>();

    public static final EntityType<ZoologistEntity> ZOOLOGIST_ENTITY = Registry.register(Registries.ENTITY_TYPE, id("zoologist"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ZoologistEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build());

    public static final EntityType<SlimeSummonEntity> SLIME_SUMMON = registerSummon("slime_summon", SlimeSummonEntity::new, EntityDimensions.fixed(0.375F, 0.375F), createDefaultAttributes(0.30000001192092896, 1.0));

    public static void register() {
        FabricDefaultAttributeRegistry.register(ZOOLOGIST_ENTITY, ZoologistEntity.createZoologistAttributes());
    }

    public static <T extends Entity> EntityType<T> registerSummon(String id, EntityType.EntityFactory<T> factory, EntityDimensions dimensions, DefaultAttributeContainer.Builder attributes) {
        EntityType<T> summon = Registry.register(Registries.ENTITY_TYPE, id(id), FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(dimensions).build());
        summonEntityDamageMap.put((EntityType<? extends SummonEntity>) summon, attributes.build().getValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
        FabricDefaultAttributeRegistry.register((EntityType<? extends SummonEntity>) summon, attributes);
        return summon;
    }

    public static DefaultAttributeContainer.Builder createDefaultAttributes(double speed, double attackDamage) {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, speed).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, attackDamage);
    }
}