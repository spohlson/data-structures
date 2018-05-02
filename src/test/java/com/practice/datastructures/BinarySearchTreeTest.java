package com.practice.datastructures;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

	/**
	 *  		4
	 * 		  /   \
	 * 		2		6
	 * 	   / \     / \
	 * 	  1   3   5   7
	 */
	public BinarySearchTree<Integer> createValidIntegerBST() {
		Node<Integer> one = new Node<>(1);
		Node<Integer> three = new Node<>(3);

		Node<Integer> five = new Node<>(5);
		Node<Integer> seven = new Node<>(7);

		Node<Integer> two = new Node<>(2, one, three);

		Node<Integer> six = new Node<>(6, five, seven);

		Node<Integer> four = new Node<>(4, two, six);
		return new BinarySearchTree<Integer>(four);
	}

	/**
	 *   		A
	 * 		  /   \
	 * 		B		C
	 * 	  /  \     /  \
	 *  D     E   F    G
	 */
	public BinarySearchTree<String> createValidStringBST() {
		Node<String> d = new Node<>("D");
		Node<String> e = new Node<>("E");
		Node<String> b = new Node<>("B", d, e);

		Node<String> f = new Node<>("F");
		Node<String> g = new Node<>("G");
		Node<String> c = new Node<>("C", f, g);

		Node<String> a = new Node<>("A", b, c);

		return new BinarySearchTree<String>(a);
	}

	/**
	 *   		A
	 * 		  /   \
	 * 		B		C
	 * 	     \     /  \
	 *        D   E    F
	 *        	 /    /  \
	 *          G	 H    I
	 */
	public BinarySearchTree<String> createValidStringBST1() {
		Node<String> g = new Node<>("G");
		Node<String> h = new Node<>("H");
		Node<String> i = new Node<>("I");

		Node<String> d = new Node<>("D");
		Node<String> b = new Node<>("B", null, d);

		Node<String> e = new Node<>("E", g, null);
		Node<String> f = new Node<>("F", h, i);
		Node<String> c = new Node<>("C", e, f);


		Node<String> a = new Node<>("A", b, c);

		return new BinarySearchTree<String>(a);
	}

	@Test
	public void printTreeInOrder() {
		BinarySearchTree<String> bst = createValidStringBST();
		bst.printInOrder();
	}

	@Test
	public void getInOrderList() {
		BinarySearchTree<String> bst = createValidStringBST();
		List<String> list = bst.getInOrderList();
		List<String> expected = Arrays.asList("D", "B", "E", "A", "F", "C", "G");
		Assert.assertTrue(list.equals(expected));
	}

	@Test
	public void findString() {
		String expected = "C";
		String left = "F";
		String right = "G";

		BinarySearchTree<String> bst = createValidStringBST();
		Node<String> node = bst.find(expected);
		Assert.assertNotNull(node);
		Assert.assertTrue(expected.equals(node.getData()));
		Assert.assertTrue(left.equals(node.getLeft().getData()));
		Assert.assertTrue(right.equals(node.getRight().getData()));
	}

	@Test
	public void findStringNotInBST() {
		String test = "X";
		BinarySearchTree<String> bst = createValidStringBST();
		Node<String> node = bst.find(test);
		Assert.assertNull(node);
	}

	@Test
	public void find() {
		int expected = 6;
		int left = 5;
		int right = 7;
		BinarySearchTree<Integer> bst = createValidIntegerBST();
		Node<Integer> node = bst.find(expected);
		Assert.assertNotNull(node);
		Assert.assertTrue(expected == node.getData());
		Assert.assertTrue(left == node.getLeft().getData());
		Assert.assertTrue(right == node.getRight().getData());
	}

	@Test
	public void insert() {
		int insert = 8;
		BinarySearchTree<Integer> bst = createValidIntegerBST();
		bst.insert(insert);

		Node<Integer> node = bst.find(insert);
		Assert.assertNotNull(node);
		Assert.assertTrue(insert == node.getData());
	}

	@Test
	public void printTreePreOrder() {
		BinarySearchTree<String> bst = createValidStringBST();
		bst.printPreOrder();
	}

	@Test
	public void getPreOrderList() {
		BinarySearchTree<String> bst = createValidStringBST();
		List<String> list = bst.getPreOrderList();
		List<String> expected = Arrays.asList("A", "B", "D", "E", "C", "F", "G");
		Assert.assertTrue(list.equals(expected));
	}

	@Test
	public void printTreePostOrder() {
		BinarySearchTree<String> bst = createValidStringBST();
		bst.printPostOrder();
	}

	@Test
	public void getPostOrderList() {
		BinarySearchTree<String> bst = createValidStringBST1();
		List<String> list = bst.getPostOrderList();
		List<String> expected = Arrays.asList("D", "B", "G", "E", "H", "I", "F", "C", "A");
		Assert.assertTrue(list.equals(expected));
	}

	@Test
	public void copy() {
		BinarySearchTree<String> bst = createValidStringBST();
		List<String> list = bst.getPreOrderList();

		BinarySearchTree<String> copyBST = bst.copy();
		List<String> listCopy = copyBST.getPreOrderList();

		Assert.assertTrue(list.equals(listCopy));
	}

	@Test
	public void deleteTree() {
		BinarySearchTree<String> bst = createValidStringBST1();
		bst.deleteTree();
		Assert.assertNull(bst.getRoot());
	}

	@Test
	public void breadthFirstWithList() {
		BinarySearchTree<String> bst = createValidStringBST1();
		bst.breadthFirstWithList();
	}

	@Test
	public void breadthFirstWithQueue() {
		BinarySearchTree<String> bst = createValidStringBST1();
		bst.breadthFirstWithQueue();
	}

	@Test
	public void printGivenLevel() {
		BinarySearchTree<String> bst = createValidStringBST1();
		bst.printGivenLevel(2);
		System.out.println("");
		bst.printGivenLevel(3);

	}

}
