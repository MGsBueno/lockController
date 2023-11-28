package com.mgsbueno.lock.services;

import com.mgsbueno.lock.entities.Lock;
import com.mgsbueno.lock.repositories.LockRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    private final LockRepository lockRepository;

    public LockService(LockRepository lockRepository) {
        this.lockRepository = lockRepository;
    }

    public Lock save(Lock lock) {
        // Lógica de validação, se necessário
        return lockRepository.save(lock);
    }

    public Lock findById(Long id) throws ChangeSetPersister.NotFoundException {
        // Adicionar lógica de verificação de existência, se necessário
        return lockRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Lock update(Long id, Lock updatedLock) throws ChangeSetPersister.NotFoundException {
        Lock existingLock = findById(id);

        // Atualiza os campos do objeto existente com base nos dados atualizados
        existingLock.setName(updatedLock.getName());
        return lockRepository.save(existingLock);
    }

    public void deleteById(Long id) {
        lockRepository.deleteById(id);
    }
}
