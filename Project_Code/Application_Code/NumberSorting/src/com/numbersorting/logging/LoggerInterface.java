package com.numbersorting.logging;

/**
 * @author Rounak_Verma. This interface provides different type of logging
 *         methods.
 */
public interface LoggerInterface {

	// Method used to log exception messages with Object as parameter.
	public abstract void error(Object paramObject);

	// Method used to log debug messages with Object as parameter.
	public abstract void debug(Object paramObject);

	// Method used to log warning messages with Object as parameter.
	public abstract void warn(Object paramObject);

	// Method used to log info messages with Object as parameter.
	public abstract void info(Object paramObject);

}
