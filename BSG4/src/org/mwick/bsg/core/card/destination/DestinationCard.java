package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Token;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.ActionContainer;

public abstract class DestinationCard extends AbstractAction implements Token<DestinationCard> {

	protected int distance;
	
	public DestinationCard(int distance) {
		this.distance = distance;
	}
	
	@Override
	public void act(Board b) {
		((DestinationManager)b.getManager(DestinationCard.class)).addDistance(distance);
	}
}
