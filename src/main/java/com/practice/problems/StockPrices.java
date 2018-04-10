package com.practice.problems;

import org.junit.Assert;
import org.junit.Test;

public class StockPrices {

	/**
	 * Suppose we could access yesterday's stock prices as a list where the
	 * indices are the time in minutes past trade opening time, which was 9:30
	 * am local time. The values are the price in dollars of stock at that time.
	 * So if the stock cost $500 at 10:30 am, stock_prices_yesterday[60] = 500.
	 * 
	 * Write an efficient function that takes stock_prices_yesterday and returns
	 * the best profit I could have made from 1 purchase of 1 sale of 1 stock
	 * yesterday.
	 * 
	 * Ex. [10, 7, 5, 8, 11, 9] would return 6 (buying for $5 and selling for
	 * $11)
	 */

	public int getMaxProfit(int[] stockPrices) {
		int len = stockPrices.length;

		if (len < 2) {
			throw new IllegalArgumentException("Must be more than 2 stock prices");
		}

		int minPrice = stockPrices[0];
		int maxProfit = stockPrices[1] - minPrice;

		for (int i = 1; i < len; i++) {
			int price = stockPrices[i];

			int potentialProfit = price - minPrice;

			if (potentialProfit > maxProfit) {
				maxProfit = potentialProfit;
			}

			if (price < minPrice) {
				minPrice = price;
			}
		}

		return maxProfit;
	}

	@Test
	public void test() {
		int[] stockPrices = new int[] { 10, 7, 5, 8, 11, 9 };
		int expected = 6;
		int output = getMaxProfit(stockPrices);

		Assert.assertTrue(expected == output);
	}

}
