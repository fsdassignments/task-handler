package com.sbu.taskhandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbu.taskhandler.model.ParentTask;
import com.sbu.taskhandler.services.ParentTaskService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
public class ParentTaskController {
	@Autowired
	private ParentTaskService parentTaskService;

	@GetMapping("/parent/tasks")
	public ResponseEntity<List<ParentTask>> list() {
		return ResponseEntity.ok().body(parentTaskService.list());
	}
}
