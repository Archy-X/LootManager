package com.archyx.lootmanager.loot.parser;

import com.archyx.lootmanager.loot.Loot;
import com.archyx.lootmanager.util.Parser;
import com.archyx.lootmanager.util.TextUtil;

import java.util.Map;

public abstract class LootParser extends Parser {

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

}
