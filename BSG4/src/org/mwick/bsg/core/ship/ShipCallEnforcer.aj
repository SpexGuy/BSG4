package org.mwick.bsg.core.ship;

public aspect ShipCallEnforcer {
	public pointcut ManagerShipCall()
		: (
			call(* Ship+.moveTo(..)) ||
			call(* Ship+.setActive(..))
		  )
		&& !within(ShipManager+);
	
	declare error :
		ManagerShipCall() :
		"This function may change only one half of a bidirectional dependency and therefore should only be called by its associated manager";

}
