package com.decks.util.french;

public enum FrenchRanks { As(1), _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), _10(10), J(11), Q(12), K(13);
	private final int value;
	
	private FrenchRanks(int value) { 
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}