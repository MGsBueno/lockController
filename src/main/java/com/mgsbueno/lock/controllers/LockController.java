package com.mgsbueno.lock.controllers;

import com.mgsbueno.lock.entities.DoorLock;
import com.mgsbueno.lock.services.LockService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locks")
public class LockController {
    private final LockService lockService;

    public LockController(LockService lockService) {
        this.lockService = lockService;
    }

    @PostMapping("/create")

    public DoorLock createLock(@RequestBody DoorLock lock) {
        return lockService.save(lock);
    }

    @GetMapping("/{id}")
    public DoorLock getLockById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return lockService.findById(id);
    }

    @PutMapping("/update/{id}")
    public DoorLock updateLock(@PathVariable Long id, @RequestBody DoorLock updatedLock) throws ChangeSetPersister.NotFoundException {
        return lockService.update(id, updatedLock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLock(@PathVariable Long id) {
        lockService.deleteById(id);
    }



}

