package org.mwick.bsg.base;

import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.ActionContainer;

public class DestinationCard extends ActionContainer {

	protected int distance;
	
	public DestinationCard(Action action, int distance) {
		super(action);
		this.distance = distance;
	}
	
	@Override
	public void act() {
		super.act();
		//TODO:[distance] add distance to counter
	}

}