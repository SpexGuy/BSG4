package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractShip;
import org.mwick.bsg.core.Ship;
import org.mwick.bsg.core.ShipManager;

public class HeavyRaider extends AbstractShip {

	@Override
	public void activate() {
		if (area.canSpawnVipers()) {
			((BoardingParty)getBoard().getTokenManager(BoardingParty.class)).addCenturion();
			((ShipManager)  getBoard().getTokenManager(Ship.class)).returnShip(this);
		} else
			;//TODO:[public access] find nearest boarding location and move towards it
	}

}
