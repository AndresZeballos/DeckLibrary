package com.MTG.lands;

import com.MTG.deck.ITap;
import com.MTG.deck.MTGCard;

public class Land extends MTGCard implements ITap {
	
	private LandType type;

	public Land(LandType type) {
		super(type.name(), 0, 3);
		this.setType(type);
	}

	@Override
	public void tap() {
		// TODO Add a mana to the pool
	}

	public LandType getType() {
		return type;
	}

	public void setType(LandType type) {
		this.type = type;
	}

}
