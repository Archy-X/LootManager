package com.archyx.lootmanager.loot.builder;

import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.context.LootContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class LootBuilder {

    protected int weight;
    protected String message;
    protected Map<String, Set<LootContext>> contexts;

    public LootBuilder() {
        this.weight = 10;
        this.message = "";
        this.contexts = new HashMap<>();
    }

    public LootBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }

    public LootBuilder message(String message) {
        this.message = message;
        return this;
    }

    public LootBuilder contexts(Map<String, Set<LootContext>> contexts) {
        this.contexts = contexts;
        return this;
    }

    public abstract Loot build();

}
