package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public abstract class ActionContainer implements Action {

	private Action action;
	
	public ActionContainer(Action action) {
		this.action = action;
	}
	
	@Override
	public Type getType() {
		return action.getType();
	}

	@Override
	public boolean canAct(Board b) {
		return action.canAct(b);
	}

	@Override
	public void act(Board b) {
		action.act(b);
	}

}
