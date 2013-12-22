package org.mwick.bsg.core;

public interface ResourceManager {
	public Resource getResource(int name);
	
	public static class Change extends AbstractAction {
		private Resource resource;
		private int amount;
		public Change(int name, int amount) {
			super(Action.Type.PASSIVE);
			resource = ((ResourceManager)getBoard().getTokenManager(Resource.class)).getResource(name);
			this.amount = amount;
		}
		@Override
		public void act() {
			resource.addAmount(amount);
		}
	}
}
