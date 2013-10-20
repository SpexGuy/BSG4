package org.mwick.bsg.base;

import java.util.HashSet;
import java.util.Set;

import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.Choice;
import org.mwick.bsg.core.Hand;

public abstract class Character {
	
	protected Location location;
	
	protected Hand<SkillCard> skillCards;
	
	protected Hand<LoyaltyCard> loyaltyCards;
	
	protected Set<Title> titles;
	
	protected Action oncePerGame;
	
	
	
	public Character(Location startLocation, Action oncePerGame) {
		location = startLocation;
		skillCards = new Hand<SkillCard>();
		loyaltyCards = new Hand<LoyaltyCard>();
		titles = new HashSet<Title>();
		this.oncePerGame = oncePerGame;
	}
	
	
	
	protected abstract Choice getChoices();
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public void removeTitle(Title title) {
		titles.remove(title);
	}
	public void addTitle(Title title) {
		titles.add(title);
	}
}
