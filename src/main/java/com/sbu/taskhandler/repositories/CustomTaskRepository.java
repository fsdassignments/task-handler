package com.sbu.taskhandler.repositories;

import java.util.Date;
import java.util.List;

import com.sbu.taskhandler.model.Task;

public interface CustomTaskRepository {
	List<Task> findTasks(String taskName, String parentTaskName, Integer priorityFrom, 
			Integer priorityTo, Date startDate, Date endDate);
}
