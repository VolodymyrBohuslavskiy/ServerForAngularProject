package com.example.angular.controllerrs;

import com.example.angular.models.User;
import com.example.angular.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class asyncController {

    @Autowired
    UserService userService;

    @GetMapping("/showall")
    @CrossOrigin(origins = "*")
    public String showAll() throws JsonProcessingException {
        List<User> all = userService.findAll();
        return new ObjectMapper().writeValueAsString(all);
    }

    @DeleteMapping("/delete{id}")
    @CrossOrigin(origins = "*")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
//    @CrossOrigin("host") /*не працює (*/
    public void add(@RequestBody String newUser) throws IOException {
        System.out.println("Take user");
        User user = new ObjectMapper().readValue(newUser, User.class);
        userService.save(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public void logIn(@RequestBody String oneUser) throws IOException {
        User user = new ObjectMapper().readValue(oneUser, User.class);
        User userByUsernameAndPassword = userService.findUserByUsernameaAndPassword(user.getUsername(), user.getPassword());
        if (userByUsernameAndPassword != null) {
            System.out.println(userByUsernameAndPassword);
        } else System.out.println("NONE USER WITH" + " " + user.getUsername() + " " + user.getPassword());

    }


}
