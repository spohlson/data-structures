package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

import com.practice.datastructures.Node;

public class InvertBinaryTree {

	/**
	 * Input:
	 * 
	 *      4
	 *    /   \
	 *   2     7
	 *  / \   / \
	 * 1   3 6   9
	 * 
	 * Output:
	 * 
	 *      4
	 *    /   \
	 *   7     2
	 *  / \   / \
	 * 9   6 3   1
	 */
	public void invertBT(Node<Integer> node) {
		if (node == null) {
			return;
		}
		Node<Integer> left = node.getLeft();
		Node<Integer> right = node.getRight();

		node.setLeft(right);
		node.setRight(left);

		invertBT(right);
		invertBT(left);
	}

	private Node<Integer> createInput() {
		Node<Integer> one = new Node<>(1);
		Node<Integer> three = new Node<>(3);
		Node<Integer> six = new Node<>(6);
		Node<Integer> nine = new Node<>(9);

		Node<Integer> two = new Node<>(2, one, three);
		Node<Integer> seven = new Node<>(7, six, nine);

		Node<Integer> four = new Node<>(4, two, seven);
		return four;
	}

	@Test
	public void test() {
		Node<Integer> root = createInput();

		invertBT(root);
		Assert.assertTrue(root.getLeft().getLeft().getData() == 9);
		Assert.assertTrue(root.getRight().getLeft().getData() == 3);
		Assert.assertTrue(root.getLeft().getRight().getData() == 6);
	}

}
