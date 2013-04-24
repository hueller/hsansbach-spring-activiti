package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.process.service.UserTaskService;

@Service(value = "userTaskService")
public class UserTaskServiceImpl implements UserTaskService {
	
	@Autowired
	private TaskService taskService;
	
	@Override
	public List<Task> getTasksForAssigne(String assigne) {
		return taskService.createTaskQuery().taskAssignee(assigne).list();
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

}