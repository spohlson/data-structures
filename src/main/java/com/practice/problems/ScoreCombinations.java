package com.practice.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreCombinations {

	private static final Logger LOG = LoggerFactory.getLogger(ScoreCombinations.class);

	/**
	 * Write a program that takes a final score and scores for individual plays,
	 * and returns the number of combinations of plays that result in the final
	 * score.
	 * 
	 * Example: Football points ( 2 - safety, 3 - field goal, 7 - touchdown)
	 * 
	 * final score: 12
	 * 
	 * Combinations: 4
	 * 
	 * 1. 6 safeties (2 x 6)
	 * 2. 3 safeties, 2 field goals (2 x 3 + 3 x 2)
	 * 3. 1 safety, 1 field goal, 1 touchdown (2 + 3 + 7)
	 * 4. 4 field goals (3 x 4)
	 * 
	 * Input: countCombos(12, {2, 3, 7})
	 * Output: 4
	 */
	public int countCombos(int[] points, int score) {
		int[] table = new int[score + 1];

		Arrays.fill(table, 0);

		// base case (if given score is 0)
		table[0] = 1;

		// pick points one by one and update the table[] values after the index
		// is >= the value of the score
		for (int point : points) {
			for (int j = point; j <= score; j++) {
				int prev = table[j - point];
				int cur = table[j];
				table[j] = prev + cur;
			}
		}
		LOG.info("{}", table);
		return table[score];
	}

	@Test
	public void testCountWays() {
		int[] points = { 1, 2, 3 };
		int finalScore = 4;
		int output = countCombos(points, finalScore);
		int expected = 4;
		Assert.assertTrue(expected == output);

		points = new int[] { 2, 3, 7 };
		finalScore = 12;
		output = countCombos(points, finalScore);
		Assert.assertTrue(expected == output);
	}

}
