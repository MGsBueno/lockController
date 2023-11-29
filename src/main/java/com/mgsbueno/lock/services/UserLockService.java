package com.mgsbueno.lock.services;

import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.entities.DoorLock;
import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLockService {
    private final UserLockRepository userLockRepository;
    private final UserRepository userRepository;
    private final LockRepository lockRepository;

    @Autowired
    public UserLockService(UserLockRepository userLockRepository, UserRepository userRepository, LockRepository lockRepository, UserService appUserService) {
        this.userLockRepository = userLockRepository;
        this.userRepository = userRepository;
        this.lockRepository = lockRepository;
    }

    public UserLock save(UserLock userLock) {
        return userLockRepository.save(userLock);
    }

    public UserLock findById(Long id) throws ChangeSetPersister.NotFoundException {
        return userLockRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    // Método para tentar abrir o cadeado
    public boolean attemptToOpenLock(Long userId, Long lockId) {
        Optional<AppUser> optionalUser = userRepository.findById(userId);
        Optional<DoorLock> optionalLock = lockRepository.findById(lockId);

        if (optionalUser.isPresent() && optionalLock.isPresent()) {
            AppUser user = optionalUser.get();
            DoorLock lock = optionalLock.get();
            UserLock attempt = new UserLock();

            if (user.getHierarchyLevel() < lock.getRequiredHierarchyLevel()) {
                userLockRepository.save(attempt);
                return false;
            }

        userLockRepository.save(attempt);
        }

        return true;
    }
}
