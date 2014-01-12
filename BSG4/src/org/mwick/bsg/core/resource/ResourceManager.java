package org.mwick.bsg.core.resource;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Manager;
import org.mwick.bsg.core.action.AbstractAction;

public class ResourceManager extends AbstractListManager<Resource> {

	private static final long serialVersionUID = 3890772260433171710L;

	public ResourceManager() {
		super(Resource.class);
	}

	private ResourceManager(Board newBoard, ResourceManager old) {
		super(newBoard, old);
	}
	
	@Override
	public Manager<Resource> copy(Board newBoard) {
		return new ResourceManager(newBoard, this);
	}

	public static class Change extends AbstractAction {
		private Descriptor<Resource> resource;
		private int amount;
		
		public Change(Descriptor<Resource> resource, int amount) {
			this.resource = resource;
			this.amount = amount;
		}
		
		@Override
		public void act(Board b) {
			resource.get(b).addAmount(amount);
		}
	}
}
