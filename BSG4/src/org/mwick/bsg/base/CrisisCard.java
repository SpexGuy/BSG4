package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractAction;
import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.ActionContainer;
import org.mwick.bsg.core.BoardDependency;
import org.mwick.bsg.core.Ship;
import org.mwick.bsg.core.ShipManager;

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
	

	
	
	
	public static final Action activateRaiders =
		new AbstractAction(Action.Type.PASSIVE) {
			public boolean canAct() {
				return true;
			}
			public void act() {
				((ShipManager)(this.getBoard().getTokenManager(Ship.class))).activateShips(Raider.class);
			}
		};
	public static final Action activateHeavyRaiders =
		new AbstractAction(Action.Type.PASSIVE) {
			public boolean canAct() {
				return true;
			}
			public void act() {
				((ShipManager)(this.getBoard().getTokenManager(Ship.class))).activateShips(HeavyRaider.class);
			}
		};
	public static final Action activateBasestars =
		new AbstractAction(Action.Type.PASSIVE) {
			public boolean canAct() {
				return true;
			}
			public void act() {
				((ShipManager)(this.getBoard().getTokenManager(Ship.class))).activateShips(Basestar.class);
			}
		};
	public static final Action activateLaunch =
		new AbstractAction(Action.Type.PASSIVE) {
			public boolean canAct() {
				return true;
			}
			public void act() {
				//TODO:[ships] Activate Launch
			}
		};
}
