package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.List;

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
		return startProcess(key.name());
	}

    @Override
    public String startProcess(String key) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        return processInstance.getId();
    }
	
	@Override
	public List<Task> getTasksForAssigne(String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).list();
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

}
