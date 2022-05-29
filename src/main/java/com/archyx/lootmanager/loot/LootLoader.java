package com.archyx.lootmanager.loot;

import com.archyx.lootmanager.LootManager;
import com.archyx.lootmanager.loot.parser.CommandLootParser;
import com.archyx.lootmanager.loot.parser.ItemLootParser;
import com.archyx.lootmanager.util.DataUtil;
import com.archyx.lootmanager.util.Parser;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LootLoader extends Parser {

    private final LootManager manager;

    public LootLoader(LootManager manager) {
        this.manager = manager;
    }

    public LootTable loadLootTable(File file, FileConfiguration config) {
        // Parse loot table type, default to block
        String typeString = config.getString("type");
        LootTableType type = LootTableType.BLOCK;
        if (typeString != null) {
            type = LootTableType.valueOf(typeString.toUpperCase(Locale.ROOT));
        }
        // Load pools
        ConfigurationSection poolsSection = config.getConfigurationSection("pools");
        if (poolsSection == null) return null;
        List<LootPool> pools = new ArrayList<>();
        for (String poolName : poolsSection.getKeys(false)) {
            ConfigurationSection currentPool = poolsSection.getConfigurationSection(poolName);
            if (currentPool == null) continue;

            double baseChance = currentPool.getDouble("base_chance", 1.0) / 100; // Converts from percent chance to decimal
            double chancePerLuck = currentPool.getDouble("chance_per_luck", 0.0) / 100;
            int selectionPriority = currentPool.getInt("selection_priority", 1);
            boolean overrideVanillaLoot = currentPool.getBoolean("override_vanilla_loot", false);

            // Parse each loot entry
            List<Map<?,?>> lootMapList = currentPool.getMapList("loot");
            List<Loot> lootList = new ArrayList<>();
            int index = 0;
            for (Map<?, ?> lootEntryMap : lootMapList) {
                Loot loot = null;
                try {
                    String lootType = DataUtil.getString(lootEntryMap, "type");
                    // Item loot
                    if (lootType.equalsIgnoreCase("item")) {
                        if (getBooleanOrDefault(lootEntryMap, "ignore_legacy", false) && XMaterial.getVersion() <= 12) {
                            index++;
                            continue;
                        }
                        loot = new ItemLootParser().parse(lootEntryMap);
                    }
                    // Command loot
                    else if (lootType.equalsIgnoreCase("command")) {
                        loot = new CommandLootParser().parse(lootEntryMap);
                    } else {
                        throw new IllegalArgumentException("Unknown loot type: " + lootType);
                    }
                } catch (Exception e) {
                    manager.getPlugin().getLogger().warning("Error parsing loot in file loot/" + file.getName() + " at path pools." + poolName + ".loot." + index + ", see below for error:");
                    e.printStackTrace();
                }
                if (loot != null) {
                    lootList.add(loot);
                }
                index++;
            }
            // Create pool
            LootPool pool = new LootPool(poolName, lootList, baseChance, chancePerLuck, selectionPriority, overrideVanillaLoot);
            pools.add(pool);
        }
        // Sort pools by selection priority
        pools.sort((pool1, pool2) -> pool2.getSelectionPriority() - pool1.getSelectionPriority());
        // Create table
        return new LootTable(type, pools);
    }

}
