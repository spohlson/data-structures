package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicTacToeBool {

	private static final Logger LOG = LoggerFactory.getLogger(TicTacToeBool.class);

	private static final char EMPTY_CHAR = '\u0000';

	public boolean isWonInts(char[][] board) {
		int len = board[0].length;

		Map<Integer, Integer> rows = new HashMap<>(len);
		Map<Integer, Integer> cols = new HashMap<>(len);

		int leftDiag = 0;
		int rightDiag = 0;

		int ldColIndex = 0;
		int ldRowIndex = 0;

		int rdColIndex = len - 1;
		int rdRowIndex = 0;

		for (int row = 0; row < len; row++) {

			if (!rows.containsKey(row)) {
				rows.put(row, 0);
			}
			int rowCount = rows.get(row);

			for (int col = 0; col < len; col++) {

				if (!cols.containsKey(col)) {
					cols.put(col, 0);
				}
				char letter = board[row][col];
				int val = getVal(letter, len);

				int colCount = cols.get(col);
				cols.put(col, colCount += val);

				if ((row == ldRowIndex) && (col == ldColIndex)) {
					leftDiag += val;
					ldColIndex++;
				} else if ((row == rdRowIndex) && (col == rdColIndex)) {
					rightDiag += val;
					rdColIndex--;
				}
				rowCount += val;
			}
			rows.put(row, rowCount);
		}

		if (won(leftDiag, len) || won(rightDiag, len)) {
			return true;
		}

		for (int row : rows.keySet()) {
			int count = rows.get(row);

			if (won(count, len)) {
				return true;
			}
		}

		for (int col : cols.keySet()) {
			int count = cols.get(col);

			if (won(count, len)) {
				return true;
			}
		}

		return false;
	}

	private boolean won(int count, int boardLen) {
		return ((count == 0) || (count == boardLen));
	}

	private int getVal(char letter, int boardLen) {
		return (letter == EMPTY_CHAR) ? boardLen + 1 : ((letter == 'X') ? 1 : 0);
	}

	@Test
	public void testIsWonInts() {
		char[][] grid = new char[][] { { EMPTY_CHAR, EMPTY_CHAR, 'X' }, { EMPTY_CHAR, 'X', 'O' },
			{ 'X', EMPTY_CHAR, 'O' } };
			boolean expected = true;
			boolean output = isWonInts(grid);
			Assert.assertTrue(expected == output);

			//		grid = new char[][] { {}, {}, {} };
	}

	@Test
	public void test1() {
		String bit = "01";
		String nullStr = null;
		bit += nullStr;
		LOG.info("{}", bit);
	}

	@Test
	public void test() {
		// char[][] grid = new char[3][3];
		// char letter = grid[0][0];
		// int a = 0b01010111;
		// int b = 0b11111111;

		String input = "1010";

		// Use as radix 2 because it's binary
		int number = Integer.parseInt(input, 2);
		LOG.info("#: {}", number);
	}

}
