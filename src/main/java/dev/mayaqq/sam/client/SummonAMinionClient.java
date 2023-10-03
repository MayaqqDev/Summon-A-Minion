package dev.mayaqq.sam.client;

import dev.mayaqq.sam.client.rendering.RenderingRegistry;
import net.fabricmc.api.ClientModInitializer;

public class SummonAMinionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderingRegistry.register();
    }
}
