package org.mwick.bsg.core.card.destination;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Sequence;
import org.mwick.bsg.core.resource.BaseResourceManager;
import org.mwick.bsg.core.resource.ResourceManager;

public class BaseDestinationManager extends DestinationManager {

	private static final long serialVersionUID = 8844332329327807758L;

	public BaseDestinationManager() {
		super();
		
		addToken(new TyliumPlanet());
		addToken(new TyliumPlanet());
		addToken(new TyliumPlanet());
		addToken(new TyliumPlanet());
		
		addToken(new IcyMoon());
		addToken(new IcyMoon());
		
		addToken(new RagnarAnchorage());
		
		Action barrenPlanet = new ResourceManager.Change(BaseResourceManager.FUEL, -2);
		addToken(new ActionDestinationCard(2, barrenPlanet));
		addToken(new ActionDestinationCard(2, barrenPlanet));
		addToken(new ActionDestinationCard(2, barrenPlanet));
		addToken(new ActionDestinationCard(2, barrenPlanet));
		
		Action remotePlanet = new Sequence()
						.addAction(new ResourceManager.Change(BaseResourceManager.FUEL, -1));
						//TODO:[raptor] also lose a raptor
		addToken(new ActionDestinationCard(2, remotePlanet));
		addToken(new ActionDestinationCard(2, remotePlanet));
		addToken(new ActionDestinationCard(2, remotePlanet));
		
		Action deepSpace =
			new Sequence()
				.addAction(new ResourceManager.Change(BaseResourceManager.FUEL, -1))
				.addAction(new ResourceManager.Change(BaseResourceManager.MORALE, -1));
		addToken(new ActionDestinationCard(2, deepSpace));
		addToken(new ActionDestinationCard(2, deepSpace));
		addToken(new ActionDestinationCard(2, deepSpace));
		
		addToken(new CylonRefinery());
		
		addToken(new AsteroidFeild());
		addToken(new AsteroidFeild());
		
		addToken(new CylonAmbush());
		
		addToken(new ActionDestinationCard(3, new ResourceManager.Change(BaseResourceManager.FUEL, 3)));
	}

	public BaseDestinationManager(Board newBoard, DestinationManager old) {
		super(newBoard, old);
	}

}
