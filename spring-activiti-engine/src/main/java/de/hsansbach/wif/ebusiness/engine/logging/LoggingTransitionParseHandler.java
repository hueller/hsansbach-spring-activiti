package de.hsansbach.wif.ebusiness.engine.logging;

import java.util.ArrayList;
import java.util.Collection;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;

public class LoggingTransitionParseHandler extends AbstractLoggingParseHandler {

	@Override
	public Collection<Class<? extends BaseElement>> getHandledTypes() {
		return new ArrayList<Class<? extends BaseElement>>() {
			private static final long serialVersionUID = 1L;
			{
				add(SequenceFlow.class);
			}
		};
	}

	@Override
	public void parse(BpmnParse bpmnParse, BaseElement element) {
		bpmnParse.getSequenceFlows().get(element.getId()).addExecutionListener(loggingTransitionListener);
	}

}