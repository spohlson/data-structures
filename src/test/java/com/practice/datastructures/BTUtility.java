package com.practice.datastructures;

import com.practice.utilities.BSTPrinter;

public class BTUtility {

	public void printTree(Node<?> root) {
		BSTPrinter.printNode(root);
	}

	public boolean areEqual(Node<Integer> node1, Node<Integer> node2) {
		if ((node1 == null) && (node2 == null)) {
			return true;
		} else if ((node1 == null) || (node2 == null) || !node1.equals(node2)) {
			return false;
		}

		return areEqual(node1.getLeft(), node2.getLeft())
				&& areEqual(node1.getRight(), node2.getRight());
	}

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

	/**
	 *  	6
	 * 	     \
	 * 		  9
	 * 		 / \
	 * 		7   10
	 * 			  \
	 * 			   11
	 */
	public Node<Integer> createIntegerBT() {
		Node<Integer> seven = new Node<>(7);
		Node<Integer> eleven = new Node<>(11);
		Node<Integer> ten = new Node<>(10, null, eleven);
		Node<Integer> nine = new Node<>(9, seven, ten);
		Node<Integer> six = new Node<>(6, null, nine);
		return six;
	}

	/**
	 * 				1
	 * 			   / \
	 * 			  2   4
	 * 			 /   / \
	 * 			3   5   6
	 * 				   /
	 * 				  7
	 */
	public Node<Integer> createIntegerBT1() {
		Node<Integer> seven = new Node<>(7);
		Node<Integer> three = new Node<>(3);
		Node<Integer> five = new Node<>(5);

		Node<Integer> six = new Node<>(6, seven, null);
		Node<Integer> four = new Node<>(4, five, six);
		Node<Integer> two = new Node<>(2, three, null);
		Node<Integer> one = new Node<>(1, two, four);
		return one;
	}

	/**
	 * 				23
	 * 			  /    \
	 * 		   14       67
	 * 		 /   \     /   \
	 *     12    19   54    76
	 *    /     /     /		/
	 *  9     17    50    72
	 */
	public Node<Integer> createHeightBalancedBST() {
		Node<Integer> nine = new Node<>(9);
		Node<Integer> seventeen = new Node<>(17);
		Node<Integer> fifty = new Node<>(50);
		Node<Integer> seventyTwo = new Node<>(72);

		Node<Integer> twelve = new Node<>(12, nine, null);
		Node<Integer> nineteen = new Node<>(19, seventeen, null);
		Node<Integer> fiftyFour = new Node<>(54, fifty, null);
		Node<Integer> seventySix = new Node<>(76, seventyTwo, null);

		Node<Integer> fourteen = new Node<>(14, twelve, nineteen);
		Node<Integer> sixtySeven = new Node<>(67, fiftyFour, seventySix);

		Node<Integer> twentyThree = new Node<>(23, fourteen, sixtySeven);
		return twentyThree;
	}

}
