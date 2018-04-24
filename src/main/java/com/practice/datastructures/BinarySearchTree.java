package com.practice.datastructures;

public class BinarySearchTree {

	private Node root;

	public class Node {

		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node left, Node right) {
			this(data);
			this.left = left;
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public void insert(int data) {

	}

	public Node find(int data) {
		return findPreOrder(data);
	}

	/**
	 * Tree Example for Traversals:
	 * 			1
	 * 		   /  \
	 * 		2		3
	 * 	   / \
	 * 	  4	  5
	 */

	/**
	 * left --> root --> right
	 * 
	 * From Example: 4 2 5 1 3
	 * 
	 * 1. Traverse left subtree, call inOrder(left subtree) 2. Visit root 3.
	 * Traverse right subtree, call inOrder(right subtree)
	 * 
	 * Use when you want to flatten the tree back to original sequence since it
	 * would be flattened the same way it was created.
	 */
	public Node findInOrder(int data) {
		return null;
	}

	/**
	 * root --> left --> right
	 * 
	 * From Example: 1 2 3 4 5
	 * 
	 * 1. Visit root 2. Traverse left subtree, call preOrder(left subtree) 3.
	 * Traverse right subtree, call preOrder(right subtree)
	 * 
	 * Traverses tree in ascending order (1 2 3 4 5)
	 * 
	 * Use when you need to explore the roots before inspecting any leaves.
	 */
	public Node findPreOrder(int data) {
		return null;
	}

	/**
	 * left --> right --> root
	 * 
	 * From Example: 4 5 2 3 1
	 * 
	 * 1. Traverse left subtree, call postOrder(left subtree) 2. Traverse right
	 * subtree, call postOrder(right subtree) 3. Visit root
	 * 
	 * Use when you need to explore the leaves before any nodes.
	 */
	public Node findPostOrder(int data) {
		return null;
	}

	public Node findBreadthFirst(int data) {
		return null;
	}

	public void delete(int data) {

	}

	/**
	 * Print the entire tree in increasing order
	 */
	public void display() {

	}

}
