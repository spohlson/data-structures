package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

public class TreeProblems {

	public class Node {

		public int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node left, Node right) {
			this(data);
			this.left = left;
			this.right = right;
		}

	}

	/**
	 * Complete the preOrder function in your editor below, which has parameter:
	 * a pointer to the root of a binary tree. It must print the values in the
	 * tree's preorder traversal as a single line of space-separated values.
	 * 
	 * root --> left --> right
	 */
	public void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	@Test
	public void testPreorderT() {
		Node four = new Node(4, null, null);
		Node six = new Node(6, null, null);
		Node three = new Node(3, null, four);
		Node five = new Node(5, three, six);
		Node two = new Node(2, null, five);
		Node one = new Node(1, null, two);

		preorder(one);
		// Should print --> 1 2 5 3 4 6
	}

	/**
	 * Complete the postOrder function in your editor below, which has
	 * parameter: a pointer to the root of a binary tree. It must print the
	 * values in the tree's postorder traversal as a single line of
	 * space-separated values.
	 * 
	 * left --> right --> root
	 */
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	@Test
	public void testPrintPostorderTraversal() {
		Node four = new Node(4, null, null);
		Node six = new Node(6, null, null);
		Node three = new Node(3, null, four);
		Node five = new Node(5, three, six);
		Node two = new Node(2, null, five);
		Node one = new Node(1, null, two);

		postOrder(one);
		// Should print --> 4 3 6 5 2 1
	}

	/**
	 * Complete the inOrder function in your editor below, which has parameter:
	 * a pointer to the root of a binary tree. It must print the values in the
	 * tree's inorder traversal as a single line of space-separated values.
	 * 
	 * left --> root --> right
	 */
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	@Test
	public void testInOrder() {
		Node four = new Node(4, null, null);
		Node six = new Node(6, null, null);
		Node three = new Node(3, null, four);
		Node five = new Node(5, three, six);
		Node two = new Node(2, null, five);
		Node one = new Node(1, null, two);

		inOrder(one);
		// Should print --> 1 2 3 4 5 6
	}

	/**
	 * Get the height of a binary tree. If there's only a single node in the
	 * tree then height will return as 0.
	 */
	public int getHeightDFS(Node node) {
		if (null == node) {
			return -1;
		}
		int hLeftSub = getHeightDFS(node.left);
		int hRightSub = getHeightDFS(node.right);
		return Math.max(hLeftSub, hRightSub) + 1;
	}

	public int getHeightBFS(Node root) {
		int height = -1;

		if (root == null) {
			return height;
		}
		List<Node> levelAbove = Arrays.asList(root);

		while (!CollectionUtils.isEmpty(levelAbove)) {
			List<Node> level = new ArrayList<>();

			for (Node node : levelAbove) {
				Node left = node.left;

				if (left != null) {
					level.add(left);
				}
				Node right = node.right;

				if (right != null) {
					level.add(right);
				}
			}
			levelAbove = level;

			height++;
		}
		return height;
	}

	@Test
	public void testGetHeight() {
		Node root = new Node(1);
		int expected = 0;
		int output = getHeightBFS(root);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testGetHeight1() {
		Node seven = new Node(7);
		Node six = new Node(6, null, seven);
		Node four = new Node(4);
		Node one = new Node(1);
		Node two = new Node(2, one, null);
		Node five = new Node(5, four, six);
		Node three = new Node(3, two, five);

		int expected = 3;
		int output = getHeightBFS(three);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Top View
	 */
	public void topView(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		topView(root.right);
	}

	@Test
	public void testTopView() {
		Node four = new Node(4);
		Node six = new Node(6);
		Node three = new Node(3, null, four);
		Node five = new Node(5, three, six);
		Node two = new Node(2, null, five);
		Node one = new Node(1, null, two);

		topView(one);
		// should print 1 2 5 6
	}
}
