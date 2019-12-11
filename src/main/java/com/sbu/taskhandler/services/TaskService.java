package com.sbu.taskhandler.services;

import java.util.Date;
import java.util.List;

import com.sbu.taskhandler.errors.TaskNotFoundException;
import com.sbu.taskhandler.model.Task;

public interface TaskService {
	int save(Task task) throws Exception;
	
	void update(int id, Task task) throws TaskNotFoundException;
	
	List<Task> list();
	
	Task get(int id) throws TaskNotFoundException;

	List<Task> searchTasks(String taskName, String parentTaskName, Integer priorityFrom, 
			Integer priorityTo, Date startDate, Date endDate);
}
