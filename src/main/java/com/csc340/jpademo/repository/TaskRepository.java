package com.csc340.jpademo.repository;

import com.csc340.jpademo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Custom methods if needed
}
