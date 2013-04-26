package de.hsansbach.wif.ebusiness.engine.logging;

import java.util.ArrayList;
import java.util.Collection;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;

public class LoggingUserTaskExecutionParseHandler extends AbstractLoggingParseHandler {

	@Override
	public Collection<Class<? extends BaseElement>> getHandledTypes() {
		return new ArrayList<Class<? extends BaseElement>>() {
			private static final long serialVersionUID = 1L;
			{
				add(UserTask.class);
			}
		};
	}

	@Override
	public void parse(BpmnParse bpmnParse, BaseElement element) {
		bpmnParse.getCurrentActivity().addExecutionListener(ExecutionListener.EVENTNAME_START, loggingUserTaskExecutionListener);
	}

}