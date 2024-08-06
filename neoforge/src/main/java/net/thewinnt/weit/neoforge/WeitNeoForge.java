package net.thewinnt.weit.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.thewinnt.weit.Weit;
import net.neoforged.fml.common.Mod;

@Mod(value = Weit.MOD_ID, dist = Dist.CLIENT)
public final class WeitNeoForge {
    public WeitNeoForge() {
        // Run our common setup.
        Weit.init(new NeoForgePlatform());
    }
}
