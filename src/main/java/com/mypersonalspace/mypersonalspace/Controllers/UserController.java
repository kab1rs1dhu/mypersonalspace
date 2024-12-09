package com.mypersonalspace.mypersonalspace.Controllers;

import com.mypersonalspace.mypersonalspace.Models.Helpers.Task;
import com.mypersonalspace.mypersonalspace.Models.User;
import com.mypersonalspace.mypersonalspace.Repositories.TaskRepository;
import com.mypersonalspace.mypersonalspace.Repositories.UserRepository;
import com.mypersonalspace.mypersonalspace.Service.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService = new UserService();

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user-signup")
    public String saveUser(@RequestParam Map<String, String> newUser, Model model) {
        String name = newUser.get("name");
        String email = newUser.get("email");
        String password = newUser.get("password");
        String age = newUser.get("age");
        String username = newUser.get("username");

        User user = new User(name, email, password, age, username);

        userService.registerUserToDB(user);

        List<Task> tasks = taskRepo.findByUserId(user.getUid()); // gets all the tasks of the user

        model.addAttribute("tasks", tasks);
        return "home"; // Ensure this matches the template name
    }

    @GetMapping("/login")
    public String goToLogin() {
        return "Login/Login"; // Ensure this matches the template name
    }

    @GetMapping("/signup")
    public String goToSignin() {
        return "Login/SignUp"; // Ensure this matches the template name
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        User user = userService.authenticateUser(username, password);
        if (user != null) {
            session.setAttribute("username", username);
            return "redirect:/home"; // Redirect to /home after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "Login/Login"; // Ensure this matches the template name
        }
    }

    @GetMapping("/home")
    public String goToHome(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login"; // Redirect to login if username is not in session
        }
        User user = userRepo.findByUsername(username);
        List<Task> tasks = taskRepo.findByUserId(user.getUid());
        model.addAttribute("tasks", tasks);
        model.addAttribute("username", username);
        return "/Home/Home.html"; // Ensure this matches the template name
    }
}