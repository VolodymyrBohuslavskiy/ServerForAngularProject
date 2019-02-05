package com.example.angular.controllerrs;

import com.example.angular.models.User;
import com.example.angular.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class mainController {
    @Autowired
    UserService userService;

//    @PostMapping("/add")
//    public String add(User user, Model model) {
//        userService.save(user);
//        model.addAttribute("all", userService.findAll());
//        return "index";
//    }




}
