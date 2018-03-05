package com.practice.blackjack;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackDeckTest {

	@Test
	public void shuffleTest() {
		BlackJackDeck deck = new BlackJackDeck();
		List<Card> cards = deck.getCards();
		List<Card> firstSuitCards = cards.subList(0, 13);

		Suit suit = Suit.values()[0];
		int count = 1;

		for (Card card : firstSuitCards) {
			Assert.assertEquals(suit, card.getSuit());
			Assert.assertTrue(count == card.getNumberValue());
			count++;
		}

		Card sixthOrderedCard = cards.get(5);

		// force the deck's index to be moved further into the deck
		deck.getHand(5);

		deck.shuffle();

		cards = deck.getCards();

		// First 5 cards should still be in the original order
		List<Card> firstFiveCards = cards.subList(0, 5);

		count = 1;

		for (Card card : firstFiveCards) {
			Assert.assertEquals(suit, card.getSuit());
			Assert.assertTrue(count == card.getNumberValue());
			count++;
		}

		Card sixthCard = cards.get(5);

		Assert.assertFalse(sixthOrderedCard.equals(sixthCard));
	}

}
