package net.thewinnt.weit.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;
import net.thewinnt.weit.PlatformAbstractions;

import java.util.HashMap;
import java.util.Map;

// copied over from JEI's ModHelper
public class NeoForgePlatform implements PlatformAbstractions {
    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String getModName(String modId) {
        return cache.computeIfAbsent(modId, this::cacheModName);
    }

    private String cacheModName(String id) {
        return ModList.get()
            .getModContainerById(id)
            .map(ModContainer::getModInfo)
            .map(IModInfo::getDisplayName)
            .orElse(id);
    }
}
