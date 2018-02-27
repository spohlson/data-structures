package com.practice.datastructures;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.practice.datastructures.CircularSinglyLinkedList;

public class CircularSinglyLinkedListTest {

	@Test
	public void insertAtFirstTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
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
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();

		ll.insertAtEnd(0);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 0);

		ll.insertAtEnd(1);
		Assert.assertTrue(ll.getFirst() == 0);
		Assert.assertTrue(ll.getLast() == 1);
	}

	@Test
	public void insertAtTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
		ll.addAll(Arrays.asList(0, 1, 2, 3));

		ll.insertAt(2, 5);

		Assert.assertTrue(ll.get(2) == 5);
		Assert.assertTrue(ll.get(3) == 2);
	}

	@Test
	public void removeFirstTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
		ll.addAll(Arrays.asList(0, 1, 2, 3));

		Assert.assertTrue(ll.removeFirst() == 0);
		Assert.assertTrue(ll.getFirst() == 1);
	}

	@Test
	public void removeLastTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
		ll.addAll(Arrays.asList(0, 1, 2, 3));

		Assert.assertTrue(ll.removeLast() == 3);
		Assert.assertTrue(ll.getLast() == 2);
	}

	@Test
	public void removeAtTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
		ll.addAll(Arrays.asList(0, 1, 2, 3));

		Assert.assertTrue(ll.removeAt(1) == 1);
		Assert.assertTrue(ll.get(1) == 2);
	}

	@Test
	public void reverseTest() {
		CircularSinglyLinkedList<Integer> ll = new CircularSinglyLinkedList<>();
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

}
