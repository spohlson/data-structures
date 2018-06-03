package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Majority {

	/**
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than floor(n/2) times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 * Example:
	 * Input : [2, 1, 2]
	 * Return : 2 which occurs 2 times which is greater than 3/2.
	 */

	public int majorityElement(List<Integer> a) {
		if ((a == null) || (a.size() == 0)) {
			return -1;
		}
		Map<Integer, Integer> freqMap = new HashMap<>(a.size());

		for (int num : a) {

			if (!freqMap.containsKey(num)) {
				freqMap.put(num, 1);
			} else {
				freqMap.put(num, freqMap.get(num) + 1);
			}
		}
		int floor = a.size() / 2;
		int maxFreq = 0;
		int maj = 0;

		for (int num : freqMap.keySet()) {
			int freq = freqMap.get(num);

			if ((freq > floor) && (freq > maxFreq)) {
				maj = num;
			}
		}
		return maj;
	}

	public int majorityElementSolution(final List<Integer> nums) {
		if (nums == null) {
			return -1;
		}
		int maj = nums.get(0);
		int count = 1;
		int n = nums.size();

		for (int i = 1; i < n; i++) {
			int num = nums.get(i);

			if (num == maj) {
				count++;
			} else if (count == 1) {
				maj = num;
			} else {
				count--;
			}
		}

		count = 0;

		for (int i = 0; i < n; i++) {

			if (nums.get(i) == maj) {
				count++;
			}
		}

		if (count > (n / 2)) {
			return maj;
		}
		return -1;
	}

	@Test
	public void test() {
		List<Integer> list = new ArrayList<>(Arrays.asList(8, 4, 8, 4, 8, 3));
		int output = majorityElementSolution(list);
		int expected = 8;
		Assert.assertTrue(expected == output);
	}

}
