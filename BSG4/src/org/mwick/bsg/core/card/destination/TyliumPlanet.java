package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.resource.BaseResourceManager;
import org.mwick.bsg.core.resource.Resource;

public class TyliumPlanet extends DestinationCard {

	public TyliumPlanet() {
		super(1);
	}
	
	protected TyliumPlanet(TyliumPlanet old) {
		super(old);
	}
	
	@Override
	public void act(Board b) {
		Resource fuel = BaseResourceManager.FUEL.get(b);
		fuel.addAmount(-1);
		//TODO:[prompt] prompt admiral to risk raptor to roll die
		int roll = b.rollDie();
		if (roll >= 3)
			fuel.addAmount(2);
		else
			;//TODO:[raptor] lose 1 raptor
		super.act(b);
	}

	@Override
	public TyliumPlanet copy() {
		return new TyliumPlanet(this);
	}

}
