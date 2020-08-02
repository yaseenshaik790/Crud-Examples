package com.hcl.crud.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Integer errorCode = 897;

	public CustomerNotFoundException(Long userId) {
		super("jhhj " + userId);
	}

	public static Integer getErrorcode() {
		return errorCode;
	}

}
