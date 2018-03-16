package com.practice.problems;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class SortingComparator {

	/**
	 * Comparators are used to compare two objects. In this challenge, you'll
	 * create a comparator and use it to sort an array. The Player class is
	 * provided in the editor below; it has two fields: A string (name) and an
	 * integer (score).
	 * 
	 * Given an array of n Player objects, write a comparator that sorts them in
	 * order of decreasing score; if 2 or more players have the same score, sort
	 * those players alphabetically by name. To do this, you must create a
	 * Checker class that implements the Comparator interface, then write an int
	 * compare(Player a, Player b) method implementing the Comparator.compare(T
	 * o1, T o2) method.
	 * 
	 * Input Format: Locked stub code in the Solution class handles the
	 * following input from stdn: the first line contains an integer, n,
	 * denoting the # of players. Each of the n subsequent lines contains a
	 * player's respective name and score.
	 * 
	 * Constraints:
	 * 
	 * 0 <= score <= 1000
	 * Two or more players can have the same name.
	 * Player names consist of lowercase English alphabetic letters.
	 * 
	 * Sample Input:
	 * 5
	 * amy 100
	 * david 100
	 * heraldo 50
	 * aakansha 75
	 * aleksa 150
	 * 
	 * Sample Output:
	 * aleksa 150
	 * amy 100
	 * david 100
	 * aakansha 75
	 * heraldo 50
	 */

	public class Checker implements Comparator<Player> {

		@Override
		public int compare(Player player1, Player player2) {
			int score1 = player1.getScore();
			int score2 = player2.getScore();

			if (score1 < score2) {
				return 1;
			} else if (score1 > score2) {
				return -1;
			}
			String name1 = player1.getName();
			String name2 = player2.getName();

			return name1.compareTo(name2);
		}

	}

	public class Player {

		private String name;
		private int score;

		public Player(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

	}

	public void sortPlayers(Player[] players) {
		Checker checker = new Checker();

		Arrays.sort(players, checker);

		for (Player player : players) {
			System.out.printf("%s %s\n", player.name, player.score);
		}
	}

	@Test
	public void test() {
		Player amy = new Player("amy", 100);
		Player david = new Player("david", 100);
		Player heraldo = new Player("heraldo", 50);
		Player aakansha = new Player("aakansha", 75);
		Player aleksa = new Player("aleksa", 150);

		Player[] players = new Player[] { amy, david, heraldo, aakansha, aleksa };
		sortPlayers(players);

		Assert.assertEquals(aleksa, players[0]);
		Assert.assertEquals(amy, players[1]);
		Assert.assertEquals(david, players[2]);
		Assert.assertEquals(aakansha, players[3]);
		Assert.assertEquals(heraldo, players[4]);
	}

}
