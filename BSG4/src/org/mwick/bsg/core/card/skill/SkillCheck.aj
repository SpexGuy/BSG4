package org.mwick.bsg.core.card.skill;

import java.util.ArrayList;
import java.util.List;

import org.mwick.bsg.core.Board;
import org.mwick.bsg.core.Descriptor;
import org.mwick.bsg.core.action.AbstractAction;
import org.mwick.bsg.core.action.Action;

public class SkillCheck extends AbstractAction {
	public interface Evaluator {
		public int getCardValue(SkillCard card);
	}
	
	private Evaluator eval;
	private Action[] actions;
	private int[] values;
	
	public SkillCheck(Action pass, Action fail, int pivot, Evaluator eval) {
		super(Action.Type.PASSIVE);
		assert(pass.getType() == Action.Type.PASSIVE);
		assert(fail.getType() == Action.Type.PASSIVE);
		this.eval = eval;
		this.actions = new Action[] {pass, fail};
		this.values = new int[] {pivot};
	}

	public SkillCheck(Action pass, Action mid, Action fail, int passThresh, int midThresh, Evaluator eval) {
		super(Action.Type.PASSIVE);
		assert(pass.getType() == Action.Type.PASSIVE);
		assert( mid.getType() == Action.Type.PASSIVE);
		assert(fail.getType() == Action.Type.PASSIVE);
		this.eval = eval;
		this.actions = new Action[] {pass, mid, fail};
		this.values = new int[] {passThresh, midThresh};
	}

	@Override
	public boolean canAct(Board b) {
		for (int c = 0; c < actions.length; c++) {
			if (!actions[c].canAct(b)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void act(Board b) {
		List<Descriptor<SkillCard>> cards = getCards(b);
		
		int total = tallyCards(b, cards);
		
		int index;
		for (index = 0; index < values.length && values[index] > total; index++)
			; //iterate through the thresholds until the check passes.
		assert(actions[index].canAct(b));
		actions[index].act(b);
	}
	
	protected List<Descriptor<SkillCard>> getCards(Board b) {
		return new ArrayList<Descriptor<SkillCard>>();
	}
	
	protected int tallyCards(Board b, List<Descriptor<SkillCard>> cards) {
		int total = 0;
		for (Descriptor<SkillCard> c : cards) {
			total += eval.getCardValue(c.get(b));
		}
		return total;
	}
	
	public static aspect Pointcuts {
		public static pointcut getCardsFromPlayers(Board b) :
			execution(List<Descriptor<SkillCard>> SkillCheck+.getCards(..)) && args(b);
		
		public static pointcut tallyCards(Board b, List<Descriptor<SkillCard>> cards) :
			execution(int SkillCheck+.tallyCards(..)) && args(b, cards);
		
		public static pointcut evaluateSkillCard(SkillCard card) :
			call(int Evaluator+.getCardValue(SkillCard)) && args(card);
	}
}
