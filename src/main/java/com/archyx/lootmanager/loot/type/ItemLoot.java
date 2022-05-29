package com.archyx.lootmanager.loot.type;

import com.archyx.lootmanager.loot.Loot;
import org.bukkit.inventory.ItemStack;

public class ItemLoot extends Loot {

    protected ItemStack item;
    protected int minAmount;
    protected int maxAmount;

    public ItemLoot(int weight, String message, double xp, ItemStack item, int minAmount, int maxAmount) {
        super(weight, message, xp);
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
