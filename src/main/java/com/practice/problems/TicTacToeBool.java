package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicTacToeBool {

	private static final Logger LOG = LoggerFactory.getLogger(TicTacToeBool.class);

	private char[][] board;

	public TicTacToeBool(char[][] board) {
		this.board = board;
	}

	public boolean isWon() {
		int len = board[0].length;

		Map<Integer, String> rows = new HashMap<>(len);
		Map<Integer, String> cols = new HashMap<>(len);
		Map<Integer, String> diags = new HashMap<>(2);

		for (int row = 0; row < len; row++) {

			for (int col = 0; col < len; col++) {
				char letter = board[row][col];
				// String bit =

				if (rows.containsKey(row)) {

				}
			}
		}
		return false;
	}

	public char[][] createBoard() {
		char[][] grid = new char[3][3];
		return grid;
	}

	@Test
	public void test() {
		char[][] grid = new char[3][3];
		LOG.info("Grid");
	}

}
