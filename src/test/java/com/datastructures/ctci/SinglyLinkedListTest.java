package com.datastructures.ctci;

import org.junit.Assert;
import org.junit.Test;

import com.datastructures.ctci.SinglyLinkedList;

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

}
