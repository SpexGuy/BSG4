package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;

public class RagnarAnchorage extends DestinationCard {

	public RagnarAnchorage() {
		super(1);
	}

	public RagnarAnchorage(RagnarAnchorage old) {
		super(old);
	}
	
	@Override
	public void act(Board b) {
		//TODO:[prompt] select damaged vipers and raptor
		super.act(b);
	}

	@Override
	public RagnarAnchorage copy() {
		return new RagnarAnchorage(this);
	}

}
