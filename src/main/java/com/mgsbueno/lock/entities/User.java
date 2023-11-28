package com.mgsbueno.lock.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int hierarchyLevel; // Campo para representar a hierarquia do usuário -- 0,1,...,n , 0 = maxima hierarquia

    private boolean isAdmin; // Campo para identificar se o usuário é um administrador

    private boolean registred;

    @OneToMany(mappedBy = "User")
    private List<UserLock> userLock;

    public int getHierarchyLevel() {
        return this.hierarchyLevel;
    }

    public void setAdmin(boolean adminStatus) {
        this.isAdmin = adminStatus;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setHierarchyLevel(int newhierarchyLevel) {
        this.hierarchyLevel = newhierarchyLevel;
    }

    public void setRegistered(boolean b) {
        this.registred = b;
    }
}
