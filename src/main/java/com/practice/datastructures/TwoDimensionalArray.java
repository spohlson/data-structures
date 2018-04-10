package com.practice.datastructures;

import org.junit.Test;

public class TwoDimensionalArray {

	/**
	 * A 2-dimensional array is really an array of arrays.
	 */

	public void twoDArray() {
		int numOfRows = 3;
		int numOfColumns = 4;

		// create a 2D array with 3 rows and 4 columns
		// 0 --> [0][0][0][0]
		// 1 --> [0][0][0][0]
		// 2 --> [0][0][0][0]
		//		  0  1  2  3
		int[][] grid = new int[numOfRows][numOfColumns];

		// insert 3 in row 2 column 3
		// 0 --> [0][0][0][0]
		// 1 --> [0][0][0][0]
		// 2 --> [0][0][0][3]
		//		  0  1  2  3
		grid[2][3] = 3;

		// Getting length of grid represents the # of rows
		int numOfRowsInGrid = grid.length;

		// To get the # of columns grab the length of any row
		int numOfColumnsInGrid = grid[0].length;
	}

	public int[][] createTwoDArray(int numOfRows, int numOfColumns) {
		int[][] grid = new int[numOfRows][numOfColumns];
		return grid;
	}

	@Test
	public void test() {
		twoDArray();
	}

	@Test
	public void test1() {
		int[][] grid = createTwoDArray(3, 3);
		grid[0][0] = 0;
		grid[0][1] = 1;
		grid[0][2] = 2;
		grid[1][0] = 3;
		grid[1][1] = 4;
		grid[1][2] = 5;
		grid[2][0] = 6;
		grid[2][1] = 7;
		grid[2][2] = 8;

		System.out.print("");
	}

	@Test
	public void test2() {
		int[][] grid = createTwoDArray(6, 6);

		grid[0][0] = 1;
		grid[0][1] = 1;
		grid[0][2] = 1;
		grid[0][3] = 0;
		grid[0][4] = 0;
		grid[0][5] = 0;

		grid[1][0] = 0;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[1][3] = 0;
		grid[1][4] = 0;
		grid[1][5] = 0;

		grid[2][0] = 1;
		grid[2][1] = 1;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[2][4] = 0;
		grid[2][5] = 0;

		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 0;
		grid[3][4] = 0;
		grid[3][5] = 0;

		grid[4][0] = 0;
		grid[4][1] = 0;
		grid[4][2] = 0;
		grid[4][3] = 0;
		grid[4][4] = 0;
		grid[4][5] = 0;

		grid[5][0] = 0;
		grid[5][1] = 0;
		grid[5][2] = 0;
		grid[5][3] = 0;
		grid[5][4] = 0;
		grid[5][5] = 0;
	}
}
