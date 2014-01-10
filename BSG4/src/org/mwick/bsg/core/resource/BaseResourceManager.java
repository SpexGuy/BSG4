package org.mwick.bsg.core.resource;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Descriptor;

public class BaseResourceManager extends ResourceManager {

	private static final long serialVersionUID = 8146790274866133934L;

	public static final Descriptor<Resource>
			FUEL = 		 AbstractListManager.getDescriptor(Resource.class, 0),
			FOOD = 		 AbstractListManager.getDescriptor(Resource.class, 1),
			MORALE = 	 AbstractListManager.getDescriptor(Resource.class, 2),
			POPULATION = AbstractListManager.getDescriptor(Resource.class, 3);
	
	public BaseResourceManager() {
		tokens.add(new Resource(8));//fuel
		tokens.add(new Resource(8));//food
		tokens.add(new Resource(10));//morale
		tokens.add(new Resource(12));//population
	}
}
