package org.mwick.bsg.core.debug;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;

public aspect ActionAssertionAspect {
	
	pointcut actionAct(Action a, Board b) : execution(void Action+.act(Board)) && this(a) && args(b);
	
	before(Action a, Board b) : actionAct(a,b) {
		assert(a.canAct(b));
	}
}
