package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class FindElementInCircularlySortedArray {

	/**
	 * A circularly sorted array is a sorted array that has been rotated.
	 * 
	 * Ex. [ 12, 14, 18, 21, 3, 6, 8, 9 ]
	 * 
	 * In the above example you can see that the head number (3) has been
	 * rotated to the right from index 0 to index 4 while the tail number now
	 * sits at index 3.
	 * 
	 * Linear search - O(n)
	 * Binary search - O(log n)
	 */

	// [ 12, 14, 18, 21, 3, 6, 8, 9 ]
	//    0   1   2   3  4  5  6  7
	public int getIndexOfElementInArray(int[] arr, int element) {
		int len = arr.length;

		if (len == 0) {
			return -1;
		}
		int low = 0;
		int lowNum = arr[low];

		int high = len - 1;
		int highNum = arr[high];

		int mid = (len / 2) - 1;
		int midNum = arr[mid];

		if (element == midNum) {
			return mid;
		}
		int index = -1;

		if (midNum <= highNum) {
			// right half is sorted

			if ((element > midNum) && (element <= highNum)) {
				// element exists in the right half
				// binary search
				low = mid + 1;

			} else {
				// go search in the unsorted left half
				high = mid - 1;

			}
		} else {
			// left half is sorted

			if ((element < midNum) && (element >= lowNum)) {
				// element exists in the left half
				// binary search
				high = mid - 1;

			} else {
				// go search in the unsorted right half
				low = mid + 1;

			}
		}
		return index;
	}

	public int circularArraySearch(int[] arr, int arrLen, int x) {
		int low = 0;
		int high = arrLen - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int midNum = arr[mid];

			if (x == midNum) {
				return mid;
			}
			int highNum = arr[high];
			int lowNum = arr[low];

			if (midNum <= highNum) {
				// right half is sorted
				if ((x > midNum) && (x <= highNum)) {
					// x exists here
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// left half is sorted
				if ((x < midNum) && (x >= lowNum)) {
					// x exists here
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	@Test
	public void test() {
		int[] arr = new int[] { 12, 14, 18, 21, 3, 6, 8, 9 };
		int element = 8;
		int expected = 6;
		int output = getIndexOfElementInArray(arr, element);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void test1() {
		int[] arr = new int[] { 12, 14, 18, 21, 3, 6, 8, 9 };
		int element = 8;
		int expected = 6;
		int output = circularArraySearch(arr, arr.length, element);
		Assert.assertTrue(expected == output);
	}

}
