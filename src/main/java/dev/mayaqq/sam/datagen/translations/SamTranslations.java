package dev.mayaqq.sam.datagen.translations;

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
            String config = "yacl3.config.sam:config.";
            tb.add(config + "category.loot_tables", "Loot Tables");
                tb.add(config + "category.loot_tables.group.slime_staff", "Slime Staff");
                    tb.add(config + "slimeStaff", "Enable Slime Staff");
                        tb.add(config + "slimeStaff.desc", "Whether or not the Slime Staff should be obtainable from Slimes.");
                    tb.add(config + "slimeStaffChance", "Slime Staff Chance");
                        tb.add(config + "slimeStaffChance.desc", "The chance of a Slime dropping a Slime Staff.");
                    tb.add(config + "requirePlayerKill", "Require Player Kill");
                        tb.add(config + "requirePlayerKill.desc", "Whether or not the Slime Staff should only drop if the player kills the Slime or always drop regardless of who kills the Slime.");

            // Trinket Slots
            tb.add("trinkets.slot.head.cosmetic", "Head Cosmetic");
            tb.add("trinkets.slot.chest.cosmetic", "Chest Cosmetic");
            tb.add("trinkets.slot.legs.cosmetic", "Legs Cosmetic");
            tb.add("trinkets.slot.feet.cosmetic", "Feet Cosmetic");
        }
    }

    public static class TR_TR extends FabricLanguageProvider {
        public TR_TR(FabricDataOutput dataOutput) {
            super(dataOutput, "tr_tr");
        }

        @Override
        public void generateTranslations(TranslationBuilder tb) {
            // Summons
            tb.add(SamEntities.SLIME_SUMMON, "Balçık Yardakçısı");

            // Entities
            tb.add(SamEntities.ZOOLOGIST_ENTITY, "Hayvanbilimci");

            // Attributes
            tb.add(SamAttributes.MINION_DAMAGE, "Yardakçı Hasarı");
            tb.add(SamAttributes.MINION_SLOTS, "Yardakçı Yuvaları");

            // Items
            tb.add(SamItems.SLIME_STAFF, "Balçık Asası");
            tb.add(SamItems.ZOOLOGIST_SPAWN_EGG, "Hayvanbilimci Yumurtası");
                // Cosmetic
                tb.add(SamItems.DOG_EARS, "Köpek Kulakları");
                tb.add(SamItems.DOG_TAIL, "Köpek Kuyruğu");
                tb.add(SamItems.FOX_EARS, "Tilki Kulakları");
                tb.add(SamItems.FOX_TAIL, "Tilki Kuyruğu");
                tb.add(SamItems.BUNNY_EARS, "Tavşan Kulakları");
                tb.add(SamItems.BUNNY_TAIL, "Tavşan Kuyruğu");
                tb.add(SamItems.LIZARD_EARS, "Kertenkele Kulakları");
                tb.add(SamItems.LIZARD_TAIL, "Kertenkele Kuyruğu");

            // Item Groups
            tb.add(SamItemGroups.MAIN_TK, "Summon a Minion");
            tb.add(SamItemGroups.GENERAL_TK, "Genel");
            tb.add(SamItemGroups.WANDS_TK, "Asalar");
            tb.add(SamItemGroups.WHIPS_TK, "Kırbaçlar");
            tb.add(SamItemGroups.MISC_TK, "Çeşitli");
            tb.add(SamItemGroups.COSMETICS_TK, "Kozmetikler");

            // Config
        }
    }
}
