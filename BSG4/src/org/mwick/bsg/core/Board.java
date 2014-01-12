package org.mwick.bsg.core;

import java.util.HashMap;
import java.util.Map;

public final class Board {

	public static final Board current = new Board();

	private Map<Class<?>, Manager<?>> managers = new HashMap<Class<?>, Manager<?>>();
	
	private Board() {} //constructor is private
	
	@SuppressWarnings("unchecked") //the addManager function forces the T to be equivalent
	public <T> Manager<T> getManager(Class<T> tokenClass) {
		return (Manager<T>) managers.get(tokenClass);
	}
	
	public <T> void addManager(Class<T> token, Manager<T> manager) {
		managers.put(token, manager);
	}

	public Board copy() {
		Board cp = new Board();
		for (Map.Entry<Class<?>, Manager<?>> entry : managers.entrySet()) {
			cp.managers.put(entry.getKey(), entry.getValue().copy(cp));
		}
		return cp;
	}

	public int rollDie() {
		return (int)(Math.random()*8) + 1;
	}
}
