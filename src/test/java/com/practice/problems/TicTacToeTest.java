package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void test() {
		char[][] board = new char[][] { { 'O', 'X', 'O' }, { 'X', 'X', 'X' }, { 'O', 'O', 'X' } };
		TicTacToe ttt = new TicTacToe(board);
		boolean output = ttt.isWon();
		Assert.assertTrue(output);
	}

}
