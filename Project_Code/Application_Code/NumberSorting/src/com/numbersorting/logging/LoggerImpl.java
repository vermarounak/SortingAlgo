package com.numbersorting.logging;

import org.apache.log4j.Logger;

/**
 * @author Rounak_Verma. This class provides implementation of Logger interface
 *         and is used for logging exceptions.
 *
 */
public class LoggerImpl implements LoggerInterface {
	private Logger logger = null;

	/**
	 * Public parameterized constructor to initialize LoggerImpl object by
	 * passing string parameter.
	 */
	public LoggerImpl(String className) {
		this.logger = Logger.getLogger(className);
	}

	/**
	 * Method implementation used to log exception messages with Object as
	 * parameter.
	 */
	public void error(Object obj) {
		this.logger.error(obj.toString());
	}

	/**
	 * Method implementation used to log debug messages with Object as
	 * parameter.
	 */
	public void debug(Object obj) {
		this.logger.debug(obj.toString());
	}

	/**
	 * Method implementation used to log warning messages with Object as
	 * parameter.
	 */
	public void warn(Object obj) {
		this.logger.warn(obj.toString());
	}

	/**
	 * Method implementation used to log info messages with Object as parameter.
	 */
	public void info(Object obj) {
		this.logger.info(obj.toString());
	}
}
