package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.resource.BaseResourceManager;

public class CylonAmbush extends DestinationCard {

	public CylonAmbush() {
		super(3);
	}

	public CylonAmbush(CylonAmbush old) {
		super(old);
	}
	
	@Override
	public void act(Board b) {
		BaseResourceManager.FUEL.get(b).addAmount(-1);
		//TODO:[ship] place a basestar and 3 raiders in FORE and 3 civShips in AFT
		super.act(b);
	}

	@Override
	public CylonAmbush copy() {
		return new CylonAmbush(this);
	}

}
