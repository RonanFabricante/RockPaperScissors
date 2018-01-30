package com.transferwise.exam.exception;

public class InvalidRoundRequestException extends RuntimeException {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRoundRequestException(String message) {
        super(message);
    }
}
