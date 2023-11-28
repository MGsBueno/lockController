    package com.mgsbueno.lock.controllers;

    import com.mgsbueno.lock.entities.User;
    import com.mgsbueno.lock.services.UserService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @Tag(name = "UserController", description = "Endpoints para operações relacionadas a usuários")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/accept-user-registration/{adminId}")
        @Operation(summary = "Aceitar registro de usuário", description = "Aceita o cadastro de um usuário por um administrador")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Registro de usuário aceito com sucesso"),
                @ApiResponse(responseCode = "400", description = "Requisição inválida")
        })
        public String acceptUserRegistration(@PathVariable Long adminId, @RequestBody User newUser) {
            return userService.acceptUserRegistration(adminId, newUser);
        }
    }
