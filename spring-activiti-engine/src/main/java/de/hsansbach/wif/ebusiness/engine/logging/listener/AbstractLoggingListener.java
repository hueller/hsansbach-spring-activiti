package de.hsansbach.wif.ebusiness.engine.logging.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLoggingListener implements ExecutionListener {

	private static final long serialVersionUID = 1L;
	
	protected static final Logger LOG = LoggerFactory.getLogger(ExecutionListener.class);

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		if (execution instanceof ExecutionEntity) {
			ExecutionEntity ee = (ExecutionEntity) execution;
			notifyExecution(ee);
		}
	}

	protected abstract void notifyExecution(ExecutionEntity execution);

	protected static void logExecution(ExecutionEntity execution) {
		LOG.info(">>>>>[{}] {} ", execution.getId(), execution.getActivity().getId());
		LOG.info("         variables [{}]: {}", execution.getId(), execution.getVariables());
	}

	protected static void logExecution(ExecutionEntity execution, String processDefinitionId) {
		LOG.info(">>>>>[{}] {} " + processDefinitionId, execution.getId(), execution.getActivity().getId());
		LOG.info("         variables [{}]: {}", execution.getId(), execution.getVariables());
	}

}