package org.mwick.bsg.base;

import org.mwick.bsg.core.Hand;

public class Player {

	protected Location location;
	
	protected Hand<SkillCard> skillCards;
	
	protected Hand<LoyaltyCard> loyaltyCards;
	
	
	public Player() {
		skillCards = new Hand<SkillCard>();
		loyaltyCards = new Hand<LoyaltyCard>();
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void discardSkillCards(int number) {
		// TODO:[skill][prompt] discarding cards
	}
}
