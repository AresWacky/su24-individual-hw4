package com.csc340.jpademo.controller;


import com.csc340.jpademo.model.Goal;
import com.csc340.jpademo.model.Task;
import com.csc340.jpademo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;



    @GetMapping("/all")
    public String getAllTasks(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "goal-detail";
    }

    @GetMapping("/{taskId}")
    public String getTaskById(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-detail";
    }

    @PostMapping("/create")
    public String addNewTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/goals/all";
    }

    @PostMapping("/update")
    public String updateTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/tasks/" + task.getTaskId();
    }

    @GetMapping("/update/{taskId}")
    public String showTaskUpdateForm(@PathVariable int taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-update";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTaskById(@PathVariable int taskId) {
        taskService.deleteTaskById(taskId);
        return "redirect:/tasks/all";
    }

}