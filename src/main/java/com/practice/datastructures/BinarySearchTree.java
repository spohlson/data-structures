package com.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * Binary Search Tree
	 * 
	 * A BST is a binary tree in which every node fits a specific ordering
	 * property: all left descendants <= n < all right descendants. This must be
	 * true for each node n.
	 * 
	 * Note: Under some definitions, the tree cannot have duplicate values. In
	 * others, the duplicate values will be on the right or can be on either
	 * side. Clarify this with your interviewer.
	 * 
	 * Ex. Binary Search Tree
	 * 
	 * 		8
	 * 	   / \
	 * 	  4  10
	 *   / \   \
	 * 2    6   20
	 * 
	 * Ex. Not a BST (note the 12)
	 * 
	 * 			8
	 * 		   / \
	 * 		  4   10
	 * 		 / \    \
	 * 		2   12   20
	 */

	private Node<T> root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(Node<T> root) {
		this.root = root;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void insert(T data) {
		insert(data, root);
	}

	private void insert(T data, Node<T> node) {
		if (node != null) {
			int comp = data.compareTo(node.getData());

			// no duplicates
			if (comp == 0) {
				return;
			}

			if (comp == -1) {
				Node<T> left = node.getLeft();

				if (left == null) {
					node.setLeft(new Node<>(data));
				} else {
					insert(data, left);
				}
			} else {
				Node<T> right = node.getRight();

				if (right == null) {
					node.setRight(new Node<>(data));
				} else {
					insert(data, right);
				}
			}
		}
	}

	public Node<T> find(T data) {
		return find(data, root);
	}

	private Node<T> find(T data, Node<T> node) {
		if (node == null) {
			return null;
		}
		int comp = data.compareTo(node.getData());

		if (comp == 0) {
			return node;
		} else if (comp == -1) {
			return find(data, node.getLeft());
		}
		return find(data, node.getRight());
	}

	/////////////// DEPTH FIRST TRAVERSALS (in, pre, post order) ///////////////

	/**
	 * left --> root --> right
	 * 
	 * 1. Traverse left subtree, call inOrder(left subtree)
	 * 2. Visit root
	 * 3. Traverse right subtree, call inOrder(right subtree)
	 * 
	 * Use when you want to flatten the tree back to original sequence since it
	 * would be flattened the same way it was created.
	 * 
	 *  		A
	 * 		  /   \
	 * 		B		C
	 * 	  /  \     /  \
	 *  D     E   F    G
	 * 
	 *  D --> B --> E --> A --> F --> C --> G
	 */
	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node<T> node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println(node.getData());
			printInOrder(node.getRight());
		}
	}

	public List<T> getInOrderList() {
		List<T> list = new ArrayList<>();
		traverseInOrder(list, root);
		return list;
	}

	private void traverseInOrder(List<T> list, Node<T> node) {
		if (node != null) {
			traverseInOrder(list, node.getLeft());
			list.add(node.getData());
			traverseInOrder(list, node.getRight());
		}
	}

	/**
	 * PRE ORDER Traversal:
	 * Good for making a copy of the tree
	 * 
	 * root --> left --> right
	 * 
	 * 1. Visit root
	 * 2. Traverse left subtree, call preOrder(left subtree)
	 * 3. Traverse right subtree, call preOrder(right subtree)
	 * 
	 * Use when you need to explore the roots before inspecting any leaves.
	 * 
	 *   		A
	 * 		  /   \
	 * 		B		C
	 * 	  /  \     /  \
	 *  D     E   F    G
	 * 
	 *  A --> B --> D --> E --> C --> F --> G
	 */
	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node<T> node) {
		if (node != null) {
			System.out.println(node.getData());
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	public List<T> getPreOrderList() {
		List<T> list = new ArrayList<>();
		traversePreOrder(list, root);
		return list;
	}

	private void traversePreOrder(List<T> list, Node<T> node) {
		if (node != null) {
			list.add(node.getData());
			traversePreOrder(list, node.getLeft());
			traversePreOrder(list, node.getRight());
		}
	}

	public BinarySearchTree<T> copy() {
		return new BinarySearchTree<T>(copy(root));
	}

	private Node<T> copy(Node<T> node) {
		if (node == null) {
			return null;
		}
		T data = node.getData();
		Node<T> copy = new Node<>(data, copy(node.getLeft()), copy(node.getRight()));
		return copy;
	}

	/**
	 * POST ORDER Traversal
	 * Good for deleting a BST
	 * 
	 * left --> right --> root
	 * 
	 * 1. Traverse left subtree, call postOrder(left subtree)
	 * 2. Traverse right subtree, call postOrder(right subtree)
	 * 3. Visit root
	 * 
	 * Use when you need to explore the leaves before any nodes.
	 * 
	 *    		A
	 * 		  /   \
	 * 		B		C
	 * 	  /  \     /  \
	 *  D     E   F    G
	 * 
	 *  D --> E --> B --> F --> G --> C --> A
	 * 
	 *     		A
	 * 		  /   \
	 * 		B		C
	 * 	     \     /  \
	 *        D   E    F
	 *        	 /    /  \
	 *          G	 H    I
	 * 
	 * D --> B --> G --> E --> H --> I --> F --> C --> A
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node<T> node) {
		if (node != null) {
			printPostOrder(node.getLeft());
			printPostOrder(node.getRight());
			System.out.println(node.getData());
		}
	}

	public List<T> getPostOrderList() {
		List<T> list = new ArrayList<>();
		traversePostOrder(list, root);
		return list;
	}

	private void traversePostOrder(List<T> list, Node<T> node) {
		if (node != null) {
			traversePostOrder(list, node.getLeft());
			traversePostOrder(list, node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * PostOrder is the most efficient way to delete a tree b/c it removes the
	 * leaves first
	 * 
	 * left --> right --> root
	 */
	public void deleteTree() {
		deleteTree(root, root);
		setRoot(null);
	}

	private void deleteTree(Node<T> parent, Node<T> node) {
		if (node == null) {
			return;
		}
		deleteTree(node, node.getLeft());
		deleteTree(node, node.getRight());

		System.out.println(node.getData());

		if (node.equals(parent.getLeft())) {
			parent.setLeft(null);
		} else {
			parent.setRight(null);
		}
	}

	/////////////// BREADTH FIRST (LEVEL ORDER) TRAVERSAL ///////////////

	/**
	 * Traversing one level at a time.
	 * 
	 * Good for showing who is in charge of a company or priority levels.
	 * 
	 * 						Captain Picard
	 * 					|					|
	 * 			Commander Riker			   Commander Data
	 * 			|			|					|
	 *   Lt Cmdr Worf		Lt Cmdr Xi		Lt. Cmdr Crusher
	 *   		|								|
	 *   Lieutenant X						Lieutenant Y
	 * 
	 * Level:
	 * 
	 * 0			J
	 *  		  /   \
	 * 1		F		K
	 *  	  /  \		 \
	 * 2     A    H       Z
	 *        \
	 * 3       D
	 * 
	 * J --> K --> A --> H --> Z --> D
	 */
	public void breadthFirstWithList() {
		List<Node<T>> list = new ArrayList<>();
		list.add(root);

		for (int i = 0; i < list.size(); i++) {
			Node<T> node = list.get(i);
			Node<T> left = node.getLeft();

			if (left != null) {
				list.add(left);
			}
			Node<T> right = node.getRight();

			if (right != null) {
				list.add(right);
			}
		}

		for (Node<T> node : list) {
			print(node.getData());
		}
	}

	public void breadthFirstWithQueue() {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			print(node.getData());

			Node<T> left = node.getLeft();

			if (left != null) {
				queue.add(left);
			}
			Node<T> right = node.getRight();

			if (right != null) {
				queue.add(right);
			}
		}
	}

	public void printGivenLevel(int k) {
		if (k == 0) {
			print(root.getData());
			return;
		}

		List<Node<T>> above = Arrays.asList(root);

		int level = 1;

		while (level <= k) {
			List<Node<T>> levelList = new ArrayList<>();

			for (Node<T> node : above) {
				Node<T> left = node.getLeft();

				if (left != null) {
					levelList.add(left);
				}
				Node<T> right = node.getRight();

				if (right != null) {
					levelList.add(right);
				}
			}
			above = levelList;

			level++;
		}

		for (Node<T> node : above) {
			print(node.getData());
		}
	}

	private void print(T data) {
		System.out.println(data);
	}

}
