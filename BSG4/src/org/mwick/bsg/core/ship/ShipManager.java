package org.mwick.bsg.core.ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mwick.bsg.core.AbstractManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Manager;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;

/**
 * This class is abstract because subclasses must initialize the data members.
 * @author Martin Wickham
 *
 */
@SuppressWarnings("rawtypes")
public class ShipManager extends AbstractManager<Ship> {

	private static final long serialVersionUID = 7620849429421665420L;

	protected final Map<Class<? extends Ship<?>>, List<Ship<?>>> ships;
	protected final SpaceArea reserves;

	public ShipManager(SpaceArea reserves) {
		this.reserves = reserves;
		ships = new HashMap<Class<? extends Ship<?>>, List<Ship<?>>>();
	}
	
	protected ShipManager(Board newBoard, ShipManager old) {
		super(newBoard);
		ships = new HashMap<Class<? extends Ship<?>>, List<Ship<?>>>();
		for (Map.Entry<Class<? extends Ship<?>>, List<Ship<?>>> entry : old.ships.entrySet()) {
			List<Ship<?>> oldList = entry.getValue();
			List<Ship<?>> newList = new ArrayList<Ship<?>>(oldList.size());
			for (Ship<?> s : oldList) {
				newList.add(s.copy());
			}
			ships.put(entry.getKey(), newList);
		}
		this.reserves = old.reserves;
	}
	
	@SuppressWarnings("unchecked")
	protected void addNewShip(Ship<?> s) {
		s.setActive(false);
		s.moveTo(reserves);
		if (!ships.containsKey(s.getClass()))
			ships.put((Class<? extends Ship<?>>) s.getClass(), new ArrayList<Ship<?>>());
		ships.get(s.getClass()).add(s);
		reserves.add(s.getDescriptor());
	}

	public <T extends Ship<T>> void activateShips(Board b, Class<T> type) {
		for (Ship<?> s : ships.get(type)) {
			s.activate(b);
		}
	}

	public <T extends Ship<T>> Descriptor<T> addShip(Class<T> type, SpaceArea target) {
		if (reserves.getNumShips(type) > 0) {
			Descriptor<T> _s = (Descriptor<T>)reserves.remove(type);
			Ship<T> s = _s.get(board);
			s.setActive(true);
			assert(s.canMoveTo(target));
			doMoveShip(s, target);
			return _s;
		}
		return null;
	}

	public <T extends Ship<T>> Descriptor<T> moveShip(Class<T> type, SpaceArea from,
			SpaceArea to) {
		if (from.getNumShips(type) > 0) {
			Descriptor<T> _s = (Descriptor<T>)from.remove(type);
			Ship<T> s = _s.get(board);
			assert(s.canMoveTo(to));
			doMoveShip(s, to);
			return _s;
		}
		return null;
	}
	
	public <T extends Ship<T>> void moveShip(Descriptor<T> _s, SpaceArea to) {
		Ship<T> s = _s.get(board);
		s.getArea().remove(_s);
		assert(s.canMoveTo(to));
		doMoveShip(s, to);
	}
	
	public <T extends Ship<T>> void returnShip(Class<T> type, SpaceArea from) {
		if (from.getNumShips(type) > 0) {
			Ship<T> s = from.remove(type).get(board);
			s.setActive(false);
			doMoveShip(s, reserves);
		}
	}

	public <T extends Ship<T>> void returnShip(Descriptor<T> _s) {
		Ship<T> s = _s.get(board);
		s.getArea().remove(_s);
		s.setActive(false);
		doMoveShip(s, reserves);
	}
	
	public <T extends Ship<T>> void deleteShip(Class<T> type, SpaceArea from) {
		if (from.getNumShips(type) > 0) {
			Ship<T> s = from.remove(type).get(board);
			s.setActive(false);
			s.moveTo(null);
		}
	}

	public <T extends Ship<T>> void deleteShip(Descriptor<T> _s) {
		Ship<T> s = _s.get(board);
		s.getArea().remove(_s);
		s.setActive(false);
		s.moveTo(null);
	}

	protected void doMoveShip(Ship<?> s, SpaceArea to) {
		s.moveTo(to);
		to.add(s.getDescriptor());
	}
	
	@SuppressWarnings("unchecked")
	private <T extends Ship<T>> T fetch(ShipDescriptor<T> desc) {
		return (T) ships.get(desc.shipType).get(desc.listIndex);
	}
	
	@Override
	public Manager<Ship> copy(Board newBoard) {
		return new ShipManager(newBoard, this);
	}

	protected static class ShipDescriptor<T extends Ship<T>> implements Descriptor<T> {
		private final Class<T> shipType;
		private final int listIndex;
		
		public ShipDescriptor(Class<T> shipType, int listIndex) {
			this.shipType = shipType;
			this.listIndex = listIndex;
		}
		
		@Override
		public T get(Board b) {
			return ((ShipManager)b.getManager(Ship.class)).fetch(this);
		}
	}
	
	public static class Move<T extends Ship<T>> extends AbstractAction {
		private Descriptor<T> s;
		private SpaceArea target;
		
		public Move(Descriptor<T> s, SpaceArea target) {
			super(Action.Type.PASSIVE);
			this.s = s;
			this.target = target;
		}
		
		public boolean canAct(Board b) {
			return s.get(b).canMoveTo(target);
		}
		
		public void act(Board b) {
			((ShipManager) b.getManager(Ship.class)).moveShip(s, target);
		}
	}
	
}
