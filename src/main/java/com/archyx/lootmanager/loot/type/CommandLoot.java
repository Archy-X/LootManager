package com.archyx.lootmanager.loot.type;

import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.util.CommandExecutor;

public class CommandLoot extends Loot {

    private final CommandExecutor executor;
    private final String command;

    public CommandLoot(int weight, String message, double xp, CommandExecutor executor, String command) {
        super(weight, message, xp);
        this.executor = executor;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

}
