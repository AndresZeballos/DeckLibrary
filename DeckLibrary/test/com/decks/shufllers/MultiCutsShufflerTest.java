package com.decks.shufllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.decks.SimpleCard;
import com.decks.Deck;
import com.decks.shufflers.MultiCutsShuffler;

public class MultiCutsShufflerTest {

	public List<SimpleCard> obtainCards(int size) {
		ArrayList<SimpleCard> cards = new ArrayList<SimpleCard>(size);
		for (int i = 0; i < size; i++) {
			cards.add(new SimpleCard(i));
		}
		return cards;
	}
	

	@Test
	public void multiCutShuffleShouldDoNothingOnEmptyDeck() {
		List<SimpleCard> cards = obtainCards(0);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
		deck.shuffle(new MultiCutsShuffler<>());
		assertEquals(beforeShuffleDeck, deck.getDeckCards());
	}

	@Test
	public void multiCutShuffleShouldRandomizeIt() {
		List<SimpleCard> cards = obtainCards(10);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		MultiCutsShuffler<SimpleCard> shuffler = new MultiCutsShuffler<SimpleCard>();
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffle(shuffler);
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
		}
	}
}
