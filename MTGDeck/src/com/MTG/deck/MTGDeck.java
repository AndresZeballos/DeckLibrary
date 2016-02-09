package com.MTG.deck;

import java.util.List;

import com.decks.Deck;

public class MTGDeck extends Deck<MTGCard> {

	public MTGDeck(List<MTGCard> cards) {
		super();
		this.deckCards = cards;
	}
}
