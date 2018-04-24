package com.practice.problems;

import org.junit.Test;

public class CheckNeighbors {

	/*
	 * 
	 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
	 * 
	 * word = "ABCCED", -> returns true, word = "SEE", -> returns true, word =
	 * "ABCB", -> returns false.
	 * 
	 * 
	 * 
	 * To execute Java, please define "static void main" on a class named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 * 
	 * 
	 * - traversing the board to determine if the first letter exists. - nested for
	 * loops - if board[row][col] = word[0] call my helper method (board, word, row,
	 * col, 1, visited)
	 * 
	 * return false
	 * 
	 * if (board[row + 1][col] === word[idxPtr)) checkNeighbors(board, word, row +
	 * 1, col, idxPtr + 1, visited)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// public boolean boardContainsWord1(char[][] board, String word) {
	// int numOfColumns = board[0].length;
	// int numOfRows = board.length;
	// int wordLen = word.length();

	// if ((numOfRows * numOfColumns) < wordLen) {
	// return false;
	// }
	// char[] topRow = board[0];

	// char[] row = board[1];

	// for (int i = 1; i < numOfRows; i++) {
	// char[] bottomRow = board[i + 1];

	// int letterIndex = 0;
	// char letter = row[letterIndex];

	// int wordIndex = 0;

	// if (letter == word.charAt(wordIndex)) {
	// char nextLetter = row[letterIndex + 1];

	// if (nextLetter == word.charAt(wordIndex + 1)) {

	// }
	// }

	// }

	// }

	public boolean equalsChar(char one, char two) {
		return one == two;
	}

	public boolean boardContainsWord(char[][] board, String word) {
		int numOfColumns = board[0].length;
		int numOfRows = board.length;
		int wordLen = word.length();

		if ((numOfRows * numOfColumns) < wordLen) {
			return false;
		}
		boolean containsWord = false;

		char[] wordChars = word.toCharArray();

		for (int i = 0; i < numOfRows; i++) {
			char[] row = board[i];

			for (int q = 0; q < row.length; q++) {
				char letter = row[q];

				int wordIndex = 0;

				while (wordIndex < (wordLen - 1)) {
					char wordChar = word.charAt(wordIndex);

					if (equalsChar(wordChar, letter)) {
						// check right;
						char right = row[q + 1];

						if (right == word.charAt(wordIndex + 1)) {
							wordIndex++;

						}
					}
				}

				for (char wordChar : wordChars) {
					if (equalsChar(wordChar, letter)) {
						// check right;
						letter = row[q + 1];
					}
				}
			}

			// System.out.println("Char at row " + i + ": " + letter);
			//
			// char below = board[i + 1][letterIndex];
			// char above = board[i - 1][letterIndex];
			// char left = row[letterIndex - 1];
			// char right = row[letterIndex + 1];

		}
		return containsWord;
	}

	@Test
	public void test() {

		// board =
		// [
		// ['A','B','C','E'],
		// ['S','F','C','S'],
		// ['A','D','E','E']
		// ]
		char[][] board = new char[3][4];

		board[0][0] = 'A';
		board[0][1] = 'B';
		board[0][2] = 'C';
		board[0][3] = 'E';

		board[1][0] = 'S';
		board[1][1] = 'F';
		board[1][2] = 'C';
		board[1][3] = 'S';

		board[2][0] = 'A';
		board[2][1] = 'D';
		board[2][2] = 'E';
		board[2][3] = 'E';

		String word = "AFCS";

		boolean containsWord = boardContainsWord(board, word);

		System.out.println("Success: " + containsWord);
	}

}
