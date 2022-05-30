package com.archyx.lootmanager;

import com.archyx.lootmanager.loot.LootLoader;
import com.archyx.lootmanager.loot.context.ContextManager;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LootManager {

    private final Plugin plugin;
    private final LootLoader lootLoader;
    private final Map<String, ContextManager> contextManagers;
    private final Set<String> optionKeys;

    public LootManager(Plugin plugin) {
        this.plugin = plugin;
        this.lootLoader = new LootLoader(this);
        this.contextManagers = new HashMap<>();
        this.optionKeys = new HashSet<>();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public LootLoader getLootLoader() {
        return lootLoader;
    }

    public Set<String> getContextKeySet() {
        return contextManagers.keySet();
    }

    @Nullable
    public ContextManager getContextManager(String contextKey) {
        return contextManagers.get(contextKey);
    }

    public void registerContextManager(ContextManager contextManager) {
        this.contextManagers.put(contextManager.getContextKey(), contextManager);
    }

    public Set<String> getOptionKeys() {
        return optionKeys;
    }

    public void addOptionKey(String key) {
        optionKeys.add(key);
    }

    public void addOptionKeys(String... keys) {
        optionKeys.addAll(Arrays.asList(keys));
    }

}
