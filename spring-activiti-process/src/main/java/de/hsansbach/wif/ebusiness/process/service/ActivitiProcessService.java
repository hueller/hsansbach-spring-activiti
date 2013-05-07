package de.hsansbach.wif.ebusiness.process.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import de.hsansbach.wif.ebusiness.process.ProcessKey;

@Named
public class ActivitiProcessService {
    
    @Inject
    private RuntimeService runtimeService;
    
    @Inject
	private TaskService taskService;
    
    @Inject
    private HistoryService historyService;
    
	public String startProcess(ProcessKey key) {
		return startProcess(key, null);
	}
    
    public String startProcess(ProcessKey key, Map<String, Object> variables) {
    	return startProcess(key.name(), variables);
	}

    public String startProcess(String key, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
        return processInstance.getId();
    }
	
	public List<Task> getTasksForAssigne(String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).list();
	}
	
	public Task getActiveTaskForProcessInstanceId(String processInstanceId) {
		return taskService.createTaskQuery().processInstanceId(processInstanceId).active().singleResult();
	}
	
	public Map<String, Object> getVariablesForProcessInstanceId(String processInstanceId) {
		return runtimeService.getVariables(processInstanceId);
	}

	public Object getVariableForProcessInstanceIdAndVariableKey(String processInstanceId, String variableKey) {
		return runtimeService.getVariable(processInstanceId, variableKey);
	}
	
	public void setVariableToProcessInstance(String processInstanceId, String variableKey, Object variableValue) {
		runtimeService.setVariable(processInstanceId, variableKey, variableValue);
	}
	
	public Object getVariableForHistoricProcessInstanceIdAndVariableKey(String processInstanceId, String variableKey) {
		List<HistoricVariableInstance> variables = historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstanceId).list();
		for (HistoricVariableInstance variable : variables) {
			if (variableKey.equals(variable.getVariableName())) {
				return variable.getValue();
			}
		}
		return null;
	}

	public void completeTask(String taskId) {
		completeTask(taskId, null);
	}

	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

}
