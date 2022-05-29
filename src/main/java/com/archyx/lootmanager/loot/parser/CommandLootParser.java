package com.archyx.lootmanager.loot.parser;

import com.archyx.lootmanager.LootManager;
import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.builder.CommandLootBuilder;
import com.archyx.lootmanager.util.CommandExecutor;

import java.util.Locale;
import java.util.Map;

public class CommandLootParser extends LootParser {

    public CommandLootParser(LootManager manager) {
        super(manager);
    }

    @Override
    public Loot parse(Map<?, ?> map) {
        CommandLootBuilder builder = new CommandLootBuilder();

        if (map.containsKey("executor")) {
            builder.executor(CommandExecutor.valueOf(getString(map, "executor").toUpperCase(Locale.ROOT)));
        }

        return builder.command(getString(map, "command"))
                .message(parseMessage(map))
                .weight(parseWeight(map))
                .contexts(parseContexts(map))
                .options(parseOptions(map))
                .build();
    }
}
