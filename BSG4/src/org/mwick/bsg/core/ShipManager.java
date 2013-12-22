package org.mwick.bsg.core;

public interface ShipManager {
	
	/**
	 * activates all ships of the given type
	 * @param ships the type of ship
	 */
	void activateShips(Class<? extends Ship> ships);
	
	/**
	 * attempts to add a ship to the given space area
	 * @param target the space area to move the ship into
	 * @return the ship that was spawned
	 */
	Ship addShip(Class<? extends Ship> type, SpaceArea target);
	
	/**
	 * attempts to move a ship from <code>from</code> to <code>to</code>
	 * @param type
	 * @param from
	 * @param to
	 * @return the ship that was moved
	 */
	Ship moveShip(Class<? extends Ship> type, SpaceArea from, SpaceArea to);
	
	/**
	 * moves the given ship to <code>to</code>
	 * @param s
	 * @param to
	 */
	void moveShip(Ship s, SpaceArea to);
	
	/**
	 * returns a ship of the given type from the given area to the reserves
	 * @param type
	 * @param from
	 */
	void returnShip(Class<? extends Ship> type, SpaceArea from);
	
	/**
	 * returns the given ship to the reserves
	 * @param s
	 */
	void returnShip(Ship s);
	
	/**
	 * permanently removes a ship of the given type from the game
	 * @param type
	 * @param from
	 */
	void deleteShip(Class<? extends Ship> type, SpaceArea from);
	
	/**
	 * removes the ship from all space areas
	 * @param s
	 */
	void deleteShip(Ship s);
	
	
	public static class Move extends AbstractAction {
		private Ship s;
		private SpaceArea target;
		
		public Move(Ship s, SpaceArea target) {
			super(Action.Type.PASSIVE);
			this.s = s;
			this.target = target;
		}
		
		public boolean canAct() {
			return s.canMoveTo(target);
		}
		
		public void act() {
			((ShipManager) getBoard().getTokenManager(Ship.class)).moveShip(s, target);
		}
	}
}
