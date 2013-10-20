package org.mwick.bsg.core;

public class NullAction implements Action {

	@Override
	public Type getType() {
		return null;
	}

	@Override
	public boolean canAct() {
		return false;
	}

	@Override
	public void act() {
		
	}

}
