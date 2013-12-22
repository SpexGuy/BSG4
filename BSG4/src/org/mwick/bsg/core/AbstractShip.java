package org.mwick.bsg.core;

@BoardDependency
public abstract class AbstractShip implements Ship {

	protected boolean active;
	protected SpaceArea area;
	
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
	public void destroy() {
		((ShipManager)getBoard().getTokenManager(Ship.class)).returnShip(this);
	}

}
