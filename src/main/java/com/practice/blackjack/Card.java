package com.practice.blackjack;

public class Card {

	private Suit suit;
	private int numberValue;

	public Card(Suit suit, int numberValue) {
		this.suit = suit;
		if ((numberValue < 1) || (numberValue > 13)) {
			throw new IllegalArgumentException("Invalid value for card. Can only be 1-13.");
		}
		this.numberValue = numberValue;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(int value) {
		numberValue = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card card = (Card) obj;
			return suit.equals(card.getSuit()) && (numberValue == card.getNumberValue());
		}
		return false;
	}

}
