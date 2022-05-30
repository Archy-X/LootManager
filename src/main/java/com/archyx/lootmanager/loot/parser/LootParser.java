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


    protected double parseXp(Map<?, ?> map) {
        if (map.containsKey("xp")) {
            return getDouble(map, "xp");
        } else {
            return -1.0;
        }
    }

    protected Map<String, Set<LootContext>> parseContexts(Map<?, ?> map) {
        Map<String, Set<LootContext>> contexts = new HashMap<>();
        for (String contextKey : manager.getContextKeySet()) {
            if (map.containsKey(contextKey)) {
                Set<LootContext> contextSet = new HashSet<>();
                ContextManager contextManager = manager.getContextManager(contextKey); // Get the manager
                if (contextManager == null) continue;

                List<String> contextList = getStringList(map, contextKey); // Get the list of contexts
                for (String contextName : contextList) { // Parse each context
                    Set<LootContext> lootContext = contextManager.parseContext(contextName);
                    if (lootContext != null) {
                        contextSet.addAll(lootContext);
                    }
                }
                contexts.put(contextKey, contextSet);
            }
        }
        return contexts;
    }

    protected Map<String, Object> parseOptions(Map<?, ?> map) {
        Map<String, Object> options = new HashMap<>();
        for (String optionKey : manager.getOptionKeys()) {
            if (map.containsKey(optionKey)) {
                Object option = getElement(map, optionKey);
                options.put(optionKey, option);
            }
        }
        return options;
    }

}
