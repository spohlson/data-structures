package com.practice.problems;

public class FibonacciOutputArray {

	/**
	 * Write a program to calculate the first 10 Fibonacci numbers and store the
	 * results in a one-dimensional array. In a second array calculate and store
	 * the average values of the adjacent numbers in the series. The first array
	 * should contain integer values and the second floating point values.
	 * Output the contents of both arrays in a neat format.
	 */

	public void fibonacci() {
		int limit = 10;

		long[] series = new long[limit];

		// create first 2 series elements
		series[0] = 1;
		series[1] = 1;

		// create the Fibonacci series and store it in an array
		for (int i = 2; i < limit; i++) {
			series[i] = series[i - 1] + series[i - 2];
		}

		// print the Fibonacci series numbers
		System.out.println("Fibonacci Series upto " + limit);
		for (int i = 0; i < limit; i++) {
			System.out.print(series[i] + " ");
		}
	}

	public double getAverage(int[] seq) {
		int sum = 0;

		for (int element : seq) {
			sum += element;
		}

		double average = (double) sum / seq.length;

		System.out.println("Average value of array elements is : " + average);
		return average;
	}

}
