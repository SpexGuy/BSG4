package org.mwick.bsg.base;

import java.util.List;

import org.mwick.bsg.core.AbstractAction;
import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.Choice;

public class BaseMovementManager implements MovementManager {

	List<Location> locations;
	
	@Override
	public Choice getMoveChoices(Player p) {
		Choice destinations = new Choice();
		Location current = p.getLocation();
		for (Location loc : locations) {
			if (loc != current) {
				destinations.addAction(new Move(p, loc));
			}
		}
		return destinations;
	}

	@Override
	public int getMoveCost(Location from, Location to) {
		if (to.isHazardous())
			return -1;
		if (to.getGroup() != from.getGroup())
			return 1;
		return 0;
	}

	@Override
	public void movePlayer(Player p, Location target) {
		p.getLocation().removePlayer(p);
		p.setLocation(target);
		target.addPlayer(p);
	}
	
	
	public class Move extends AbstractAction {

		private Player p;
		private Location target;
		private int cost;
		
		public Move(Player p, Location target) {
			super(Action.Type.MOVEMENT);
			this.p = p;
			this.target = target;
			this.cost = getMoveCost(p.getLocation(), target);
		}
		
		@Override
		public boolean canAct() {
			return cost >= 0;
		}

		@Override
		public void act() {
			if (cost > 0)
				p.discardSkillCards(cost);
			movePlayer(p, target);
		}
		
	}
	
	public class ForcedMove extends AbstractAction {
		
		private Player p;
		private Location target;
		
		public ForcedMove(Player p, Location target) {
			super(Action.Type.PASSIVE);
			this.p = p;
			this.target = target;
		}
		
		@Override
		public boolean canAct() {
			return !p.getLocation().isBinding();
		}

		@Override
		public void act() {
			movePlayer(p, target);
		}
	}
	
	public class EscapeMove extends AbstractAction {
		
		private Player p;
		private Location target;
		
		public EscapeMove(Player p, Location target) {
			super(Action.Type.PASSIVE);
			this.p = p;
			this.target = target;
		}
		
		@Override
		public boolean canAct() {
			return p.getLocation().isBinding();
		}

		@Override
		public void act() {
			movePlayer(p, target);
		}

	}
	
}
