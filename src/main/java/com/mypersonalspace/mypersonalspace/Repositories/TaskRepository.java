package com.mypersonalspace.mypersonalspace.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypersonalspace.mypersonalspace.Models.Helpers.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    
    List<Task> findByPriority(int priority);
    List<Task> findByTaskName(String taskName);
    List<Task> findByTaskDescription(String taskDescription);
    List<Task> findByTaskDueDate(String taskDueDate);
    List<Task> findByUserId(int userId);

    
    
}
