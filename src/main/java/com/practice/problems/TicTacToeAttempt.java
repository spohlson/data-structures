package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TicTacToeAttempt {

	class TicTacToe {

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

		// public boolean isPlayerWinner(Player player) {
		// int numOfRows = board.length;
		// int numOfColumns = board[0].length;
		//
		// Player[] column = board[0][0];
		//
		// for (int i = 0; i < numOfColumns; i++) {
		// int rowIndex = 0;
		//
		// while (rowIndex < numOfRows) {
		// Player[] row = board[rowIndex];
		//
		// rowIndex++;
		// }
		//
		// }
		// }

	}

	class Solution {

		public class Job {

			private int userId;
			private int start;
			private int end;
			private int resource;

			public Job(int userId, int start, int end, int resource) {
				this.userId = userId;
				this.start = start;
				this.end = end;
				this.resource = resource;
			}

			public int getUserId() {
				return userId;
			}

			public int getStart() {
				return start;
			}

			public int getEnd() {
				return end;
			}

			public int getResource() {
				return resource;
			}

		}

		public int getMaxResourcesConsumedForUser(List<Job> jobs, int userId) {
			int max = 0;

			Map<Integer, Integer> map = new HashMap<>();

			for (Job job : jobs) {
				int jobUserId = job.getUserId();

				if (jobUserId == userId) {
					int start = job.getStart();
					int end = job.getEnd();
					int resource = job.getResource();

					int count = start;
					while (count <= end) {

						if (map.containsKey(count)) {
							int val = map.get(count) + resource;

							if (val > max) {
								max = val;
							}
							map.put(count, val);
						} else {
							if (resource > max) {
								max = resource;
							}
							map.put(count, resource);
						}

						count++;
					}

				}
			}

			return max;
		}

		@Test
		public void test() {

			Job one = new Job(1, 1, 10, 5);
			Job two = new Job(1, 2, 8, 1);
			Job three = new Job(1, 5, 15, 5);
			Job four = new Job(1, 40, 50, 10);

			List<Job> jobs = new ArrayList<>(Arrays.asList(one, two, three, four));

			int expected = 11;
			int userId = 1;

			int output = getMaxResourcesConsumedForUser(jobs, 1);

			System.out.print("Success: " + (expected == output));
		}

	}

	/*
	 * u - user s - start time e - end time r - resources Job(u: 1, s: 1, e: 10,
	 * r: 5) Job(u: 1, s: 2, e: 8, r: 1) Job(u: 1, s: 5, e: 15, r: 5) Job(u: 1,
	 * s: 40, e: 50, r: 10) Job(u: 2,
	 * 
	 * user: 1 -> 11 resources
	 * 
	 * 1 : 5 2 : 6 3 : 6 4 : 6 5 : 11 6 : 11 7 : 11 8 : 11 9 : 10 10 : 10 11 : 5
	 * 12 13 14 15 ... 40 : 10 41 ...
	 * 
	 * 
	 * 
	 * 
	 */

}
