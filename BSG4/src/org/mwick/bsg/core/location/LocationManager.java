package org.mwick.bsg.core.location;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Choice;
import org.mwick.bsg.core.player.Player;

public class LocationManager extends AbstractListManager<Location> {

	private static final long serialVersionUID = 6510984639318551619L;

	public LocationManager() {
		super(Location.class);
	}
	
	public LocationManager(Board b, LocationManager old) {
		super(b, old);
	}
	
	public Choice getMoveChoices(Descriptor<Player> p) {
		Choice destinations = new Choice();
		Location current = p.get(board).getLocation().get(board);
		for (Location loc : tokens) {
			if (!loc.equals(current)) {
				destinations.addAction(new Move(p, loc.getDescriptor()));
			}
		}
		return destinations;
	}

	public int getMoveCost(Descriptor<Location> _from, Descriptor<Location> _to) {
		Location from = _from.get(board);
		Location to = _to.get(board);
		if (to.isHazardous())
			return -1;
		if (to.getGroup() != from.getGroup())
			return 1;
		return 0;
	}

	public void movePlayer(Descriptor<Player> p, Descriptor<Location> target) {
		p.get(board).getLocation().get(board).removePlayer(p);
		p.get(board).setLocation(target);
		target.get(board).addPlayer(p);
	}
	
	@Override
	public LocationManager copy(Board b) {
		return new LocationManager(b, this);
	}
	
	public static class Move extends AbstractAction {

		private Descriptor<Player> p;
		private Descriptor<Location> target;
		
		public Move(Descriptor<Player> p, Descriptor<Location> target) {
			this.p = p;
			this.target = target;
		}
		
		@Override
		public boolean canAct(Board b) {
			return getCost(b) >= 0;
		}

		@Override
		public void act(Board b) {
			int cost = getCost(b);
			if (cost > 0)
				p.get(b).discardSkillCards(cost);
			((LocationManager)b.getManager(Location.class)).movePlayer(p, target);
		}
		
		private int getCost(Board b) {
			return ((LocationManager)b.getManager(Location.class)).getMoveCost(p.get(b).getLocation(), target);
		}
		
	}
	
	public static class ForcedMove extends AbstractAction {
		private Descriptor<Player> p;
		private Descriptor<Location> target;
		
		public ForcedMove(Descriptor<Player> p, Descriptor<Location> target) {
			this.p = p;
			this.target = target;
		}
		
		@Override
		public boolean canAct(Board b) {
			return !p.get(b).getLocation().get(b).isBinding();
		}

		@Override
		public void act(Board b) {
			((LocationManager)b.getManager(Location.class)).movePlayer(p, target);
		}
	}
	
	public static class EscapeMove extends AbstractAction {
		
		private Descriptor<Player> p;
		private Descriptor<Location> target;
		
		public EscapeMove(Descriptor<Player> p, Descriptor<Location> target) {
			this.p = p;
			this.target = target;
		}
		
		@Override
		public boolean canAct(Board b) {
			return p.get(b).getLocation().get(b).isBinding();
		}

		@Override
		public void act(Board b) {
			((LocationManager)b.getManager(Location.class)).movePlayer(p, target);
		}

	}
}
