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
		
		addCard(new ConsolidatePower(1, POLITICS));
		addCard(new ConsolidatePower(2, POLITICS));
		addCard(new InvestigativeCommittee(3, POLITICS));
		addCard(new InvestigativeCommittee(4, POLITICS));
		addCard(new InvestigativeCommittee(5, POLITICS));
		
		addCard(new ExecutiveOrder(1, LEADERSHIP));
		addCard(new ExecutiveOrder(2, LEADERSHIP));
		addCard(new DeclareEmergency(3, LEADERSHIP));
		addCard(new DeclareEmergency(4, LEADERSHIP));
		addCard(new DeclareEmergency(5, LEADERSHIP));

		addCard(new LaunchScout(1, TACTICS));
		addCard(new LaunchScout(2, TACTICS));
		addCard(new StrategicPlan(3, TACTICS));
		addCard(new StrategicPlan(4, TACTICS));
		addCard(new StrategicPlan(5, TACTICS));
		
		addCard(new EvasiveManeuvers(1, PILOTING));
		addCard(new EvasiveManeuvers(2, PILOTING));
		addCard(new MaximumFirepower(3, PILOTING));
		addCard(new MaximumFirepower(4, PILOTING));
		addCard(new MaximumFirepower(5, PILOTING));
		
		addCard(new Repair(1, ENGINEERING));
		addCard(new Repair(2, ENGINEERING));
		addCard(new ScientificResearch(3, ENGINEERING));
		addCard(new ScientificResearch(3, ENGINEERING));
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
