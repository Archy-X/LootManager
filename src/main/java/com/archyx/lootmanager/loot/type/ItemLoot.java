package com.archyx.lootmanager.loot.type;

import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.context.LootContext;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Set;

public class ItemLoot extends Loot {

    protected ItemStack item;
    protected int minAmount;
    protected int maxAmount;

    public ItemLoot(int weight, String message, Map<String, Set<LootContext>> contexts, ItemStack item, int minAmount, int maxAmount) {
        super(weight, message, contexts);
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

}
