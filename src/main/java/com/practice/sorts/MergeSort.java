package com.practice.sorts;

import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

	/**
	 * Pros - Fast runtime. Always O(nlogn)
	 * 
	 * Cons - 1. Takes up lots of memory (O(n) space) since it must copy into a
	 * temporary array. 2. Not adaptable - will have the same runtime whether
	 * array is already sorted or not.
	 * 
	 * Take array, divide by half, mergeSort(leftHalf) then mergeSort(rightHalf)
	 * then merge left & right half in sorted order
	 */

	public static void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;

		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}

	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;

		int size = (rightEnd - leftStart) + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while ((left <= leftEnd) && (right <= rightEnd)) {

			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		// only one half will have remaining elements left over to copy but just
		// copy over both sides
		System.arraycopy(array, left, temp, index, (leftEnd - left) + 1);
		System.arraycopy(array, right, temp, index, (rightEnd - right) + 1);
		// copy everything back
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}

	@Test
	public void test() {
		int[] array = new int[] { 10, 5, 2, 7, 4, 9, 12, 1, 8, 6, 11, 3 };

		mergeSort(array);

		int[] expectedArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int expected = expectedArray[i];

			Assert.assertTrue(num == expected);
		}
	}

}
