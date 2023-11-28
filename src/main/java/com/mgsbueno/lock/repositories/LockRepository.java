package com.mgsbueno.lock.repositories;

import com.mgsbueno.lock.entities.Lock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockRepository extends JpaRepository<Lock, Long> {
    // Métodos específicos, se necessário
}
