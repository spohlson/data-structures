package com.practice.blackjack;

import java.util.ArrayList;

public class BlackJackDeck extends Deck {

	public BlackJackDeck() {
		this(false);
	}

	public BlackJackDeck(boolean shuffle) {
		initialize();
		allowReShuffling = true;

		if (shuffle) {
			shuffle();
		}
	}

	private void initialize() {
		cards = new ArrayList<>(52);

		int maxValue = 13;

		for (Suit suit : Suit.values()) {
			int value = 1;

			while (value <= maxValue) {
				Card card = new Card(suit, value);
				cards.add(card);

				value++;
			}
		}
	}

	public BlackJackHand getHand() {
		return getHand(2);
	}

	@Override
	public BlackJackHand getHand(int numOfCards) {
		BlackJackHand hand = new BlackJackHand(getCards(numOfCards));
		return hand;
	}

}
