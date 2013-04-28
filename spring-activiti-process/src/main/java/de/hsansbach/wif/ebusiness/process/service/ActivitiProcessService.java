package de.hsansbach.wif.ebusiness.process.service;

import java.util.List;

import org.activiti.engine.task.Task;

import de.hsansbach.wif.ebusiness.process.ProcessKey;

public interface ActivitiProcessService {
	
	String startProcess(ProcessKey key);

	String startProcess(String key);

	List<Task> getTasksForAssigne(String assigne);

	void completeTask(String taskId);

}
