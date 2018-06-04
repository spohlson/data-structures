package com.practice.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindElectionWinner {

	/**
	 * Find winner of an election where votes are represented as candidate names
	 * Given an array of names of candidates in an election. A candidate name in
	 * array represents a vote casted to the candidate. Print the name of
	 * candidates received Max vote. If there is tie, print lexicographically
	 * (alphabetically) smaller name.
	 * 
	 * Input : votes[] = {"john", "johnny", "jackie", "johnny", "john",
	 * "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
	 * 
	 * Output : John
	 */

	public String getWinner(String[] votes) {
		if (votes.length == 0) {
			return null;
		}
		Map<String, Integer> freqMap = new HashMap<>();
		int maxFreq = 0;

		for (String vote : votes) {
			int freq = freqMap.containsKey(vote) ? (freqMap.get(vote) + 1) : 1;
			freqMap.put(vote, freq);

			if (freq > maxFreq) {
				maxFreq = freq;
			}
		}
		List<String> winners = new ArrayList<>();

		for (String candidate : freqMap.keySet()) {
			int freq = freqMap.get(candidate);

			if (freq == maxFreq) {
				winners.add(candidate);
			}
		}
		Collections.sort(winners);
		String winner = winners.get(0);
		return winner;
	}

	@Test
	public void test() {
		String[] votes = new String[] { "john", "johnny", "jackie", "johnny", "john", "jackie",
				"jamie", "jamie", "john", "johnny", "jamie", "johnny", "john" };
		String expected = "john";
		String output = getWinner(votes);
		Assert.assertTrue(expected == output);
	}

}
