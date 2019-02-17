package com.proglabs.nbaprojectrestapi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Player.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int id;

    @Column
    protected String name;

    @Column
    private LocalDate birthday;

    @ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Team team;

    @Column
    private String nationality;

    @Column
    private float ppg;

    @Column
    private float apg;

    @Column
    private float rpg;

    public Player() {}

    public Player(String name, LocalDate birthday, String nationality, float ppg, float apg, float rpg) {
        this.birthday = birthday;
        this.nationality = nationality;
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
    }

    public int getId() {
        return  id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public float getPpg() {
        return ppg;
    }

    public void setPpg(float ppg) {
        this.ppg = ppg;
    }

    public float getApg() {
        return apg;
    }

    public void setApg(float apg) {
        this.apg = apg;
    }

    public float getRpg() {
        return rpg;
    }

    public void setRpg(float rpg) {
        this.rpg = rpg;
    }
}
