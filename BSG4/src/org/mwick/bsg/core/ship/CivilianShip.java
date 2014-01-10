package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Sequence;
import org.mwick.bsg.core.resource.Resource;
import org.mwick.bsg.core.resource.ResourceManager;

public class CivilianShip extends AbstractShip<CivilianShip> {

	private Action destroyAction;
	
	public CivilianShip(Descriptor<CivilianShip> desc) {
		this(desc, Action.NULL);
	}
	public CivilianShip(Descriptor<CivilianShip> desc, Descriptor<Resource> resource) {
		this(desc,
			new ResourceManager.Change(resource, -1));
	}
	public CivilianShip(Descriptor<CivilianShip> desc, Descriptor<Resource> resource1, Descriptor<Resource> resource2) {
		this(desc,
			new Sequence()
				.addAction(new ResourceManager.Change(resource1, -1))
				.addAction(new ResourceManager.Change(resource2, -1)));
	}
	
	protected CivilianShip(CivilianShip old) {
		super(old);
		this.destroyAction = old.destroyAction;
	}
	
	public CivilianShip(Descriptor<CivilianShip> desc, Action destroy) {
		super(desc);
		destroyAction = destroy;
	}

	@Override
	public void activate(Board b) {
	}
	
	@Override
	public void destroy(Board b) {
		destroyAction.act(b);
		super.destroy(b);
	}
	
	@Override
	public CivilianShip copy() {
		return new CivilianShip(this);
	}

}
