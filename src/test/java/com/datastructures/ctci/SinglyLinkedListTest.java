package com.datastructures.ctci;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void emptyListTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		Assert.assertTrue(ll.isEmpty());
	}

	@Test
	public void nonEmptyListTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.add(1);
		Assert.assertFalse(ll.isEmpty());
	}

	@Test
	public void clearTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		Assert.assertTrue(ll.size() == 3);

		ll.clear();
		Assert.assertTrue(ll.isEmpty());
	}

	@Test
	public void addAllTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		Assert.assertTrue(ll.isEmpty());

		ll.addAll(Arrays.asList(1, 2, 3, 4));
		Assert.assertTrue(ll.size() == 4);
	}

	@Test
	public void reverseTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.addAll(Arrays.asList(0, 1, 2, 3));

		for (int i = 0; i < ll.size(); i++) {
			int val = ll.get(i);
			Assert.assertTrue(val == i);
		}

		ll.reverse();

		int[] reversedArr = new int[] { 3, 2, 1, 0 };

		for (int i = 0; i < ll.size(); i++) {
			int val = ll.get(i);
			Assert.assertTrue(val == reversedArr[i]);
		}
	}

	@Test
	public void removeTest() {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		Assert.assertFalse(ll.remove(null));
		Assert.assertFalse(ll.remove(new Integer(1)));

		ll.addAll(Arrays.asList(0, 1));

		ll.remove(new Integer(1));

		Assert.assertTrue(ll.size() == 1);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 0);

		ll.addAll(Arrays.asList(1, 2, 3, 4));

		ll.remove(new Integer(3));

		Assert.assertTrue(ll.get(3) == 4);

		ll.remove(new Integer(4));

		Assert.assertTrue(ll.getLast() == 2);
	}

}
