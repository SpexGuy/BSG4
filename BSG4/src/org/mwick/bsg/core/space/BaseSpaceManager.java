package org.mwick.bsg.core.space;

import org.mwick.bsg.core.Board;

public class BaseSpaceManager extends SpaceManager {

	private static final long serialVersionUID = 2637511358652142037L;

	public BaseSpaceManager() {
		super(generateReserves());
		for (int c = 0; c < 6; c++) {
			BaseSpaceArea b = new BaseSpaceArea(c, getDescriptor(c));
			b.link(getDescriptor((c+5)%6), getDescriptor((c+1)%6));
			tokens.add(b);
		}
	}
	
	private static SpaceArea generateReserves() {
		BaseSpaceArea reserves = new BaseSpaceArea(-1, new ListDescriptor<SpaceArea>(SpaceArea.class, -1));
		reserves.link(reserves.getDescriptor(), reserves.getDescriptor());
		return reserves;
	}

	protected BaseSpaceManager(Board b, SpaceManager old) {
		super(b, old);
	}

}
