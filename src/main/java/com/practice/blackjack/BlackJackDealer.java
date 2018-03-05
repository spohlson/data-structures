package com.practice.blackjack;

import java.util.List;

import org.springframework.util.CollectionUtils;

public class BlackJackDealer extends BlackJackPlayer {

	public BlackJackDealer(BlackJackHand hand) {
		super("Dealer", hand);
	}

	/**
	 * Not currently used.
	 */
	public Card peek() {
		List<Card> cards = hand.getCards();

		if (CollectionUtils.isEmpty(cards)) {
			return null;
		}
		return cards.get(0);
	}

}
