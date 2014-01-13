package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.resource.BaseResourceManager;

public class AsteroidFeild extends DestinationCard {

	public AsteroidFeild() {
		super(3);
	}

	public AsteroidFeild(AsteroidFeild old) {
		super(old);
	}
	
	@Override
	public void act(Board b) {
		BaseResourceManager.FUEL.get(b).addAmount(-2);
		//TODO:[civship] draw and destroy a civ ship
		super.act(b);
	}

	@Override
	public AsteroidFeild copy() {
		return new AsteroidFeild(this);
	}

}
