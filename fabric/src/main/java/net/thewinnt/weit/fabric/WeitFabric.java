package net.thewinnt.weit.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.thewinnt.weit.Weit;
import net.fabricmc.api.ModInitializer;

public final class WeitFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Weit.init(new FabricPlatform());
    }
}
