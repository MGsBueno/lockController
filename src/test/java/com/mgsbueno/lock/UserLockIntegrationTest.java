package com.mgsbueno.lock;

import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.entities.Lock;
import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.services.LockService;
import com.mgsbueno.lock.services.UserLockService;
import com.mgsbueno.lock.services.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class UserLockIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private LockService lockService;

    @Autowired
    private UserLockService userLockService;

    @Test
    public void givenNewUserAndLock_whenAssociateUserWithLock_thenSuccess() {
        // Cria um novo usuário
        AppUser newUser = new AppUser();
        newUser.setName("Alice");
        newUser.setHierarchyLevel(0);
        AppUser savedUser = userService.save(newUser);

        // Cria um novo cadeado
        Lock newLock = new Lock();
        newLock.setName("Main Door");
        newLock.setSite("Office");
        Lock savedLock = lockService.save(newLock);

        // Associa o usuário ao cadeado
        UserLock userLock = new UserLock();
        userLock.setUsers(savedUser);
        userLock.setLock(savedLock);
        UserLock savedUserLock = userLockService.save(userLock);

        assertNotNull(savedUserLock);
        assertEquals(savedUser, savedUserLock.getUsers());
        assertEquals(savedLock, savedUserLock.getLock());
    }
}
