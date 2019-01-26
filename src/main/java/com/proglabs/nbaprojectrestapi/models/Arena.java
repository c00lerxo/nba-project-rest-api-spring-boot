package com.proglabs.nbaprojectrestapi.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Arena.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Arena extends AbstractModel {

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Team_ID", referencedColumnName = "id")
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;

    public Arena() {}

    public Arena(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
