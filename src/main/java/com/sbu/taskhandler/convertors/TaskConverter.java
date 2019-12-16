package com.sbu.taskhandler.convertors;

import java.util.ArrayList;
import java.util.List;

import com.sbu.taskhandler.model.ParentTask;
import com.sbu.taskhandler.model.Task;
import com.sbu.taskhandler.vo.TaskVO;

public class TaskConverter {
	public static Task toPojo(TaskVO taskVO) {
		Task task = new Task();
		task.setTaskId(taskVO.getTaskId());
		task.setTask(taskVO.getTask());
		task.setParentTask(new ParentTask(taskVO.getParentTaskId()));
		task.setPriority(taskVO.getPriority());
		task.setStartDate(taskVO.getStartDate());
		task.setEndDate(taskVO.getEndDate());
		task.setIsFinished(taskVO.getIsFinished());
		return task;
	}

	public static List<TaskVO> toDtos(List<Task> tasks) {
		List<TaskVO> tasksList = new ArrayList<>();
		for (Task task : tasks) {
			TaskVO taskVO = toDto(task);

			tasksList.add(taskVO);
		}
		return tasksList;
	}

	public static TaskVO toDto(Task task) {
		TaskVO taskVO = new TaskVO();
		taskVO.setTaskId(task.getTaskId());
		taskVO.setTask(task.getTask());
		taskVO.setParentTaskId(task.getParentTask().getParentId());
		taskVO.setPriority(task.getPriority());
		taskVO.setStartDate(task.getStartDate());
		taskVO.setEndDate(task.getEndDate());
		taskVO.setIsFinished(task.getIsFinished());
		return taskVO;
	}
}
