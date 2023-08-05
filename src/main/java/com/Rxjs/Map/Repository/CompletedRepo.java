package com.Rxjs.Map.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rxjs.Map.Entity.CompletedTask;

public interface CompletedRepo extends JpaRepository<CompletedTask,Long>{

}
