package com.archyx.lootmanager.loot.builder;


import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.type.CommandLoot;
import com.archyx.lootmanager.util.CommandExecutor;

public class CommandLootBuilder extends LootBuilder {

    private CommandExecutor executor;
    private String command;

    public CommandLootBuilder() {
        this.executor = CommandExecutor.CONSOLE;
    }

    @Override
    public Loot build() {
        return new CommandLoot(weight, message, contexts, options, executor, command);
    }

    public CommandLootBuilder executor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    public CommandLootBuilder command(String command) {
        this.command = command;
        return this;
    }

}
