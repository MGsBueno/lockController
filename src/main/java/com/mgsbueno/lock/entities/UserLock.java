package com.mgsbueno.lock.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserLock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "Lock_id")
    private Lock lock;

    @Column(name = "timeStamp") // hora de acesso
    private LocalDateTime timeStamp;

    @Column(name = "success")
    private boolean sucess;

    public UserLock() {
    }

    @ManyToOne(optional = false)
    private AppUser users;

    public AppUser getUsers() {
        return users;
    }

    public void setUsers(AppUser users) {

        this.users = users;
    }

    public Lock getLock() {
        return this.lock;
    }

    public void setLock(Lock savedLock) {
        this.lock = savedLock;
    }
}
