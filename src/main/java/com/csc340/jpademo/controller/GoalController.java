package com.csc340.jpademo.controller;

import com.csc340.jpademo.model.Goal;
import com.csc340.jpademo.service.GoalService;
import com.csc340.jpademo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/all")
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goal-list";
    }

    @GetMapping("/{goalId}")
    public String getStudentById(@PathVariable int goalId, Model model) {
        model.addAttribute("goal", goalService.getGoalById(goalId));
        return "goal-detail";
    }

    @PostMapping("/create")
    public String addNewGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/" + goal.getGoalId();
    }

    @GetMapping("/update/{goalId}")
    public String showGoalUpdateForm(@PathVariable int goalId, Model model) {
        model.addAttribute("student", goalService.getGoalById(goalId));
        return "goal-update";
    }

    @GetMapping("/delete/{goalId}")
    public String deleteGoalById(@PathVariable int goalId) {
        goalService.deleteGoalById(goalId);
        return "redirect:/goals/all";
    }


}
