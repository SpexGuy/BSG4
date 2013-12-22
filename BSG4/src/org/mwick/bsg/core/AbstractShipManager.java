package org.mwick.bsg.core;

import java.util.List;
import java.util.Map;

/**
 * This class is abstract because subclasses must initialize the data members.
 * @author Martin Wickham
 *
 */
public abstract class AbstractShipManager implements ShipManager {

	protected Map<Class<? extends Ship>, List<Ship>> ships;
	protected SpaceArea reserves;
	
	@Override
	public void activateShips(Class<? extends Ship> type) {
		for (Ship s : ships.get(type)) {
			s.activate();
		}
	}

	@Override
	public Ship addShip(Class<? extends Ship> type, SpaceArea target) {
		if (reserves.getNumShips(type) > 0) {
			Ship s = reserves.remove(type);
			s.setActive(true);
			assert(s.canMoveTo(target));
			doMoveShip(s, target);
			return s;
		}
		return null;
	}

	@Override
	public Ship moveShip(Class<? extends Ship> type, SpaceArea from,
			SpaceArea to) {
		if (from.getNumShips(type) > 0) {
			Ship s = from.remove(type);
			assert(s.canMoveTo(to));
			doMoveShip(s, to);
			return s;
		}
		return null;
	}
	
	@Override
	public void moveShip(Ship s, SpaceArea to) {
		s.getArea().remove(s);
		assert(s.canMoveTo(to));
		doMoveShip(s, to);
	}
	
	@Override
	public void returnShip(Class<? extends Ship> type, SpaceArea from) {
		if (from.getNumShips(type) > 0) {
			Ship s = from.remove(type);
			s.setActive(false);
			doMoveShip(s, reserves);
		}
	}

	@Override
	public void returnShip(Ship s) {
		s.getArea().remove(s);
		s.setActive(false);
		doMoveShip(s, reserves);
	}
	
	@Override
	public void deleteShip(Class<? extends Ship> type, SpaceArea from) {
		if (from.getNumShips(type) > 0) {
			Ship s = from.remove(type);
			s.setActive(false);
			s.moveTo(null);
		}
	}

	@Override
	public void deleteShip(Ship s) {
		s.getArea().remove(s);
		s.setActive(false);
		s.moveTo(null);
	}

	protected void doMoveShip(Ship s, SpaceArea to) {
		s.moveTo(to);
		to.add(s);
	}

	
}
