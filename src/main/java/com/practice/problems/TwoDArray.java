package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class TwoDArray {

	/**
	 * Given a 6x6 2D array, A:
	 * 
	 * 1 1 1 0 0 0
	 * 0 1 0 0 0 0
	 * 1 1 1 0 0 0
	 * 0 0 0 0 0 0
	 * 0 0 0 0 0 0
	 * 0 0 0 0 0 0
	 * 
	 * We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
	 * a b c
	 *   d
	 * e f g
	 * 
	 * There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.
	 * 
	 * Task: Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
	 */

	public int getMaxHourGlassSum(int[][] arr) {
		int[] topRow = arr[0];

		int numOfColumns = topRow.length;
		int numOfRows = arr.length;

		if ((numOfColumns < 3) || (numOfRows < 3)) {
			throw new IllegalArgumentException("2D array must have at least 3 columns and 3 rows");
		}

		int maxSum = -Integer.MAX_VALUE;

		int[] row = arr[1];

		for (int i = 1; i < (numOfRows - 1); i++) {
			int[] bottomRow = arr[i + 1];

			for (int j = 1; j < (numOfColumns - 1); j++) {
				int sum = topRow[j - 1] + topRow[j] + topRow[j + 1] + row[j] + bottomRow[j - 1]
						+ bottomRow[j] + bottomRow[j + 1];

				if (sum > maxSum) {
					maxSum = sum;
				}
			}

			topRow = row;
			row = bottomRow;
		}

		System.out.println(maxSum);
		return maxSum;
	}

	@Test
	public void test() {
		int[][] arr = new int[5][4];

		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[0][2] = 1;
		arr[0][3] = 0;

		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[1][2] = 0;
		arr[1][3] = 0;

		arr[2][0] = 1;
		arr[2][1] = 0;
		arr[2][2] = 1;
		arr[2][3] = 0;

		arr[3][0] = 0;
		arr[3][1] = 0;
		arr[3][2] = 0;
		arr[3][3] = 0;

		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = 0;

		int expected = 5;

		int output = getMaxHourGlassSum(arr);

		Assert.assertTrue(expected == output);
	}

	@Test
	public void test1() {
		int[][] arr = new int[6][6];

		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[0][2] = 1;
		arr[0][3] = 0;
		arr[0][4] = 0;
		arr[0][5] = 0;

		arr[1][0] = 0;
		arr[1][1] = 1;
		arr[1][2] = 0;
		arr[1][3] = 0;
		arr[1][4] = 0;
		arr[1][5] = 0;

		arr[2][0] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		arr[2][3] = 0;
		arr[2][4] = 0;
		arr[2][5] = 0;

		arr[3][0] = 0;
		arr[3][1] = 0;
		arr[3][2] = 2;
		arr[3][3] = 4;
		arr[3][4] = 4;
		arr[3][5] = 0;

		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = 2;
		arr[4][4] = 0;
		arr[4][5] = 0;

		arr[5][0] = 0;
		arr[5][1] = 0;
		arr[5][2] = 1;
		arr[5][3] = 2;
		arr[5][4] = 4;
		arr[5][5] = 0;

		int expected = 19;

		int output = getMaxHourGlassSum(arr);

		Assert.assertTrue(expected == output);
	}
}
