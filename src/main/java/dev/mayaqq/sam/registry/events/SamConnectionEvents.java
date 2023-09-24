package dev.mayaqq.sam.registry.events;

import dev.mayaqq.sam.extensions.PlayerEntityExtension;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class SamConnectionEvents {
    public static void register() {
        // Disconnect
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            PlayerEntity player = handler.getPlayer();
            ((PlayerEntityExtension) player).summonAMinion$getSummonedMinions().forEach(entity -> {
                entity.remove(Entity.RemovalReason.DISCARDED);
            });
            ((PlayerEntityExtension) player).summonAMinion$getSummonedMinions().clear();
        });
    }
}
