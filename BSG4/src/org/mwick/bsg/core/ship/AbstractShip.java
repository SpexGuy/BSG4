package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public abstract class AbstractShip<T extends AbstractShip<T>> implements Ship<T> {

	protected boolean active;
	protected SpaceArea area;
	protected Descriptor<T> desc;
	
	public AbstractShip(Descriptor<T> desc) {
		this.desc = desc;
	}
	
	protected AbstractShip(AbstractShip<T> old) {
		this.area = old.area;
		this.active = old.active;
		this.desc = old.desc;
	}

	@Override
	public boolean canMoveTo(SpaceArea target) {
		return true;
	}

	@Override
	public SpaceArea getArea() {
		return area;
	}

	@Override
	public void moveTo(SpaceArea target) {
		area = target;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public void destroy(Board b) {
		((ShipManager)b.getManager(Ship.class)).returnShip(desc);
	}
	
	@Override
	public Descriptor<T> getDescriptor() {
		return desc;
	}

}
