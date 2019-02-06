package com.example.angular.controllerrs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class mainController {

    @PostMapping("/hello")
    public String hello(){
        return "hello";
    }

}
