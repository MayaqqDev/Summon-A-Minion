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
    public static String WHIPS_TK = "itemGroup.sam.whips";
    public static String WANDS_TK = "itemGroup.sam.wands";

    public static final Identifier GROUP_ID = id("main");
    public static final ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SamItems.SLIME_STAFF))
            .entries(((displayContext, entries) -> {
                entries.add(SamItems.SLIME_STAFF);
            }))
            .displayName(Text.translatable(MAIN_TK))
            .noRenderedName()
            .build();

    public static final ItemGroup WANDS = new ItemSubGroup.Builder(MAIN, Text.translatable(WANDS_TK)).entries(((displayContext, entries) -> {
        entries.add(SamItems.SLIME_STAFF);
    })).build();

    public static final ItemGroup WHIPS = new ItemSubGroup.Builder(MAIN, Text.translatable(WHIPS_TK)).entries(((displayContext, entries) -> {
    })).build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, GROUP_ID, MAIN);
    }
}