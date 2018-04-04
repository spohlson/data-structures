package com.practice.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindDifferenceInTwoArrays {

	/**
	 * Write a function called findDifference that takes 2 arrays of integers as
	 * arguments, the first array has an arbitrary amount of #s while the second
	 * has mostly the same #s. The first array will always have one # that is
	 * different.
	 * 
	 * Example:
	 * 
	 * 1st array --> [3, 6, 8, 12, 4]
	 * 2nd array --> [4, 6, 8, 12]
	 * Returns 3
	 * 
	 * Can assume that neither array would be empty or null.
	 */

	/**
	 * Since we know for certain that arr1 will have one extra number:
	 * 
	 * 1. Add up all numbers in arr1 --> total
	 * 2. Subtract all numbers in arr2 from the total
	 * 3. Return total
	 */
	public int findDifferenceCountTotals(int[] arr1, int[] arr2) {
		int total = 0;

		for (int num : arr1) {
			total += num;
		}

		for (int num : arr2) {
			total -= num;
		}

		return total;
	}

	/**
	 * 1. Convert arr2 to a set
	 * 2. Iterate over arr1
	 * 3. Check if each number is contained in the set, return on the number that is not in set
	 */
	public int findDifferenceWithSet(int[] arr1, int[] arr2) {
		Set<Integer> set2 = new HashSet<>(Arrays.stream(arr2).boxed().collect(Collectors.toList()));

		for (int num : arr1) {
			if (!set2.contains(num)) {
				return num;
			}
		}
		return 0;
	}

	@Test
	public void testAddition() {
		int[] arr1 = new int[] { 3, 6, 8, 12, 4 };
		int[] arr2 = new int[] { 4, 6, 8, 12 };

		int expected = 3;

		int output = findDifferenceCountTotals(arr1, arr2);

		Assert.assertTrue(expected == output);
	}

	@Test
	public void testWithSet() {
		int[] arr1 = new int[] { 3, 6, 8, 12, 4 };
		int[] arr2 = new int[] { 4, 6, 8, 12 };

		int expected = 3;

		int output = findDifferenceWithSet(arr1, arr2);

		Assert.assertTrue(expected == output);
	}

}
