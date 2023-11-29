package com.mgsbueno.lock.services;

import com.mgsbueno.lock.entities.DoorLock;
import com.mgsbueno.lock.repositories.LockRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    private final LockRepository lockRepository;

    public LockService(LockRepository lockRepository) {
        this.lockRepository = lockRepository;
    }


    public DoorLock save(DoorLock lock) {
        // Lógica de validação, se necessário
        return lockRepository.save(lock);
    }

    public DoorLock findById(Long id) throws ChangeSetPersister.NotFoundException {
        // Adicionar lógica de verificação de existência, se necessário
        return lockRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public DoorLock update(Long id, DoorLock updatedLock) throws ChangeSetPersister.NotFoundException {
        DoorLock existingLock = findById(id);

        // Atualiza os campos do objeto existente com base nos dados atualizados
        existingLock.setName(updatedLock.getName());
        return lockRepository.save(existingLock);
    }

    public void deleteById(Long id) {
        lockRepository.deleteById(id);
    }
}
