package org.mwick.bsg.core.ship;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mwick.bsg.core.Descriptor;

public class BaseSpaceArea implements SpaceArea {

	private int position;
	
	private SpaceArea cw;
	private SpaceArea ccw;
	
	private Map<Class<? extends Ship<?>>, List<Descriptor<?>>> ships =
			new HashMap<Class<? extends Ship<?>>, List<Descriptor<?>>>();
	
	public BaseSpaceArea(int position) {
		this.position = position;
	}
	
	public void link(SpaceArea cw, SpaceArea ccw) {
		this.cw = cw;
		this.ccw = ccw;
	}
	
	@Override
	public int distanceTo(SpaceArea other) {
		//This function of the difference produces the output
		//0,1,2,3,2,1,0 for differences 0,1,2,3,4,5,6
		//which is the desired behavior for a ring of size 6.
		return 3 - Math.abs(3 - Math.abs(position-((BaseSpaceArea)other).position));
	}

	@Override
	public boolean canSpawnVipers() {
		return position < 2;
	}

	@Override
	public SpaceArea getCW() {
		return cw;
	}

	@Override
	public SpaceArea getCCW() {
		return ccw;
	}

	@Override
	public <T extends Ship<T>> int getNumShips(Class<T> type) {
		List<Descriptor<?>> s = ships.get(type);
		if (s == null)
			return 0;
		return s.size();
	}

	@Override
	public <T extends Ship<T>> boolean remove(Descriptor<T> ship) {
		List<Descriptor<?>> s = ships.get(ship.getClass());
		if (s == null)
			return false;
		return s.remove(ship);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Ship<T>> Descriptor<T> remove(Class<T> type) {
		List<Descriptor<?>> s = ships.get(type);
		if (s == null)
			return null;
		return (Descriptor<T>) s.remove(s.size()-1);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Ship<T>> void add(Descriptor<T> ship) {
		if (!ships.containsKey(ship.getClass()))
			ships.put((Class<? extends Ship<?>>) ship.getClass(), new LinkedList<Descriptor<?>>());
		ships.get(ship.getClass()).add(ship);
	}

}
