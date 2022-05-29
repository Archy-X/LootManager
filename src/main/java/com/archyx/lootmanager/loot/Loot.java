package com.archyx.lootmanager.loot;


import com.archyx.lootmanager.loot.context.LootContext;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public abstract class Loot {

    protected final int weight;
    protected final String message;
    protected final Map<String, Set<LootContext>> contexts;
    protected final Map<String, Object> options;

    public Loot(int weight, String message, Map<String, Set<LootContext>> contexts, Map<String, Object> options) {
        this.weight = weight;
        this.message = message;
        this.contexts = contexts;
        this.options = options;
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

    public Map<String, Object> getOptions() {
        return options;
    }

    @Nullable
    public <T> T getOption(String key, Class<T> type) {
        Object o = options.get(key);
        if (o == null) return null;
        return type.cast(o);
    }

    @Nullable
    public <T> T getOption(String key, Class<T> type, T def) {
        Object o = options.get(key);
        if (o == null) return def;
        return type.cast(o);
    }

}
