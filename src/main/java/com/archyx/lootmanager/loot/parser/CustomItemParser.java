package com.archyx.lootmanager.loot.parser;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface CustomItemParser {

    boolean shouldUseParser(Map<?, ?> map);

    ItemStack parseCustomItem(Map<?, ?> map);

}
