package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.resource.BaseResourceManager;

public class IcyMoon extends DestinationCard {

	public IcyMoon() {
		super(1);
	}
	
	protected IcyMoon(IcyMoon old) {
		super(old);
	}
	
	@Override
	public void act(Board b) {
		BaseResourceManager.FUEL.get(b).addAmount(-1);
		//TODO:[prompt] prompt admiral to risk raptor to roll die
		int roll = b.rollDie();
		if (roll >= 3)
			BaseResourceManager.FOOD.get(b).addAmount(1);
		else
			;//TODO:[raptor] lose 1 raptor
		super.act(b);
	}

	@Override
	public IcyMoon copy() {
		return new IcyMoon(this);
	}

}
