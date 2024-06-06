package com.csc340.jpademo.service;

import com.csc340.jpademo.model.Goal;
import com.csc340.jpademo.repository.GoalRepository;
import com.csc340.jpademo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;


    public Object getAllGoals() {
        return goalRepository.findAll();
    }

    public void addNewGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoalById(int goalId) {
        goalRepository.deleteById(goalId);
    }

    public Object getGoalById(int goalId) {
        return goalRepository.findById(goalId).orElse(null);

    }
}
