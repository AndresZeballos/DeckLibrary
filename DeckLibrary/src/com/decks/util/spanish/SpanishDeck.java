package com.decks.util.spanish;

import java.util.ArrayList;

import com.decks.Deck;

public class SpanishDeck extends Deck<SpanishCard> {

	/** 
	 * Create a deck of 48 Spanish cards
	 */
	public SpanishDeck() {
		super();
		this.deckCards = new ArrayList<SpanishCard>();
		for (SpanishSuits f : SpanishSuits.values()) {
			for (SpanishRanks r : SpanishRanks.values()) {
				deckCards.add(new SpanishCard(f, r));
			}
		}
	}

	/**
	 * Remove all the cards in the deck with the Rank passed 
	 * This method will be useful in games that not require, for example, the 7's and 8's
	 * @param rank
	 * @return
	 */
	public boolean removeCards(SpanishRanks rank) {
		if (rank != null) {
			boolean result = true;
			ArrayList<SpanishCard> cards = new ArrayList<SpanishCard>(deckCards);
			for (SpanishCard card : cards) {
				if (card.getRank() == rank)
					result &= deckCards.remove(card);
			}
			return result;
		} 
		return false;
	}

	/**
	 * Remove all the cards in the deck with the Suit passed
	 * This method will be useful in games that not needs, for example, the gold's
	 * @param suit
	 * @return
	 */
	public boolean removeCards(SpanishSuits suit) {
		if (suit != null) {
			boolean result = true;
			ArrayList<SpanishCard> cards = new ArrayList<SpanishCard>(deckCards);
			for (SpanishCard card : cards) {
				if (card.getSuit() == suit)
					result &= deckCards.remove(card);
			}
			return result;
		} 
		return false;
	}

}
