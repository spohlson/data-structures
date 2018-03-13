package com.practice.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrieContacts {
	
	/**
	 * Create a Contacts Application with the following 2 types of operations:
	 * 
	 * 1. Add name, where name is a string denoting a contact name. This must
	 * store name as a new contact in the application.
	 * 
	 * 2. Find partial, where partial is a string denoting a partial name to
	 * search the application for. It must count the # of contacts starting with
	 * partial and print the count on a new line.
	 * 
	 * Given n sequential add and find operations, perform each operation in
	 * order.
	 * 
	 * Note: name and partial contain lowercase English letters only & the input
	 * doesn't have any duplicate name for the add operation.
	 * 
	 * Input Format:
	 * 
	 * The first line contains a single integer, n, denoting the # of operations
	 * to perform. Each line i of the n subsequent lines contains an operation
	 * in one of the two forms defined above.
	 * 
	 * Output format:
	 * 
	 * For each "find partial" operation, print the # of contact names starting with partial on a new line.
	 * 
	 * Sample Input:
	 * 4
	 * add hack
	 * add hackerrank
	 * find hac
	 * find hak
	 * 
	 * Sample Output:
	 * 2
	 * 0
	 */

	public static class TrieNode {

		private Map<Character, TrieNode> children;
		private int size;

		public TrieNode() {
			children = new HashMap<>();
		}

		public Map<Character, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, TrieNode> children) {
			this.children = children;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void putChildIfAbsent(char ch) {
			children.putIfAbsent(ch, new TrieNode());
		}

		public TrieNode getChild(char ch) {
			return children.get(ch);
		}

		public void increaseSize() {
			size++;
		}

	}

	public static class Trie {

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public TrieNode getRoot() {
			return root;
		}

		public void setRoot(TrieNode root) {
			this.root = root;
		}

		public void add(String str) {
			TrieNode curr = root;

			for (int i = 0; i < str.length(); i++) {
				Character ch = str.charAt(i);

				curr.putChildIfAbsent(ch);

				curr = curr.getChild(ch);

				curr.increaseSize();
			}
		}

		public int find(String prefix) {
			TrieNode curr = root;

			for (int i = 0; i < prefix.length(); i++) {
				Character ch = prefix.charAt(i);

				curr = curr.getChild(ch);

				if (curr == null) {
					return 0;
				}
			}

			int size = curr.getSize();
			return size;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Trie trie = new Trie();

		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			String contact = scan.next();

			if (operation.equals("add")) {
				trie.add(contact);
			} else if (operation.equals("find")) {
				System.out.println(trie.find(contact));
			}
		}
		scan.close();
	}

}
