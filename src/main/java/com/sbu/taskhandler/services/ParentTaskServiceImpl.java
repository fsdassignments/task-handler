package com.sbu.taskhandler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbu.taskhandler.model.ParentTask;
import com.sbu.taskhandler.repositories.ParentTaskRepository;

@Service
@Transactional(readOnly = true)
public class ParentTaskServiceImpl implements ParentTaskService {
	
	@Autowired
	private ParentTaskRepository parentTaskRepository;

	@Transactional
	@Override
	public List<ParentTask> list() {
		return parentTaskRepository.findAll();
	}

	@Transactional
	@Override
	public List<ParentTask> searchParentTask(String parentName) {
		return null;
	}

}
