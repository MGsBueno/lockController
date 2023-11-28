package com.mgsbueno.lock.controllers;
import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.services.UserLockService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/userlocks")
public class UserLockController {
    private final UserLockService userLockService;

    public UserLockController(UserLockService userLockService) {
        this.userLockService = userLockService;
    }

    @PostMapping("/create")
    public UserLock createUserLock(@RequestBody UserLock userLock) {
        return userLockService.save(userLock);
    }

    @GetMapping("/{id}")
    public UserLock getUserLockById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return userLockService.findById(id);
    }

    // Outros endpoints do UserLockController conforme necessário
}
