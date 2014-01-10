package org.mwick.bsg.core.ship;

import org.mwick.bsg.base.BoardingParty;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public class HeavyRaider extends AbstractShip<HeavyRaider> {

	public HeavyRaider(Descriptor<HeavyRaider> desc) {
		super(desc);
	}
	
	protected HeavyRaider(HeavyRaider old) {
		super(old);
	}
	
	@Override
	public void activate(Board b) {
		if (area.canSpawnVipers()) {
			((BoardingParty)b.getManager(BoardingParty.class)).addCenturion();
			((ShipManager)  b.getManager(Ship.class)).returnShip(desc);
		} else
			;//TODO:[public access] find nearest boarding location and move towards it
	}

	@Override
	public HeavyRaider copy() {
		return new HeavyRaider(this);
	}

}
