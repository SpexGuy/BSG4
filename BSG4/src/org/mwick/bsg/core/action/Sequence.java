package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public class Sequence extends ActionList {
	
	public Sequence(Action.Type type) {
		super(type);
	}

	public Sequence() {
		super(Action.Type.PASSIVE);
	}
	
	@Override
	public void act(Board b) {
		for (Action a : actions) {
			if (a.canAct(b)) {
				a.act(b);
			}
		}
	}
}
