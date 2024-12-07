package com.mypersonalspace.mypersonalspace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "/Home/Home.html";

    }

    @GetMapping("/home")
    public String goToHome() {
        return "/Home/Home.html";
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
    public String loginUser(){
        return"";
    }
    
}
