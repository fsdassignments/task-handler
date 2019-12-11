package com.sbu.taskhandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbu.taskhandler.model.ParentTask;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer> {

}
