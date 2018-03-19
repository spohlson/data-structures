package com.practice.problems;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeSortCountInversions {

	/**
	 * In an array, the elements at indices i and j (where i < j) form an
	 * inversion of arr[i] > arr[j]. In other words, inverted elements arr[i]
	 * and arr[j] are considered to be 'out of order'. To correct an inversion,
	 * we can swap adjacent elements.
	 * 
	 * Ex. consider arr = [2, 4, 1]. It has 2 inversions: (2, 1) and (4, 1). To
	 * sort the array, we must perform the following two swaps to correct the
	 * inversions --> arr = [2, 4, 1] swap(arr[1], arr[2]) then swap(arr[0],
	 * arr[1]) --> [1, 2, 4]
	 * 
	 * Given d datasets, print the # of inversions that must be swapped to sort
	 * each dataset on a new line.
	 * 
	 * Input Format:
	 * 
	 * The 1st line contains integer, d, denoting # of datasets. The 2d
	 * subsequent lines describe each respective dataset over 2 lines:
	 * 
	 * 1. 1st line contains an integer, n, denoting # of elements in dataset.
	 * 
	 * 2. 2nd line contains n space-separated integers describing the respective
	 * values of arr[0], arr[1],..., arr[n-1]
	 * 
	 * Output Format: For each of the d datasets, print the # of inversions that
	 * must be swapped to sort the dataset on a new line.
	 * 
	 * Sample Input:
	 * 2
	 * 5
	 * 1 1 1 2 2
	 * 5
	 * 2 1 3 1 2
	 * 
	 * Sample Output:
	 * 0
	 * 4
	 */

	private static final Logger LOG = LoggerFactory.getLogger(MergeSortCountInversions.class);

	public static long countInversionsOne(int[] arr) {
		int[] aux = arr.clone();
		return countInversions(arr, 0, arr.length - 1, aux, "1st Level", 1);
	}

	private static long countInversions(int[] arr, int lo, int hi, int[] aux, String level,
			int levelCount) {
		if (lo >= hi) {
			return 0;
		}

		int mid = lo + ((hi - lo) / 2);
		LOG.info("{} {} - hi = {}, lo = {}, mid = {}", level, levelCount, hi, lo, mid);

		long count = 0;
		count += countInversions(aux, lo, mid, arr, "2nd Level", levelCount++);
		count += countInversions(aux, mid + 1, hi, arr, "3rd Level", levelCount++);
		count += merge(arr, lo, mid, hi, aux);

		return count;
	}

	private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
		long count = 0;
		int i = lo;
		int j = mid + 1;
		int k = lo;

		while ((i <= mid) || (j <= hi)) {
			if (i > mid) {
				arr[k++] = aux[j++];
			} else if (j > hi) {
				arr[k++] = aux[i++];
			} else if (aux[i] <= aux[j]) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
				count += (mid + 1) - i;
			}
		}

		return count;
	}

	public static int countInversions(int[] arr) {
		int inversions = 0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {

			for (int j = i + 1; j < len; j++) {
				int iElement = arr[i];
				int jElement = arr[j];

				if (iElement > jElement) {
					arr[i] = jElement;
					arr[j] = iElement;

					inversions++;
				}
			}
		}

		return inversions;
	}

	@Test
	public void test() {
		int[] arr = new int[] { 2, 1, 3, 1, 2 };
		long expected = 4;
		long output = countInversionsOne(arr);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testOne() {
		int[] arr = new int[] { 1, 1, 1, 2, 2 };
		int expected = 0;
		int output = countInversions(arr);
		Assert.assertTrue(expected == output);
	}

	@Test
	public void testTwo() {
		int[] arr = new int[] { 2, 1, 3, 1, 2 };
		int expected = 4;
		int output = countInversions(arr);
		Assert.assertTrue(expected == output);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];

			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			int result = countInversions(arr);
			System.out.println(result);
		}
		in.close();
	}

}
