package com.mgsbueno.lock.controllers;

import com.mgsbueno.lock.entities.UserLock;
import com.mgsbueno.lock.services.UserLockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userlocks")
@Tag(name = "UserLockController", description = "Endpoints para operações entre usuários e fechaduras")
public class UserLockController {
    private final UserLockService userLockService;

    public UserLockController(UserLockService userLockService) {
        this.userLockService = userLockService;
    }

    @PostMapping("/create")
    @Operation(summary = "Criar relação usuário-fechadura", description = "Cria uma nova relação entre usuário e fechadura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relação usuário-fechadura criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public UserLock createUserLock(@RequestBody UserLock userLock) {
        return userLockService.save(userLock);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter relação usuário-fechadura por ID", description = "Retorna uma relação usuário-fechadura pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relação usuário-fechadura encontrada"),
            @ApiResponse(responseCode = "404", description = "Relação usuário-fechadura não encontrada")
    })
    public UserLock getUserLockById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return userLockService.findById(id);
    }

    // Outros endpoints do UserLockController conforme necessário
}
