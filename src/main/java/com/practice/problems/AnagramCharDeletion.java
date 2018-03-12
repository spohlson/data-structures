package com.practice.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCharDeletion {

	/**
	 * Given two strings (that may or may not be of the same length) determine
	 * the minimum number of character deletions required to make them anagrams
	 * with the exact same frequency. Any characters can be deleted from either
	 * of the strings.
	 * 
	 * Ex 1. str1 = "abc" and str2 = "cdec" --> Returns 5 (chars a, b, d, e, and
	 * the extra c from str2 get deleted)
	 * 
	 * Ex 2. str1 = "balloon", str2 = "baboon" --> anagram would be "baoon".
	 * returns 3
	 */

	/**
	 * My Solution
	 */
	public int getNumOfCharDeletionsForAnagram(String str1, String str2) {
		String[] arr1 = str1.split("");
		Map<String, Integer> map1 = new HashMap<>();

		for (String letter : arr1) {
			int freq = 1;

			if (map1.containsKey(letter)) {
				freq += map1.get(letter);
			}
			map1.put(letter, freq);
		}

		String[] arr2 = str2.split("");
		Map<String, Integer> anagramMap = new HashMap<>();

		int count = 0;

		for (String letter : arr2) {

			if (map1.containsKey(letter)) {

				if (!anagramMap.containsKey(letter)) {
					anagramMap.put(letter, 1);

					count++;
				} else {
					int map1Freq = map1.get(letter);
					int anagramMapFreq = anagramMap.get(letter);

					if (map1Freq > anagramMapFreq) {
						anagramMap.put(letter, anagramMapFreq + 1);

						count++;
					}
				}
			}
		}

		int totalCount = (arr1.length - count) + (arr2.length - count);
		return totalCount;
	}

	/**
	 * HackerRank's Solution
	 */
	public static int numberNeeded(String first, String second) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < first.length(); i++) {
			if (map.get(first.charAt(i)) == null) {
				map.put(first.charAt(i), 1);
			} else {
				int cur = map.get(first.charAt(i));
				map.put(first.charAt(i), cur + 1);
			}
		}
		for (int i = 0; i < second.length(); i++) {
			if (map.containsKey(second.charAt(i))) {
				int cur = map.get(second.charAt(i));
				if (cur == 1) {
					map.remove(second.charAt(i));
				} else {
					map.put(second.charAt(i), cur - 1);
				}
			} else {
				count++;
			}
		}

		for (Integer i : map.values()) {
			count = count + i;
		}

		return count;
	}

	public void testAnagramCharDeletions(String str1, String str2, int expectedDeletions) {
		int num = getNumOfCharDeletionsForAnagram(str1, str2);
		Assert.assertTrue(expectedDeletions == num);
	}

	@Test
	public void tests() {
		testAnagramCharDeletions("abcd", "cdcdcd", 6);
		testAnagramCharDeletions("balloon", "baboon", 3);
		testAnagramCharDeletions("abcd", "efgh", 8);
		testAnagramCharDeletions("stressed", "desserts", 0);
		testAnagramCharDeletions("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", 104);
	}

}
