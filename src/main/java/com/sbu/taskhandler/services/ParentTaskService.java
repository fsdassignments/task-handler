package com.sbu.taskhandler.services;

import java.util.List;

import com.sbu.taskhandler.model.ParentTask;

public interface ParentTaskService {
	List<ParentTask> list();
	
	List<ParentTask> searchParentTask(String parentName);
}
