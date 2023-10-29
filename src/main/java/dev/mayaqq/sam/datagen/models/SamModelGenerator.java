package dev.mayaqq.sam.datagen.models;

import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class SamModelGenerator extends FabricModelProvider {
    public SamModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator img) {
        img.register(SamItems.SLIME_STAFF, Models.HANDHELD);
        img.register(SamItems.ZOOLOGIST_SPAWN_EGG, item("template_spawn_egg"));
        img.register(SamItems.LEATHER_WHIP, Models.HANDHELD);
        img.register(SamItems.DOG_EARS, Models.GENERATED);
        img.register(SamItems.DOG_TAIL, Models.GENERATED);
        img.register(SamItems.FOX_EARS, Models.GENERATED);
        img.register(SamItems.FOX_TAIL, Models.GENERATED);
        img.register(SamItems.LIZARD_EARS, Models.GENERATED);
        img.register(SamItems.LIZARD_TAIL, Models.GENERATED);
        img.register(SamItems.BUNNY_EARS, Models.GENERATED);
        img.register(SamItems.BUNNY_TAIL, Models.GENERATED);
    }

    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}
