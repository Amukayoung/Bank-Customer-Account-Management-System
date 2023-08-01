package com.example.BankAccountManager.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(path = "/api/v1/user")
    public List<User> getUser(){
        return userService.getUser();

    }
    @PostMapping(path = "/api/v1/user")
    public void registerNewUser(@RequestBody User user){
        System.out.println(user);
        userService.addNewUser(user);
    }

    @PutMapping(path = "/api/v1/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/api/v1/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

