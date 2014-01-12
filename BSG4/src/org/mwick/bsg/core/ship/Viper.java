package org.mwick.bsg.core.ship;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;
import org.mwick.bsg.core.action.Choice;
import org.mwick.bsg.core.space.SpaceArea;

public class Viper extends AbstractShip<Viper> {
	private static class Attack extends AbstractAction {
		private Descriptor<Viper> viper;
		public Attack(Descriptor<Viper> v) {
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
		new Choice()
			.addAction(new Attack(desc))
			.addAction(new ShipManager.Move<Viper>(desc, this.getArea().get(b).getCW()))
			.addAction(new ShipManager.Move<Viper>(desc, this.getArea().get(b).getCCW()))
		.act(b);
	}
	
	@Override
	public boolean canMoveTo(Board b, Descriptor<SpaceArea> other) {
		if (active)
			return area.get(b).distanceTo(b, other) <= 1;
		return other.get(b).canSpawnVipers();
	}

	@Override
	public Viper copy() {
		return new Viper(this);
	}

}
