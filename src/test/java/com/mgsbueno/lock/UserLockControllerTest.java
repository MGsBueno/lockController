package com.mgsbueno.lock;

import com.mgsbueno.lock.controllers.UserLockController;
import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.services.UserLockService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserLockControllerTest {

    @Mock
    private UserLockService userLockService;

    @InjectMocks
    private UserLockController userLockController;

    @Test
    public void testCreateUserLock() {
        UserLock newUserLock = new UserLock();

        when(userLockService.save(newUserLock)).thenReturn(newUserLock);

        UserLock result = userLockController.createUserLock(newUserLock);
        assertEquals(newUserLock, result);
    }

}
