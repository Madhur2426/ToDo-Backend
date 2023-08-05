package com.Rxjs.Map.Controller;

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

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Dto.PendingDto;
import com.Rxjs.Map.Entity.CompletedTask;
import com.Rxjs.Map.Entity.Task;
import com.Rxjs.Map.Service.CompletedInterface;
import com.Rxjs.Map.Service.TaskInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")

public class Controller {
	@Autowired
	TaskInterface service;
	@Autowired
	CompletedInterface completed;

	@PostMapping("/saveTask")
	public ResponseEntity<String> saveTask(@RequestBody PendingDto task) {
		return this.service.saveTask(task);
	}

	@GetMapping("/showTask")
	public ResponseEntity<List<Task>> getTask() {
        return this.service.getTask();
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Task> updateTodo(@RequestBody Long id){
		return this.service.updateTodo(id);
	}
	  @GetMapping("/lastId")
	  public long getLastId() {
		  return this.service.getLastId();
	  }
	  @GetMapping("/showCompletedTask")
		public ResponseEntity<List<CompletedTask>> getCompletedTask() {
	        return this.completed.getCompletedTask();
	 }
	  @PostMapping("/saveCompletedTask")
		public ResponseEntity<String> saveCompletedTask(@RequestBody CompletedDto task) {
			return this.completed.saveCompletedTask(task);
		}
}
