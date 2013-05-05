package de.hsansbach.wif.ebusiness.process.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.process.ProcessKey;

@Service
public class ActivitiProcessService {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
	private TaskService taskService;
    
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
	
	public Task getTaskForAssigneAndProcessInstanceId(String processInstanceId, String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).processInstanceId(processInstanceId).singleResult();
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

	public void completeTask(String taskId) {
		completeTask(taskId, null);
	}

	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

}
