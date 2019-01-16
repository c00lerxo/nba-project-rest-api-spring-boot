package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.exceptions.TeamNotFoundException;
import com.proglabs.nbaprojectrestapi.models.Team;
import com.proglabs.nbaprojectrestapi.repositories.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/teams")
    List<Team> getAll() {
        return repository.findAll();
    }

    @GetMapping("/teams/{id}")
    Team get(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
    }

    @PostMapping("/teams")
    Team create(@RequestBody Team newTeam) {
        return repository.save(newTeam);
    }

    @PutMapping("/teams/{id}")
    Team update(@RequestBody Team newTeam, @PathVariable Integer id) {

        return repository.findById(id)
                .map(team -> {
                    team.setName(newTeam.getName());
                    team.setChampionships(newTeam.getChampionships());
                    team.setPlayers(newTeam.getPlayers());
                    team.setArena(newTeam.getArena());
                    team.setCoach(newTeam.getCoach());
                    team.setCity(newTeam.getCity());
                    return repository.save(team);
                })
                .orElseGet(() -> {
                    newTeam.setId(id);
                    return repository.save(newTeam);
                });
    }

    @DeleteMapping("/teams/{id}")
    void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
