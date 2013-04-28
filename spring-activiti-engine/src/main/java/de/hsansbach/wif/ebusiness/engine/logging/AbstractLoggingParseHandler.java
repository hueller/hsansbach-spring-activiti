package de.hsansbach.wif.ebusiness.engine.logging;

import org.activiti.engine.parse.BpmnParseHandler;

import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingExecutionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingStartEndEventExecutionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingTransitionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingUserTaskExecutionListener;

public abstract class AbstractLoggingParseHandler implements BpmnParseHandler {

	protected final LoggingExecutionListener loggingExecutionListener;
	protected final LoggingTransitionListener loggingTransitionListener;
	protected final LoggingUserTaskExecutionListener loggingUserTaskExecutionListener;
	protected final LoggingStartEndEventExecutionListener loggingStartEndEventExecutionListener;

	public AbstractLoggingParseHandler() {
		LoggingListeners loggingListeners = new LoggingListeners();
		loggingExecutionListener = loggingListeners.executionListener;
		loggingTransitionListener = loggingListeners.transitionListener;
		loggingUserTaskExecutionListener = loggingListeners.userTaskExecutionListener;
		loggingStartEndEventExecutionListener = loggingListeners.startEndEventExecutionListener;
	}

}