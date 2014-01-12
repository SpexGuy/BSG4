package org.mwick.bsg.core.space;

import org.mwick.bsg.core.AbstractListManager;
import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.Manager;

public class SpaceManager extends AbstractListManager<SpaceArea> {

	private static final long serialVersionUID = 7134054156379666400L;

	private SpaceArea reserves;
	
	public SpaceManager(SpaceArea reserves) {
		super(SpaceArea.class);
		this.reserves = reserves;
	}
	
	protected SpaceManager(Board b, SpaceManager old) {
		super(b, old);
		reserves = old.reserves.copy();
	}
	
	@Override
	protected SpaceArea fetch(ListDescriptor<SpaceArea> desc) {
		if (desc.getIndex() < 0)
			return reserves;
		return super.fetch(desc);
	}
	
	public Descriptor<SpaceArea> getReserves() {
		return reserves.getDescriptor();
	}

	@Override
	public Manager<SpaceArea> copy(Board newBoard) {
		return new SpaceManager(newBoard, this);
	}

}
