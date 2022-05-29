package com.archyx.lootmanager.loot;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootTable {

	private final LootTableType type;
	private final List<LootPool> pools;
	
	public LootTable(LootTableType type, List<LootPool> pools) {
		this.type = type;
		this.pools = pools;
	}

	public LootTableType getType() {
		return type;
	}

	@Nullable
	public LootPool getPool(String name) {
		for (LootPool pool : pools) {
			if (pool.getName().equals(name)) {
				return pool;
			}
		}
		return null;
	}

	public List<LootPool> getPools() {
		return pools;
	}

}
