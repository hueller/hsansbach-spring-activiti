package de.hsansbach.wif.ebusiness.process.service;

import java.util.List;

import org.activiti.engine.task.Task;

public interface UserTaskService {
	
	List<Task> getTasksForAssigne(String assigne);
	
	void completeTask(String taskId);

}