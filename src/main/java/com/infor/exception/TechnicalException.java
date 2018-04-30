package com.infor.exception;

public class TechnicalException extends Exception {

	private static final long serialVersionUID = -9063619347471041894L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
