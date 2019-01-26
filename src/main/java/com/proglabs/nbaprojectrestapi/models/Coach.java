package com.proglabs.nbaprojectrestapi.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Coach.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Coach extends AbstractModel {

    @Column
    private String experience;

    @Column
    private int championships;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Team_ID", referencedColumnName = "id")
    private Team team;

    public Coach() {}

    public Coach(String name, String experience, int championships) {
        this.name = name;
        this.experience = experience;
        this.championships = championships;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getChampionships() {
        return championships;
    }

    public void setChampionships(int championships) {
        this.championships = championships;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
