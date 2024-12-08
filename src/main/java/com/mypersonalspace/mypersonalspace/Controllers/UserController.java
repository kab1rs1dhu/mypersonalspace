package com.mypersonalspace.mypersonalspace.Controllers;

import com.mypersonalspace.mypersonalspace.Models.*;
import com.mypersonalspace.mypersonalspace.Models.Helpers.Task;
import com.mypersonalspace.mypersonalspace.Repositories.TaskRepository;
import com.mypersonalspace.mypersonalspace.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService = new UserService(); // will use this to save the user to the database. also encrypt the password.

    @Autowired
    private TaskRepository taskRepo;



    @PostMapping("/user-signup")
    public String saveUser(@RequestParam Map<String, String> newUser, HttpServletResponse response, Model model) {
        String name = newUser.get("name");
        String email = newUser.get("email");
        String password = newUser.get("password");
        String age = newUser.get("age");
        String username = newUser.get("username");

        User user = new User(name, email, password, age, username);

        userService.registerUserToDB(user);

        List<Task> tasks = taskRepo.findByUserId(user.getUid()); // gets all the tasks of the user

        model.addAttribute("tasks", tasks);
        return "Home/Home.html";

    }

    @GetMapping("/login")
    public String goToLogin() {
        return "/Login/Login.html";
    }

    @GetMapping("/signup")
    public String goToSignin() {
        return "/Login/SignUp.html";
    }


    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userService.authenticateUser(username, password);
        if (user != null) {
            List<Task> tasks = taskRepo.findByUserId(user.getUid()); // gets all the tasks of the user
            model.addAttribute("tasks", tasks);
            return "Home/Home.html";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "/Login/Login.html";
        }
    }


}