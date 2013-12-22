package org.mwick.bsg.base;

import org.mwick.bsg.core.AbstractAction;
import org.mwick.bsg.core.AbstractShip;
import org.mwick.bsg.core.Action;
import org.mwick.bsg.core.Choice;
import org.mwick.bsg.core.ShipManager;
import org.mwick.bsg.core.SpaceArea;

public class Viper extends AbstractShip {
	private static class Attack extends AbstractAction {
		private Viper viper;
		public Attack(Viper v) {
			super(Action.Type.PASSIVE);
			viper = v;
		}
		public boolean canAct() {
			//TODO:[public access] find out if the viper can attack anything
			return true;
		}
		public void act() {
			//TODO:[attack] viper attacks someone
			//choose a target
			//handle attack logic
		}
	}
	
	@Override
	public void activate() {
		new Choice(Action.Type.PASSIVE)
			.addAction(new Attack(this))
			.addAction(new ShipManager.Move(this, this.getArea().getCW()))
			.addAction(new ShipManager.Move(this, this.getArea().getCCW()))
		.act();
	}
	
	@Override
	public boolean canMoveTo(SpaceArea other) {
		if (active)
			return area.distanceTo(other) <= 1;
		return other.canSpawnVipers();
	}

}
