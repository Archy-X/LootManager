package com.archyx.lootmanager.loot.builder;

import com.archyx.lootmanager.loot.Loot;

public abstract class LootBuilder {
    protected int weight;
    protected String message;
    protected double xp;

    public LootBuilder() {
        this.weight = 10;
        this.message = "";
        this.xp = -1.0;
    }

    public LootBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }

    public LootBuilder message(String message) {
        this.message = message;
        return this;
    }

    public LootBuilder xp(double xp) {
        this.xp = xp;
        return this;
    }

    public abstract Loot build();

}
