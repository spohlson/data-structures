package com.practice.problems;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListDetectCycle {

	/**
	 * A linked list is said to contain a cycle if any node is visited more than
	 * once while traversing the list.
	 * 
	 * Create a function with one parameter: a pointer to a Node object named
	 * head that points to the head of a linked list. Your function must return
	 * a boolean denoting whether or not there is a cycle in the list. If there
	 * is a cycle, return true; otherwise, return false.
	 * 
	 * Note: If the list is empty, head will be null.
	 */

	public class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node next) {
			this(data);
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	/**
	 * My solution
	 */
	public boolean hasCycle(Node head) {
		Set<Node> nodes = new HashSet<>();
		Node curr = head;

		while (curr != null) {

			if (!nodes.contains(curr)) {
				nodes.add(curr);
			} else {
				return true;
			}

			curr = curr.getNext();
		}

		return false;
	}

	/**
	 * Hackerrank top solution
	 */
	public boolean hasCycleOtherSolution(Node head) {
		if (head == null) {
			return false;
		} else {
			Node slow = head;
			Node fast = head.getNext();

			while ((fast != null) && (fast.getNext() != null) && (fast != slow)) {
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}

			if ((fast != null) && (fast == slow)) {
				return true;
			}

			return false;
		}
	}

	@Test
	public void testCycle1() {
		Node three = new Node(3);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		three.setNext(two);

		boolean hasCycle = hasCycle(one);
		Assert.assertTrue(hasCycle);
	}

	@Test
	public void testCycle2() {
		Node three = new Node(3);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		three.setNext(one);

		boolean hasCycle = hasCycle(one);
		Assert.assertTrue(hasCycle);
	}

	@Test
	public void testCycle3() {
		Node node = new Node(1);
		node.setNext(node);

		boolean hasCycle = hasCycle(node);
		Assert.assertTrue(hasCycle);
	}

	@Test
	public void testCycle4() {
		Node six = new Node(6);
		Node five = new Node(5, six);
		Node four = new Node(4, five);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		six.setNext(four);

		boolean hasCycle = hasCycle(one);
		Assert.assertTrue(hasCycle);
	}

	@Test
	public void testEmpty() {
		Node node = null;

		boolean hasCycle = hasCycle(node);
		Assert.assertFalse(hasCycle);
	}

	@Test
	public void testNoCycle1() {
		Node node = new Node(1);

		boolean hasCycle = hasCycle(node);
		Assert.assertFalse(hasCycle);
	}

	@Test
	public void testNoCycle2() {
		Node four = new Node(4);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		boolean hasCycle = hasCycle(one);
		Assert.assertFalse(hasCycle);
	}

}
