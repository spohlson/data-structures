package com.practice.datastructures;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NaryTreeTest {


	/**
	 * 			1
	 * 		/	|	\
	 * 	   3	2	 4
	 *   /  \
	 *  5	 6
	 */
	public NaryTree<Integer> createTree1() {
		NaryNode<Integer> five = new NaryNode<>(5);
		NaryNode<Integer> six = new NaryNode<>(6);
		NaryNode<Integer> two = new NaryNode<>(2);
		NaryNode<Integer> four = new NaryNode<>(4);

		List<NaryNode<Integer>> threesChildren = Arrays.asList(five, six);
		NaryNode<Integer> three = new NaryNode<>(3, threesChildren);

		List<NaryNode<Integer>> rootsChildren = Arrays.asList(three, two, four);
		NaryNode<Integer> root = new NaryNode<>(1, rootsChildren);

		NaryTree<Integer> tree = new NaryTree<>(root);
		return tree;
	}

	@Test
	public void testPrintPreOrder() {
		NaryTree<Integer> tree = createTree1();
		tree.printPreOrder();
	}

	@Test
	public void testGetPreOrder() {
		NaryTree<Integer> tree = createTree1();
		List<Integer> values = tree.getPreOrder();
		List<Integer> expected = Arrays.asList(1, 3, 5, 6, 2, 4);
		Assert.assertTrue(expected.equals(values));
	}

	@Test
	public void testPrintPostOrder() {
		NaryTree<Integer> tree = createTree1();
		tree.printPostOrder();
	}

	@Test
	public void testGetPostOrder() {
		NaryTree<Integer> tree = createTree1();
		List<Integer> values = tree.getPostOrder();
		List<Integer> expected = Arrays.asList(5, 6, 3, 2, 4, 1);
		Assert.assertTrue(expected.equals(values));
	}

	@Test
	public void testPrintLeveltOrder() {
		NaryTree<Integer> tree = createTree1();
		tree.printLevelOrder();
	}

	@Test
	public void testGetLevelOrder() {
		NaryTree<Integer> tree = createTree1();
		List<List<Integer>> values = tree.getLevelOrder();
		List<List<Integer>> expected = Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2, 4),
				Arrays.asList(5, 6));
		Assert.assertTrue(expected.equals(values));
	}

}
