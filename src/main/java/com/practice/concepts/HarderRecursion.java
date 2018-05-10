package com.practice.concepts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class HarderRecursion {

	/**
	 * Given an array of ints, is it possible to choose a group of some of the
	 * ints, such that the group sums to the given target? This is a classic
	 * backtracking recursion problem. Once you understand the recursive
	 * backtracking strategy in this problem, you can use the same pattern for
	 * many problems to search a space of choices. Rather than looking at the
	 * whole array, our convention is to consider the part of the array starting
	 * at index start and continuing to the end of the array. The caller can
	 * specify the whole array simply by passing start as 0. No loops are needed
	 * -- the recursive calls progress down the array.
	 * 
	 * groupSum(0, [2, 4, 8], 10) → true
	 * groupSum(0, [2, 4, 8], 14) → true
	 * groupSum(0, [2, 4, 8], 9) → false
	 */
	public boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) {
			return target == 0;
		}
		int num = nums[start];

		if (groupSum(start + 1, nums, target - num) || groupSum(start + 1, nums, target)) {
			return true;
		}
		return false;
	}

	@Test
	public void testGroupSum() {
		int start = 0;
		int[] arr = new int[] { 2, 4, 8 };
		int target = 10;
		boolean expected = true;
		Assert.assertTrue(expected == groupSum(start, arr, target));

		arr = new int[] { 2, 4, 8 };
		target = 6;
		expected = true;
		Assert.assertTrue(expected == groupSum(start, arr, target));

		arr = new int[] { 2, 4, 8 };
		target = 14;
		expected = true;
		Assert.assertTrue(expected == groupSum(start, arr, target));

		arr = new int[] { 2, 4, 8 };
		target = 9;
		expected = false;
		Assert.assertTrue(expected == groupSum(start, arr, target));

		arr = new int[] { 2, 3, 4, 8 };
		target = 11;
		expected = true;
		Assert.assertTrue(expected == groupSum(start, arr, target));
	}

	/**
	 * Write a function that sums all numbers in a 2D array. Do not use loops.
	 */
	public int sum2DArray(int[][] grid) {
		int start = 0;
		int sum = 0;
		return sum2DArray(grid, sum, start);
	}

	private int sum2DArray(int[][] grid, int sum, int start) {
		if (start == grid.length) {
			return sum;
		}
		sum = sumArray(grid[start], sum, 0);
		return sum2DArray(grid, sum, start + 1);
	}

	private int sumArray(int[] arr, int sum, int start) {
		if (start == arr.length) {
			return sum;
		}
		sum += arr[start];
		return sumArray(arr, sum, start + 1);
	}

	@Test
	public void testSum2DArray() {
		int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9, 10 } };
		int expected = 55;
		int output = sum2DArray(grid);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Write a function that generates all possible combinations of 1 and 0 for
	 * n bits. Ex. If the function receives 2 as the number of bits, it should
	 * produce 4 combinations: 00, 01, 10, 11. You cannot use any mathematical
	 * operators.
	 */
	public Set<String> getBitCombinations(int n) {
		int numOfBits = 2;
		int numOfCombos = (int) Math.pow(numOfBits, n);
		Set<String> combos = new HashSet<>(numOfCombos);
		getBitCombos(combos, numOfCombos, n, 0, "");
		return combos;
	}

	private void getBitCombos(Set<String> combos, int numOfCombos, int slots, int bit, String combo) {
		if (combos.size() == numOfCombos) {
			return;
		} else if (combo.length() == slots) {
			combos.add(combo);
			return;
		}
		int oppBit = bit ^ 1;
		String oppCombo = combo + oppBit;
		getBitCombos(combos, numOfCombos, slots, oppBit, oppCombo);

		combo = combo + bit;
		getBitCombos(combos, numOfCombos, slots, bit, combo);
	}

	@Test
	public void testGetBitCombinations() {
		int n = 2;
		Set<String> combos = getBitCombinations(n);
		int expected = (int) Math.pow(2, n);
		Assert.assertTrue(combos.size() == expected);
		System.out.println("N: " + n + ", " + combos.size() + " combos\n" + combos + "\n");

		n = 3;
		combos = getBitCombinations(n);
		expected = (int) Math.pow(2, n);
		Assert.assertTrue(combos.size() == expected);
		System.out.println("N: " + n + ", " + combos.size() + " combos\n" + combos + "\n");

		n = 4;
		combos = getBitCombinations(n);
		expected = (int) Math.pow(2, n);
		Assert.assertTrue(combos.size() == expected);
		System.out.println("N: " + n + ", " + combos.size() + " combos\n" + combos + "\n");
	}

	/**
	 * Print all possible combinations of binary
	 */
	public class BinaryCombos {

		private String[] combo;

		public BinaryCombos() {
			combo = new String[2];
		}

		private void binary(int n) {
			if (n == 0) {
				System.out.println(String.join("", combo));
			} else {
				combo[n - 1] = "0";
				binary(n - 1);

				combo[n - 1] = "1";
				binary(n - 1);
			}
		}

	}

	@Test
	public void testBinaryCombos() {
		BinaryCombos bCombos = new BinaryCombos();
		bCombos.binary(2);
	}

	/**
	 * Find the kth largest # in an array recursively
	 */
	public int kthLargest(int[] arr, int k) {

		return 0;
	}

	/**
	 * 
	 */
	public int kthLargestWithSort(int[] arr, int k) {
		Arrays.sort(arr);

		if ((k <= 0) || (k > arr.length)) {
			return -1;
		}
		return arr[k - 1];
	}

	@Test
	public void testKthLargestWithSort() {
		int[] arr = new int[] { 3, 2, 8, 5, 16, 9 };
		int k = 4;
		int expected = 8;
		int output = kthLargestWithSort(arr, k);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Given an array of ints, is it possible to choose a group of some of the
	 * ints, beginning at the start index, such that the group sums to the given
	 * target? However, with the additional constraint that all 6's must be
	 * chosen. (No loops needed.)
	 * 
	 * 
	 * groupSum6(0, [5, 6, 2], 8) → true
	 * groupSum6(0, [5, 6, 2], 9) → false
	 * groupSum6(0, [5, 6, 2], 7) → false
	 */
	public boolean groupSum6(int start, int[] nums, int target) {
		if (start >= nums.length) {
			return (target == 0);
		}
		int num = nums[start];

		if (num == 6) {
			return groupSum6(start + 1, nums, target - num);
		}

		if (groupSum6(start + 1, nums, target - num) || groupSum6(start + 1, nums, target)) {
			return true;
		}
		return false;
	}

	@Test
	public void testGroupSum6() {
		int start = 0;
		int[] arr = new int[] { 5, 6, 2 };
		int target = 8;
		boolean expected = true;
		Assert.assertTrue(expected == groupSum6(start, arr, target));

		arr = new int[] { 5, 6, 2 };
		target = 9;
		expected = false;
		Assert.assertTrue(expected == groupSum6(start, arr, target));

		arr = new int[] { 5, 6, 2 };
		target = 7;
		expected = false;
		Assert.assertTrue(expected == groupSum6(start, arr, target));

		arr = new int[] { 5, 6, 5, 6, 2 };
		target = 12;
		expected = true;
		Assert.assertTrue(expected == groupSum6(start, arr, target));
	}

	/**
	 * Given an array of ints, is it possible to choose a group of some of the
	 * ints, such that the group sums to the given target with this additional
	 * constraint: If a value in the array is chosen to be in the group, the
	 * value immediately following it in the array must not be chosen. (No loops
	 * needed.)
	 * 
	 * groupNoAdj(0, [2, 5, 10, 4], 12) → true
	 * groupNoAdj(0, [2, 5, 10, 4], 14) → false
	 * groupNoAdj(0, [2, 5, 10, 4], 7) → false
	 */
	public boolean groupNoAdj(int start, int[] nums, int target) {
		if (start > (nums.length - 1)) {
			return target == 0;
		}
		int num = nums[start];

		if (groupNoAdj(start + 2, nums, target - num) || groupNoAdj(start + 1, nums, target)) {
			return true;
		}
		return false;
	}

	@Test
	public void testGroupNoAdj() {
		int start = 0;
		int[] arr = new int[] { 2, 5, 10, 4 };
		int target = 12;
		boolean expected = true;
		Assert.assertTrue(expected == groupNoAdj(start, arr, target));

		target = 14;
		expected = false;
		Assert.assertTrue(expected == groupNoAdj(start, arr, target));

		target = 7;
		expected = false;
		Assert.assertTrue(expected == groupNoAdj(start, arr, target));
	}

	/**
	 * Given an array of ints, is it possible to choose a group of some of the
	 * ints, such that the group sums to the given target with these additional
	 * constraints: all multiples of 5 in the array must be included in the
	 * group. If the value immediately following a multiple of 5 is 1, it must
	 * not be chosen. (No loops needed.)
	 * 
	 * groupSum5(0, [2, 5, 10, 4], 19) → true
	 * groupSum5(0, [2, 5, 10, 4], 17) → true
	 * groupSum5(0, [2, 5, 10, 4], 12) → false
	 */
	public boolean groupSum5(int start, int[] nums, int target) {
		if (start >= nums.length) {
			return target == 0;
		}
		int num = nums[start];

		if ((num % 5) == 0) {
			int newStart = start + 1;

			if ((newStart < nums.length) && (nums[newStart] == 1)) {
				newStart++;
			}
			return groupSum5(newStart, nums, target - num);
		}

		if (groupSum5(start + 1, nums, target - num) || groupSum5(start + 1, nums, target)) {
			return true;
		}
		return false;
	}

	@Test
	public void testGroupSum5() {
		int start = 0;
		int[] arr = new int[] { 2, 5, 10, 4 };
		int target = 19;
		boolean expected = true;
		Assert.assertTrue(expected == groupSum5(start, arr, target));

		target = 17;
		expected = true;
		Assert.assertTrue(expected == groupSum5(start, arr, target));

		target = 12;
		expected = false;
		Assert.assertTrue(expected == groupSum5(start, arr, target));

		arr = new int[] { 3, 5, 1 };
		target = 4;
		expected = false;
		Assert.assertTrue(expected == groupSum5(start, arr, target));

		arr = new int[] { 3, 5, 1 };
		target = 5;
		expected = true;
		Assert.assertTrue(expected == groupSum5(start, arr, target));

		arr = new int[] { 3, 5, 1 };
		target = 9;
		expected = false;
		Assert.assertTrue(expected == groupSum5(start, arr, target));
	}

	/**
	 * Given an array of ints, is it possible to choose a group of some of the
	 * ints, such that the group sums to the given target, with this additional
	 * constraint: if there are numbers in the array that are adjacent and the
	 * identical value, they must either all be chosen, or none of them chosen.
	 * For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in
	 * the middle must be chosen or not, all as a group. (one loop can be used
	 * to find the extent of the identical values).
	 * 
	 * groupSumClump(0, [2, 4, 8], 10) → true
	 * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
	 * groupSumClump(0, [2, 4, 4, 8], 14) → false
	 */
	public boolean groupSumClump(int start, int[] nums, int target) {
		if (start >= nums.length) {
			return target == 0;
		}
		int num = nums[start];

		int count = 1;
		int i = start + 1;

		while ((i < nums.length) && (nums[i] == num)) {
			count++;
			i++;
		}

		if (count > 1) {
			start = i;
			num = num * count;

			if (groupSumClump(i, nums, target - (num * count)) || groupSumClump(i, nums, target)) {
				return true;
			}
			return false;
		}

		if (groupSumClump(start + 1, nums, target - num)
				|| groupSumClump(start + 1, nums, target)) {
			return true;
		}
		return false;
	}

	@Test
	public void testGroupSumClump() {
		int start = 0;
		int[] arr = new int[] { 2, 4, 8 };
		int target = 10;
		boolean expected = true;
		Assert.assertTrue(expected == groupSumClump(start, arr, target));

		arr = new int[] { 1, 2, 4, 8, 1 };
		target = 14;
		expected = true;
		Assert.assertTrue(expected == groupSumClump(start, arr, target));

		arr = new int[] { 8, 2, 2, 1 };
		target = 9;
		expected = true;
		Assert.assertTrue(expected == groupSumClump(start, arr, target));

		arr = new int[] { 2, 4, 4, 8 };
		target = 14;
		expected = false;
		Assert.assertTrue(expected == groupSumClump(start, arr, target));
	}

	/**
	 * Given an array of ints, is it possible to divide the ints into two
	 * groups, so that the sums of the two groups are the same. Every int must
	 * be in one group or the other. Write a recursive helper method that takes
	 * whatever arguments you like, and make the initial call to your recursive
	 * helper from splitArray(). (No loops needed.)
	 * 
	 * splitArray([2, 2]) → true
	 * splitArray([2, 3]) → false
	 * splitArray([5, 2, 3]) → true
	 */
	public boolean splitArray(int[] nums) {
		return splitArrayHelper(0, nums, 0, 0);
	}

	public boolean splitArrayHelper(int start, int[] nums, int group1, int group2) {
		if (start >= nums.length) {
			return group1 == group2;
		}
		int num = nums[start];

		if (splitArrayHelper(start + 1, nums, group1 + num, group2)
				|| splitArrayHelper(start + 1, nums, group1, group2 + num)) {
			return true;
		}

		return false;
	}

	@Test
	public void testSplitArray() {
		int[] arr = new int[] { 2, 2 };
		boolean expected = true;
		Assert.assertTrue(expected == splitArray(arr));

		arr = new int[] { 2, 3 };
		expected = false;
		Assert.assertTrue(expected == splitArray(arr));

		arr = new int[] { 5, 2, 3 };
		expected = true;
		Assert.assertTrue(expected == splitArray(arr));
	}

	/**
	 * Given two sequences, find the length of longest subsequence present in
	 * both of them. A subsequence is a sequence that appears in the same
	 * relative order, but not necessarily contiguous. For example, “abc”,
	 * “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a
	 * string of length n has 2^n different possible subsequences.
	 */
	public int getLCS(String str1, String str2) {
		int lcs = lcs(str1, 0, str2, 0);
		return lcs;
	}

	private int lcs(String str1, int start1, String str2, int start2) {
		if ((start1 >= str1.length()) || (start2 >= str2.length())) {
			return 0;
		}
		char letter1 = str1.charAt(start1);
		char letter2 = str2.charAt(start2);

		if (letter1 == letter2) {
			return 1 + lcs(str1, start1 + 1, str2, start2 + 1);
		}
		return max(lcs(str1, start1 + 1, str2, start2), lcs(str1, start1, str2, start2 + 1));
	}

	private int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	@Test
	public void testGetLCS() {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		int expected = 3;
		int output = getLCS(str1, str2);
		Assert.assertTrue(expected == output);

		str1 = "AGGTAB";
		str2 = "GXTXAYB";
		expected = 4;
		output = getLCS(str1, str2);
		Assert.assertTrue(expected == output);
	}

}
