package com.archyx.lootmanager;

import com.archyx.lootmanager.loot.LootLoader;
import com.archyx.lootmanager.loot.context.ContextManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class LootManager extends JavaPlugin {

    private final Plugin plugin;
    private final LootLoader lootLoader;
    private final Map<String, ContextManager> contextManagers;

    public LootManager(Plugin plugin) {
        this.plugin = plugin;
        this.lootLoader = new LootLoader(this);
        this.contextManagers = new HashMap<>();
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

}
