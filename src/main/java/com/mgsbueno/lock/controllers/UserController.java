package com.mgsbueno.lock.controllers;

import com.mgsbueno.lock.entities.User;
import com.mgsbueno.lock.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/accept-user-registration/{adminId}")
    public String acceptUserRegistration(@PathVariable Long adminId, @RequestBody User newUser) {
        return userService.acceptUserRegistration(adminId, newUser);
    }
}

