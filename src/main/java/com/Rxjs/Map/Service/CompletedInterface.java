package com.Rxjs.Map.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Entity.CompletedTask;

public interface CompletedInterface {
	public ResponseEntity<String> saveCompletedTask(CompletedDto list);
	public ResponseEntity<List<CompletedTask>> getCompletedTask();
}
