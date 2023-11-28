package com.mgsbueno.lock.repositories;

import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    // Métodos específicos, se necessário
}
