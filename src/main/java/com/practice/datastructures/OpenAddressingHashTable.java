package com.practice.datastructures;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class OpenAddressingHashTable {

	private static int SIZE = 1000;

	private String[] hashtable = new String[SIZE];

	public void add(String value) {
		int probe = 0;

		while (probe < SIZE) {
			int hash = hash(value, probe);
			if (hashtable[hash] == null) {
				hashtable[hash] = value;
				return;
			}
			probe++;
		}

		throw new RuntimeException("Hash table overflow");
	}

	public boolean contains(String value) {
		int probe = 0;

		while (probe < SIZE) {
			int hash = hash(value, probe);
			if (hashtable[hash] == null) {
				return false;
			} else {
				if (hashtable[hash].equals(value)) {
					return true;
				}
				probe++;
			}
		}

		return false;
	}

	private int hash(String value, int probe) {
		HashFunction hf = Hashing.murmur3_128();
		int hash = Math.abs(hf.newHasher().putString(value, Charsets.UTF_8).hash().asInt()) % SIZE;
		return (hash + probe) % SIZE;
	}

}
