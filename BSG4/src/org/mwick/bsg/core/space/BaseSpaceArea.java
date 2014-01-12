package org.mwick.bsg.core.space;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.ship.Ship;

public class BaseSpaceArea implements SpaceArea {

	private int position;
	private Descriptor<SpaceArea> desc;
	
	private Descriptor<SpaceArea> cw;
	private Descriptor<SpaceArea> ccw;
	
	private Map<Class<? extends Ship<?>>, List<Descriptor<?>>> ships;
	
	public BaseSpaceArea(int position, Descriptor<SpaceArea> desc) {
		this.position = position;
		ships = new HashMap<Class<? extends Ship<?>>, List<Descriptor<?>>>();
		this.desc = desc;
	}
	
	protected BaseSpaceArea(BaseSpaceArea old) {
		this.position = old.position;
		this.cw = old.cw;
		this.ccw = old.ccw;
		this.ships = new HashMap<Class<? extends Ship<?>>, List<Descriptor<?>>>();
		for (Map.Entry<Class<? extends Ship<?>>, List<Descriptor<?>>> entry : old.ships.entrySet()) {
			ships.put(entry.getKey(), new ArrayList<Descriptor<?>>(entry.getValue()));
		}
	}

	public void link(Descriptor<SpaceArea> cw, Descriptor<SpaceArea> ccw) {
		this.cw = cw;
		this.ccw = ccw;
	}
	
	@Override
	public int distanceTo(Board b, Descriptor<SpaceArea> other) {
		//This function of the difference produces the output
		//0,1,2,3,2,1,0 for differences 0,1,2,3,4,5,6
		//which is the desired behavior for a ring of size 6.
		return 3 - Math.abs(3 - Math.abs(position-((BaseSpaceArea)other.get(b)).position));
	}

	@Override
	public boolean canSpawnVipers() {
		return position < 2;
	}

	@Override
	public Descriptor<SpaceArea> getCW() {
		return cw;
	}

	@Override
	public Descriptor<SpaceArea> getCCW() {
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
	public <T extends Ship<T>> void add(Descriptor<T> ship) {
		if (!ships.containsKey(ship.getTokenClass()))
			ships.put(ship.getTokenClass(), new LinkedList<Descriptor<?>>());
		ships.get(ship.getTokenClass()).add(ship);
	}

	@Override
	public SpaceArea copy() {
		return new BaseSpaceArea(this);
	}

	@Override
	public Descriptor<SpaceArea> getDescriptor() {
		return desc;
	}

}
