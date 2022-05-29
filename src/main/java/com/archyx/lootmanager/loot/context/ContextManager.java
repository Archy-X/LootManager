package com.archyx.lootmanager.loot.context;

import org.jetbrains.annotations.Nullable;

public abstract class ContextManager {

    private final String contextKey;

    public ContextManager(String contextKey) {
        this.contextKey = contextKey;
    }

    public String getContextKey() {
        return contextKey;
    }

    @Nullable
    public abstract LootContext parseContext(String name);

}
