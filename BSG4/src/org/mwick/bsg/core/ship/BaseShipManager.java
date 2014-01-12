package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.resource.BaseResourceManager;

public class BaseShipManager extends ShipManager {

	private static final long serialVersionUID = -7758430231391215261L;

	public BaseShipManager() {
		for (int c = 0; c < 16; c++) {
			addNewShip(new Raider(new ShipDescriptor<Raider>(Raider.class, c)));
		}
		for (int c = 0; c < 4; c++) {
			addNewShip(new HeavyRaider(new ShipDescriptor<HeavyRaider>(HeavyRaider.class, c)));
		}
		for (int c = 0; c < 8; c++) {
			addNewShip(new Viper(new ShipDescriptor<Viper>(Viper.class, c)));
		}
		for (int c = 0; c < 2; c++) {
			addNewShip(new Basestar(new ShipDescriptor<Basestar>(Basestar.class, c)));
		}
		int c = 0;
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++)));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++)));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION, BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION, BaseResourceManager.POPULATION));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION, BaseResourceManager.FUEL));
		addNewShip(new CivilianShip(new ShipDescriptor<CivilianShip>(CivilianShip.class, c++),
				BaseResourceManager.POPULATION, BaseResourceManager.MORALE));
		
		//raptors are not considered ships in this implementation
	}
}
