package com.mgsbueno.lock;
import com.mgsbueno.lock.controllers.UserController;
import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testAcceptUserRegistration() {
        Long adminId = 1L;
        AppUser newUser = new AppUser();
        newUser.setName("New User");
        newUser.setHierarchyLevel(0);
        newUser.getHierarchyLevel();

        when(userService.acceptUserRegistration(adminId, newUser)).thenReturn("Success");
        String result = userController.acceptUserRegistration(adminId, newUser);
        assertEquals("Success", result);

    }

    // Adicione aqui outros testes para UserController conforme necessário
}

