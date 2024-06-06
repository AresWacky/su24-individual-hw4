package com.csc340.jpademo.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goalId", referencedColumnName = "goalId")
    private Goal goal;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task() {

    }

    public Task(int taskId, Goal goal, String title, String details, Status status) {
        this.taskId = taskId;
        this.goal = goal;
        this.title = title;
        this.details = details;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getGoalId() {
        if (goal != null) {
            return goal.getGoalId();
        } else {
            return -1; // or any default value you prefer
        }
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nullable
    public String getDetails() {
        return details;
    }

    public void setDetails(@Nullable String details) {
        this.details = details;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}