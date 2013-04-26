package de.hsansbach.wif.ebusiness.engine.logging;

import java.util.ArrayList;
import java.util.Collection;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;

public class LoggingStartEndEventExecutionParseHandler extends AbstractLoggingParseHandler {

	@Override
	public Collection<Class<? extends BaseElement>> getHandledTypes() {
		return new ArrayList<Class<? extends BaseElement>>() {
			private static final long serialVersionUID = 1L;
			{
				add(StartEvent.class);
				add(EndEvent.class);
			}
		};
	}

	@Override
	public void parse(BpmnParse bpmnParse, BaseElement element) {
		bpmnParse.getCurrentActivity().addExecutionListener(ExecutionListener.EVENTNAME_START, loggingStartEndEventExecutionListener);
	}

}