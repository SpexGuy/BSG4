package org.mwick.bsg.core.space;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;

public class BaseSpaceManager extends SpaceManager {

	private static final long serialVersionUID = 2637511358652142037L;

	public static final Descriptor<SpaceArea>
		RESERVES		= getDescriptor(SpaceArea.class, -1),
		PORT_BOW 		= getDescriptor(SpaceArea.class, 0),
		PORT_QUARTER	= getDescriptor(SpaceArea.class, 1),
		AFT				= getDescriptor(SpaceArea.class, 2),
		STAR_QUARTER	= getDescriptor(SpaceArea.class, 3),
		STAR_BOW		= getDescriptor(SpaceArea.class, 4),
		FORE			= getDescriptor(SpaceArea.class, 5);

	public BaseSpaceManager() {
		super(generateReserves());
		for (int c = 0; c < 6; c++) {
			BaseSpaceArea b = new BaseSpaceArea(c, getDescriptor(c));
			b.link(getDescriptor((c+5)%6), getDescriptor((c+1)%6));
			tokens.add(b);
		}
	}
	
	private static SpaceArea generateReserves() {
		BaseSpaceArea reserves = new BaseSpaceArea(-1, RESERVES);
		reserves.link(RESERVES, RESERVES);
		return reserves;
	}

	protected BaseSpaceManager(Board b, SpaceManager old) {
		super(b, old);
	}

}
