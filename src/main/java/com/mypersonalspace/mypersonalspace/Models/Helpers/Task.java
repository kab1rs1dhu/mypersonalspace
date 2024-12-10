package com.mypersonalspace.mypersonalspace.Models.Helpers;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private int priority; // represents the priority of the task
    private String taskName;
    private String taskDescription;
    private String taskDueDate;
    private int userId; // would represent the user id of the user that created the task

    public Task() {
    }


    public Task(int priority, String taskName, String taskDescription, String taskDueDate, int userId) {
        this.priority = priority;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.userId = userId;
    }

    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUid() {
        return uid;
    }


    
}
