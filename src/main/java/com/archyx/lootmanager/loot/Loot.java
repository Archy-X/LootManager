package com.archyx.lootmanager.loot;

public abstract class Loot {

    protected final int weight;
    protected final String message;
    protected final double xp;

    public Loot(int weight, String message, double xp) {
        this.weight = weight;
        this.message = message;
        this.xp = xp;
    }

    public int getWeight() {
        return weight;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Gets the amount of Skill XP to reward
     * @return The amount of XP, -1 if not specified
     */
    public double getXp() {
        return xp;
    }

}
