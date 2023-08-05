package com.Rxjs.Map.Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Dto.PendingDto;
import com.Rxjs.Map.Entity.CompletedTask;
import com.Rxjs.Map.Entity.Task;
import com.Rxjs.Map.Repository.TaskRepo;
import com.example.AssignmnetAPI.DTO.RegistrationDTO;
import com.example.AssignmnetAPI.Entity.User;

@Service
public class ServiceImplementation implements TaskInterface{
@Autowired
TaskRepo repo;
@Autowired
ModelMapper modelMapper;
public Task pendingTask(PendingDto completed) {
	Task completed1=this.modelMapper.map(completed,Task.class);
	return completed1;
}

	@Override
	public ResponseEntity<String> saveTask(PendingDto task) {
		try {
			 Task completed=this.pendingTask(task);
			 Task saved = repo.save(completed);
			if (saved != null)
				return ResponseEntity.status(HttpStatus.OK).body("Saved");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");
	}
	@Override
	public ResponseEntity<List<Task>> getTask(){
		List<Task> task= this.repo.findAll();
		if(task.size()==0) 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
	
	@Override
         public ResponseEntity<Task> updateTodo(Long id){
		 Optional<Task> optionalTask = repo.findById(id);		    
		    Task todo = optionalTask.get();
		    todo.setCompleted(true);
		   todo= repo.save(todo);
		    return ResponseEntity.ok(todo);
	}

	@Override
	public long getLastId() {
	      List<Task> taskList=repo.findAll();
     Task findId= taskList.get(taskList.size()-1);
     return findId.getId();
     }
}
	

