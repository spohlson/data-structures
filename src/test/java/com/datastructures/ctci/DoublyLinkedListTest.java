package com.datastructures.ctci;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void insertAtFirstTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		Assert.assertTrue(ll.isEmpty());

		ll.insertAtFirst(0);
		Assert.assertTrue(ll.size() == 1);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 0);

		ll.insertAtFirst(1);
		Assert.assertTrue(ll.size() == 2);
		Assert.assertTrue(ll.getFirst() == 1);
		Assert.assertTrue(ll.getLast() == 0);
	}

	@Test
	public void insertAtEndTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();

		ll.insertAtEnd(0);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 0);

		ll.insertAtEnd(1);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 1);
	}

	@Test
	public void insertAtTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);

		ll.insertAt(3, 9);

		Assert.assertTrue(ll.get(3) == 9);
	}

	@Test(
			expected = IndexOutOfBoundsException.class)
	public void removeFirstExceptionTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.removeFirst();
		ll.get(0);
	}

	@Test
	public void removeFirstTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.add(0);

		ll.removeFirst();
		Assert.assertTrue(ll.isEmpty());

		ll.add(0);
		ll.add(1);
		ll.add(2);

		ll.removeFirst();
		Assert.assertTrue(ll.get(0) == 1);
	}

	@Test
	public void removeLastTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.removeLast();

		Assert.assertTrue(ll.get(ll.size() - 1) == 2);
	}

	@Test
	public void removeAt() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);

		ll.removeAt(2);
		Assert.assertTrue(ll.get(2) == 3);
	}

	@Test
	public void reverseTest() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);

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
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
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
