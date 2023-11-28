package com.mgsbueno.lock.controllers;

import com.mgsbueno.lock.entities.Lock;
import com.mgsbueno.lock.services.LockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locks")
@Tag(name = "LockController", description = "Endpoints para operações relacionadas a fechaduras")
public class LockController {
    private final LockService lockService;

    public LockController(LockService lockService) {
        this.lockService = lockService;
    }

    @PostMapping("/create")
    @Operation(summary = "Criar uma fechadura", description = "Cria uma nova fechadura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fechadura criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Lock createLock(@RequestBody Lock lock) {
        return lockService.save(lock);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter fechadura por ID", description = "Retorna uma fechadura pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fechadura encontrada"),
            @ApiResponse(responseCode = "404", description = "Fechadura não encontrada")
    })
    public Lock getLockById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return lockService.findById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualizar fechadura por ID", description = "Atualiza uma fechadura pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fechadura atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fechadura não encontrada")
    })
    public Lock updateLock(@PathVariable Long id, @RequestBody Lock updatedLock) throws ChangeSetPersister.NotFoundException {
        return lockService.update(id, updatedLock);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Excluir fechadura por ID", description = "Exclui uma fechadura pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fechadura excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fechadura não encontrada")
    })
    public void deleteLock(@PathVariable Long id) {
        lockService.deleteById(id);
    }
}
