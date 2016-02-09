package com.decks.util.spanish;

import com.decks.Card;

public class SpanishCard extends Card {
	
	private SpanishSuits suit;
	private SpanishRanks rank;
	
	public SpanishCard() {
		super();
	}
	
	public SpanishCard(SpanishSuits suit, SpanishRanks rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "SpanishCard [suit=" + suit + ", rank=" + rank + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 13;
		int result = 1;
		result = prime * result + suit.getValue();
		result = prime * result + rank.getValue();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpanishCard other = (SpanishCard) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public SpanishSuits getSuit() {
		return suit;
	}

	public void setSuit(SpanishSuits suit) {
		this.suit = suit;
	}

	public SpanishRanks getRank() {
		return rank;
	}

	public void setRank(SpanishRanks rank) {
		this.rank = rank;
	}
}
