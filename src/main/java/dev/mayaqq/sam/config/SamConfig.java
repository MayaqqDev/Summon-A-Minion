package dev.mayaqq.sam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.FloatFieldControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.TickBoxControllerBuilderImpl;
import dev.mayaqq.sam.SummonAMinion;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class SamConfig {
     public static final String TITLE = "config.sam.title";
        public static final String CATEGORY_LOOT_TABLES = "config.sam.category.loot_tables";
            public static final String OPTION_GROUP_SLIME_STAFF = "config.sam.option_group.slime_staff";
                public static final String OPTION_SLIME_STAFF = "config.sam.option.slime_staff";
                    public static final String OPTION_SLIME_STAFF_DESCRIPTION = "config.sam.option.slime_staff.description";
                public static final String OPTION_SLIME_STAFF_CHANCE = "config.sam.option.slime_staff.chance";
                public static final String OPTION_SLIME_STAFF_REQUIRE_PLAYER_KILL = "config.sam.option.slime_staff.require_player_kill";

    public static final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("SummonAMinion.json");

    @SerialEntry
    public boolean slimeStaff = true;
    @SerialEntry
    public float slimeStaffChance = 0.1F;
    @SerialEntry
    public boolean requirePlayerKill = true;

    public static final ConfigClassHandler<SamConfig> HANDLER = ConfigClassHandler.createBuilder(SamConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(configFile).appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();
}
