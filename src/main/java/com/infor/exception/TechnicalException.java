package com.infor.exception;

/**
 * Exception class to incorporate all business use case failures
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class TechnicalException extends Exception {

	private static final long serialVersionUID = -9063619347471041894L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
