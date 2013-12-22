package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractShipManager;
import org.mwick.bsg.core.Ship;

public class BaseShipManager extends AbstractShipManager {
	public BaseShipManager() {
		reserves = new BaseSpaceArea();
		for (int c = 0; c < 16; c++) {
			addNewShip(new Raider());
		}
		for (int c = 0; c < 4; c++) {
			addNewShip(new HeavyRaider());
		}
		for (int c = 0; c < 8; c++) {
			addNewShip(new Viper());
		}
		for (int c = 0; c < 2; c++) {
			addNewShip(new Basestar());
		}
		addNewShip(new CivilianShip());
		addNewShip(new CivilianShip());
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION, BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION, BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION, BaseResourceManager.FUEL));
		addNewShip(new CivilianShip(BaseResourceManager.POPULATION, BaseResourceManager.MORALE));
		
		//raptors are not considered ships in this implementation
	}
	
	private void addNewShip(Ship s) {
		s.setActive(false);
		s.moveTo(reserves);
		reserves.add(s);
	}

}
