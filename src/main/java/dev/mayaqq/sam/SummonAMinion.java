package dev.mayaqq.sam;

import dev.mayaqq.sam.config.SamConfig;
import dev.mayaqq.sam.registry.SamAttributes;
import dev.mayaqq.sam.registry.SamEntities;
import dev.mayaqq.sam.registry.SamItems;
import dev.mayaqq.sam.registry.events.SamConnectionEvents;
import dev.mayaqq.sam.registry.events.SamLootTableEvents;
import dev.mayaqq.sam.registry.itemGroups.SamItemGroups;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummonAMinion implements ModInitializer {
    public static final String MOD_ID = "sam";
    public static final Logger LOGGER = LoggerFactory.getLogger("sam");

    @Override
    public void onInitialize() {
        SamConfig.INSTANCE.load();
        SamItems.register();
        SamAttributes.register();
        SamEntities.register();
        SamConnectionEvents.register();
        SamItemGroups.register();
        SamLootTableEvents.register();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
