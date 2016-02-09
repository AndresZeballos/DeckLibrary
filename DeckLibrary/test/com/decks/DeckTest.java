package com.decks;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.decks.Deck;

public class DeckTest {

	public List<SimpleCard> obtainCards(int size) {
		ArrayList<SimpleCard> cards = new ArrayList<SimpleCard>(size);
		for (int i = 0; i < size; i++) {
			cards.add(new SimpleCard(i));
		}
		return cards;
	}

	@Test
	public void shuffleADeckShouldRandomizeIt() {
		List<SimpleCard> cards = obtainCards(10);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffle();
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
		}
	}

	@Test
	public void shuffleADeckShouldRandomizeTheRemain() {
		List<SimpleCard> cards = obtainCards(50);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffleRemain();
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
			deck.nextCard();
		}
	}

	@Test
	public void addBottomShouldControlNullCards() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertFalse(deck.addBottom(null));
	}

	@Test
	public void addBottomShouldPutCardAtLast() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		for (int x = 0; x < 15; x++) {
			// Use some card of the deck
			deck.nextCard();
		}
		SimpleCard card = new SimpleCard(667);
		assertTrue(deck.addBottom(card));
		SimpleCard lastCard = null;
		while (deck.hasCards()) {
			lastCard = deck.nextCard();
		}
		assertEquals(card, lastCard);
	}

	@Test
	public void addBottomOnNewDeckShouldPutCardAtLast() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard card = new SimpleCard(667);
		assertTrue(deck.addBottom(card));
		SimpleCard lastCard = null;
		while (deck.hasCards()) {
			lastCard = deck.nextCard();
		}
		assertEquals(card, lastCard);
	}

	@Test
	public void addBottomOnEmptyDeckShouldPutCardAtLast() {
		List<SimpleCard> cards = obtainCards(0);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard card = new SimpleCard(667);
		assertTrue(deck.addBottom(card));
		SimpleCard lastCard = null;
		while (deck.hasCards()) {
			lastCard = deck.nextCard();
		}
		assertEquals(card, lastCard);
	}

	@Test
	public void addTopShouldControlNullCards() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertFalse(deck.addTop(null));
	}

	@Test
	public void addTopOnNewDeckShouldPutCardAtFirst() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard card = new SimpleCard(667);
		assertTrue(deck.addTop(card));
		SimpleCard topCard = deck.nextCard();
		assertEquals(card, topCard);
	}

	@Test
	public void addTopOnEmptyDeckShouldPutCardAtFirst() {
		List<SimpleCard> cards = obtainCards(0);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard card = new SimpleCard(667);
		assertTrue(deck.addTop(card));
		SimpleCard topCard = deck.nextCard();
		assertEquals(card, topCard);
	}

	@Test
	public void removeCardShouldControlNullCards() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertFalse(deck.removeCard(null));
	}

	@Test
	public void removeCardShouldRemoveFirstCard() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard first = deck.nextCard();
		assertTrue(deck.removeCard(first));
		assertEquals(49, deck.getDeckCards().size());
	}

	@Test
	public void removeCardShouldRemoveLastCard() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard last = new SimpleCard(667);
		deck.addBottom(last);
		assertTrue(deck.removeCard(last));
		assertEquals(50, deck.getDeckCards().size());
	}

	@Test
	public void removeCardShouldNotRemoveACardNotInIt() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard notInTheDeck = new SimpleCard(667);
		assertFalse(deck.removeCard(notInTheDeck));
		assertEquals(50, deck.getDeckCards().size());
	}

	@Test
	public void hasCardShouldReturnFalseOnEmptyDeck() {
		List<SimpleCard> cards = obtainCards(0);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertFalse(deck.hasCards());
	}

	@Test
	public void hasCardShouldReturnTrueOnNewDeck() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertTrue(deck.hasCards());
	}

	@Test
	public void hasCardShouldReturnFalseOnUsedDeck() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		for (int x = 0; x < 50; x++) {
			// Use all card of the deck
			deck.nextCard();
		}
		assertFalse(deck.hasCards());
	}

	@Test
	public void nextCardShouldReturnNullOnEmptyDeck() {
		List<SimpleCard> cards = obtainCards(0);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		assertNull(deck.nextCard());
	}
	@Test
	public void nextCardShouldReturnNullOnUsedDeck() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		for (int x = 0; x < 50; x++) {
			// Use all card of the deck
			deck.nextCard();
		}
		assertNull(deck.nextCard());
	}

	@Test
	public void nextCardShouldReturnFirstCardOnDeck() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard top = new SimpleCard(667);
		deck.addTop(top);
		assertEquals(top, deck.nextCard());
	}

	@Test
	public void nextCardShouldReturnLastCardOnDeck() {
		List<SimpleCard> cards = obtainCards(50);
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		SimpleCard last = new SimpleCard(667);
		deck.addBottom(last);
		for (int x = 0; x < 50; x++) {
			// Use all card of the deck
			deck.nextCard();
		}
		assertEquals(last, deck.nextCard());
	}
}
