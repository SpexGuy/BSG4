package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public class Raider extends AbstractShip<Raider> {

	public Raider(Descriptor<Raider> desc) {
		super(desc);
	}
	
	protected Raider(Raider old) {
		super(old);
	}
	
	@Override
	public void activate(Board b) {
		if (this.getArea().getNumShips(Viper.class) > 0)
			;//TODO:[attack] attack viper
		if (this.getArea().getNumShips(CivilianShip.class) > 0)
			;//TODO:[attack] attack civilian ship
		//TODO:[public access] find nearest civilian ship
		//TODO:[damage] if no civs, attack galactica
	}

	@Override
	public Raider copy() {
		return new Raider(this);
	}

}
