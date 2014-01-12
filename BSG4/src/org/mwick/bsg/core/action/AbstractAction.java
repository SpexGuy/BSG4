package org.mwick.bsg.core.action;

import org.mwick.bsg.core.Board;

public abstract class AbstractAction implements Action {
	@Override
	public boolean canAct(Board b) {
		return true;
	}

}
