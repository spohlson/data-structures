package com.practice.problems;

public class Sudoku {

	private int[][] grid;

	public Sudoku(int[][] grid) {
		this.grid = grid;
	}

	public int[][] getGrid() {
		return grid;
	}

	private boolean numInRow(int num, int rowIndex) {
		int[] row = grid[rowIndex];

		for (int rowNum : row) {
			if (rowNum == num) {
				return true;
			}
		}
		return false;
	}

	private boolean numInColumn(int num, int columnIndex) {
		int len = grid[0].length;

		for (int i = 0; i < len; i++) {
			int columnNum = grid[i][columnIndex];

			if (columnNum == num) {
				return true;
			}
		}
		return false;
	}

	private boolean numInSubGrid(int num, int startRow, int startCol) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {

				if (grid[row + startRow][col + startCol] == num) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSafe(int num, int row, int col) {
		return !numInRow(num, row) && !numInColumn(num, col)
				&& !numInSubGrid(num, row - (row % 3), col - (col % 3));
	}

	public boolean solve() {
		for (int row = 0; row < grid.length; row++) {

			for (int col = 0; col < grid.length; col++) {
				int num = grid[row][col];

				if (num == 0) {
					int k = 1;

					while (k < 10) {

						if (isSafe(k, row, col)) {
							grid[row][col] = k;

							if (!solve()) {
								grid[row][col] = 0;
							} else {
								return true;
							}
						}
						k++;
					}
					return false;
				}
			}
		}
		return true;
	}

	public void printGrid(int[][] sudoku) {
		for (int[] element : sudoku) {

			for (int col = 0; col < (sudoku.length); col++) {
				System.out.printf("%2d ", element[col]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] grid = new int[9][9];
		grid[0][7] = 1;
		grid[0][8] = 2;
		grid[2][3] = 6;
		grid[1][4] = 3;
		grid[1][5] = 5;
		grid[2][7] = 7;
		grid[3][0] = 7;
		grid[3][6] = 3;
		grid[4][3] = 4;
		grid[4][6] = 8;
		grid[5][0] = 1;
		grid[6][3] = 1;
		grid[6][4] = 2;
		grid[7][1] = 8;
		grid[7][7] = 4;
		grid[8][1] = 5;
		grid[8][6] = 6;

		Sudoku sud = new Sudoku(grid);
		// sud.solve();
		// int[][] output = sud.getGrid();
		// sud.printGrid(output);

		int[][] expected = new int[][] { { 67, 3, 8, 9, 4, 5, 1, 2 }, { 9, 1, 2, 7, 3, 5, 4, 8, 6 },
			{ 8, 4, 5, 6, 1, 2, 9, 7, 3 }, { 7, 9, 8, 2, 6, 1, 3, 5, 4 },
			{ 5, 2, 6, 4, 7, 3, 8, 9, 1 }, { 1, 3, 4, 5, 8, 9, 2, 6, 7 },
			{ 4, 6, 9, 1, 2, 8, 7, 3, 5 }, { 2, 8, 7, 3, 5, 6, 1, 4, 9 },
			{ 3, 5, 1, 9, 4, 7, 6, 2, 8 } };

			sud.printGrid(expected);

			// for (int i = 0; i < output.length; i++) {
			// int[] outputRow = output[i];
			// int[] expectedRow = expected[i];
			//
			// if (!expectedRow.equals(outputRow)) {
			// throw new RuntimeException("Failed to fill sudoku grid
			// successfully");
			// }
			// }
	}

}
