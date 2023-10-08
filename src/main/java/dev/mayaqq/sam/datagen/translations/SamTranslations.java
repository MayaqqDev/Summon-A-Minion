package dev.mayaqq.sam.datagen.translations;

import dev.mayaqq.sam.config.SamConfig;
import dev.mayaqq.sam.registry.SamAttributes;
import dev.mayaqq.sam.registry.SamEntities;
import dev.mayaqq.sam.registry.SamItems;
import dev.mayaqq.sam.registry.itemGroups.SamItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class SamTranslations {
    public static class EN_US extends FabricLanguageProvider {
        public EN_US(FabricDataOutput dataOutput) {
            super(dataOutput, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder tb) {
            // Summons
            tb.add(SamEntities.SLIME_SUMMON, "Slime Summon");

            // Entities
            tb.add(SamEntities.ZOOLOGIST_ENTITY, "Zoologist");

            // Attributes
            tb.add(SamAttributes.MINION_DAMAGE, "Minion Damage");
            tb.add(SamAttributes.MINION_SLOTS, "Minion Slots");

            // Items
            tb.add(SamItems.SLIME_STAFF, "Slime Staff");
            tb.add(SamItems.ZOOLOGIST_SPAWN_EGG, "Zoologist Spawn Egg");
                // Cosmetic
                tb.add(SamItems.DOG_EARS, "Dog Ears");
                tb.add(SamItems.DOG_TAIL, "Dog Tail");
                tb.add(SamItems.FOX_EARS, "Foxx Ears");
                tb.add(SamItems.FOX_TAIL, "Foxx Tail");
                tb.add(SamItems.BUNNY_EARS, "Bunny Ears");
                tb.add(SamItems.BUNNY_TAIL, "Bunny Tail");
                tb.add(SamItems.LIZARD_EARS, "Lizard Ears");
                tb.add(SamItems.LIZARD_TAIL, "Lizard Tail");

            // Item Groups
            tb.add(SamItemGroups.MAIN_TK, "Summon a Minion");
            tb.add(SamItemGroups.GENERAL_TK, "General");
            tb.add(SamItemGroups.WANDS_TK, "Wands");
            tb.add(SamItemGroups.WHIPS_TK, "Whips");
            tb.add(SamItemGroups.MISC_TK, "Misc");
            tb.add(SamItemGroups.COSMETICS_TK, "Cosmetics");

            // Config
            tb.add(SamConfig.TITLE, "Summon A Minion Config");
            tb.add(SamConfig.CATEGORY_LOOT_TABLES, "Loot Tables");
            tb.add(SamConfig.OPTION_GROUP_SLIME_STAFF, "Slime Staff");
            tb.add(SamConfig.OPTION_SLIME_STAFF, "Slime Staff Loot Table");
            tb.add(SamConfig.OPTION_SLIME_STAFF_DESCRIPTION, "Should Slimes drop the Slime Staff");
            tb.add(SamConfig.OPTION_SLIME_STAFF_CHANCE, "Chance");
            tb.add(SamConfig.OPTION_SLIME_STAFF_REQUIRE_PLAYER_KILL, "Require Player Kill");
        }
    }
}