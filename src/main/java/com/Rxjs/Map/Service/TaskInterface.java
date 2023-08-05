package com.Rxjs.Map.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Dto.PendingDto;
import com.Rxjs.Map.Entity.Task;

public interface TaskInterface {
	public ResponseEntity<String> saveTask(PendingDto task);
	public ResponseEntity<List<Task>> getTask();
	public long getLastId();
	public ResponseEntity<Task> updateTodo(Long id);
	}
