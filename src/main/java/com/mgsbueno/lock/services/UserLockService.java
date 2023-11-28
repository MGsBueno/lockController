package com.mgsbueno.lock.services;

import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.repositories.UserLockRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UserLockService {
    private final UserLockRepository userLockRepository;

    public UserLockService(UserLockRepository userLockRepository) {
        this.userLockRepository = userLockRepository;
    }

    public UserLock save(UserLock userLock) {
        return userLockRepository.save(userLock);
    }

    public UserLock findById(Long id) throws ChangeSetPersister.NotFoundException {
        return userLockRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

}

