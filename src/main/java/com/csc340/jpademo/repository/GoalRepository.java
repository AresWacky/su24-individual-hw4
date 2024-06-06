package com.csc340.jpademo.repository;

import com.csc340.jpademo.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
    // Custom methods if needed
}
