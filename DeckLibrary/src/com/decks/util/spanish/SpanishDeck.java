package com.decks.util.spanish;

import java.util.ArrayList;

import com.decks.Deck;

public class SpanishDeck extends Deck<SpanishCard> {

	public SpanishDeck() {
		super();
		this.deckCards = new ArrayList<SpanishCard>();
		for (SpanishSuits f : SpanishSuits.values()) {
			for (SpanishRanks r : SpanishRanks.values()) {
				deckCards.add(new SpanishCard(f, r));
			}
		}
	}

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
