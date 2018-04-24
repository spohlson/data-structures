package com.practice.concepts;

import org.junit.Test;

import com.practice.datastructures.Node;
import com.practice.utilities.BSTPrinter;

public class BSTRecursion {

	private static BSTPrinter printer = new BSTPrinter();

	/**
	 * 1. One step simpler: add new value into the left or right sub-tree
	 * 
	 * Function determine if data should go into left or right sub-tree
	 * 
	 * 3.
	 */
	public void insertRecursively(Node<Integer> node, int data) {
		int nodeData = node.getData();

		if (data == nodeData) {
			return;
		}
		boolean goLeft = data < nodeData;

		Node<Integer> leaf = goLeft ? node.getLeft() : node.getRight();

		if (leaf == null) {
			Node<Integer> newNode = new Node(data);

			if (goLeft) {
				node.setLeft(newNode);
			} else {
				node.setRight(newNode);
			}
			return;
		}

		insertRecursively(leaf, data);
	}

	public Node<Integer> createBST() {
		Node<Integer> one = new Node(1);

		Node<Integer> four = new Node(4);
		Node<Integer> seven = new Node(7);
		Node<Integer> six = new Node(6, four, seven);

		Node<Integer> three = new Node(3, one, six);

		Node<Integer> thirteen = new Node(13);
		Node<Integer> fourteen = new Node(14, thirteen, null);
		Node<Integer> ten = new Node(10, null, fourteen);

		Node<Integer> eight = new Node(8, three, ten);

		return eight;
	}

	@Test
	public void test() {
		Node<Integer> root = createBST();
		printer.printNode(root);
		// int data = 12;
		// insertRecursively(root, data);
	}

}
