package org.mwick.bsg.core;

import java.util.List;

/**
 * This class is abstract because subclasses must decide how to initialize the data members.
 * @author Martin Wickham
 *
 */
public abstract class AbstractResourceManager implements ResourceManager {

	protected List<Resource> resources;
	
	@Override
	public Resource getResource(int name) {
		return resources.get(name);
	}

}
