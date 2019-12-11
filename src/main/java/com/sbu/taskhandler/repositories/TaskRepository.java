package com.sbu.taskhandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbu.taskhandler.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>,CustomTaskRepository {

}
