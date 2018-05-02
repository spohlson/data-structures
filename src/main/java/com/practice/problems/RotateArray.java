package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

	/**
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4]
	 */

	/**
	 * Rotate in O(1) space and O(n) time using reversal
	 * Space: O(1)
	 * Time: O(n)
	 */
	public void rotateArrByReversal(int[] arr, int k) {
		int len = arr.length;

		if (len < 2) {
			return;
		} else if (k > len) {
			k = k % len;
		} else if (k == 0) {
			return;
		} else if (k < 0) {
			k += len;
		}
		int lastIdx = len - 1;
		int firstEnd = lastIdx - k;

		reverse(arr, 0, firstEnd);
		reverse(arr, firstEnd + 1, lastIdx);
		reverse(arr, 0, lastIdx);
	}

	private void reverse(int[] arr, int start, int end) {
		if ((arr == null) || (arr.length < 2)) {
			return;
		}

		while (start < end) {
			int startNum = arr[start];
			int endNum = arr[end];

			arr[start] = endNum;
			arr[end] = startNum;

			start++;
			end--;
		}
	}

	@Test
	public void testRotateArrByReversal() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		rotateArrByReversal(nums, k);
		Assert.assertArrayEquals(expected, nums);

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		k = -2;
		expected = new int[] { 3, 4, 5, 6, 1, 2 };
		rotateArrByReversal(nums, k);
		Assert.assertArrayEquals(expected, nums);
	}

	/**
	 * Rotate by creating new array
	 * Space: O(n)
	 * Time: O(n)
	 */
	public void rotateArrCopyArr(int[] arr, int k) {
		int len = arr.length;

		if (len < 2) {
			return;
		} else if (k > len) {
			k = k % len;
		} else if (k == 0) {
			return;
		} else if (k < 0) {
			k += len;
		}

		int[] nums = new int[len];
		int idx = 0;

		for (int i = 0; i < len; i++) {
			idx = i + k;

			if (idx >= len) {
				idx = idx - len;
			}
			nums[idx] = arr[i];
		}
		System.arraycopy(nums, 0, arr, 0, len);
	}

	@Test
	public void testRotateArrCopyArr() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		rotateArrCopyArr(nums, k);
		Assert.assertArrayEquals(expected, nums);

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		k = -2;
		expected = new int[] { 3, 4, 5, 6, 1, 2 };
		rotateArrCopyArr(nums, k);
		Assert.assertArrayEquals(expected, nums);
	}

	/**
	 * Rotate in O(1) space
	 * Hint: bubble sort-like
	 * 
	 * Space: O(1)
	 * Time: O(n * k)
	 */
	public void rotateArrInPlace(int[] arr, int k) {
		int len = arr.length;

		if (len < 2) {
			return;
		} else if (k > len) {
			k = k % len;
		} else if (k == 0) {
			return;
		} else if (k < 0) {
			k += len;
		}
		int i = 0;

		while (i < k) {

			for (int j = len - 1; j > 0; j--) {
				int num = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = num;
			}
			i++;
		}
	}

	@Test
	public void testRotateArrInPlace() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] expected = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		rotateArrInPlace(nums, k);
		Assert.assertArrayEquals(expected, nums);

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		k = -2;
		expected = new int[] { 3, 4, 5, 6, 1, 2 };
		rotateArrInPlace(nums, k);
		Assert.assertArrayEquals(expected, nums);
	}

}
