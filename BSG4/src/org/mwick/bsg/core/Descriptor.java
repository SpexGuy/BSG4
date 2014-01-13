package org.mwick.bsg.core;

public interface Descriptor<T> {
	public T get(Board b);
	public Class<T> getTokenClass();
}
