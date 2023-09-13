package dev.mayaqq.sam.registry;

import dev.mayaqq.sam.SummonAMinion;
import dev.mayaqq.sam.registry.items.base.SummonerWandItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SamItems {

    public static final Item SLIME_STAFF = register("slime_staff", new SummonerWandItem(new Item.Settings()));

    public static void register() {}

    public static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, SummonAMinion.id(name), item);
    }
}
