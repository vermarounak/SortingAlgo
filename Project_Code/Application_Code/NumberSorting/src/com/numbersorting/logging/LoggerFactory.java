package com.numbersorting.logging;

import java.util.ResourceBundle;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author Rounak_Verma
 *
 */
public class LoggerFactory {

	// Private Constructor to avoid creation of object creation of this class.
	private LoggerFactory() {

	}

	/** Static method used to get instance of LoggerImpl class. */
	public static LoggerInterface getLogger(String className) {
		return new LoggerImpl(className);
	}

	// Static block to initialize log4j in the application by reading log4j
	// config file placed on the path mentioned in environment.properties file.
	static {
		ResourceBundle rb = ResourceBundle.getBundle("environment");
		String log4jpath = rb.getString("LOG4J_FILE_PATH").trim();
		if (log4jpath != null) {
			DOMConfigurator.configure(log4jpath);
		}
	}
}
