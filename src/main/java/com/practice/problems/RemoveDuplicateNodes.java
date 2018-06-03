package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateNodes {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 */

	public class ListNode {

		public int val;
		public ListNode next;

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
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
			ListNode other = (ListNode) obj;
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

	}

	/**
	 * Better runtime. The recursive solution gets a stack overflow exception if
	 * the linkedlist is too long.
	 */
	public ListNode deleteDuplicates(ListNode node) {
		if ((node == null) || (node.next == null)) {
			return node;
		}
		ListNode curr = node;

		while (curr != null) {
			ListNode next = curr.next;

			while ((next != null) && (curr.val == next.val)) {
				next = next.next;
			}
			curr.next = next;
			curr = next;
		}
		return node;
	}

	public ListNode deleteDuplicatesRecursively(ListNode a) {
		removeDuplicatesRecursively(a);
		return a;
	}

	private void removeDuplicatesRecursively(ListNode node) {
		if (node == null) {
			return;
		}
		ListNode curr = node;
		ListNode next = curr.next;

		while ((next != null) && (curr.val == next.val)) {
			next = next.next;
		}
		curr.next = next;

		deleteDuplicatesRecursively(next);
	}

	@Test
	public void testIteratively() {
		ListNode tail = new ListNode(3, null);
		ListNode two = new ListNode(2, tail);
		ListNode twoTwo = new ListNode(2, two);
		ListNode twoTwoTwo = new ListNode(2, twoTwo);
		ListNode one = new ListNode(1, twoTwoTwo);
		ListNode oneOne = new ListNode(1, one);
		ListNode root = new ListNode(0, oneOne);

		ListNode output = deleteDuplicates(root);

		ListNode expectedTail = new ListNode(3, null);
		ListNode expectedTwo = new ListNode(2, expectedTail);
		ListNode expectedOne = new ListNode(1, expectedTwo);
		ListNode expectedRoot = new ListNode(0, expectedOne);

		Assert.assertTrue(output.equals(expectedRoot));
	}

	@Test
	public void testRecursively() {
		ListNode tail = new ListNode(3, null);
		ListNode two = new ListNode(2, tail);
		ListNode twoTwo = new ListNode(2, two);
		ListNode twoTwoTwo = new ListNode(2, twoTwo);
		ListNode one = new ListNode(1, twoTwoTwo);
		ListNode oneOne = new ListNode(1, one);
		ListNode root = new ListNode(0, oneOne);

		ListNode output = deleteDuplicatesRecursively(root);

		ListNode expectedTail = new ListNode(3, null);
		ListNode expectedTwo = new ListNode(2, expectedTail);
		ListNode expectedOne = new ListNode(1, expectedTwo);
		ListNode expectedRoot = new ListNode(0, expectedOne);

		Assert.assertTrue(output.equals(expectedRoot));
	}

}
