package com.datastructures.problems;

import java.util.Scanner;

public class LeftRotationArrayOperation {

	/**
	 * A left rotation operation on an array of size n shifts each of the
	 * array's elements 1 unit to the left. For example, if 2 left rotations are
	 * performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5,
	 * 1, 2].
	 * 
	 * Given an array of n integers and a number, d, perform d left rotations on
	 * the array. Then print the updated array as a single line of
	 * space-separated integers.
	 * 
	 * Input Format:
	 * The first line contains two space-separated integers
	 * denoting the respective values of n (the number of integers) and d (the
	 * number of left rotations you must perform). The second line contains n
	 * space-separated integers describing the respective elements of the
	 * array's initial state.
	 * 
	 * Output Format:
	 * Print a single line of n space-separated integers denoting the final
	 * state of the array after performing d left rotations.
	 * 
	 * Sample Input:
	 * > 5 4
	 * > 1 2 3 4 5
	 * 
	 * Sample Output:
	 * > 5 1 2 3 4
	 * 
	 * Constraints:
	 * 1 <= n <= 10^5
	 * 1 <= d <= n
	 */

	public int[] rotateArrayLeftNewArray(int[] items, int left) {
		int len = items.length;

		if ((len == 0) || (left <= 0) || (left > len)) {
			throw new IllegalArgumentException("Invalid parameters");
		}

		int[] leftArray = new int[len];

		int base = len - left;

		for (int i = 0; i < len; i++) {
			int newIdx = base + i;

			if (newIdx >= len) {
				newIdx = newIdx - len;
			}

			leftArray[newIdx] = items[i];
		}

		System.out.print(leftArray);

		return leftArray;
	}

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int sizeOfArray = in.nextInt();
		// int numToRotateLeft = in.nextInt();
		// make the array of the inputed elements
		// int[] array = new int[sizeOfArray];
		// for (int i = 0; i < sizeOfArray; i++) {
		// array[i] = in.nextInt();
		// }

		int numToRotateLeft = 4;
		int[] array = new int[] { 1, 2, 3, 4, 5 };

		LeftRotationArrayOperation app = new LeftRotationArrayOperation();
		int[] rotatedArray = app.rotateArrayLeftNewArray(array, numToRotateLeft);

		// for (int item : rotatedArray) {
		// System.out.print(item + " ");
		// }
	}

	/**
	 * My Solution on HackerRank Solution
	 */

	public static class Solution {

		private int[] rotateArrayLeft(int[] items, int left) {
			int len = items.length;

			if ((len == 0) || (left <= 0) || (left > len)) {
				throw new IllegalArgumentException("Invalid parameters");
			}

			int[] leftArray = new int[len];

			int base = len - left;

			for (int i = 0; i < len; i++) {
				int newIdx = base + i;

				if (newIdx >= len) {
					newIdx = newIdx - len;
				}

				leftArray[newIdx] = items[i];
			}

			return leftArray;
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}

			Solution sol = new Solution();

			int[] rotatedArray = sol.rotateArrayLeft(a, k);

			for (int item : rotatedArray) {
				System.out.print(item + " ");
			}
		}
	}

}
