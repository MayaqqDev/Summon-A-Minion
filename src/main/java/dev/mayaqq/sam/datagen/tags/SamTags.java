package dev.mayaqq.sam.datagen.tags;

import dev.mayaqq.sam.SummonAMinion;
import dev.mayaqq.sam.registry.SamItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class SamTags {
    public static class ItemTags extends FabricTagProvider.ItemTagProvider {

        public static final TagKey<Item> COSMETIC_HEAD = TagKey.of(Registries.ITEM.getKey(), new Identifier("trinkets", "head/cosmetic"));
        public static final TagKey<Item> COSMETIC_CHEST = TagKey.of(Registries.ITEM.getKey(), new Identifier("trinkets", "chest/cosmetic"));
        public static final TagKey<Item> COSMETIC_LEGS = TagKey.of(Registries.ITEM.getKey(), new Identifier("trinkets", "legs/cosmetic"));
        public static final TagKey<Item> COSMETIC_FEET = TagKey.of(Registries.ITEM.getKey(), new Identifier("trinkets", "feet/cosmetic"));

        public static final TagKey<Item> WHIPS = TagKey.of(Registries.ITEM.getKey(), SummonAMinion.id("whips"));

        public ItemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(COSMETIC_HEAD)
                    .add(SamItems.BUNNY_EARS)
                    .add(SamItems.DOG_EARS)
                    .add(SamItems.FOX_EARS)
                    .add(SamItems.LIZARD_EARS);
            getOrCreateTagBuilder(COSMETIC_LEGS)
                    .add(SamItems.BUNNY_TAIL)
                    .add(SamItems.DOG_TAIL)
                    .add(SamItems.FOX_TAIL)
                    .add(SamItems.LIZARD_TAIL);
            getOrCreateTagBuilder(WHIPS)
                    .add(SamItems.LEATHER_WHIP);
        }
    }

    public static class BlockTags extends FabricTagProvider.BlockTagProvider {
        public BlockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {

        }
    }

    public static class FluidTags extends FabricTagProvider.FluidTagProvider {
        public FluidTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {

        }
    }

    private static Identifier mcId(String path) {
        return new Identifier("minecraft", path);
    }
}
