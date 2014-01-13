package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;

public class ActionDestinationCard extends DestinationCard {

	private Action action;
	
	public ActionDestinationCard(int distance, Action action) {
		super(distance);
		this.action = action;
	}
	
	protected ActionDestinationCard(ActionDestinationCard old) {
		super(old);
		this.action = old.action;
	}

	@Override
	public boolean canAct(Board b) {
		return action.canAct(b);
	}
	
	@Override
	public void act(Board b) {
		action.act(b);
		super.act(b);
	}
	
	@Override
	public ActionDestinationCard copy() {
		return new ActionDestinationCard(this);
	}

}
