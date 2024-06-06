package com.csc340.jpademo.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;

    private int userId;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date targetDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Goal(int goalId, int userId, String title, String details, Date targetDate, Status status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Goal() {

    }

    //getters and setters:
    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }


    @OneToMany(mappedBy = "goal")
    private Collection<Task> task;

    public Collection<Task> getTask() {
        return task;
    }

    public void setTask(Collection<Task> task) {
        this.task = task;
    }
}