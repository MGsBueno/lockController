package com.mgsbueno.lock.controllers;
import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.services.UserLockService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userlocks")
public class UserLockController {
    private final UserLockService userLockService;

    public UserLockController(UserLockService userLockService) {
        this.userLockService = userLockService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserLock> createUserLock(@RequestBody UserLock userLock) {
        UserLock createdUserLock = userLockService.save(userLock);
        return new ResponseEntity<>(createdUserLock, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLock> getUserLockById(@PathVariable Long id) {
        try {
            UserLock userLock = userLockService.findById(id);
            return new ResponseEntity<>(userLock, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/open/{userId}/{lockId}")
    public ResponseEntity<String> openLockById(@PathVariable Long userId, @PathVariable Long lockId) {
        boolean success = userLockService.attemptToOpenLock(userId, lockId);

        if (success) {
            return new ResponseEntity<>("Lock opened successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to open lock", HttpStatus.UNAUTHORIZED);
        }
    }

    // Outros endpoints do UserLockController conforme necessário
}
