package com.Rxjs.Map.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class CompletedTask {

	
		@Id
		Long id;
		String task;
		boolean isCompleted;

		public CompletedTask() {
			super();
			// TODO Auto-generated constructor stub
		}

		public  CompletedTask(Long id, String task, boolean isCompleted) {
			super();
			this.id = id;
			this.task = task;
			this.isCompleted = isCompleted;
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