package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class HeapsRunningMedian {

	/**
	 * The median of a dataset of integers is the midpoint value of the dataset
	 * for which an equal number of integers are less than and greater than the
	 * value. To find the median, you must first sort your dataset of integers
	 * in non-decreasing order, then:
	 * 
	 * - If your dataset contains an odd number of elements, the median is the
	 * middle element of the sorted sample. In the sorted dataset {1, 2, 3}, 2
	 * is the median.
	 * 
	 * - If your dataset contains an even number of elements, the median is the
	 * average of the two middle elements of the sorted sample. In the sorted
	 * dataset {1, 2, 3, 4}, (2 + 3)/2 = 2.5 is the median.
	 * 
	 * Given an input stream of n integers, you must perform the following task
	 * for each ith integer:
	 * 
	 * 1. Add the ith integer to a running list of integers.
	 * 
	 * 2. Find the median of the updated list (i.e., for the first element
	 * through the ith element).
	 * 
	 * 3. Print the list's updated median on a new line. The printed value must
	 * be a double-precision number scaled to 1 decimal place (i.e., 12.3
	 * format).
	 * 
	 * Input Format:
	 * 
	 * The first line contains a single integer, n, denoting the number of
	 * integers in the data stream. Each line i of the n subsequent lines
	 * contains an integer, ai, to be added to your list.
	 * 
	 * Sample Input:
	 * 6
	 * 12
	 * 4
	 * 5
	 * 3
	 * 8
	 * 7
	 * 
	 * Sample Output:
	 * 12.0
	 * 8.0
	 * 5.0
	 * 4.5
	 * 5.0
	 * 6.0
	 */

	/**
	 * Create a sorted list write function to add new element to list in the
	 * correct order write getMedian function
	 */

	public class SortedList {

		private List<Double> list;

		public SortedList() {
			list = new ArrayList<>();
		}

		public void add(double element) {
			if (list.isEmpty() || (element >= list.get(list.size() - 1))) {
				list.add(element);
			} else {

				for (int i = 0; i < list.size(); i++) {
					double num = list.get(i);

					if (element <= num) {
						list.add(i, element);
						return;
					}
				}
			}
		}

		public Double getMedian() {
			if (list.isEmpty()) {
				return null;
			}
			int size = list.size();
			int mid = size / 2;

			Double median;

			if ((size % 2) == 1) {
				median = list.get(mid);
			} else {
				Double midOne = list.get(mid);
				Double midTwo = list.get(mid - 1);

				median = (midOne + midTwo) / 2;
			}
			return median;
		}
	}

	/**
	 * TODO: Provide a solution using heaps
	 */

	@Test
	public void test() {
		Double[] arr = new Double[] { new Double(12), new Double(4), new Double(5), new Double(3),
				new Double(8), new Double(7) };

		SortedList list = new SortedList();
		List<Double> output = new ArrayList<>();

		for (Double dub : arr) {
			list.add(dub);
			double median = list.getMedian();
			output.add(median);
		}

		List<Double> expected = Arrays.asList(12.0, 8.0, 5.0, 4.5, 5.0, 6.0);
		Assert.assertTrue(output.size() == expected.size());

		for (int i = 0; i < output.size(); i++) {
			Double median = output.get(i);
			Assert.assertEquals(median, expected.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
	}

}
