package dev.mayaqq.sam;

import dev.mayaqq.sam.registry.SamAttributes;
import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummonAMinion implements ModInitializer {
    public static final String MOD_ID = "sam";
    public static final Logger LOGGER = LoggerFactory.getLogger("sam");

    @Override
    public void onInitialize() {
        SamItems.register();
        SamAttributes.register();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
