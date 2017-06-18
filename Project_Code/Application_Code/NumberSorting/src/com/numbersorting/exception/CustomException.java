package com.numbersorting.exception;

/**
 * @author Rounak_Verma. This class is used to create custom application based
 *         exception and wrapping every exception to the custom one.
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 101L;

	/**
	 * Public constructor used to create exception object with out any
	 * parameter.
	 */
	public CustomException() {
	}

	/**
	 * Parameterized constructor with String and Throwable parameter used to
	 * create exception object.
	 * 
	 */
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameterized constructor with Throwable parameter used to create
	 * exception object.
	 */
	public CustomException(Throwable cause) {
		super(cause);
	}

}