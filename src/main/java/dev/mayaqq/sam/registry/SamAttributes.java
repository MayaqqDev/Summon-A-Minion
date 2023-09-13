package dev.mayaqq.sam.registry;

import dev.mayaqq.sam.SummonAMinion;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SamAttributes {

    public static final EntityAttribute MINION_SLOTS = register("minion_slots", 1, 0, 1000);

    public static void register() {}

    public static EntityAttribute register(String name, double base, double min, double max) {
        return Registry.register(Registries.ATTRIBUTE, SummonAMinion.id(name), new ClampedEntityAttribute("attribute.name.generic." + SummonAMinion.MOD_ID + "." + name, base, min, max));
    }
}
