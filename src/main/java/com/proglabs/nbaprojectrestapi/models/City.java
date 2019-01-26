package com.proglabs.nbaprojectrestapi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = City.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class City extends AbstractModel {

    @Column
    private String description;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Team> teams = new HashSet<Team>();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Arena> arenas = new HashSet<Arena>();

    public City() {}

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Arena> getArenas() {
        return arenas;
    }

    public void setArenas(Set<Arena> arenas) {
        this.arenas = arenas;
    }
}
