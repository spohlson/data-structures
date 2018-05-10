package com.practice.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheProblem {

	/**
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1.
	 * 
	 * set(key, value) - Set or insert the value if the key is not already
	 * present. When the cache reached its capacity, it should invalidate the
	 * least recently used item before inserting a new item.
	 */

	public class Node {

		private int key;
		private int value;
		private Node pre;
		private Node next;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getPre() {
			return pre;
		}

		public void setPre(Node pre) {
			this.pre = pre;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public class LRUCache {

		private int capacity;
		private Map<Integer, Node> cache;
		private Node head;
		private Node tail;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			cache = new HashMap<>(capacity);
		}

	}

}
