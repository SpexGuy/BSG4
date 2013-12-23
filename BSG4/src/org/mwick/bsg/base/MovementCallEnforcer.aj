package org.mwick.bsg.base;

public aspect MovementCallEnforcer {
	declare error :
	(call(* Location+.addPlayer(..)) ||
	 call(* Location+.removePlayer(..)) ||
	 call(* Player+.setLocation(..))) &&
	!within(MovementManager+) :
	"This method alters only half of a bidirectional relationship, and should only be changed through the MovementManager.";
}
