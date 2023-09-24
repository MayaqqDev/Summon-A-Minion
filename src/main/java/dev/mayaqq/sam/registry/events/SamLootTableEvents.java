package dev.mayaqq.sam.registry.events;

import dev.mayaqq.sam.config.SamConfig;
import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProviderTypes;
import net.minecraft.util.Identifier;

public class SamLootTableEvents {
    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && id.equals(new Identifier("minecraft", "entities/slime")) && SamConfig.INSTANCE.slimeStaff) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(SamItems.SLIME_STAFF)).rolls(BinomialLootNumberProvider.create(1, SamConfig.INSTANCE.slimeStaffChance));

                tableBuilder.pool(pool);
            }
        });
    }
}