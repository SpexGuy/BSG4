package org.mwick.bsg.core.player;

import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.card.Hand;
import org.mwick.bsg.core.card.loyalty.LoyaltyCard;
import org.mwick.bsg.core.card.skill.SkillCard;

public class Player implements Token<Player> {

	protected Hand<SkillCard> skillCards;
	
	protected Hand<LoyaltyCard> loyaltyCards;
	
	
	public Player() {
		skillCards = new Hand<SkillCard>();
		loyaltyCards = new Hand<LoyaltyCard>();
	}
	
	public Player(Player player) {
		// TODO Auto-generated constructor stub
	}

	public void discardSkillCards(int number) {
		// TODO:[skill][prompt] discarding cards
	}

	@Override
	public Player copy() {
		return new Player(this);
	}
}
