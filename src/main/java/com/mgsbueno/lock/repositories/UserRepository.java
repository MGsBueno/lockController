package com.mgsbueno.lock.repositories;

import com.mgsbueno.lock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos específicos, se necessário
}
