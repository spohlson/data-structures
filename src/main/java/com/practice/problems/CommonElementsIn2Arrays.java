package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class CommonElementsIn2Arrays {

	/**
	 * Find common elements in 2 arrays
	 */
	public List<Integer> findCommonElements(int[] arr1, int[] arr2) {
		Set<Integer> arr1Set = new HashSet<>();

		for (int num : arr1) {
			arr1Set.add(num);
		}
		List<Integer> common = new ArrayList<>();

		for (int num : arr2) {

			if (arr1Set.contains(num)) {
				common.add(num);
			}
		}
		return common;
	}

	public List<Integer> findCommonElements1(List<Integer> list1, List<Integer> list2) {
		if (!list1.retainAll(list2)) {
			return new ArrayList<>(0);
		}
		return list1;
	}

	/**
	 * Find all uncommon elements in 2 arrays
	 */
	public List<Integer> findUncommonElements(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<>();

		for (int num : arr1) {
			set.add(num);
		}
		List<Integer> uncommon = new ArrayList<>();

		for (int num : arr2) {

			if (!set.contains(num)) {
				uncommon.add(num);
			} else {
				set.remove(num);
			}
		}
		uncommon.addAll(set);
		return uncommon;
	}

	@Test
	public void test() {
		int[] arr1 = new int[] { 5, 3, 7, 7, 8, 9 };
		int[] arr2 = new int[] { 5, 3, 6, 7 };

		List<Integer> expected = Arrays.asList(5, 3, 7);
		List<Integer> output = findCommonElements(arr1, arr2);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test1() {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(5, 3, 7, 8, 9));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(5, 3, 6, 7));

		List<Integer> expected = Arrays.asList(5, 3, 7);
		List<Integer> output = findCommonElements1(list1, list2);
		Assert.assertTrue(expected.equals(output));
	}

	@Test
	public void test2() {
		int[] arr1 = new int[] { 5, 3, 7, 7, 8, 9 };
		int[] arr2 = new int[] { 5, 3, 6, 7 };

		List<Integer> expected = Arrays.asList(6, 8, 9);
		List<Integer> output = findUncommonElements(arr1, arr2);
		Assert.assertTrue(expected.equals(output));
	}

}
