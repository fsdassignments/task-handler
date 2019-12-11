package com.sbu.taskhandler.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbu.taskhandler.errors.TaskNotFoundException;
import com.sbu.taskhandler.model.Task;
import com.sbu.taskhandler.repositories.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	@Override
	public int save(Task task) throws Exception {
		taskRepository.save(task);
		return task.getTaskId();
	}

	@Transactional
	@Override
	public List<Task> list() {
		return taskRepository.findAll();
	}

	@Transactional
	@Override
	public void update(int id, Task task) throws TaskNotFoundException {
		taskRepository.save(task);
	}

	@Transactional
	@Override
	public Task get(int id) throws TaskNotFoundException {
		return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
	}

	@Override
	public List<Task> searchTasks(String taskName, String parentTaskName, Integer priorityFrom, 
			Integer priorityTo, Date startDate, Date endDate) {
		return taskRepository.findTasks(taskName, parentTaskName, priorityFrom, priorityTo, startDate, endDate);
	}

}
