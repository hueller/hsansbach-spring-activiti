package de.hsansbach.wif.ebusiness.engine.logging;

import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.pvm.process.TransitionImpl;

public class LoggingListeners {

	public final LoggingExecutionListener executionListener;
	public final LoggingTransitionListener transitionListener;
	public final LoggingUserTaskExecutionListener userTaskExecutionListener;
	public final LoggingStartEndEventExecutionListener startEndEventExecutionListener;

	public LoggingListeners() {
		executionListener = new LoggingExecutionListener();
		transitionListener = new LoggingTransitionListener();
		userTaskExecutionListener = new LoggingUserTaskExecutionListener();
		startEndEventExecutionListener = new LoggingStartEndEventExecutionListener();
	}

	public class LoggingExecutionListener extends AbstractLoggingListener {
		private static final long serialVersionUID = 1L;

		@Override
		protected void notifyExecution(ExecutionEntity execution) {
			logExecution(execution);
		}
	}

	public class LoggingStartEndEventExecutionListener extends AbstractLoggingListener {
		private static final long serialVersionUID = 1L;

		@Override
		protected void notifyExecution(ExecutionEntity execution) {
			String processDefinitionId = execution.getProcessDefinitionId();
			logExecution(execution, processDefinitionId);
		}
	}

	public class LoggingTransitionListener extends AbstractLoggingListener {
		private static final long serialVersionUID = 1L;

		@Override
		protected void notifyExecution(ExecutionEntity execution) {
			TransitionImpl transitionTaken = execution.getTransition();
			if (transitionTaken != null) {
				LOG.info(">>>>>[{}] ({} -> {} -> {})", new Object[] { execution.getId(),
						transitionTaken.getSource().getId(), transitionTaken.getId(),
						transitionTaken.getDestination().getId() });
			}
		}
	}

	public class LoggingUserTaskExecutionListener extends AbstractLoggingListener {
		private static final long serialVersionUID = 1L;

		@Override
		protected void notifyExecution(ExecutionEntity execution) {
			logExecution(execution, "(user task)");
		}
	}
}
