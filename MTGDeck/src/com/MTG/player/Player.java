package com.MTG.player;

import java.util.ArrayList;
import java.util.List;

import com.MTG.deck.MTGCard;
import com.MTG.deck.MTGDeck;
import com.MTG.deck.RouletteShuffler;
import com.MTG.lands.ManaType;
import com.decks.exceptions.CardNotInDeckException;

public class Player {
	
	private List<ManaType> manaPool;
	private MTGDeck deck;
	private List<MTGCard> hand;
	private List<MTGCard> inGameCards;

	public Player(MTGDeck deck) {
		super();
		this.deck = deck;
		this.manaPool = new ArrayList<ManaType>();
	}
	
	public void startGame(){
		try {
			deck.shuffle(new RouletteShuffler<MTGCard>());
		} catch (CardNotInDeckException e) {
			e.printStackTrace();
		} finally {
			deck.shuffle();
		}
		manaPool.clear();
	}
	
	public void playTurn(){
		for (MTGCard card: inGameCards ){
			card.untap();
		}
		MTGCard draw = deck.nextCard();
		hand.add(draw);
		// TODO: continue the implementation
	}

	public List<ManaType> getManaPool() {
		return manaPool;
	}

	public void setManaPool(List<ManaType> manaPool) {
		this.manaPool = manaPool;
	}

	public MTGDeck getDeck() {
		return deck;
	}

	public void setDeck(MTGDeck deck) {
		this.deck = deck;
	}

}
