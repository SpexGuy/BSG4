package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public class Sequence extends ActionList {
	
	@Override
	public void act(Board b) {
		for (Action a : actions) {
			if (a.canAct(b)) {
				a.act(b);
			}
		}
	}
}
