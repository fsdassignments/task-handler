package com.sbu.taskhandler.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbu.taskhandler.convertors.TaskConverter;
import com.sbu.taskhandler.errors.TaskNotFoundException;
import com.sbu.taskhandler.model.Task;
import com.sbu.taskhandler.services.TaskService;
import com.sbu.taskhandler.vo.TaskVO;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<TaskVO>> list() {
		List<TaskVO> tasksList = TaskConverter.toDto(taskService.list());
		return ResponseEntity.ok().body(tasksList);
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> get(@PathVariable("id") int id) throws TaskNotFoundException {
		Task task = taskService.get(id);
		return ResponseEntity.ok().body(task);
	}
	
	@GetMapping("/tasks/search")
	public ResponseEntity<List<TaskVO>> search(@RequestParam(required = false) String taskName, @RequestParam(required = false) String parentTaskName,
			@RequestParam(required = false) Integer priorityFrom, @RequestParam(required = false) Integer priorityTo,
			@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate) {
			System.out.println("task:" + taskName);
			System.out.println("parentTask:" + parentTaskName);
			System.out.println("priorityFrom:" + priorityFrom);
			System.out.println("priorityTo:" + priorityTo);
			System.out.println("startDate:" + startDate);
			System.out.println("endDate:" + endDate);
			List<TaskVO> tasksList = TaskConverter.toDto(taskService.searchTasks(taskName, parentTaskName, priorityFrom, priorityTo, startDate, endDate));
			return ResponseEntity.ok().body(tasksList);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<TaskVO> save(@RequestBody TaskVO task) throws Exception {
		Task taskToSave = TaskConverter.toPojo(task);
		int id = taskService.save(taskToSave);
		task.setTaskId(id);
		return ResponseEntity.ok().body(task);
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<TaskVO> update(@PathVariable("id") int id, @RequestBody TaskVO task) throws TaskNotFoundException {
		Task taskToUpdate = TaskConverter.toPojo(task);
		System.out.println("book to update: " + taskToUpdate.toString());
		taskService.update(id, taskToUpdate);
		return ResponseEntity.ok().body(task);
	}
}
