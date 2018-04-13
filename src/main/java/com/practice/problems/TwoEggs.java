package com.practice.problems;

public class TwoEggs {

	/**
	 * A building has 100 floors. One of the floors is the highest floor an egg
	 * can be dropped from without breaking. If an egg is dropped from above
	 * that floor, it will break. If it is dropped from that floor or below, it
	 * will be completely undamaged and you can drop the egg again.
	 * 
	 * Given two eggs, find the highest floor an egg can be dropped from without
	 * breaking, with as few drops as possible. Write a function to represent
	 * this and return the fewest drops possible for a given highest floor that
	 * an egg can be dropped.
	 */

	public int getFewestDrops(int eggs, int floors, int breakingFloor) {
		int fewestDrops = 0;

		if (eggs <= 0) {
			throw new IllegalArgumentException("Eggs are required");
		} else if (eggs == 1) {
			// 0(N) since every floor would need to be checked
			return breakingFloor;
		} else if (floors < 2) {
			throw new IllegalArgumentException("2+ floors are required");
		}

		int mid = floors / 2;

		if (mid < breakingFloor) {
			fewestDrops++;
			// fewestDrops =
		}

		return fewestDrops;
	}

}
