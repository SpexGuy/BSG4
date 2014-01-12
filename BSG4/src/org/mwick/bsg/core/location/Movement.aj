package org.mwick.bsg.core.location;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.player.Player;

public aspect Movement {
	
	public static aspect LocationModifications {
		private final List<Descriptor<Player>> Location.occupants = new LinkedList<Descriptor<Player>>();
		private final List<Descriptor<Player>> Location.occupantsShared = Collections.unmodifiableList(occupants);
		
		public void Location.addPlayer(Descriptor<Player> p) {
			occupants.add(p);
		}
		
		public void Location.removePlayer(Descriptor<Player> p) {
			boolean success = occupants.remove(p);
			assert(success);
		}
		
		public List<Descriptor<Player>> Location.getOccupants() {
			return occupantsShared;
		}
	}
	
	public static aspect PlayerModifications {
		private Descriptor<Location> Player.location;
		
		public void org.mwick.bsg.core.player.Player.setLocation(Descriptor<Location> loc) {
			this.location = loc;
		}
		
		public Descriptor<Location> Player.getLocation() {
			return this.location;
		}
	}

	public static aspect Enforcer {
		declare error :
		(call(* Location+.addPlayer(..)) ||
		 call(* Location+.removePlayer(..)) ||
		 call(* Player+.setLocation(..))) &&
		!within(LocationManager+) :
		"This method alters only half of a bidirectional relationship, "
		+ "and should only be changed through the MovementManager.";
	}
}