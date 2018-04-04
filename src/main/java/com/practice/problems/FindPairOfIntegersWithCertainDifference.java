package com.practice.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindPairOfIntegersWithCertainDifference {

	/**
	 * Given an array of distinct integer values, count the number of pairs of
	 * integers that have a difference of k. For example, given the array [1, 7,
	 * 5, 9, 2, 12, 3] and the difference k = 2, there are four pairs with
	 * difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
	 * 
	 * Output --> 4
	 */

	/**
	 * 1. Sort array
	 * 2. Create pair count variable set to 0
	 * 3. Iterate over array, get num at index 0 up till array length minus one
	 * 4. Add a nested iteration over array starting at num index plus one (int next) up till array length
	 * 5. Subtract next by num --> numDiff
	 * 6. If numDiff is equal to the argument diff then increase count and break nested iteration
	 * 7. Check if numdiff is greater than diff, if so then break from the nested iteration
	 * 8. Return count
	 */

	public int findPairs(int diff, int[] arr) {
		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < (arr.length - 1); i++) {
			int num = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				int next = arr[j];

				int numDiff = next - num;

				if (numDiff == diff) {
					count++;
					break;
				} else if (numDiff > diff) {
					break;
				}
			}
		}

		return count;
	}

	@Test
	public void test() {
		int[] arr = new int[] { 1, 7, 5, 9, 2, 12, 3 };
		int diff = 2;

		int expected = 4;

		int output = findPairs(diff, arr);

		Assert.assertTrue(expected == output);
	}

}
