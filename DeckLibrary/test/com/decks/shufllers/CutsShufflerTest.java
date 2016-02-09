package com.decks.shufllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.decks.SimpleCard;
import com.decks.Deck;
import com.decks.shufflers.CutsShuffler;

public class CutsShufflerTest {

	public List<SimpleCard> obtainCards(int size) {
		ArrayList<SimpleCard> cards = new ArrayList<SimpleCard>(size);
		for (int i = 0; i < size; i++) {
			cards.add(new SimpleCard(i));
		}
		return cards;
	}

	@Test
	public void cutShuffleShouldDoNothingOnEmptyDeck() {
		List<SimpleCard> cards = obtainCards(0);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
		deck.shuffle(new CutsShuffler<>());
		assertEquals(beforeShuffleDeck, deck.getDeckCards());
	}

	@Test
	public void cutShuffleShouldRandomizeIt() {
		List<SimpleCard> cards = obtainCards(20);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		CutsShuffler<SimpleCard> shuffler = new CutsShuffler<>();
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffle(shuffler);
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
		}
	}
}
