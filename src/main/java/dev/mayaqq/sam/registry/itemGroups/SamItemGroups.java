package dev.mayaqq.sam.registry.itemGroups;

import de.dafuqs.fractal.api.ItemSubGroup;
import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static dev.mayaqq.sam.SummonAMinion.id;

public class SamItemGroups {

    public static String MAIN_TK = "itemGroup.sam.main";
    public static String GENERAL_TK = "itemGroup.sam.general";
    public static String WHIPS_TK = "itemGroup.sam.whips";
    public static String WANDS_TK = "itemGroup.sam.wands";
    public static String MISC_TK = "itemGroup.sam.misc";
    public static String COSMETICS_TK = "itemGroup.sam.cosmetics";

    public static final Identifier GROUP_ID = id("main");
    public static final ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SamItems.SLIME_STAFF))
            .entries(((displayContext, entries) -> {
                entries.add(SamItems.SLIME_STAFF);
            }))
            .displayName(Text.translatable(MAIN_TK))
            .noRenderedName()
            .build();

    public static final ItemGroup GENERAL = new ItemSubGroup.Builder(MAIN, Text.translatable(GENERAL_TK)).entries(((displayContext, entries) -> {
        SamItems.ITEMS.forEach(entries::add);
    })).build();

    public static final ItemGroup WANDS = new ItemSubGroup.Builder(MAIN, Text.translatable(WANDS_TK)).entries(((displayContext, entries) -> {
        entries.add(SamItems.SLIME_STAFF);
    })).build();

    public static final ItemGroup WHIPS = new ItemSubGroup.Builder(MAIN, Text.translatable(WHIPS_TK)).entries(((displayContext, entries) -> {
        entries.add(SamItems.LEATHER_WHIP);
    })).build();

    public static final ItemGroup MISC = new ItemSubGroup.Builder(MAIN, Text.translatable(MISC_TK)).entries(((displayContext, entries) -> {
        entries.add(SamItems.ZOOLOGIST_SPAWN_EGG);
    })).build();

    public static final ItemGroup COSMETICS = new ItemSubGroup.Builder(MAIN, Text.translatable(COSMETICS_TK)).entries(((displayContext, entries) -> {
        entries.add(SamItems.DOG_EARS);
        entries.add(SamItems.DOG_TAIL);
        entries.add(SamItems.FOX_EARS);
        entries.add(SamItems.FOX_TAIL);
        entries.add(SamItems.LIZARD_EARS);
        entries.add(SamItems.LIZARD_TAIL);
        entries.add(SamItems.BUNNY_EARS);
        entries.add(SamItems.BUNNY_TAIL);
    })).build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, GROUP_ID, MAIN);
    }
}
