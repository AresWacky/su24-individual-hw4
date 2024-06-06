package com.csc340.jpademo.service;


import com.csc340.jpademo.model.Goal;
import com.csc340.jpademo.model.Task;
import com.csc340.jpademo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Object getAllTasks() {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        taskRepository.save(task); // Save the Task object
    }

    public void deleteTaskById(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Object getTaskById(int taskId) {
        return taskRepository.findById(taskId).orElse(null);

    }

}
