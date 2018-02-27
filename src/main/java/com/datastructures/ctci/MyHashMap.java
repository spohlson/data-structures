package com.datastructures.ctci;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap: Pros/Cons & When to Use
 * 
 * Pros:
 * - Designed for retreiving elements fast
 */
public class MyHashMap<K, E> extends AbstractMap<K, E> implements Map<K, E> {

	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<java.util.Map.Entry<K, E>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
