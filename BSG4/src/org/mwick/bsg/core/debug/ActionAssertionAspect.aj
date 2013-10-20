package org.mwick.bsg.core.debug;

import org.mwick.bsg.core.Action;

public aspect ActionAssertionAspect {
	
	pointcut actionAct(Action a) : execution(void Action+.act()) && this(a);
	
	before(Action a) : actionAct(a) {
		assert(a.canAct());
	}
}
