package dev.mayaqq.sam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.impl.controller.FloatFieldControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.TickBoxControllerBuilderImpl;
import dev.mayaqq.sam.SummonAMinion;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.nio.file.Files;
import java.nio.file.Path;

public class SamConfig {
    public static SamConfig INSTANCE = new SamConfig();

     public static final String TITLE = "config.sam.title";
        public static final String CATEGORY_LOOT_TABLES = "config.sam.category.loot_tables";
            public static final String OPTION_GROUP_SLIME_STAFF = "config.sam.option_group.slime_staff";
                public static final String OPTION_SLIME_STAFF = "config.sam.option.slime_staff";
                    public static final String OPTION_SLIME_STAFF_DESCRIPTION = "config.sam.option.slime_staff.description";
                public static final String OPTION_SLIME_STAFF_CHANCE = "config.sam.option.slime_staff.chance";

    public final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("SummonAMinion.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // loot tables
    public boolean slimeStaff = true;
        public float slimeStaffChance = 0.1F;

    public void save() {
        try {
            Files.deleteIfExists(configFile);

            JsonObject json = new JsonObject();
            json.addProperty("slimeStaff", slimeStaff);
            json.addProperty("slimeStaffChance", slimeStaffChance);

            Files.writeString(configFile, gson.toJson(json));
        } catch (Exception e) {
            SummonAMinion.LOGGER.error("Failed to save config file with exception: " + e.getMessage());
        }
    }

    public void load() {
        try {
            if (Files.notExists(configFile)) {
                save();
                return;
            }

            JsonObject json = gson.fromJson(Files.readString(configFile), JsonObject.class);

            if (json.has("slimeStaff")) slimeStaff = json.getAsJsonPrimitive("slimeStaff").getAsBoolean();
            if (json.has("slimeStaffChance")) slimeStaffChance = json.getAsJsonPrimitive("slimeStaffChance").getAsFloat();
        } catch (Exception e) {
            SummonAMinion.LOGGER.error("Failed to load config file with exception: " + e.getMessage());
        }
    }

    public Screen makeScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable(TITLE))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable(CATEGORY_LOOT_TABLES))
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable(OPTION_GROUP_SLIME_STAFF))
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.translatable(OPTION_SLIME_STAFF))
                                        .description(OptionDescription.of(Text.translatable(OPTION_SLIME_STAFF_DESCRIPTION)))
                                        .binding(
                                                true,
                                                () -> slimeStaff,
                                                value -> slimeStaff = value
                                        )
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.createBuilder(float.class)
                                        .name(Text.translatable(OPTION_SLIME_STAFF_CHANCE))
                                        .binding(
                                                0.1F,
                                                () -> slimeStaffChance,
                                                value -> slimeStaffChance = value
                                        )
                                        .controller(FloatFieldControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .build())
                .save(this::save)
                .build()
                .generateScreen(parent);
    }
}
