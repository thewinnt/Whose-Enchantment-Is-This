package net.thewinnt.weit.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.thewinnt.weit.PlatformAbstractions;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

// copied over from JEI's ModHelper
public class FabricPlatform implements PlatformAbstractions {
    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String getModName(String modId) {
        return cache.computeIfAbsent(modId, this::cacheModName);
    }

    private String cacheModName(String id) {
        return FabricLoader.getInstance()
            .getModContainer(id)
            .map(ModContainer::getMetadata)
            .map(ModMetadata::getName)
            .orElse(id);
    }
}
