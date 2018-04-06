package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class ReverseArray {

	/**
	 * Write a function that manually reverses an array.
	 */

	public int[] reverseArrayIntoNewArray(int[] arr) {
		int len = arr.length;

		int[] reversedArr = new int[len];
		int j = 0;

		for (int i = len - 1; i >= 0; i--) {
			reversedArr[j] = arr[i];
			j++;
		}

		return reversedArr;
	}

	public int[] reverseArray(int[] arr) {
		int len = arr.length;
		int swapIdx = len - 1;
		int mid = len / 2;

		for (int i = 0; i < mid; i++) {
			int num = arr[i];
			arr[i] = arr[swapIdx];
			arr[swapIdx] = num;
			swapIdx--;
		}

		return arr;
	}

	@Test
	public void testReverseArray() {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int[] expected = new int[] { 5, 4, 3, 2, 1 };
		int[] output = reverseArray(input);

		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testReverseArray1() {
		int[] input = new int[] { 1, 2, 3, 4 };
		int[] expected = new int[] { 4, 3, 2, 1 };
		int[] output = reverseArray(input);

		Assert.assertArrayEquals(expected, output);
	}

	@Test
	public void testNewArray() {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		int[] expected = new int[] { 5, 4, 3, 2, 1 };
		int[] output = reverseArrayIntoNewArray(input);

		Assert.assertArrayEquals(expected, output);
	}

}
