package dev.mayaqq.sam.client;

import dev.mayaqq.sam.client.rendering.entities.RenderingRegistry;
import net.fabricmc.api.ClientModInitializer;

public class SummonAMinionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderingRegistry.register();
    }
}
