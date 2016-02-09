package com.decks.util.spanish;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.decks.util.spanish.SpanishDeck;
import com.decks.util.spanish.SpanishRanks;
import com.decks.util.spanish.SpanishSuits;

public class SpanishDeckTest {

	@Test
	public void aNewSpanishDeckShouldHave48Cards() {
		SpanishDeck deck = new SpanishDeck();
		assertEquals(48, deck.getDeckCards().size());
	}

	@Test
	public void removeCardsShouldRemoveThe4CardsWithARank() {
		SpanishDeck deck = new SpanishDeck();
		deck.removeCards(SpanishRanks._3);
		assertEquals(44, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._11);
		assertEquals(40, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._7);
		assertEquals(36, deck.getDeckCards().size());
	}

	@Test
	public void removeCardsShouldRemoveOnlyOneTimeThe4CardsWithARank() {
		SpanishDeck deck = new SpanishDeck();
		deck.removeCards(SpanishRanks._3);
		assertEquals(44, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._3);
		assertEquals(44, deck.getDeckCards().size());

	}

	@Test
	public void removeCardsShouldRemoveThe12CardsOfASuit() {
		SpanishDeck deck = new SpanishDeck();
		deck.removeCards(SpanishSuits.Coins);
		assertEquals(36, deck.getDeckCards().size());
		deck.removeCards(SpanishSuits.Cups);
		assertEquals(24, deck.getDeckCards().size());
		deck.removeCards(SpanishSuits.Clubs);
		assertEquals(12, deck.getDeckCards().size());
	}

	@Test
	public void removeCardsShouldRemoveOnlyOneTimeThe12CardsOfASuit() {
		SpanishDeck deck = new SpanishDeck();
		deck.removeCards(SpanishSuits.Coins);
		assertEquals(36, deck.getDeckCards().size());
		deck.removeCards(SpanishSuits.Coins);
		assertEquals(36, deck.getDeckCards().size());
	}

	@Test
	public void removeCardsShouldRemoveOnlyOneTimeACard() {
		SpanishDeck deck = new SpanishDeck();
		deck.removeCards(SpanishSuits.Coins);
		assertEquals(36, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._5);
		assertEquals(33, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._8);
		assertEquals(30, deck.getDeckCards().size());
		deck.removeCards(SpanishSuits.Swords);
		assertEquals(20, deck.getDeckCards().size());
		deck.removeCards(SpanishRanks._7);
		assertEquals(18, deck.getDeckCards().size());
	}
}
