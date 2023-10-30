package dev.mayaqq.sam.datagen;

import dev.mayaqq.sam.SummonAMinion;
import dev.mayaqq.sam.datagen.models.SamModelGenerator;
import dev.mayaqq.sam.datagen.tags.SamTags;
import dev.mayaqq.sam.datagen.translations.SamTranslations;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SamDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fdg) {
        FabricDataGenerator.Pack pack = fdg.createPack();
        pack.addProvider(SamTranslations.EN_US::new);
        pack.addProvider(SamTranslations.TR_TR::new);
        pack.addProvider(SamModelGenerator::new);
        pack.addProvider(SamTags.ItemTags::new);
        pack.addProvider(SamTags.BlockTags::new);
        pack.addProvider(SamTags.FluidTags::new);
        SummonAMinion.LOGGER.info("Finished Sam Datagen");
    }
}
