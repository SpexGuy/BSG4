package org.mwick.bsg.core;

public class Sequence extends ActionList {
	
	public Sequence(Action.Type type) {
		super(type);
	}

	public Sequence() {
		super(Action.Type.PASSIVE);
	}
	
	@Override
	public void act() {
		for (Action a : actions) {
			if (a.canAct()) {
				a.act();
			}
		}
	}
}
