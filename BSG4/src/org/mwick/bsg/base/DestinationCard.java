package org.mwick.bsg.base;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.ActionContainer;

public class DestinationCard extends ActionContainer {

	protected int distance;
	
	public DestinationCard(Action action, int distance) {
		super(action);
		this.distance = distance;
	}
	
	@Override
	public void act(Board b) {
		super.act(b);
		//TODO:[distance] add distance to counter
	}

}
