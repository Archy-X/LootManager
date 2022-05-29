package com.archyx.lootmanager.loot;


import com.archyx.lootmanager.loot.context.LootContext;

import java.util.Map;
import java.util.Set;

public abstract class Loot {

    protected final int weight;
    protected final String message;
    protected final Map<String, Set<LootContext>> contexts;

    public Loot(int weight, String message, Map<String, Set<LootContext>> contexts) {
        this.weight = weight;
        this.message = message;
        this.contexts = contexts;
    }

    public int getWeight() {
        return weight;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Set<LootContext>> getContexts() {
        return contexts;
    }

}
