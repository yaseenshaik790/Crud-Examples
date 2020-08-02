package com.hcl.crud.exception;

public class CustomerAlreadyExcistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Integer errorCode = 2332;

	public static Integer getErrorcode() {
		return errorCode;
	}

	public CustomerAlreadyExcistException(Long userId) {
		super(userId + " ");
	}

}
