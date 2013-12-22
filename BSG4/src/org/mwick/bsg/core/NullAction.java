package org.mwick.bsg.core;

public class NullAction implements Action {

	@Override
	public Type getType() {
		return Action.Type.PASSIVE;
	}

	@Override
	public boolean canAct() {
		return true;
	}

	@Override
	public void act() {
		
	}

}
