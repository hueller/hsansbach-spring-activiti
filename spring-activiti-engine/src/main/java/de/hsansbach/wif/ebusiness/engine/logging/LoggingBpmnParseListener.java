package de.hsansbach.wif.ebusiness.engine.logging;

import java.util.List;

import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.bpmn.parser.BpmnParseListener;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ScopeImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.impl.util.xml.Element;
import org.activiti.engine.impl.variable.VariableDeclaration;

import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingExecutionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingStartEndEventExecutionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingTransitionListener;
import de.hsansbach.wif.ebusiness.engine.logging.LoggingListeners.LoggingUserTaskExecutionListener;

public class LoggingBpmnParseListener implements BpmnParseListener {

	private final LoggingExecutionListener loggingExecutionListener;
	private final LoggingTransitionListener loggingTransitionListener;
	private final LoggingUserTaskExecutionListener loggingUserTaskExecutionListener;
	private final LoggingStartEndEventExecutionListener loggingStartEndEventExecutionListener;

	public LoggingBpmnParseListener() {
		LoggingListeners loggingListeners = new LoggingListeners();
		loggingExecutionListener = loggingListeners.executionListener;
		loggingTransitionListener = loggingListeners.transitionListener;
		loggingUserTaskExecutionListener = loggingListeners.userTaskExecutionListener;
		loggingStartEndEventExecutionListener = loggingListeners.startEndEventExecutionListener;
	}

	@Override
	public void parseProcess(Element processElement, ProcessDefinitionEntity processDefinition) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEventActivity) {
		startEventActivity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingStartEndEventExecutionListener);
	}

	@Override
	public void parseExclusiveGateway(Element exclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseInclusiveGateway(Element inclusiveGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseParallelGateway(Element parallelGwElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseScriptTask(Element scriptTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseServiceTask(Element serviceTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseBusinessRuleTask(Element businessRuleTaskElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseTask(Element taskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingExecutionListener);
	}

	@Override
	public void parseManualTask(Element manualTaskElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_START, loggingUserTaskExecutionListener);
	}

	@Override
	public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
		activity.addExecutionListener(ExecutionListener.EVENTNAME_END, loggingStartEndEventExecutionListener);
	}

	@Override
	public void parseBoundaryTimerEventDefinition(Element timerEventDefinition, boolean interrupting, ActivityImpl timerActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseBoundaryErrorEventDefinition(Element errorEventDefinition, boolean interrupting, ActivityImpl activity, ActivityImpl nestedErrorEventActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseSubProcess(Element subProcessElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseCallActivity(Element callActivityElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseProperty(Element propertyElement, VariableDeclaration variableDeclaration, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseSequenceFlow(Element sequenceFlowElement, ScopeImpl scopeElement, TransitionImpl transition) {
		transition.addExecutionListener(loggingTransitionListener);
	}

	@Override
	public void parseSendTask(Element sendTaskElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseMultiInstanceLoopCharacteristics(Element activityElement, Element multiInstanceLoopCharacteristicsElement, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseIntermediateTimerEventDefinition(Element timerEventDefinition, ActivityImpl timerActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseRootElement(Element rootElement, List<ProcessDefinitionEntity> processDefinitions) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseReceiveTask(Element receiveTaskElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseIntermediateSignalCatchEventDefinition(Element signalEventDefinition, ActivityImpl signalActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseIntermediateMessageCatchEventDefinition(Element messageEventDefinition, ActivityImpl nestedActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseBoundarySignalEventDefinition(Element signalEventDefinition, boolean interrupting, ActivityImpl signalActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseEventBasedGateway(Element eventBasedGwElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseTransaction(Element transactionElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseCompensateEventDefinition(Element compensateEventDefinition, ActivityImpl compensationActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseIntermediateThrowEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseIntermediateCatchEvent(Element intermediateEventElement, ScopeImpl scope, ActivityImpl activity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseBoundaryEvent(Element boundaryEventElement, ScopeImpl scopeElement, ActivityImpl nestedActivity) {
		// Currently no logging is needed for this element
	}

	@Override
	public void parseBoundaryMessageEventDefinition(Element element, boolean interrupting, ActivityImpl messageActivity) {
		// Currently no logging is needed for this element
	}

}