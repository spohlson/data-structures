package com.practice.problems;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DataVisualization {

	/**
	 * Write a function that takes hourly data of a 24 hour period containing
	 * amount made per hour (i.e. [(0, 0), (1, 0), (2, 0), (3, 0), (4, 0), (5,
	 * 0), (6, 0), (7, 0), (8, 15), (9, 12), (10, 0), (11, 24), (12, 0), (13,
	 * 50), (14, 0), (15, 1), (16, 0), (17, 0), (18, 9), (19, 0), (20, 0), (21,
	 * 0), (22, 0), (23, 0)]) and returns only the working hours data (i.e. hour
	 * 8 through 18 since those have values)
	 * 
	 * Returns:
	 * (8,15),(9,12),(10,0),(11,24),(12,0),(13,50),(14,0),(15,1),(16,0),(17,0),(18,9)
	 */

	public class HourValue {

		private int hour;
		private int value;

		public HourValue(int hour, int value) {
			this.hour = hour;
			this.value = value;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			HourValue other = (HourValue) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (hour != other.hour) {
				return false;
			}
			if (value != other.value) {
				return false;
			}
			return true;
		}

		private DataVisualization getOuterType() {
			return DataVisualization.this;
		}

	}

	public HourValue[] getWorkingHoursData(HourValue[] dayData) {
		int start = -1;
		int end = -1;

		// iterate forward until an hour with a value is found
		for (int i = 0; i < dayData.length; i++) {
			HourValue hourVal = dayData[i];
			int val = hourVal.getValue();

			if (val > 0) {
				start = i;
				break;
			}
		}

		// iterate backwards until the an hour with a value is found
		for (int i = dayData.length - 1; i > 0; i--) {
			HourValue hourVal = dayData[i];
			int val = hourVal.getValue();

			if (val > 0) {
				end = i;
				break;
			}
		}

		if ((start == -1) || (end == -1)) {
			return new HourValue[0];
		}

		return Arrays.copyOfRange(dayData, start, end);
	}


	////////////// Test Helper Methods //////////////

	private int getRandomInt(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt((max - min) + 1);
	}

	private HourValue[] createTestArr(int startHour, int endHour) {
		HourValue[] arr = new HourValue[24];

		for (int i = 0; i < 24; i++) {
			int val = 0;

			if ((i == startHour) || (i == endHour)) {
				val = getRandomInt(5, 50);
			} else if ((i > startHour) && (i < endHour)) {
				val = getRandomInt(0, 60);
			}

			HourValue hourVal = new HourValue(i, val);
			arr[i] = hourVal;
		}

		return arr;
	}

	@Test
	public void test() {
		int start = 8;
		int end = 17;

		HourValue[] arr = createTestArr(start, end);
		HourValue[] expected = Arrays.copyOfRange(arr, start, end);

		HourValue[] output = getWorkingHoursData(arr);

		Assert.assertTrue(Arrays.equals(expected, output));
	}

	@Test
	public void test1() {
		int start = 8;
		int end = 8;

		HourValue[] arr = createTestArr(start, end);
		HourValue[] expected = Arrays.copyOfRange(arr, start, end);

		HourValue[] output = getWorkingHoursData(arr);

		Assert.assertTrue(Arrays.equals(expected, output));
	}

	@Test
	public void testEmpty() {
		HourValue[] arr = new HourValue[24];

		for (int i = 0; i < 24; i++) {
			arr[i] = new HourValue(i, 0);
		}

		HourValue[] expected = new HourValue[0];

		HourValue[] output = getWorkingHoursData(arr);

		Assert.assertTrue(Arrays.equals(expected, output));
	}

}
