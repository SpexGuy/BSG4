package org.mwick.bsg.base;

import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.ActionContainer;
import org.mwick.bsg.core.BoardDependency;

@BoardDependency
public class CrisisCard extends ActionContainer {

	protected Action postCrisis;
	
	public CrisisCard(Action action, Action postCrisis) {
		super(action);
	}
	
	@Override
	public void act() {
		super.act();
		postCrisis.act();
	}
}
