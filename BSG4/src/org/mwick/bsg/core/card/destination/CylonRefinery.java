package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.resource.BaseResourceManager;

public class CylonRefinery extends DestinationCard {

	public CylonRefinery() {
		super(2);
	}

	public CylonRefinery(CylonRefinery old) {
		super(old);
	}

	@Override
	public void act(Board b) {
		BaseResourceManager.FUEL.get(b).addAmount(-1);
		//TODO:[public access] check for at least 2 undamaged vipers
		if (true) {
			//TODO:[prompt] ask admiral to risk 2 vipers
			if (b.rollDie() >= 6) {
				BaseResourceManager.FUEL.get(b).addAmount(2);
			} else {
				//TODO:[attack] damage 2 vipers
			}
		}
		super.act(b);
	}

	@Override
	public CylonRefinery copy() {
		return new CylonRefinery(this);
	}

}
