package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Manager;

public class DestinationManager extends AbstractListManager<DestinationCard> {

	private static final long serialVersionUID = -4648328320050484035L;

	private int distance = 0;
	
	public DestinationManager() {
		super(DestinationCard.class);
	}

	public DestinationManager(Board newBoard, DestinationManager old) {
		super(newBoard, old);
	}

	@Override
	public Manager<DestinationCard> copy(Board newBoard) {
		return new DestinationManager(newBoard, this);
	}

	public void addDistance(int distance) {
		this.distance += distance;
	}
	
	public int getDistance() {
		return distance;
	}

}
