package com.archyx.lootmanager;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LootManager extends JavaPlugin {

    private final Plugin plugin;

    public LootManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

}
