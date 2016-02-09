package com.decks.util.french;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.decks.util.french.FrenchDeck;

public class FrenchDeckTest {

	@Test
	public void aNewFrenchDeckShouldHave52Cards() {
		FrenchDeck deck = new FrenchDeck();
		assertEquals(52, deck.getDeckCards().size());
	}

}
