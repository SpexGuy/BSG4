package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Choice;

public class Viper extends AbstractShip<Viper> {
	private static class Attack extends AbstractAction {
		private Viper viper;
		public Attack(Viper v) {
			super(Action.Type.PASSIVE);
			viper = v;
		}
		@Override
		public boolean canAct(Board b) {
			//TODO:[public access] find out if the viper can attack anything
			return true;
		}
		@Override
		public void act(Board b) {
			//TODO:[attack] viper attacks someone
			//choose a target
			//handle attack logic
		}
	}
	
	public Viper(Descriptor<Viper> desc) {
		super(desc);
	}
	
	protected Viper(Viper old) {
		super(old);
	}
	
	@Override
	public void activate(Board b) {
		new Choice(Action.Type.PASSIVE)
			.addAction(new Attack(this))
			.addAction(new ShipManager.Move<Viper>(desc, this.getArea().getCW()))
			.addAction(new ShipManager.Move<Viper>(desc, this.getArea().getCCW()))
		.act(b);
	}
	
	@Override
	public boolean canMoveTo(SpaceArea other) {
		if (active)
			return area.distanceTo(other) <= 1;
		return other.canSpawnVipers();
	}

	@Override
	public Viper copy() {
		return new Viper(this);
	}

}
