package org.mwick.bsg.core;

public abstract class AbstractAction implements Action {

	protected Action.Type type;
	
	public AbstractAction(Action.Type type) {
		this.type = type;
	}
	
	@Override
	public Action.Type getType() {
		return type;
	}
	
	@Override
	public boolean canAct() {
		// This method is meant to act as a join point for aop additions
		return true;
	}

}
