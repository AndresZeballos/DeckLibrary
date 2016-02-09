package com.MTG.creatures;

import com.MTG.deck.MTGCard;

public class Creature extends MTGCard {
	
	private int strength;
	private int resistence;
	
	public Creature(String name, int cost, int strength, int resistence) {
		super(name, cost, 4);
		this.strength = strength;
		this.resistence = resistence;
	}
	
	public int getResistence() {
		return resistence;
	}
	public void setResistence(int resistence) {
		this.resistence = resistence;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}

}
