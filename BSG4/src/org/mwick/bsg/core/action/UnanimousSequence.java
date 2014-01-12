package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public class UnanimousSequence extends Sequence {

	@Override
	public boolean canAct(Board b) {
		for (Action a : actions) {
			if (!a.canAct(b)) {
				return false;
			}
		}
		return true;
	}

}
