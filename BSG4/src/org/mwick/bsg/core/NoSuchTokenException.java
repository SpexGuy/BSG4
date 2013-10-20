package org.mwick.bsg.core;

/**
 * An exception which is thrown when a nonexistent token is requested
 * @author Martin Wickham
 *
 */
public class NoSuchTokenException extends Exception {

	private static final long serialVersionUID = -7466530380401958454L;

	public NoSuchTokenException() {
		super();
	}

	public NoSuchTokenException(String message) {
		super(message);
	}
	
	public NoSuchTokenException(Throwable cause) {
		super(cause);
	}
}
