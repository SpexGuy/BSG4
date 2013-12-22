package org.mwick.bsg.base;

import java.util.ArrayList;

import org.mwick.bsg.core.AbstractResourceManager;
import org.mwick.bsg.core.Resource;

public class BaseResourceManager extends AbstractResourceManager {
	public static final int FUEL = 0,
							FOOD = 1,
							MORALE = 2,
							POPULATION = 3;
	
	public BaseResourceManager() {
		resources = new ArrayList<Resource>(4);
		resources.add(new Resource(8));//fuel
		resources.add(new Resource(8));//food
		resources.add(new Resource(10));//morale
		resources.add(new Resource(12));//population
	}
}
