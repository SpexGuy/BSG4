package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractShip;

public class Raider extends AbstractShip {

	@Override
	public void activate() {
		if (this.getArea().getNumShips(Viper.class) > 0)
			;//TODO:[attack] attack viper
		if (this.getArea().getNumShips(CivilianShip.class) > 0)
			;//TODO:[attack] attack civilian ship
		//TODO:[public access] find nearest civilian ship
		//TODO:[damage] if no civs, attack galactica
	}

}
