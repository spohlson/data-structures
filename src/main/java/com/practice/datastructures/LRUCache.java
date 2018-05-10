package com.practice.datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -942512273056185208L;
	private int cacheSize;

	public LRUCache(int cacheSize) {
		super(cacheSize, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() >= cacheSize;
	}
}
