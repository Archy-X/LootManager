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
    private final Set<String> lootOptionKeys;
    private final Set<String> poolOptionKeys;

    public LootManager(Plugin plugin) {
        this.plugin = plugin;
        this.lootLoader = new LootLoader(this);
        this.contextManagers = new HashMap<>();
        this.lootOptionKeys = new HashSet<>();
        this.poolOptionKeys = new HashSet<>();
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

    public Set<String> getLootOptionKeys() {
        return lootOptionKeys;
    }

    public void addLootOptionKey(String key) {
        lootOptionKeys.add(key);
    }

    public void addLootOptionKeys(String... keys) {
        lootOptionKeys.addAll(Arrays.asList(keys));
    }

    public Set<String> getPoolOptionKeys() {
        return poolOptionKeys;
    }

    public void addPoolOptionKey(String key) {
        poolOptionKeys.add(key);
    }

    public void addPoolOptionKeys(String... keys) {
        poolOptionKeys.addAll(Arrays.asList(keys));
    }

}
