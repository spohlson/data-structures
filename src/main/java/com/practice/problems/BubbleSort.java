package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {

	/**
	 * Given an n-element array of distinct elements sort the array in ascending
	 * order using the Bubble Sort algorithm provided. Once sorted, print the
	 * following:
	 * 
	 * 1. "Array is sorted in numSwaps swaps." - where numSwaps is the number of
	 * swaps that took place.
	 * 
	 * 2. "First Element: firstElement" where firstElement is the first element
	 * in the sorted array.
	 * 
	 * 3. "Last Element: lastElement" where lastElement is the last element in
	 * the sorted array.
	 * 
	 * Hint: To complete this challenge, you must add a variable that keeps a
	 * running tally of all swaps that occur during execution.
	 * 
	 * Input Format - The first line contains an integer, n, denoting the # of
	 * elements in array. The second line contains n space-separated integers
	 * describing the respective values of array.
	 * 
	 * Sample Input:
	 * 
	 * 3
	 * 3 2 1
	 * 
	 * Sample Output:
	 * 
	 * Array is sorted in 3 swaps.
	 * First Element: 1
	 * Last Element: 3
	 */

	/**
	 * Provided bubble sort method:
	 * 
	 * for (int i = 0; i < n; i++) {
	 * 		for (int j = 0; j < n - 1; j++) {
	 * 			if (a[j] > a[j + 1]) {
	 * 				swap(a[j], a[j + 1]);
	 * 			}
	 * 		}
	 * }
	 */
	public int bubbleSortReturnNumOfSwaps(int[] arr) {
		int len = arr.length;
		int swaps = 0;

		for (int i = 0; i < len; i++) {

			for (int j = 0; j < (len - 1); j++) {

				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swaps++;
				}
			}
		}
		return swaps;
	}

	private void swap(int[] arr, int idxOne, int idxTwo) {
		int numOne = arr[idxOne];
		int numTwo = arr[idxTwo];

		arr[idxOne] = numTwo;
		arr[idxTwo] = numOne;
	}

	@Test
	public void test() {
		int[] arr = new int[] { 3, 2, 1 };
		int swaps = bubbleSortReturnNumOfSwaps(arr);
		Assert.assertTrue(swaps == 3);
		Assert.assertTrue(arr[0] == 1);
		Assert.assertTrue(arr[2] == 3);
	}

	@Test
	public void test1() {
		int[] arr = new int[] { 3, 2, 1 };
		int swaps = bubbleSortReturnNumOfSwaps(arr);
		System.out.println("Array is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + arr[0]);
		System.out.println("Last Element: " + arr[arr.length - 1]);
	}

	/**
	 * Bubble Sort Array
	 */
	public void bubbleSort(int[] arr) {
		int len = arr.length;
		int count = len;

		while (count > 0) {

			for (int i = 0; i < (count - 1); i++) {
				int num = arr[i];
				int next = arr[i + 1];

				if (num > next) {
					arr[i] = next;
					arr[i + 1] = num;
				}
			}
			count--;
		}
	}

	@Test
	public void testBubbleSort() {
		int[] arr = new int[] { 5, 4, 3, 2, 1 };
		int[] expected = new int[] { 1, 2, 3, 4, 5 };
		bubbleSort(arr);
		Assert.assertArrayEquals(expected, arr);
	}

}
