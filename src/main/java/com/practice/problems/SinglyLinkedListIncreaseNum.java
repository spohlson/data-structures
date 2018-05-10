package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListIncreaseNum {

	/**
	 * A non-negative number is expressed as a SinglyLinkedList. Add one to it.
	 * Do not solve by fetching the number, increasing it, then inserting into a
	 * new SinglyLinkedList.
	 * 
	 * 1→0→4 => 1→0→5
	 * 1→9→9 => 2→0→0
	 * 9→9 => 1→0→0
	 * 0 => 1
	 * 9 => 1→0
	 * 1→9→3→9→9 => 1→9→4→0→0
	 */

	public class Node {

		private int val;
		private Node next;

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node next) {
			this(val);
			this.next = next;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public boolean hasNext() {
			return next != null;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (next == null) {
				if (other.next != null) {
					return false;
				}
			} else if (!next.equals(other.next)) {
				return false;
			}
			if (val != other.val) {
				return false;
			}
			return true;
		}

		private SinglyLinkedListIncreaseNum getOuterType() {
			return SinglyLinkedListIncreaseNum.this;
		}

	}

	public Node plusOne(Node node) {
		if (node == null) {
			return node;
		}
		node = reverseLL(node);
		incrementLL(node);
		node = reverseLL(node);
		return node;
	}

	private Node reverseLL(Node node) {
		if (node == null) {
			return node;
		}
		Node prev = null;
		Node curr = node;

		while (curr != null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private void incrementLL(Node node) {
		int val = node.getVal();

		if (val == 9) {
			node.setVal(0);

			if (!node.hasNext()) {
				Node next = new Node(1);
				node.setNext(next);
			} else {
				incrementLL(node.getNext());
			}
		} else {
			node.setVal(val + 1);
		}
	}

	///////// TEST METHODS /////////

	public Node createNodes(int[] nums) {
		Node head = new Node(nums[0]);
		Node node = head;

		for (int i = 1; i < nums.length; i++) {
			Node next = new Node(nums[i]);
			node.setNext(next);
			node = next;
		}
		return head;
	}

	@Test
	public void test() {
		Node node = createNodes(new int[] { 1, 0, 4 });
		Node expected = createNodes(new int[] { 1, 0, 5 });
		Node output = plusOne(node);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test1() {
		Node node = createNodes(new int[] { 1, 9, 9 });
		Node expected = createNodes(new int[] { 2, 0, 0 });
		Node output = plusOne(node);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test2() {
		Node node = createNodes(new int[] { 9, 9 });
		Node expected = createNodes(new int[] { 1, 0, 0 });
		Node output = plusOne(node);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test3() {
		Node node = createNodes(new int[] { 1, 9, 3, 9, 9 });
		Node expected = createNodes(new int[] { 1, 9, 4, 0, 0 });
		Node output = plusOne(node);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test4() {
		Node node = createNodes(new int[] { 0 });
		Node expected = createNodes(new int[] { 1 });
		Node output = plusOne(node);
		Assert.assertTrue(expected.equals(output));
	}

}
