package com.mgsbueno.lock.entities;


import jakarta.persistence.*;

@Entity
public class DoorLock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String site;    // local de instalação
    private int HierarchyLevel;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredHierarchyLevel() {
        return this.HierarchyLevel;
    }
}
