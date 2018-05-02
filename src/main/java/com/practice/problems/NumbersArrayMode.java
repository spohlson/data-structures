package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class NumbersArrayMode {

	/**
	 * Given an array of numbers, return the mode (the number that appears the
	 * most times)
	 */
	public int getMode(int[] arr) {
		if (arr.length == 0) {
			return -1;
		} else if (arr.length == 1) {
			return arr[0];
		}

		Map<Integer, Integer> numFreqMap = new HashMap<>();
		int hiFreq = 0;
		int mode = -1;

		for (int num : arr) {
			int freq = 1;

			if (numFreqMap.containsKey(num)) {
				freq += numFreqMap.get(num);
			}
			numFreqMap.put(num, freq);

			if (freq > hiFreq) {
				hiFreq = freq;
				mode = num;
			}
		}
		return mode;
	}

	@Test
	public void testGetMode() {
		int[] arr = new int[] { 1, 2, 3, 4, 2, 1, 2 };
		int expected = 2;
		int output = getMode(arr);
		Assert.assertTrue(expected == output);

		arr = new int[] { 1, 1, 6, 6, 1 };
		expected = 1;
		output = getMode(arr);
		Assert.assertTrue(expected == output);
	}
}
