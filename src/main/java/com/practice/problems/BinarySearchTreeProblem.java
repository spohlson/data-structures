package com.practice.problems;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeProblem {

	/**
	 * For the purposes of this challenge, we define a binary search tree to be
	 * a binary tree with the following ordering properties:
	 * 
	 * 1. The data value of every node in a node's left subtree is less than the
	 * data value of that node.
	 * 
	 * 2. The data value of every node in a node's right subtree is greater than
	 * the data value of that node.
	 * 
	 * Given the root node of a binary tree, can you determine if it's also a
	 * binary search tree?
	 * 
	 * Complete the function in your editor below, which has 1 parameter: a
	 * pointer to the root of a binary tree. It must return a boolean denoting
	 * whether or not the binary tree is a binary search tree. You may have to
	 * write one or more helper functions to complete this challenge.
	 * 
	 * Note: We do not consider a binary tree to be a binary search tree if it
	 * contains duplicate values.
	 * 
	 * Input Format:
	 * 
	 * You are not responsible for reading any input from stdin. Hidden code
	 * stubs will assemble a binary tree and pass its root node to your function
	 * as an argument.
	 * 
	 * Output Format:
	 * 
	 * You are not responsible for printing any output to stdout. Your function
	 * must return true if the tree is a binary search tree; otherwise, it must
	 * return false. Hidden code stubs will print this result as a Yes or No
	 * answer on a new line.
	 * 
	 * Sample Input:
	 * 
	 * 			4
	 * 		  /   \
	 * 		2		6
	 *   /  \		/ \
	 * 1	3		5	7
	 * 
	 * Sample Output: Yes
	 */

	/**
	 * /* Hidden stub code will pass a root argument to the function below.
	 * Complete the function to solve the challenge. Hint: you may want to write
	 * one or more helper functions.
	 */

	public class Node {

		private int val;
		private Node left;
		private Node right;

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node left, Node right) {
			this(val);
			this.left = left;
			this.right = right;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
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

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}

	}

	/**
	 * Class for iterative usage.
	 */
	public class BNode {

		private Node node;
		private int min;
		private int max;

		public BNode(Node node, int min, int max) {
			this.node = node;
			this.min = min;
			this.max = max;
		}

		public Node getNode() {
			return node;
		}

		public void setNode(Node node) {
			this.node = node;
		}

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

	}

	public boolean isValidBSTRecursive(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		int val = node.getVal();

		if ((val <= min) || (val >= max)) {
			return false;
		}

		return isValidBSTRecursive(node.getLeft(), min, val)
				&& isValidBSTRecursive(node.getRight(), val, max);
	}

	public boolean checkBSTRecursive(Node root) {
		return isValidBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkBSTIterative(Node root) {
		if (root == null) {
			return true;
		}
		BNode bRoot = new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

		LinkedList<BNode> queue = new LinkedList<>();
		queue.add(bRoot);

		while (!queue.isEmpty()) {
			BNode b = queue.poll();
			int min = b.getMin();
			int max = b.getMax();
			Node node = b.getNode();
			int val = node.getVal();

			if ((val <= min) || (val >= max)) {
				return false;
			}

			if (node.hasLeft()) {
				queue.offer(new BNode(node.getLeft(), min, val));
			}

			if (node.hasRight()) {
				queue.offer(new BNode(node.getRight(), val, max));
			}
		}

		return true;
	}

	//////////// Test Helper Methods ////////////

	public Node createValidBST() {
		Node one = new Node(1);
		Node three = new Node(3);
		Node two = new Node(2, one, three);

		Node five = new Node(5);
		Node seven = new Node(7);
		Node six = new Node(6, five, seven);

		Node root = new Node(4, two, six);
		return root;
	}

	public Node createInvalidBST() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3, one, two);

		Node five = new Node(5);
		Node seven = new Node(7);
		Node six = new Node(6, five, seven);

		Node root = new Node(4, three, six);
		return root;
	}

	public Node createInvalidBSTWithDuplicates() {
		Node one = new Node(1);
		Node three = new Node(3);
		Node two = new Node(2, one, three);

		Node five = new Node(5);
		Node eight = new Node(8);

		Node six = new Node(6, five, eight);
		Node seven = new Node(7, five, eight);

		Node ten = new Node(10, six, seven);

		Node root = new Node(4, two, ten);
		return root;
	}

	//////////// Tests ////////////

	@Test
	public void testValidRecursive() {
		Node root = createValidBST();
		Assert.assertTrue(checkBSTRecursive(root));
	}

	@Test
	public void testValidIterative() {
		Node root = createValidBST();
		Assert.assertTrue(checkBSTIterative(root));
	}

	@Test
	public void testInvalidRecursive() {
		Node root = createInvalidBST();
		Assert.assertFalse(checkBSTRecursive(root));
	}

	@Test
	public void testInvalidIterative() {
		Node root = createInvalidBST();
		Assert.assertFalse(checkBSTIterative(root));
	}

	@Test
	public void testInvalidRecursiveWithDuplicates() {
		Node root = createInvalidBSTWithDuplicates();
		Assert.assertFalse(checkBSTRecursive(root));
	}

	@Test
	public void testInvalidIterativeWithDuplicates() {
		Node root = createInvalidBSTWithDuplicates();
		Assert.assertFalse(checkBSTIterative(root));
	}

}
