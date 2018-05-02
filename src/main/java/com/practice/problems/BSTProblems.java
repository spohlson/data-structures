package com.practice.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.practice.datastructures.BTUtility;
import com.practice.datastructures.BinarySearchTree;
import com.practice.datastructures.Node;

public class BSTProblems {

	private BTUtility util;

	@Before
	public void init() {
		util = new BTUtility();
	}

	/**
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 */
	public boolean areEqual(Node<Integer> node1, Node<Integer> node2) {
		if ((node1 == null) && (node2 == null)) {
			return true;
		} else if ((node1 == null) || (node2 == null) || !node1.equals(node2)) {
			return false;
		}

		return areEqual(node1.getLeft(), node2.getLeft())
				&& areEqual(node1.getRight(), node2.getRight());
	}

	@Test
	public void areEqualTest() {
		Node<Integer> node1 = util.createHeightBalancedBST();
		Node<Integer> node2 = util.createHeightBalancedBST();
		boolean expected = true;
		boolean output = areEqual(node1, node2);
		Assert.assertTrue(expected == output);

		node1 = util.createIntegerBT();
		node2 = util.createIntegerBT1();
		expected = false;
		output = areEqual(node1, node2);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 */
	public Node<Integer> balanceArray(int[] arr) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		balanceHelper(bst, null, 0, arr.length, arr);
		return bst.getRoot();
	}

	private void balanceHelper(BinarySearchTree<Integer> bst, Node<Integer> root, int start,
			int end, int[] arr) {
		int len = end - start;

		if (len <= 0) {
			return;
		}
		int mid = start + (len / 2);
		int data = arr[mid];
		Node<Integer> node = new Node<>(data);

		if (root == null) {
			bst.setRoot(node);
		} else if (data < root.getData()) {
			root.setLeft(node);
		} else {
			root.setRight(node);
		}
		balanceHelper(bst, node, start, mid, arr);
		balanceHelper(bst, node, mid + 1, end, arr);
	}

	@Test
	public void balanceArrayTest() {
		int[] arr = new int[] { 9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
		Node<Integer> expected = util.createHeightBalancedBST();
		Node<Integer> output = balanceArray(arr);
		Assert.assertTrue(util.areEqual(expected, output));
	}

	/**
	 * Validate a BST
	 * 
	 * 1. left subtree of a node contains only nodes with keys less than the node's key
	 * 2. right subtree of a node contains only nodes with keys greater than the node's key
	 * 3. both left and right subtrees must also be bsts
	 */
	public boolean isValidBST(Node<Integer> node) {
		if (node == null) {
			return false;
		}
		int data = node.getData();
		boolean isValid = true;

		Node<Integer> left = node.getLeft();

		if (left != null) {

			if (data <= left.getData()) {
				return false;
			}
			isValid = isValidBST(left);
		}

		Node<Integer> right = node.getRight();

		if (right != null) {

			if (data >= right.getData()) {
				return false;
			}
			isValid = isValidBST(right);
		}
		return isValid;
	}

	@Test
	public void isValidBSTTest() {
		Node<Integer> invalidRoot = util.createIntegerBT1();
		boolean output = isValidBST(invalidRoot);
		Assert.assertFalse(output);

		Node<Integer> validRoot = util.createValidIntegerBST().getRoot();
		output = isValidBST(validRoot);
		Assert.assertTrue(output);
	}

	/**
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it. (1 ≤ k ≤ BST's total elements)
	 */
	public int kthSmallest(BinarySearchTree<Integer> bst, int k) {
		List<Integer> list = new ArrayList<>();
		traverseInOrder(list, bst.getRoot());

		if (k >= list.size()) {
			throw new IllegalArgumentException("Not enough nodes in BST for kth smallest");
		}
		return list.get(k - 1);
	}

	private void traverseInOrder(List<Integer> list, Node<Integer> node) {
		if (node != null) {
			traverseInOrder(list, node.getLeft());
			list.add(node.getData());
			traverseInOrder(list, node.getRight());
		}
	}

	@Test
	public void kthSmallestTest() {
		BinarySearchTree<Integer> bst = util.createValidIntegerBST();
		int k = 5;
		int expected = 5;
		int output = kthSmallest(bst, k);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Longest Consecutive Path
	 * 
	 * Given a Binary Tree find the length of the longest path which comprises
	 * of nodes with consecutive values in increasing order. Every node is
	 * considered as a path of length 1.
	 * 
	 * 		6
	 * 	     \
	 * 		  9
	 * 		 / \
	 * 		7   10
	 * 			  \
	 * 			   11
	 * 
	 * LCP: 9, 10, 11	Length: 3
	 * 
	 * 				1
	 * 			   / \
	 * 			  2   4
	 * 			 /   / \
	 * 			3   5   6
	 * 				   /
	 * 				  7
	 * 
	 * LCP: 1, 2, 3		Length: 3
	 */
	/**
	 * Recursively
	 */
	public class LCP {

		private int max;

		public LCP() {
			max = 0;
		}

		public int longestConsecutive(Node<Integer> node) {
			helper(node);
			return max;
		}

		private int helper(Node<Integer> node) {
			if (node == null) {
				return 0;
			}
			Node<Integer> left = node.getLeft();
			Node<Integer> right = node.getRight();

			int leftMax = helper(left);
			int rightMax = helper(right);

			int fromLeft = 1;
			int fromRight = 1;

			int data = node.getData();

			if ((left != null) && ((left.getData() - 1) == data)) {
				fromLeft = leftMax + 1;
			}

			if ((right != null) && ((right.getData() - 1) == data)) {
				fromRight = rightMax + 1;
			}

			max = Math.max(Math.max(max, fromLeft), fromRight);

			int leftRightMax = Math.max(fromLeft, fromRight);
			return leftRightMax;
		}
	}

	/**
	 * LCP Iteratively
	 */
	public int lcp(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		int max = 0;

		List<Node<Integer>> list = new ArrayList<>();
		list.add(root);

		for (int i = 0; i < list.size(); i++) {
			count++;

			if (count > max) {
				max = count;
			}
			Node<Integer> node = list.get(i);
			int data = node.getData();

			boolean resetCount = true;

			Node<Integer> left = node.getLeft();

			if (left != null) {
				int leftData = left.getData();

				if ((data + 1) == leftData) {
					list.add(i + 1, left);

					resetCount = false;
				} else {
					list.add(left);
				}
			}
			Node<Integer> right = node.getRight();

			if (right != null) {
				int rightData = right.getData();

				if ((data + 1) == rightData) {
					list.add(i + 1, right);

					resetCount = false;
				} else {
					list.add(right);
				}
			}

			if (resetCount) {
				count = 0;
			}
		}
		return max;
	}

	/**
	 * LCP with Queue
	 */
	public int lcpQueue(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.offer(root);

		Queue<Integer> sizeQueue = new LinkedList<>();
		sizeQueue.offer(1);

		int max = 1;

		while (!queue.isEmpty()) {
			Node<Integer> node = queue.poll();
			int data = node.getData();

			int size = sizeQueue.poll();

			Node<Integer> left = node.getLeft();

			if (left != null) {
				int leftCount = size;

				int leftData = left.getData();

				if (data == (leftData - 1)) {
					leftCount++;
					max = Math.max(max, leftCount);
				} else {
					leftCount = 1;
				}

				queue.offer(left);
				sizeQueue.offer(leftCount);
			}

			Node<Integer> right = node.getRight();

			if (right != null) {
				int rightCount = size;

				int rightData = right.getData();

				if (data == (rightData - 1)) {
					rightCount++;
					max = Math.max(max, rightCount);
				} else {
					rightCount = 1;
				}

				queue.offer(right);
				sizeQueue.offer(rightCount);
			}
		}
		return max;
	}

	@Test
	public void lcpRecursivelyTest() {
		Node<Integer> root = util.createIntegerBT();
		int expected = 3;
		LCP lcp = new LCP();
		int output = lcp.longestConsecutive(root);
		System.out.println("Output: " + output + ", Expected: " + expected);
		Assert.assertTrue(expected == output);

		root = util.createIntegerBT1();
		lcp = new LCP();
		output = lcp.longestConsecutive(root);
		System.out.println("Output: " + output + ", Expected: " + expected);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void lcpTest() {
		Node<Integer> root = util.createIntegerBT();
		int expected = 3;
		int output = lcp(root);
		System.out.println("Output: " + output + ", Expected: " + expected);
		Assert.assertTrue(expected == output);

		root = util.createIntegerBT1();
		output = lcp(root);
		System.out.println("Output: " + output + ", Expected: " + expected);
		Assert.assertTrue(expected == output);
	}

}
