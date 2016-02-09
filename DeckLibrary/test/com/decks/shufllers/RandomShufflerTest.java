package com.decks.shufllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.decks.SimpleCard;
import com.decks.exceptions.CardNotInDeckException;
import com.decks.Deck;
import com.decks.shufflers.RandomShuffler;

public class RandomShufflerTest {

	public List<SimpleCard> obtainCards(int size) {
		ArrayList<SimpleCard> cards = new ArrayList<SimpleCard>(size);
		for (int i = 0; i < size; i++) {
			cards.add(new SimpleCard(i));
		}
		return cards;
	}

	@Test
	public void randomShuffleShouldDoNothingOnEmptyDeck() throws CardNotInDeckException {
		List<SimpleCard> cards = obtainCards(0);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
		deck.shuffle(new RandomShuffler<>());
		assertEquals(beforeShuffleDeck, deck.getDeckCards());
	}

	@Test
	public void randomShuffleShouldRandomizeIt() throws CardNotInDeckException {
		List<SimpleCard> cards = obtainCards(30);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		RandomShuffler<SimpleCard> shuffler = new RandomShuffler<SimpleCard>();
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffle(shuffler);
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
		}
	}

	@Test
	public void randomShuffleShouldRandomizeTheRemain() throws CardNotInDeckException {
		List<SimpleCard> cards = obtainCards(50);
		List<SimpleCard> beforeShuffleDeck;
		Deck<SimpleCard> deck = new Deck<SimpleCard>(cards);
		RandomShuffler<SimpleCard> shuffler = new RandomShuffler<SimpleCard>();
		for (int x = 0; x < 30; x++) {
			beforeShuffleDeck = new ArrayList<>(deck.getDeckCards());
			deck.shuffleRemain(shuffler);
			assertNotEquals(beforeShuffleDeck, deck.getDeckCards());
			deck.nextCard();
		}
	}
}
