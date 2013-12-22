package org.mwick.bsg.base;

import org.mwick.bsg.core.Ship;
import org.mwick.bsg.core.SpaceArea;

public class BaseSpaceArea implements SpaceArea {

	@Override
	public int distanceTo(SpaceArea other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canSpawnVipers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SpaceArea getCW() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpaceArea getCCW() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumShips(Class<? extends Ship> type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Ship ship) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ship remove(Class<? extends Ship> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Ship ship) {
		// TODO Auto-generated method stub

	}

}
