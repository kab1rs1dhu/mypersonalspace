package com.mypersonalspace.mypersonalspace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    @GetMapping("add-task")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    
}