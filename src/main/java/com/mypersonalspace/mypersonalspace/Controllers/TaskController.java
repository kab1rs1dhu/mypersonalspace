package com.mypersonalspace.mypersonalspace.Controllers;

import com.mypersonalspace.mypersonalspace.Models.Helpers.Task;
import com.mypersonalspace.mypersonalspace.Repositories.TaskRepository;
import com.mypersonalspace.mypersonalspace.Repositories.UserRepository;
import com.mypersonalspace.mypersonalspace.Models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/add-task")
    public String addTask(
            @RequestParam("username") String username,
            @RequestParam("taskName") String taskName,
            @RequestParam("taskDescription") String taskDescription,
            @RequestParam("taskDueDate") String taskDueDate,
            @RequestParam("priority") int priority,
            Model model) {
        
        // Assuming you have a method to get userId by username
        int userId = getUserIdByUsername(username);

        Task newTask = new Task(priority, taskName, taskDescription, taskDueDate, userId);
        taskRepo.save(newTask);

        model.addAttribute("username", username);
        model.addAttribute("message", "Task added successfully!");
        model.addAttribute("tasks", taskRepo.findByUserId(userId));

        System.out.println("Task added successfully!");

        return ("/Home/Home.html");
    }

    private int getUserIdByUsername(String username) {
        userRepo.findByUsername(username);

        User user = userRepo.findByUsername(username);
        return user.getUid(); // Placeholder
    }

    @DeleteMapping("/delete-task/{id}")
    public void deleteTask(@PathVariable int uid) {
        taskRepo.deleteById(uid);
        System.out.println("Task deleted successfully!");
    }


}