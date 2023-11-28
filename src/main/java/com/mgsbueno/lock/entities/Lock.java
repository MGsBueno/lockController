package com.mgsbueno.lock.entities;


import jakarta.persistence.*;

@Entity
public class Lock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String site;    // local de instalação

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSite(String exampleSite) {
        this.site = exampleSite;
    }

    public String getSite() {
        return this.site;
    }
}
