package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RansomNote {

	/**
	 * A kidnapper wrote a ransom note but is worried it will be traced back to
	 * him. He found a magazine and wants to know if he can cut out whole words
	 * from it and use them to create an untraceable replica of his ransom note.
	 * The words in his note are case-sensitive and he must use whole words
	 * available in the magazine, meaning he cannot use substrings or
	 * concatenation to create the words he needs.
	 * 
	 * Given the words in the magazine and the words in the ransom note, print
	 * Yes if he can replicate his ransom note exactly using whole words from
	 * the magazine; otherwise, print No.
	 * 
	 * Input Format: The first line contains two space-separated integers
	 * describing the respective values of m (the number of words in the
	 * magazine) and n (the number of words in the ransom note). The second line
	 * contains m space-separated strings denoting the words present in the
	 * magazine. The third line contains n space-separated strings denoting the
	 * words present in the ransom note.
	 * 
	 * Constraints:
	 * 1 <= m, n <= 30000
	 * 1 <= length of any word <= 5
	 * Each words consists of English alphabetic letters
	 * The words in the note and magazine are case-sensitive
	 * -------------------------------
	 * Sample Input 1:
	 * 6 4
	 * give me one grand today night
	 * give one grand today
	 * 
	 * Output 1: Yes
	 * -------------------------------
	 * Sample Input 2:
	 * 6 5
	 * two times three is not four
	 * two times two is four
	 * 
	 * Output 2: No
	 */

	public boolean canCreateRansomNote(String[] ransom, String[] magazine) {
		Map<String, Integer> ransomMap = new HashMap<>();

		for (String word : ransom) {
			int freq = (ransomMap.containsKey(word) ? ransomMap.get(word) : 0) + 1;
			ransomMap.put(word, freq);
		}

		for (String word : magazine) {

			if (ransomMap.containsKey(word)) {
				int freq = ransomMap.get(word);

				if (freq > 1) {
					ransomMap.put(word, freq - 1);
				} else {
					ransomMap.remove(word);
				}
			}
		}

		boolean result = ransomMap.isEmpty();
		System.out.println((result ? "Yes" : "No"));
		return result;
	}

	public void testCanCreateRansomNote(String ransom, String magazine, boolean expectedBool) {
		String[] ransomArr = ransom.split("\\s");
		String[] magazineArr = magazine.split("\\s");
		boolean result = canCreateRansomNote(ransomArr, magazineArr);
		Assert.assertTrue(expectedBool == result);
	}

	@Test
	public void tests() {
		testCanCreateRansomNote("give one grand today", "give one grand today night", true);
		testCanCreateRansomNote("two times two is four", "two times three is not four", false);
		testCanCreateRansomNote("Give me the money or I send the email",
				"Give me money or I send the email", false);
		testCanCreateRansomNote("Give me the money or I send the email",
				"email the the Give send I money or me", true);
	}

}
