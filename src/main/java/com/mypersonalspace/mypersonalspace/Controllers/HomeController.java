package com.mypersonalspace.mypersonalspace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    
}
