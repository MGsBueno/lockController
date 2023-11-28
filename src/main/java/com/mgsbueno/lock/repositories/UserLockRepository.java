package com.mgsbueno.lock.repositories;

import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.entities.Lock;
import com.mgsbueno.lock.entities.AppUser;
import com.mgsbueno.lock.entities.UserLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserLockRepository extends JpaRepository<UserLock, Long> {
    List<UserLock> findByUser(AppUser user);
    List<UserLock> findByLock(Lock lock);
    // Outros métodos conforme necessário
}
