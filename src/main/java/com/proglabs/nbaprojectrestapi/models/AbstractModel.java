package com.proglabs.nbaprojectrestapi.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int id;

    @Column
    protected String name;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
