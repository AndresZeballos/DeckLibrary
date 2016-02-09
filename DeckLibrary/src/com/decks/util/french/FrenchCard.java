package com.decks.util.french;

import com.decks.Card;

public class FrenchCard extends Card {

	private FrenchSuits suit;
	private FrenchRanks rank;

	public FrenchCard() {
		super();
	}

	public FrenchCard(FrenchSuits suit, FrenchRanks rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "FrenchCard [suit=" + suit + ", rank=" + rank + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
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
		FrenchCard other = (FrenchCard) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public FrenchSuits getSuit() {
		return suit;
	}

	public void setSuit(FrenchSuits suit) {
		this.suit = suit;
	}

	public FrenchRanks getRank() {
		return rank;
	}

	public void setRank(FrenchRanks rank) {
		this.rank = rank;
	}

}
