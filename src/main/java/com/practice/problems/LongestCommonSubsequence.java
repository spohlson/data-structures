package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestCommonSubsequence {

	private static final Logger LOG = LoggerFactory.getLogger(LongestCommonSubsequence.class);

	/**
	 * Helper method
	 */
	private int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	/**
	 * Given two sequences, find the length of longest subsequence present in
	 * both of them. A subsequence is a sequence that appears in the same
	 * relative order, but not necessarily contiguous. For example, “abc”,
	 * “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a
	 * string of length n has 2^n different possible subsequences.
	 */
	public int getLCS(String str1, String str2) {
		int lcs = lcs(str1, 0, str2, 0);
		return lcs;
	}

	private int lcs(String str1, int start1, String str2, int start2) {
		if ((start1 >= str1.length()) || (start2 >= str2.length())) {
			return 0;
		}
		char letter1 = str1.charAt(start1);
		char letter2 = str2.charAt(start2);

		if (letter1 == letter2) {
			return 1 + lcs(str1, start1 + 1, str2, start2 + 1);
		}
		return max(lcs(str1, start1 + 1, str2, start2), lcs(str1, start1, str2, start2 + 1));
	}

	@Test
	public void testGetLCS() {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		int expected = 3;
		int output = getLCS(str1, str2);
		Assert.assertTrue(expected == output);

		str1 = "AGGTAB";
		str2 = "GXTXAYB";
		expected = 4;
		output = getLCS(str1, str2);
		Assert.assertTrue(expected == output);
	}

	/**
	 * Get the LCS using memoization
	 */
	public int getLCSMemoization(String str1, String str2) {
		// Build this out using a Trie (like a binary tree for a dictionary but
		// with the subsequences)
		return 0;
	}

	/**
	 * Get the LCS using tabulation
	 */
	public int getLCSTabulation(String str1, String str2) {
		char[][] tab = new char[str1.length() + 1][str2.length() + 1];

		return 0;
	}

	// private char getLCSTab(char[][] tab, String str1, int start1, String
	// str2, int start2) {
	//
	// }

	/**
	 * Print the longest common subsequence
	 */
	public String printLCS(String str1, String str2) {
		return "";
	}

	@Test
	public void testPrintLCS() {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		String expected = "ADH";
		String output = printLCS(str1, str2);
		Assert.assertTrue(expected.equals(output));

		str1 = "AGGTAB";
		str2 = "GXTXAYB";
		expected = "GTAB";
		Assert.assertTrue(expected.equals(output));
	}

}
