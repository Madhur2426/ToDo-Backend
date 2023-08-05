package com.Rxjs.Map.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Id;
@Entity
public class
PendingDto {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public PendingDto(Long id, String task, boolean isCompleted) {
		super();
		this.id = id;
		this.task = task;
		this.isCompleted = isCompleted;
	}
	public PendingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	Long id;
	String task;
	boolean isCompleted;
	

}
