package com.mgsbueno.lock.controllers;


import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/accept-user-registration/{adminId}")
    public String acceptUserRegistration(@PathVariable Long adminId, @RequestBody AppUser newUser) {
        return userService.acceptUserRegistration(adminId, newUser);
    }

}

