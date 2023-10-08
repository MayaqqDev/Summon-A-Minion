package dev.mayaqq.sam.registry;

import dev.mayaqq.sam.SummonAMinion;
import dev.mayaqq.sam.registry.items.base.SummonerWandItem;
import dev.mayaqq.sam.registry.items.base.SummonerWhipItem;
import dev.mayaqq.sam.registry.items.materials.WhipMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;

public class SamItems {

    public static ArrayList<Item> ITEMS = new ArrayList<>();

    public static final Item SLIME_STAFF = register("slime_staff", new SummonerWandItem(new Item.Settings(), SamEntities.SLIME_SUMMON));
    public static final Item ZOOLOGIST_SPAWN_EGG = register("zoologist_spawn_egg", new SpawnEggItem(SamEntities.ZOOLOGIST_ENTITY, 0x5E3C3C, 0x8B4513, new Item.Settings().maxCount(64)));

    public static final Item LEATHER_WHIP = register("leather_whip", new SummonerWhipItem(WhipMaterials.LEATHER, new Item.Settings()));

    public static final Item DOG_EARS = register("dog_ears", new Item(new Item.Settings()));
    public static final Item DOG_TAIL = register("dog_tail", new Item(new Item.Settings()));
    public static final Item FOX_EARS = register("fox_ears", new Item(new Item.Settings()));
    public static final Item FOX_TAIL = register("fox_tail", new Item(new Item.Settings()));
    public static final Item LIZARD_EARS = register("lizard_ears", new Item(new Item.Settings()));
    public static final Item LIZARD_TAIL = register("lizard_tail", new Item(new Item.Settings()));
    public static final Item BUNNY_EARS = register("bunny_ears", new Item(new Item.Settings()));
    public static final Item BUNNY_TAIL = register("bunny_tail", new Item(new Item.Settings()));

    public static void register() {}

    public static Item register(String name, Item item) {
        Item itemEntry = Registry.register(Registries.ITEM, SummonAMinion.id(name), item);
        ITEMS.add(itemEntry);
        return itemEntry;
    }
}
