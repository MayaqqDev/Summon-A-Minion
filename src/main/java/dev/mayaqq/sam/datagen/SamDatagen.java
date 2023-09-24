package dev.mayaqq.sam.datagen;

import dev.mayaqq.sam.datagen.models.SamModelGenerator;
import dev.mayaqq.sam.datagen.translations.SamTranslations;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SamDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fdg) {
        FabricDataGenerator.Pack pack = fdg.createPack();
        pack.addProvider(SamTranslations.EN_US::new);
        pack.addProvider(SamModelGenerator::new);
    }
}