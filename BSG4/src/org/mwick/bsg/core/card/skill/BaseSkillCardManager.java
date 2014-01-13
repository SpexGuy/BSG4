package org.mwick.bsg.core.card.skill;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.card.ComplexDeck;
import org.mwick.bsg.core.card.Deck;

public class BaseSkillCardManager extends SkillCardManager {

	private static final long serialVersionUID = 6333800831529899038L;

	public static final int POLITICS = 0,
							LEADERSHIP = 1,
							TACTICS = 2,
							PILOTING = 3,
							ENGINEERING = 4;
	
	public BaseSkillCardManager() {
		super();
		
		for (int _ = 0; _ < 8; _++)
			addCard(new ConsolidatePower(1, POLITICS));
		for (int _ = 0; _ < 6; _++)
			addCard(new ConsolidatePower(2, POLITICS));
		for (int _ = 0; _ < 4; _++)
			addCard(new InvestigativeCommittee(3, POLITICS));
		for (int _ = 0; _ < 2; _++)
			addCard(new InvestigativeCommittee(4, POLITICS));
		for (int _ = 0; _ < 1; _++)
			addCard(new InvestigativeCommittee(5, POLITICS));
		
		for (int _ = 0; _ < 8; _++)
			addCard(new ExecutiveOrder(1, LEADERSHIP));
		for (int _ = 0; _ < 6; _++)
			addCard(new ExecutiveOrder(2, LEADERSHIP));
		for (int _ = 0; _ < 4; _++)
			addCard(new DeclareEmergency(3, LEADERSHIP));
		for (int _ = 0; _ < 2; _++)
			addCard(new DeclareEmergency(4, LEADERSHIP));
		for (int _ = 0; _ < 1; _++)
			addCard(new DeclareEmergency(5, LEADERSHIP));

		for (int _ = 0; _ < 8; _++)
			addCard(new LaunchScout(1, TACTICS));
		for (int _ = 0; _ < 6; _++)
			addCard(new LaunchScout(2, TACTICS));
		for (int _ = 0; _ < 4; _++)
			addCard(new StrategicPlan(3, TACTICS));
		for (int _ = 0; _ < 2; _++)
			addCard(new StrategicPlan(4, TACTICS));
		for (int _ = 0; _ < 1; _++)
			addCard(new StrategicPlan(5, TACTICS));
			
		for (int _ = 0; _ < 8; _++)
			addCard(new EvasiveManeuvers(1, PILOTING));
		for (int _ = 0; _ < 6; _++)
			addCard(new EvasiveManeuvers(2, PILOTING));
		for (int _ = 0; _ < 4; _++)
			addCard(new MaximumFirepower(3, PILOTING));
		for (int _ = 0; _ < 2; _++)
			addCard(new MaximumFirepower(4, PILOTING));
		for (int _ = 0; _ < 1; _++)
			addCard(new MaximumFirepower(5, PILOTING));
			
		for (int _ = 0; _ < 8; _++)
			addCard(new Repair(1, ENGINEERING));
		for (int _ = 0; _ < 6; _++)
			addCard(new Repair(2, ENGINEERING));
		for (int _ = 0; _ < 4; _++)
			addCard(new ScientificResearch(3, ENGINEERING));
		for (int _ = 0; _ < 2; _++)
			addCard(new ScientificResearch(3, ENGINEERING));
		for (int _ = 0; _ < 1; _++)
			addCard(new ScientificResearch(3, ENGINEERING));
	}

	public BaseSkillCardManager(Board b, BaseSkillCardManager old) {
		super(b, old);
	}

	@Override
	public BaseSkillCardManager copy(Board newBoard) {
		return new BaseSkillCardManager(newBoard, this);
	}

	@Override
	protected Deck<Descriptor<SkillCard>> newSkillDeck(int index) {
		return new ComplexDeck<Descriptor<SkillCard>>();
	}

}
