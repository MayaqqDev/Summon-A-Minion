package dev.mayaqq.sam.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.autogen.AutoGen;
import dev.isxander.yacl3.config.v2.api.autogen.CustomDescription;
import dev.isxander.yacl3.config.v2.api.autogen.FloatField;
import dev.isxander.yacl3.config.v2.api.autogen.TickBox;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.mayaqq.sam.SummonAMinion;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class SamConfig {

    public static final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("SummonAMinion.json");

    private static final String lt_category = "loot_tables"; // Loot Tables Category

    @AutoGen(category = lt_category, group = "slime_staff")
    @CustomDescription("yacl3.config.sam:config.slimeStaff.desc")
    @TickBox
    @SerialEntry
    public boolean slimeStaff = true;
    @AutoGen(category = lt_category, group = "slime_staff")
    @CustomDescription("yacl3.config.sam:config.slimeStaffChance.desc")
    @FloatField(min = 0, max = 1)
    @SerialEntry
    public float slimeStaffChance = 0.1F;
    @AutoGen(category = lt_category, group = "slime_staff")
    @CustomDescription("yacl3.config.sam:config.requirePlayerKill.desc")
    @TickBox
    @SerialEntry
    public boolean requirePlayerKill = true;

    public static final ConfigClassHandler<SamConfig> HANDLER = ConfigClassHandler.createBuilder(SamConfig.class)
            .id(SummonAMinion.id("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(configFile).appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();
}
