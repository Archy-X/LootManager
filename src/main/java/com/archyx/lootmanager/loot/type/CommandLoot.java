package com.archyx.lootmanager.loot.type;

import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.context.LootContext;
import com.archyx.lootmanager.util.CommandExecutor;

import java.util.Map;
import java.util.Set;

public class CommandLoot extends Loot {

    private final CommandExecutor executor;
    private final String command;

    public CommandLoot(int weight, String message, Map<String, Set<LootContext>> contexts, CommandExecutor executor, String command) {
        super(weight, message, contexts);
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
