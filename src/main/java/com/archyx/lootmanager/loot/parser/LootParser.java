package com.archyx.lootmanager.loot.parser;

import com.archyx.lootmanager.LootManager;
import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.loot.context.ContextManager;
import com.archyx.lootmanager.loot.context.LootContext;
import com.archyx.lootmanager.util.Parser;
import com.archyx.lootmanager.util.TextUtil;

import java.util.*;

public abstract class LootParser extends Parser {

    protected LootManager manager;

    public LootParser(LootManager manager) {
        this.manager = manager;
    }

    public abstract Loot parse(Map<?, ?> map);

    protected int parseWeight(Map<?, ?> map) {
        if (map.containsKey("weight")) {
            return getInt(map, "weight");
        } else {
            return 10;
        }
    }

    protected String parseMessage(Map<?, ?> map) {
        if (map.containsKey("message")) {
            return TextUtil.replace(getString(map, "message"), "&", "§");
        } else {
            return "";
        }
    }

    protected Map<String, Set<LootContext>> parseContexts(Map<?, ?> map) {
        Map<String, Set<LootContext>> contexts = new HashMap<>();
        for (String contextKey : manager.getContextKeySet()) {
            if (map.containsKey(contextKey)) {
                ContextManager contextManager = manager.getContextManager(contextKey); // Get the manager
                if (contextManager == null) continue;

                Set<LootContext> lootContext = contextManager.parseContext(map);

                if (lootContext != null) {
                    contexts.put(contextKey, lootContext);
                }
            }
        }
        return contexts;
    }

    protected Map<String, Object> parseOptions(Map<?, ?> map) {
        Map<String, Object> options = new HashMap<>();
        for (String optionKey : manager.getLootOptionKeys()) {
            if (map.containsKey(optionKey)) {
                Object option = getElement(map, optionKey);
                options.put(optionKey, option);
            }
        }
        return options;
    }

}
