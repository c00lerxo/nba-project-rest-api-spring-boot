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
        scope = Team.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Team extends AbstractModel {

    @Column
    private int championships;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Player> players = new HashSet<Player>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Coach_ID", referencedColumnName = "id")
    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Arena_ID", referencedColumnName = "id")
    private Arena arena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;

    public Team() {}

    public Team(String name, int championships) {
        this.name = name;
        this.championships = championships;
    }

    public int getChampionships() {
        return championships;
    }

    public void setChampionships(int championships) {
        this.championships = championships;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}