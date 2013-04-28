package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.service.ActivitiProcessService;

@Service(value = "activitiProcessService")
public class ActivitiProcessServiceImpl implements ActivitiProcessService {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
	private TaskService taskService;
    
    @Override
	public String startProcess(ProcessKey key) {
		return startProcess(key, null);
	}
    
    @Override
	public String startProcess(ProcessKey key, Map<String, Object> variables) {
    	return startProcess(key.name(), variables);
	}

    @Override
    public String startProcess(String key, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
        return processInstance.getId();
    }
	
	@Override
	public List<Task> getTasksForAssigne(String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).list();
	}

	@Override
	public void completeTask(String taskId) {
		completeTask(taskId, null);
	}

	@Override
	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

}
