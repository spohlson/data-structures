package com.practice.problems;

public class TicTacToe {

	/**
	 * Runtime Efficiency Problem
	 * 
	 * There's a tic-tac-toe board (1,000,000 X 1,000,000) made up of 2 Players
	 * (X/O). The board may or may not be completely filled up. Write a function
	 * that checks whether the specified Player has won tic-tac-toe.
	 * 
	 * Note: The typical solution of traversal is extremely expensive so think
	 * of a way to make it more efficient.
	 * 
	 * 
	 * Interviewing.io interviewer's solution: Using bit strings
	 * 
	 * Create 2 bit strings initialized all to true/false or 1/0 b
	 * 
	 * Do a single pass over every square
	 */

	private char[][] board;

	public TicTacToe(char[][] board) {
		this.board = board;
	}

	public boolean isWon() {
		return !(checkRows() && checkColumns() && checkDiagonally());
	}

	private boolean checkRows() {
		int len = board[0].length;

		for (int i = 0; i < len; i++) {
			char[] row = board[i];
			int count = 0;

			for (char letter : row) {

				if (letter == 'X') {
					count++;
				}
			}

			if ((count == 0) || (count == len)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkColumns() {
		int len = board[0].length;

		for (int i = 0; i < len; i++) {
			int count = 0;

			for (int j = 0; j < len; j++) {
				char letter = board[j][i];

				if (letter == 'X') {
					count++;
				}
			}

			if ((count == 0) || (count == len)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDiagonally() {
		int len = board[0].length;
		int countOne = 0;
		int countTwo = 0;

		for (int i = 0; i < len; i++) {
			char letter = board[i][i];

			if (letter == 'X') {
				countOne++;
			}

			letter = board[i][len - 1 - i];

			if (letter == 'X') {
				countTwo++;
			}
		}

		if ((countOne == 0) || (countOne == len) || (countTwo == 0) || (countTwo == len)) {
			return false;
		}
		return true;
	}

}
