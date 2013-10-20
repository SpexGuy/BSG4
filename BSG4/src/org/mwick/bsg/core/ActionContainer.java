package org.mwick.bsg.core;

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
	public boolean canAct() {
		return action.canAct();
	}

	@Override
	public void act() {
		action.act();
	}

}
