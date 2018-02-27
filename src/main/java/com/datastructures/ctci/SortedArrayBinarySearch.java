package com.datastructures.ctci;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Binary Search Trees: Pros/Cons & When to Use
 * 
 * Pros:
 * - Doesn't require much memory
 * - Traverse/add/delete/search elements in order
 * - Good for finding closest elements and searching in ranges
 *
 */
public class SortedArrayBinarySearch {

	/**
	 * Return index location of x in the given sorted array.
	 * 
	 * RUNTIME: O(log N)
	 */
	public int binarySearchForIndexOfNum(int x, int[] arr) {
		int index = arr.length / 2;
		int mid = arr[index];

		if (mid == x) {
			return index;
		}

		int[] halfArr;

		if (mid > x) {
			halfArr = Arrays.copyOfRange(arr, 0, index);
		} else {
			halfArr = Arrays.copyOfRange(arr, index, arr.length);
		}

		int loc = binarySearchForIndexOfNum(x, halfArr) + index;

		return loc;
	}

	@Test
	public void binarySearchForIndexOfNumTest() {
		int[] arr = new int[] { 1, 3, 5, 7, 9, 11, 13, 15 };
		int x = 13;

		int expected = 6;

		int indexReturned = binarySearchForIndexOfNum(x, arr);

		Assert.assertTrue("Failed", expected == indexReturned);
	}

}
