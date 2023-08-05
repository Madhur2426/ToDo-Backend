package com.Rxjs.Map.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rxjs.Map.Dto.CompletedDto;
import com.Rxjs.Map.Entity.Task;

public interface TaskRepo extends JpaRepository<Task,Long>{


}
