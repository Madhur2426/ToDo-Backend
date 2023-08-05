package com.Rxjs.Map.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Dto.PendingDto;
import com.Rxjs.Map.Entity.CompletedTask;
import com.Rxjs.Map.Entity.Task;
import com.Rxjs.Map.Repository.CompletedRepo;
@Service
public class CompletedImplementation implements CompletedInterface{
	@Autowired
	CompletedRepo completed;
	@Autowired
	ModelMapper modelMapper;
	public CompletedTask completedTask(CompletedDto list) {
       CompletedTask completed1=this.modelMapper.map(list,CompletedTask.class);
		return completed1;
	}
		@Override
		public ResponseEntity<List<CompletedTask>> getCompletedTask(){
			List<CompletedTask> task= this.completed.findAll();
			if(task.size()==0)
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			else {
		        return ResponseEntity.status(HttpStatus.OK).body(task); // Return the list of tasks if there are any
		    }
		}
		@Override
		public ResponseEntity<String> saveCompletedTask(CompletedDto list) {
			try {
				CompletedTask complete=this.completedTask(list);
				 CompletedTask saved = completed.save(complete);
				if (saved != null)
					return ResponseEntity.status(HttpStatus.OK).body("Saved");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");

			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL_SERVER_ERROR");
		}
}
