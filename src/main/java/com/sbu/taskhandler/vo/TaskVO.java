package com.sbu.taskhandler.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskVO {
	private int taskId;
	private int parentTaskId;
	private String task;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Integer priority;
	private Boolean isFinished;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(int parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Boolean getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
	@Override
	public String toString() {
		return "TaskVO [taskId=" + taskId + ", parentTaskId=" + parentTaskId + ", task=" + task + ", startDate="
				+ startDate + ", endDate=" + endDate + ", priority=" + priority + ", isFinished=" + isFinished + "]";
	}
	
	
}
