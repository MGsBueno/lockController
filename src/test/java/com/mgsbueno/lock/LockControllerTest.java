package com.mgsbueno.lock;
import com.mgsbueno.lock.controllers.LockController;
import com.mgsbueno.lock.entities.Lock;
import com.mgsbueno.lock.services.LockService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LockControllerTest {

    @Mock
    private LockService lockService;

    @InjectMocks
    private LockController lockController;

    @Test
    public void testCreateLock() {
        Lock newLock = new Lock();
        newLock.setName("New Lock");
        newLock.setSite("Example Site");

        when(lockService.save(newLock)).thenReturn(newLock);

        Lock result = lockController.createLock(newLock);
        assertEquals("New Lock", result.getName());
        assertEquals("Example Site", result.getSite());
    }

    // Adicione aqui outros testes para LockController conforme necessário
}
