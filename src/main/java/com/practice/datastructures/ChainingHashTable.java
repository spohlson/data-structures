package com.practice.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * A HashTable is an array of linked lists with no dynamic resizing.
 */
public class ChainingHashTable {

	private static int SIZE = 1000;

	private LinkedList<String>[] hashtable = new LinkedList[SIZE];

	public void add(String value) {
		int hash = hash(value);

		if (hashtable[hash] == null) {
			hashtable[hash] = new LinkedList<>();
		}

		LinkedList<String> bucket = hashtable[hash];
		bucket.add(value);
	}

	public boolean contains(String value) {
		int hash = hash(value);
		LinkedList<String> bucket = hashtable[hash];

		if (bucket != null) {
			Iterator<String> it = bucket.iterator();

			while (it.hasNext()) {

				if (it.next().equals(value)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean remove(String value) {
		int hash = hash(value);
		LinkedList<String> bucket = hashtable[hash];

		if (bucket != null) {
			Iterator<String> it = bucket.iterator();

			while (it.hasNext()) {

				if (it.next().equals(value)) {
					it.remove();
					return true;
				}
			}
		}

		return false;
	}

	private int hash(String value) {
		HashFunction hf = Hashing.murmur3_128();
		return Math.abs(hf.newHasher().putString(value, Charsets.UTF_8).hash().asInt()) % SIZE;
	}

}
