package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SortingWithHash {

	/**
	 * Given an array of numbers in the range 1..1000, return a new array with
	 * those same numbers, in sorted order. There may be repeats in the input
	 * array. If there are, you should include those repeats in your sorted
	 * answer.
	 */
	public int[] getNewSortedArray(int[] arr) {
		int len = arr.length;

		if (len == 0) {
			return new int[0];
		} else if (len == 1) {
			return new int[] { arr[0] };
		}

		Map<Integer, Integer> numFreqMap = new HashMap<>(arr.length);
		int max = 1;

		for (int num : arr) {
			int freq = 1;

			if (numFreqMap.containsKey(num)) {
				freq += numFreqMap.get(num);
			}
			numFreqMap.put(num, freq);

			if (num > max) {
				max = num;
			}
		}

		int[] sortedArr = new int[len];
		int i = 0;

		for (int num = 1; num <= max; num++) {

			if (numFreqMap.containsKey(num)) {
				int freq = numFreqMap.get(num);

				while (freq > 0) {
					sortedArr[i] = num;
					i++;
					freq--;
				}
			}
		}
		return sortedArr;
	}

	@Test
	public void testGetNewSortedArray() {
		int[] arr = new int[] { 9, 8, 1, 4, 9, 50, 2, 1 };
		int[] expected = new int[] { 1, 1, 2, 4, 8, 9, 9, 50 };
		int[] output = getNewSortedArray(arr);
		Assert.assertArrayEquals(expected, output);
	}

}
