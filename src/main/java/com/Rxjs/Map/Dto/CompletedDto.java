package com.Rxjs.Map.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class CompletedDto {
	@Id
	Long id;
	String task;
	boolean isCompleted;
	public CompletedDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompletedDto(Long id, String task, boolean isCompleted) {
		super();
		this.id = id;
		this.task = task;
		this.isCompleted = isCompleted;
	}
	@Override
	public String toString() {
		return "CompletedDto [id=" + id + ", task=" + task + ", isCompleted=" + isCompleted + "]";
	}
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
	
}
