package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractShip;
import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.ResourceManager;
import org.mwick.bsg.core.Sequence;

public class CivilianShip extends AbstractShip {

	private Action destroyAction;
	
	public CivilianShip() {
		this(Action.NULL);
	}
	public CivilianShip(int resource) {
		this(new ResourceManager.Change(resource, -1));
	}
	public CivilianShip(int resource1, int resource2) {
		this(new Sequence()
			.addAction(new ResourceManager.Change(resource1, -1))
			.addAction(new ResourceManager.Change(resource2, -1)));
	}
	public CivilianShip(Action destroy) {
		destroyAction = destroy;
	}

	@Override
	public void activate() {
	}
	
	@Override
	public void destroy() {
		destroyAction.act();
		super.destroy();
	}

}
