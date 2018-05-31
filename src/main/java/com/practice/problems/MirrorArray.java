package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class MirrorArray {

	/*
	 * We'll say that a "mirror" section in an array is a group of contiguous
	 * elements such that somewhere in the array, the same group appears in
	 * reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9,
	 * 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest
	 * mirror section found in the given array.
	 * 
	 * maxMirror({1, 2, 3, 8, 9, 3, 2, 1}) → 3
	 * maxMirror({1, 2, 1, 4}) → 1
	 * maxMirror({7, 1, 2, 9, 7, 2, 1}) → 2
	 */
	public int maxMirror(int[] arr) {

		return 0;
	}

	public void confirmTest(int[] arr, int expected) {
		int output = maxMirror(arr);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void test() {
		confirmTest(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3);
		confirmTest(new int[] { 1, 2, 1, 4 }, 1);
		confirmTest(new int[] { 7, 1, 2, 9, 7, 2, 1 }, 2);
	}

}
