package com.mgsbueno.lock.repositories;

import com.mgsbueno.lock.entities.DoorLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockRepository extends JpaRepository<DoorLock, Long> {
    // Métodos específicos, se necessário
}
