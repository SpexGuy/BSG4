package org.mwick.bsg.core;

public aspect Pointcuts {
	public static pointcut BoardOperation(Board b) :
		execution(* Board+.*(..)) && this(b);
}
