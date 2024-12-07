package com.mypersonalspace.mypersonalspace.Controllers;

import com.mypersonalspace.mypersonalspace.Models.*;
import com.mypersonalspace.mypersonalspace.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;

import java.util.*;

@Controller
public class SaveToDB {

     @Autowired
    private UserService userService = new UserService(); // will use this to save the user to the database. also encrypt the password.



    @PostMapping("/user-signup")
    public String saveUser(@RequestParam Map<String, String> newUser, HttpServletResponse response, Model model) {
        String name = newUser.get("name");
        String email = newUser.get("email");
        String password = newUser.get("password");
        String age = newUser.get("age");
        String username = newUser.get("username");

        User user = new User(name, email, password, age, username);

        userService.registerUserToDB(user);

    
        return "";

    }
}