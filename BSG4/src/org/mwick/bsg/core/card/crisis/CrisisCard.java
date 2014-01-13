package org.mwick.bsg.core.card.crisis;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.ActionContainer;
import org.mwick.bsg.core.ship.Basestar;
import org.mwick.bsg.core.ship.HeavyRaider;
import org.mwick.bsg.core.ship.Raider;
import org.mwick.bsg.core.ship.Ship;
import org.mwick.bsg.core.ship.ShipManager;

public class CrisisCard extends ActionContainer {

	protected Action postCrisis;
	
	public CrisisCard(Action action, Action postCrisis) {
		super(action);
	}
	
	@Override
	public void act(Board b) {
		super.act(b);
		postCrisis.act(b);
	}
	

	
	
	
	public static final Action activateRaiders =
		new AbstractAction() {
			public void act(Board b) {
				((ShipManager)(b.getManager(Ship.class))).activateShips(b, Raider.class);
			}
		};
	public static final Action activateHeavyRaiders =
		new AbstractAction() {
			public void act(Board b) {
				((ShipManager)(b.getManager(Ship.class))).activateShips(b, HeavyRaider.class);
			}
		};
	public static final Action activateBasestars =
		new AbstractAction() {
			public void act(Board b) {
				((ShipManager)(b.getManager(Ship.class))).activateShips(b, Basestar.class);
			}
		};
	public static final Action activateLaunch =
		new AbstractAction() {
			public void act(Board b) {
				((ShipManager)(b.getManager(Ship.class))).launchShips(b, Raider.class, 3);
			}
		};
}
