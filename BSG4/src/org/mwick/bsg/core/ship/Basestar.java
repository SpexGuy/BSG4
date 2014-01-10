package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public class Basestar extends AbstractShip<Basestar> {
	
	public Basestar(Descriptor<Basestar> desc) {
		super(desc);
	}
	
	public Basestar(Basestar old) {
		super(old);
	}
	
	@Override
	public void activate(Board b) {
		//TODO:[damage] damage galactica
	}

	@Override
	public Basestar copy() {
		return new Basestar(this);
	}
}
