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

	private Player[][] board;

	public class Player {

		private int userId;

		public Player(int userId) {
			if ((userId >= 2) || (userId < 0)) {
				// throw some exception
			}
			this.userId = userId;
		}

		private boolean isX() {
			return userId == 1;
		}

		private int getUserId() {
			return userId;
		}

	}

	//	public boolean isPlayerWinner(Player player) {
	//		int numOfRows = board.length;
	//		int numOfColumns = board[0].length;
	//
	//		Player[] column = board[0][0];
	//
	//		for (int i = 0; i < numOfColumns; i++) {
	//			int rowIndex = 0;
	//
	//			while (rowIndex < numOfRows) {
	//				Player[] row = board[rowIndex];
	//
	//				rowIndex++;
	//			}
	//
	//		}
	//	}

}
