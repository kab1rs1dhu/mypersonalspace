package com.mypersonalspace.mypersonalspace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/signin")
    public String goToSignin() {
        return "/Login/Signin.html";
    }
    
}
